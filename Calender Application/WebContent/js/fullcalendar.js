        $('#calendar').ready(function()
        	        {
        	 
        	
        	            var date = new Date();
        	            var d = date.getDate();
        	            var m = date.getMonth();
        	            var y = date.getFullYear();

        	            $( "#teams" ).click(function() {
        	            	
        	            	
        	            	 var calendar = $('#calendar').fullCalendar(
             	                    {
             	                    	
             	                        
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
        	            });
        	            
        	            $('#calendar').ready(function(){
        	            	
       	            	 var calendar = $('#calendar').fullCalendar(
            	                    {
            	                    	
            	                        
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
       	            });
        	            
        	           	           

        	        });

