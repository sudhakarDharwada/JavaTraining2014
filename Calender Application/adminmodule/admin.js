function addRow(tableID) {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            
            var zerothCell = row.insertCell(0);
            var element0=document.createElement("input");
            element0.type = "checkbox";
            element0.name = "chkbox[]";
            element0.id = "id[]";
            zerothCell.appendChild(element0);
            
            var firstCell = row.insertCell(1);
            var element1=document.createElement("input");
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
            var element4=document.createElement("input");
            element4.type = "text";
            element4.name = "contactNo[]";
            fourthCell.appendChild(element4); 
            
            var fifthCell = row.insertCell(5);
            var element5=document.createElement("select");
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
		for(var i=0; i<rowCount; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[0].childNodes[0];
			if(null != chkbox && true == chkbox.checked) 
			{
				table.deleteRow(i);
				rowCount--;
				i--;
			}
		}
	}
	catch(e) 
	{
		alert(e);
	}
}


var TeamView=Backbone.View.extend({
	 initialize:function(){
	 },
	render:function(){
		$("#calendar").html("");
		var template=_.template($('#NewTeamTemplate').html(),{});
		$('#calendar').html(template);
	}
});

var TeamMember=Backbone.Model.extend({
	defaults:{
		id:"",
		name:"",
		email:"",
		contactno:"",
		designation:""			
	},
	initialize:function(){
		console.log("member initialised");
	}
});

var TeamList=Backbone.Collection.extend(
{
	Model:TeamMember,
	initialize : function()
	{
	}
});

var Client=Backbone.Model.extend({
	defaults:{
		tName:'',
		cname:'',
		clocation:''
	}
});

var ClientList=Backbone.Collection.extend({
	Model:Client
});

Routers=Backbone.Router.extend({
        routes:{
			"":"HomePage",
            "Teams":"Teams",
            "AddTeam":"AddTeam",
            "UpdateTeam":"UpdateTeam",
            "logout":"Logout"
        },

        HomePage:function(){
			console.log('In home page');
        },
        
        Teams:function(){
			console.log("team");
		},
		
		 AddTeam:function()
		 {
			console.log("New team");
			var viewTeam=new TeamView();
			viewTeam.render();
			console.log('render done');
			$('#forming').submit(function(ev)
			{
				ev.preventDefault();
				var client=new Client({tname:$('#tname').val(), cname: +$('#cname').val(), clocation:$('#clocation').val()});
				clientlist.add(client);
				console.log(client.toJSON());
				var table = document.getElementById('dataTable');
				var rowLength=table.rows.length;
				var totalCol = 6;
				for (i = 1; i < rowLength; i++) 
				{
					var mem=new TeamMember({
						id:table.rows[i].cells[1].firstChild.value, 
						name: table.rows[i].cells[2].firstChild.value,
						email:table.rows[i].cells[3].firstChild.value,
						contactno:table.rows[i].cells[4].firstChild.value,
						designation:table.rows[i].cells[5].firstChild.value
					});
					teamList.add(mem);
				}
				console.log(teamList);
			})
		},
		 UpdateTeam:function(){
			console.log("update team");
		}
});
	
var teamList=new TeamList();
var clientlist=new ClientList();
var MyRouter=new Routers();
Backbone.history.start();

