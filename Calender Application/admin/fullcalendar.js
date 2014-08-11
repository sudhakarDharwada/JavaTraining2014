         $(document).ready(function()
        	        {
        	            /*
        	             date store today date.
        	             d store today date.
        	             m store current month.
        	             y store current year.
        	             */
        	            var date = new Date();
        	            var d = date.getDate();
        	            var m = date.getMonth();
        	            var y = date.getFullYear();

        	            /*
        	             Initialize fullCalendar and store into variable.
        	             Why in variable?
        	             Because doing so we can use it inside other function.
        	             In order to modify its option later.
        	             */

        	            var calendar = $('#calendar').fullCalendar(
        	                    {
        	                        /*
        	                         header option will define our calendar header.
        	                         left define what will be at left position in calendar
        	                         center define what will be at center position in calendar
        	                         right define what will be at right position in calendar
        	                         */
        	                        header:
        	                        {
        	                            left: 'prev,next today',
        	                            center: 'title',
        	                            right: 'month'
        	                        },
        	                        /*
        	                         defaultView option used to define which view to show by default,
        	                         for example we have used agendaWeek.
        	                         */
        	                        defaultView: 'month',
        	                        /*
        	                         selectable:true will enable user to select datetime slot
        	                         selectHelper will add helpers for selectable.
        	                         */
        	                        selectable: true,
        	                        selectHelper: true,
        	                        /*
        	                         when user select time slot this option code will execute.
        	                         It has three arguments. Start,end and allDay.
        	                         Start means starting time of event.
        	                         End means ending time of event.
        	                         allDay means if events is for entire day or not.
        	                         */
        	                        select: function(start, end, allDay)
        	                        {
        	                            /*
        	                             after selection user will be prompted for enter title for event.
        	                             */
        	                            var title = prompt('Enter Event Title:');
        	                            /*
        	                             if title is entered calendar will add title and event into fullCalendar.
        	                             */
        	                            if (title)
        	                            {
        	                                calendar.fullCalendar('renderEvent',
        	                                        {
        	                                            title: title,
        	                                            start: start,
        	                                            end: end,
        	                                            allDay: allDay
        	                                        },
        	                                        true // make the event "stick"
        	                                );
        	                            }
        	                            calendar.fullCalendar('unselect');
        	                        },
        	                        /*
        	                         editable: true allow user to edit events.
        	                         */
        	                        editable: true,
        	                        /*
        	                         events is the main option for calendar.
        	                         for demo we have added predefined events in json object.
        	                         */
        	                        events: [ ]
        	                    });

        	        });
