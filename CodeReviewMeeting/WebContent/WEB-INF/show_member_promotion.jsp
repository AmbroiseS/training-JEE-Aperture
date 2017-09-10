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
			<div class="row">
	
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
												<c:forEach var="membersOfPromotion" items="${membersOfPromotion}">
												<tr>
												
													<td>${membersOfPromotion.name}</td>
													<td>${membersOfPromotion.email}</td>
													<td>${membersOfPromotion.promotion}</td>
													<td class="text-right">
														

															<a href="/CodeReviewMeeting/modify_member?idUser=${membersOfPromotion.id}"
																class="btn btn-warning fa fa-pencil"> Modifier</a>

										<a class="btn btn-sm btn-danger" data-toggle="confirmation" href="/CodeReviewMeeting/delete_member?idMember=${membersOfPromotion.id}"><i
																class="fa fa-trash" ></i> Supprimer</a>
														

													</td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- /.table-responsive -->
								</div>
							</div>
							<!-- /.row -->
						</div>
					<!-- /.panel -->
				</div>
</div>
	<footer class="footer">
		<div class="container">
			<div class="row text-center">
				<img src="/CodeReviewMeeting/img/ebusiness.png" class="logo" alt="">
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="/CodeReviewMeeting/js/jquery-3.1.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/CodeReviewMeeting/js/bootstrap.min.js"></script>

</body>

</html>