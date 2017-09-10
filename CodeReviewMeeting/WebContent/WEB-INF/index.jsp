<%@page import="fr.epf.models.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Panneau d'administration</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-users fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<!-- TO DOT --> 
									<div class="huge">${counterPromo}</div>
									<div class="huge-label">Promotions</div>
								</div>
							</div>
						</div>
						<a href="/CodeReviewMeeting/add_promotion">
							<div class="panel-footer">
								<span class="pull-left">Ajouter une promotion</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-user fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${counterMember}</div>
									<div class="huge-label">Membres inscrits</div>
								</div>
							</div>
						</div>
						<a href="/CodeReviewMeeting/add_member">
							<div class="panel-footer">
								<span class="pull-left">Ajouter un membre</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-calendar fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${counterReview}</div>
									<div class="huge-label">Code reviews programmées</div>
								</div>
							</div>
						</div>
						<a href="/CodeReviewMeeting/add_event">
							<div class="panel-footer">
								<span class="pull-left">Ajouter une code review</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-8">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-user fa-fw"></i> Gestion des membres
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
							
									<div class="table-responsive">
										<table class="table table-hover table-striped">
											<thead>
												<tr>
													<th>Nom</th>
													<th>Email</th>
													<th>Promotion</th>
													<th class="text-right">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="member" items="${members}">
												<tr>
												
													<td>${member.name}</td>
													<td>${member.email}</td>
													<td>${member.promotion}</td>
													<td class="text-right">
														

															<a href="/CodeReviewMeeting/modify_member?idUser=${member.id}"
																class="btn btn-warning fa fa-pencil"> Modifier</a>

										<a class="btn btn-sm btn-danger" data-toggle="confirmation" href="/CodeReviewMeeting/delete_member?idMember=${member.name}"><i
																class="fa fa-trash" ></i> Supprimer</a>
														

													</td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="text-center">
											<ul class="pagination">
												<li><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
											</ul>
										</div>
									</div>
									<!-- /.table-responsive -->
								</div>
							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-8 -->
				<div class="col-lg-4">
					<div class="panel panel-default ">
						<div class="panel-heading">
							<i class="fa fa-calendar fa-fw"></i> Codes reviews programmées
						</div>
						<div class="panel-body">
							<div class="panel-scroll">
								<table class="table table-hover table-striped">

									<c:forEach var="review" items="${reviews}">
										<tr>
										  <td>${review.reviewName}</td>
										  <td>${review.reviewPromotion} </td>
										  <td class="text-right"><span class="text-muted small">${review.reviewDateTime} </span></td>
									
										</tr>
									</c:forEach>
								</table>
							</div>
							<br /> <a href="/CodeReviewMeeting/add_event"
								class="btn btn-default btn-block">Programmer une code review</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->

					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-users fa-fw"></i> Gestion des promotions
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">

							<div class="list-group panel-scroll">
							
								<a href="#" class="list-group-item"> <c:forEach
										var="promotion" items="${promotions}">
										<a href="#" class="list-group-item"> <i
											class="fa fa-users fa-fw"></i> <c:out
												value=" ${promotion.getName()}" /> <span
											class="pull-right text-muted small"><em>${promotion.promotionSize}</em>
										</span>
										</a>
									</c:forEach>
							</div>
							<!-- /.list-group -->
							<a href="/CodeReviewMeeting/add_promotion"
								class="btn btn-default btn-block">Créer une nouvelle
								promotion</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
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

	<!-- jQuery -->
	<script type='text/javascript' src="/CodeReviewMeeting/js/jquery-3.1.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/CodeReviewMeeting/js/bootstrap.min.js"></script>
	
	<!--  Bootstrap add-on JavaScript -->
	
    <script src="/CodeReviewMeeting/js/bootstrap-confirmation.js"></script>
    
    <!--  Others -->
    
    <script src ="/CodeReviewMeeting/js/dashboard.js"> </script>

</body>

</html>