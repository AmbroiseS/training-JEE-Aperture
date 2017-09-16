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


<script src="/CodeReviewMeeting/js/dashboard.js"></script>



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
		<nav class="navbar navbar-default navbar-static-top container-fluid"
			role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/CodeReviewMeeting/dashboard">When
					Is My Code Review?</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle navlink"
					data-toggle="dropdown" href="#"> <i class="fa fa-gear fa-fw"></i>
						Gérer les code reviews <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="/CodeReviewMeeting/add_promotion"><i
								class="fa fa-users fa-fw"></i> Ajouter une promotion</a></li>
						<li><a href="/CodeReviewMeeting/add_member"><i
								class="fa fa-user fa-fw"></i> Ajouter un membre</a></li>
						<li><a href="/CodeReviewMeeting/add_event"><i
								class="fa fa-calendar fa-fw"></i> Créer un rendez-vous</a></li>
					</ul></li>
			</ul>
		</nav>

		<div id="page-wrapper" class="container-fluid">
		<span id="countdown_days"></span> days <span id="countdown_hours"></span>:<span id="countdown_minutes"> </span>: <span id="countdown_seconds"></span>
		</div>
		
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<footer class="footer">
		<div class="container">
			<div class="row text-center">
				<img src="/CodeReviewMeeting/img/ebusiness.png" class="logo" alt="">
			</div>
		</div>
	</footer>


	<!-- Bootstrap Core JavaScript -->
	<script src="/CodeReviewMeeting/js/bootstrap.min.js"></script>

	<!--  Bootstrap add-on JavaScript -->

	<script src="/CodeReviewMeeting/js/bootstrap-confirmation.js"></script>

	<!--  Others -->
	<script> 
	window.onload=init("${nextReview.reviewDateTime}");
	function init(nextReview)
	{
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
		
		console.log('Left: '+ diffDays + " days  "+ diffHours + " hours "+ diffMinutes);
		if(diffSeconds <0){
			diffSeconds = 60 + diffSeconds;
			diffMinutes --;			
		}
		if(diffMinutes < 0){
			diffMinutes = 60 + diffMinutes;
			diffHours --;
		}
		if(diffHours < 0){
			diffHours = 24 + diffHours;
			diffDays --;
		}
		$('#countdown_days').html(diffDays);
		$('#countdown_hours').html(diffHours);
		$('#countdown_minutes').html(diffMinutes);
		$('#countdown_seconds').html(diffSeconds);
		launchCountDown(diffDays, diffHours, diffMinutes, diffSeconds);
		
	};
	
	function launchCountDown(days, hours, minutes, seconds){
		setInterval(function (){
			if(seconds>0){
				seconds= seconds-1 ;
			}else{
				seconds = 60;
				minutes= minutes-1;
				if(minutes < 0 ){
					minutes = 60;
					hours --;
					if(hours <0){
						hours = 24;
						days --;
						if(days == 0){
							//to do reload next review or stop counter
						}
					}
				}
			}
			console.log(days + " days "+ " "+hours+ ":"+ minutes + ":"+ seconds);
			$('#countdown_days').html(days);
			$('#countdown_hours').html(hours);
			$('#countdown_minutes').html(minutes);
			$('#countdown_seconds').html(seconds);
		}
				
				, 1000, days, hours, minutes, seconds);
		
	}
	

	</script>



</body>

</html>