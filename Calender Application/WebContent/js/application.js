$(function(){
	var Event = Backbone.Model.extend({
		defaults:{
		title:"",
		eventPlace:"",
		start:""
		},
		urlRoot:"./event-rest/events"
	});

	var Events = Backbone.Collection.extend({
		model: Event,
		url: "./event-rest/events",
		parse: function(response) {
			console.log(" in parse");
		    return response.calendarEvent;
		}
	});
	var EventsView = Backbone.View.extend({
		initialize: function(){
			_.bindAll(this,"render","addAll","addOne","select","eventClick","change","eventDropOrResize","destroy");

			this.collection.bind('reset', this.addAll);
			this.collection.bind('add', this.addOne);
			this.collection.bind('change', this.change);
			this.collection.bind('remove', this.destroy);
		},
		render: function() {
			this.$el.fullCalendar({
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month'//,basicWeek,basicDay'
				},
				selectable: true,
				selectHelper: true,
				editable: true,
				ignoreTimezone: false,
				select: this.select,
				eventClick: this.eventClick,
				eventDrop: this.eventDropOrResize,
				eventResize: this.eventDropOrResize,
			});
		},
		addAll: function() {
			this.$el.fullCalendar('addEventSource', this.collection.toJSON());
		},
		addOne: function(event) {
			this.$el.fullCalendar('renderEvent', event.toJSON(),true);
		},
		select: function(startDate) {
			this.eventView = new EventView();
			this.eventView.collection = this.collection;
			console.log(startDate);
			this.eventView.model = new Event({start: $.fullCalendar.formatDate(startDate,"yyyy-MM-dd")});
			this.eventView.render();
		},
		eventClick: function(fcEvent) {
			this.eventView = new EventView({collection:this.collection});
			console.log(fcEvent);
			console.log(fcEvent.id);
			console.log(this.collection.get(fcEvent.id));
			console.log(this.eventView.model);
			this.eventView.model = this.collection.get(fcEvent.id);
			this.eventView.render();
		},
		change: function(event) {
//			Look up the underlying event in the calendar and update its details from the model
			console.log("at change start");
			var fcEvent = this.$el.fullCalendar('clientEvents', event.get('id'))[0];
			console.log("at change middle");
			fcEvent.title = event.get('title');
			fcEvent.eventPlace = event.get('eventPlace');
			this.$el.fullCalendar('updateEvent', fcEvent);
			console.log("total done");
		},
		eventDropOrResize: function(fcEvent) {
//			Lookup the model that has the ID of the event and update its attributes
			this.collection.get(fcEvent.id).save({start: fcEvent.start, end: fcEvent.end});
		},
		destroy: function(event) {
			console.log(event.id);
			this.$el.fullCalendar('removeEvents', event.id);
		}
	});

	//var item = {title:"aaaaa",eventPlace:"bbbbb",start:""};
	var EventView = Backbone.View.extend({
		el: $('#eventDialog'),
		initialize: function() {
			_.bindAll(this,"render","open","save","close","destroy");
		},
		render: function() {
			var buttons = {'Ok': this.save};
			if (!this.model.isNew()) {
				_.extend(buttons, {'Delete': this.destroy});
			}
			_.extend(buttons, {'Cancel': this.close});
			this.$el.dialog({
				modal: true,
				title: (this.model.isNew() ? 'New' : 'Edit') + ' Event',
				buttons: buttons,
				open: this.open
			});

			return this;
		},
		open: function() {
			this.$('#title').val(this.model.get('title'));
			this.$('#place').val(this.model.get('eventPlace'));
		},
		save: function() {
			this.model.set({'title': this.$('#title').val(), 'eventPlace': this.$('#place').val()});
			console.log(this.model.isNew());
		
			if (this.model.isNew()) {
				this.collection.create(this.model,{wait: true});
				this.close();
			} else {
				this.model.save({}, {success: this.close});
			}
		},
		handleData: function(data)
		{
			//document.write("updated --- id:"+data.id+" name:"+data.name+" description:" +data.description)
			console.log("updated");

		} ,
		close: function() {
			this.$el.dialog('close');
		},
		destroy: function() {
			this.model.destroy({success: this.close});
		}
	});

	var User=Backbone.Model.extend({
		defaults:{
			name:'',
			id:0,
			email:'',
			phone:000,
			designation:''
		},
		urlRoot:"./profile-rest/profile"
	});
	var ProfileView=Backbone.View.extend({
		el:"#body",
		template:_.template($('#profile-template').html()),
		render:function(){
			this.$el.html('');
			this.$el.html(this.template(this.model.toJSON()));
			return this;
		}
	});
	var AppRouter=Backbone.Router.extend({
		routes:{
			'':'home',
			'ProfileView':'showProfile'
		},
		showProfile:function(){
			var user=new User();
			user.fetch({success:function(user){
				var profileview=new ProfileView({model:user});
				profileview.render();
			}});
		},
		home:function(){
			window.events = new Events();
			new EventsView({el: $("#body"), collection: events}).render();
			events.fetch({success:function(response){
				console.log(response);
				}
			});
		}

	});
	var approuter=new AppRouter();
	Backbone.history.start();

});