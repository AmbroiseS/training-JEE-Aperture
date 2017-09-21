	function init(nextReview, promo){
		if(promo == ""){
			$('#countdown_days').html("Please select a promotion");						
		}else{
			if(nextReview == ""){
				$('#countdown_days').html("No review scheduled");				
			}else{
				prepareCountDown(nextReview, promo);
			}			
		}
		
		$('#calendar').fullCalendar({
			header: {
        		left: 'prev,today,next',
        		center: 'title',
        		right: 'agendaDay,agendaWeek,month',
        	},
        	 events:[ {
 	            title: "Next Review",
 	            start: nextReview,
 	            color:"#bf5159",
 	            textColor: "white"
 		 }],
        	defaultView: 'month',
            scrollTime: "08:00"
		});
	};


	function prepareCountDown(nextReview, promo){
		var now = new Date();
		var nextReviewDate = new Date(nextReview);
		
		var timeDiff = Math.abs(nextReviewDate.getTime() - now.getTime());
		var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
		
		var leftHours = timeDiff -  (diffDays*3600*1000*24);
		var diffHours = Math.ceil(leftHours/ (3600*1000) );
		
		var leftMinutes = leftHours -  (diffHours*3600*1000);
		var diffMinutes = Math.ceil(leftMinutes/ (60*1000) );
		
		var leftSeconds = leftMinutes -  (diffMinutes*1000);
		var diffSeconds = Math.ceil(leftSeconds/ (60*1000) );
		
		if(diffSeconds <0){
			diffSeconds = 60 + diffSeconds;
			diffMinutes --;			
		}
		if(diffMinutes < 0){
			diffMinutes = 61 + diffMinutes;
			diffHours --;
		}
		if(diffHours < 0){
			diffHours = 24 + diffHours;
			diffDays --;
		}
		display_seconds(diffSeconds);
		display_minutes(diffMinutes);
		display_hours(diffHours);
		display_days(diffDays);
		launchCountDown(diffDays, diffHours, diffMinutes, diffSeconds);
	}
	
	function launchCountDown(days, hours, minutes, seconds){
		setInterval(function (){
			seconds = seconds-1 ;
			if(seconds <0){
				//reset seconds and decrement minutes
				seconds = 59;
				minutes= minutes -1;
				
				if(minutes < 0 ){
					//reset minutes and decrement hours
					minutes = 59;										
					hours = hours -1;
					
					if(hours <0){
						//reset hours and decrement days
						hours = 23;						
						days= days -1;
							hours = 23;
							if(days <0 ){
								//load next review
								location.href="http://localhost:8080/CodeReviewMeeting/counter_to_next_review";
						}
						display_days(days);
					}
					display_hours(hours);
				}	
				display_minutes(minutes);
			}
			display_seconds(seconds);			
		}, 1000, days, hours, minutes, seconds);
		
	}
	
	function display_minutes(minutes){
		if(minutes >= 10){
			$('#countdown_minutes').html(minutes + ":");
		}else{
			$('#countdown_minutes').html("0"+minutes + ":");
		}	
	}
	
	function display_seconds(seconds){
		if(seconds >= 10){
			$('#countdown_seconds').html(seconds);
		}else{
			$('#countdown_seconds').html("0" +seconds);
		}	
	}
	function display_hours(hours){
		if(hours >= 10){
			$('#countdown_hours').html(hours + ":");
		}else{
			$('#countdown_hours').html("0" +hours + ":");
		}	
	}
	function display_days(days){
		if(days > 0){
			$('#countdown_days').html(days + " days  ");
		}else{
			$('#countdown_days').html("");
		}	
	}
	
