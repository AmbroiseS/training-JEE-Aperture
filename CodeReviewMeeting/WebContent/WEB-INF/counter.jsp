<%@page import="fr.epf.models.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>When Is My Code Review?</title>

<!-- jQuery -->
<script type='text/javascript'
	src="/CodeReviewMeeting/js/jquery-3.1.1.min.js"></script>


<!-- Bootstrap CSS -->
<link href="/CodeReviewMeeting/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/CodeReviewMeeting/css/style.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<%@ include file="menu.jsp"%>
		<div id="page-wrapper" class="container-fluid">
			
			<div class="row">
			<br/>
				<div class="col-lg-8 col-lg-offset-2">
					<div class="panel panel-red">
						<div class="panel-heading">
			<div class="col-xs-3">
									<i class="fa fa-clock-o fa-5x"></i>
								</div>
							<div class="huge-label text-center  spaced">
							
								<span class="countdown" id="countdown_days"></span> <span
									class="countdown" id="countdown_hours"></span> <span
									class="countdown" id="countdown_minutes"> </span> <span
									class="countdown" id="countdown_seconds"></span>
							</div>
						</div>
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">

									<form action="" method="post" id="myform" id="myform">
										<label for="promotion">Promotion</label> <select
											class="input-lg form-control" name="promotion" id="promotion"
											onchange="myform.submit();">
											<option disabled selected value> -- select an option -- </option>
											<c:forEach var="promotion" items="${promotions}">
												<option ${promotion.name == selectedPromotion ? 'selected' : ''}>
                         							${promotion.name}
                         						</option>
											</c:forEach>
										</select>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<%@ include file="footer.jsp"%>


	<!-- Bootstrap Core JavaScript -->
	<script src="/CodeReviewMeeting/js/bootstrap.min.js"></script>

	<!--  Bootstrap add-on JavaScript -->

	<script src="/CodeReviewMeeting/js/bootstrap-confirmation.js"></script>

	<!--  Others -->
	<script> 
	window.onload=init("${nextReview.reviewDateTime}", "${selectedPromotion}");

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
				seconds = 59;
				minutes= minutes -1;
				if(minutes < 0 ){
					minutes = 59;										
					hours = hours -1;
					if(hours <0){
						hours = 23;						
						days= days -1;
							hours = 23;
							if(days <0 ){
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
	

	</script>



</body>

</html>