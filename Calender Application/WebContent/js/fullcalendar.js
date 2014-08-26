$('document').ready(function()
{
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();

	$( "#teams,#updateteam" ).click(function() {
		checking();
	});
	
	$('#calendar').ready(function(){
		checking();
	});
});
function checking(){
	var calendar = $('#calendar').fullCalendar(
			{

				selectHelper: true,

				header:
				{
					left: 'prev,next today',
					center: 'title',
					right: 'month'
				},

				defaultView: 'month',


				selectable: true,
				selectHelper: true,



				events: [ ]
			});
}
