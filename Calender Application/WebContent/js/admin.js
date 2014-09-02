$('#addteam').click(function() {
	$(".rightcolumn").hide();
	$(".leftcolumn").css("background-color", "#eee");
	$(".leftcolumn").css("width", "100%");
	$(".leftcolumn").css("overflow-x", "hidden");
	$(".leftcolumn").css("overflow-y", "auto");
});

$('#teams').click(function() {
	$(".leftcolumn").css("width", "60%");
	$(".rightcolumn").css("width", "40%");
	$(".rightcolumn").show();
	$("#calendar").html("");

});

$('#updateteam').click(function() {

	$(".leftcolumn").css("width", "60%");
	$(".rightcolumn").css("width", "40%");
	$(".rightcolumn").show();

	$("#calendar").html("");

});

$('#updatedetails').click(function() {
	alert('on clicking update details button...');
})

function addRow(tableID) {
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);

	var zerothCell = row.insertCell(0);
	var element0 = document.createElement("input");
	element0.type = "checkbox";
	element0.name = "chkbox[]";
	element0.id = "id[]";
	zerothCell.appendChild(element0);

	var firstCell = row.insertCell(1);
	var element1 = document.createElement("input");
	element1.type = "text";
	element1.name = "id[]";
	firstCell.appendChild(element1);

	var secondCell = row.insertCell(2);
	var element2 = document.createElement("input");
	element2.type = "text";
	element2.name = "name[]";
	secondCell.appendChild(element2);

	var thirdCell = row.insertCell(3);
	var element3 = document.createElement("input");
	element3.type = "text";
	element3.name = "email[]";
	thirdCell.appendChild(element3);

	var fourthCell = row.insertCell(4);
	var element4 = document.createElement("input");
	element4.type = "text";
	element4.name = "contactNo[]";
	fourthCell.appendChild(element4);

	var fifthCell = row.insertCell(5);
	var element5 = document.createElement("select");
	var op = new Option();
	op.value = 1;
	op.text = "Manager";
	element5.options.add(op);

	var op1 = new Option();
	op1.value = 2;
	op1.text = "ScrumMaster";
	element5.options.add(op1);

	var op2 = new Option();
	op2.value = 3;
	op2.text = "SnrDeveloper";
	element5.options.add(op2);

	var op3 = new Option();
	op3.value = 4;
	op3.text = "SnrQA";
	element5.options.add(op3);

	fifthCell.appendChild(element5);
}

function deleteRow(tableID) {
	try {
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		for ( var i = 0; i < rowCount; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[0].childNodes[0];
			if (null != chkbox && true == chkbox.checked) {
				table.deleteRow(i);
				rowCount--;
				i--;
			}
		}
	} catch (e) {
		alert(e);
	}
}
// //////////////////////////////////////////////////////////// Team

var Team = Backbone.Model.extend({
	defaults : {
		teamName : ''
	}
});

var TeamsCollection = Backbone.Collection.extend({
	model : Team
});

var TeamsCollectionView = Backbone.View.extend({
	tagName : 'ul',
	initialize : function() {

	},
	render : function() {
		this.collection.each(function(team) {
			var teamsviews = new TeamsView({
				model : team
			});
			this.$el.append(teamsviews.render().el);
		}, this);

		return this;
	},
	render1 : function() {
		this.collection.each(function(team) {
			var teamsviews = new TeamsView({
				model : team
			});
			this.$el.append(teamsviews.render1().el);
		}, this);

		return this;
	}

});

var TeamsView = Backbone.View.extend({
	tagName : 'li',
	initialize : function() {
	},
	template1 : _.template($("#teamdisplay").html()),
	events : {
		'click #getdetails' : 'showAlert',
		'click #updatedetails' : 'showAlert1'

	},

	showAlert: function(){
		console.log('check error here..');
		console.log(this.model.get('teamName'));
		var tdcv = new TeamDisplayCollectionView({ collection: displayteamscollectionData });
		$('#rightcol').html(tdcv.render().el);
		var newempdetails = new NewEmpDetails({ collection: displayteamscollectionData });
		$(".edit").hide();
		$(".delete").hide();

	},

	render : function() {
		console.log("entered teams render");
		this.$el.html(this.template1(this.model.toJSON()));
		return this;
	},

	template2 : _.template($("#updateteamdisplay").html()),

	showAlert1 : function() {
		alert(this.model.get('teamName'));
		console.log('at update team view...');
		$(".rightcolumn").hide();
		$(".leftcolumn").css("width", "100%");

		var tdcv = new TeamDisplayCollectionView({
			collection : displayteamscollectionData
		});
		$('#calendar').html(_.template($("#updateTeam_addEmp").html()));
		$('#calendar').append(tdcv.render().el);
		var newempdetails = new NewEmpDetails({
			collection : displayteamscollectionData
		});
		console.log('end of update team view...');
	},
	render1 : function() {
		console.log("entered teams render1");
		this.$el.html(this.template2(this.model.toJSON()));
		return this;
	}
});
var collectionData = new TeamsCollection([ {
	teamName : 'wallgreens'
}, {
	teamName : 'wallmart'
}, {
	teamName : 'core'
} ]);

// /////////////////////////////////////////////////////////// end of Team

// ////////////////////////////////////////////////////////// update Team
var TeamDetails = Backbone.Model.extend({
	defaults : {
		id : '',
		name : '',
		email : '',
		mobile_number : '',
		designation : ''
	}
});
var TeamDisplayCollection = Backbone.Collection.extend({
	model : TeamDetails
});
var TeamDisplayCollectionView = Backbone.View.extend({
	tagName : 'ul',
	initialize : function() {
		this.collection.on('add', this.addOne, this);
	},
	render : function() {
		this.collection.each(this.addOne, this);
		return this;
	},
	addOne : function(teamdetails) {
		var teamdetailsview = new TeamDetailsView({
			model : teamdetails,
			collection : displayteamscollectionData
		});
		this.$el.append(teamdetailsview.render().el);
	}

});

var TeamDetailsView = Backbone.View.extend({
	tagName : 'li',
	template : _.template($("#empTemplate").html()),

	initialize : function() {
		this.model.on('change', this.render, this);
		this.model.on('destroy', this.remove, this);
	},
	events : {
		'click .edit' : 'editPerson',
		'click .delete' : 'DestroyPerson'
	},
	editPerson : function() {
		alert('at edit function');
		
		
		var newEmail = prompt("please enter the new Email", this.model
				.get("email"));
		var newContactNO = prompt("please enter the new Contact", this.model
				.get("mobile_number"));
		var newDesignation = prompt("please enter the new Designation",
				this.model.get("designation"));

		
		if (!newEmail)
			return;
		this.model.set('email', newEmail);
		if (!newContactNO)
			return;
		this.model.set('mobile_number', newContactNO);
		if (!newDesignation)
			return;
		this.model.set('designation', newDesignation);
	},
	DestroyPerson : function() {
		this.$el.remove();
		this.collection.remove(this.model);
		this.model.destroy();
	},

	render : function() {
		console.log("entered team details render");
		this.$el.html(this.template(this.model.toJSON()));
		var req = new XMLHttpRequest();
		console.log("jquery");
		req.open("PUT","http://localhost:8080/Project/rest2/teamuser/"+this.model.id,true);
		req.setRequestHeader("Content-Type","application/json");
		req.send(JSON.stringify(this.model) );
		req.onreadystatechange = function()
		{
			if(req.status == 200&&req.readyState==4)
				//document.write(req.responseXML.toLocaleString());
			console.log("updated");
		}
		return this;
	},
});

var NewEmpDetails = Backbone.View
		.extend({
			el : '#addnewemp',
			events : {
				'submit' : 'submit'
			},
			submit : function(e) {
				console.log("at add emp submit....");
				e.preventDefault();
				var newPersonId = $(e.currentTarget).find('input#ids').val();
				var newPersonName = $(e.currentTarget).find('input#name').val();
				var newPersonEmail = $(e.currentTarget).find('input#email')
						.val();
				var newPersonContactNo = $(e.currentTarget).find(
						'input#contact').val();
				var newPersonDesignation = $(e.currentTarget).find(
						'select#designation').val();
				var teamdetails = new TeamDetails({
					id : newPersonId,
					name : newPersonName,
					email : newPersonEmail,
					mobile_number : newPersonContactNo,
					designation : newPersonDesignation
				});
				this.collection.add(teamdetails);
			}
		});
var displayteamscollectionData = new TeamDisplayCollection([ {
	id : '6279',
	name : 'srinivas',
	email : 'srinivas.bavirisetty@valuelabs.net',
	mobile_number : '9533394727',
	designation : 'software eng'
}, {
	id : '6387',
	name : 'chandu',
	email : 'chandrasekhar.kondamuri@valuelabs.net',
	mobile_number : '9014391152',
	designation : 'software eng'
}, {
	id : '687',
	name : 'chandu1',
	email : 'chandrasekhar1.kondamuri@valuelabs.net',
	mobile_number : '90143911521232',
	designation : 'software eng1'
}

]);
// ///////////////////////////////////////////////////////// end of update Team

var TeamView = Backbone.View.extend({
	initialize : function() {
	},
	render : function() {

		$("#calendar").html("");
		var template = _.template($('#NewTeamTemplate').html(), {});
		$('#calendar').html(template);
	}
});

var TeamMember = Backbone.Model.extend({
	urlRoot : "rest2/teamuser",
	defaults : {
		id : "",
		name : "",
		email : "",
		contactno : "",
		designation : ""
	},
	initialize : function() {
		console.log("member initialised");
	}
});

var TeamList = Backbone.Collection.extend({
	Model : TeamMember,
	url : "rest2/teamuser",
	initialize : function() {
	}
});

var Client = Backbone.Model.extend({
	urlRoot : "rest1/team",
	defaults : {
		tname : '',
		cname : '',
		clocation : ''
	}
});

var ClientList = Backbone.Collection.extend({
	Model : Client,
	url : "rest1/team"
});

Routers = Backbone.Router
		.extend({
			routes : {
				"" : "HomePage",
				"Teams" : "Teams",
				"AddTeam" : "AddTeam",
				"UpdateTeam" : "UpdateTeam",
				"logout" : "Logout"
			},

			HomePage : function() {
				console.log('In home page');
			},

			Teams : function() {
				console.log("team");
				var tcv = new TeamsCollectionView({
					collection : collectionData
				});
				$('#rightcol').html(tcv.render().el);

				console.log("endteam");

			},

			AddTeam : function() {
				console.log("New team");
				var viewTeam = new TeamView();
				viewTeam.render();
				console.log('render done');
				$('#forming').submit(
								function(ev) {
									ev.preventDefault();
									console.log();
									var client = new Client({
										tname : $('#tname').val(),
										cname : $('#cname').val(),
										clocation : $('#clocation').val()
									});
									var req = new XMLHttpRequest();
									req
											.open(
													"POST",
													"http://localhost:8080/Project/rest1/team",
													true);
									req.setRequestHeader("Content-Type",
											"application/json");
									req.send(JSON.stringify(client));
									req.onreadystatechange = function() {
										if (req.status == 200
												&& req.readyState == 4)
											console.log("added");
									}
									console.log(client.toJSON());
									
									
									var table = document.getElementById('dataTable');
									var rowLength = table.rows.length;
									var totalCol = 6;
									for (i = 1; i < rowLength; i++) {
										var mem = new TeamMember(
												{
													id : table.rows[i].cells[1].firstChild.value,
													name : table.rows[i].cells[2].firstChild.value,
													email : table.rows[i].cells[3].firstChild.value,
													contactno : table.rows[i].cells[4].firstChild.value,
													designation : table.rows[i].cells[5].firstChild.value
												});

										if (mem != null) {
											console.log("in create")
											teamList.add(mem);
											console.log("in middle")
											console.log(this.model);
											var req = new XMLHttpRequest();
											console.log("jquery");
											req.open("POST","http://localhost:8080/Project/rest2/teamuser",true);
											req.setRequestHeader(
													"Content-Type",
													"application/json");
											req.send(JSON.stringify(mem));
											req.onreadystatechange = function() {
												if (req.status == 200
														&& req.readyState == 4)
													console.log("updated");
											}
										}
									}
									console.log(teamList);
								});
			},
			UpdateTeam : function() {
				console.log("update team");
				var tcv = new TeamsCollectionView({
					collection : collectionData
				});
				$('#rightcol').html(tcv.render1().el);

				console.log("end updateteam");
			}
		});

var teamList = new TeamList();
var clientlist = new ClientList();
var MyRouter = new Routers();
Backbone.history.start();
