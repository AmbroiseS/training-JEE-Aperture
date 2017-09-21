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
				<br />
				<div class="col-lg-8 col-lg-offset-2">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="col-xs-3">
								<i class="fa fa-clock-o fa-5x"></i>
							</div>
							<div class="huge-label text-center spaced">
								<div class="fa-5x">
									<span class="countdown" id="countdown_days"></span><span
										class="countdown" id="countdown_hours"></span><span
										class="countdown" id="countdown_minutes"></span><span
										class="countdown" id="countdown_seconds"></span>
								</div>
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
												<option
													${promotion.name == selectedPromotion ? 'selected' : ''}>
                         							${promotion.name}
                         						</option>
											</c:forEach>
										</select>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div id='calendar' style="width: 100%"></div>
					<br />
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


	<!--  other -->	
	<script src="/CodeReviewMeeting/js/countdown.js"></script>
	<script> 
	$( document ).ready(function() {
		init("${nextReview.reviewDateTime}", "${selectedPromotion}");		
	});
	</script>



</body>

</html>