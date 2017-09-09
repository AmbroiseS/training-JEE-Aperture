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
						<li><a href="/CodeReviewMeeting/add_memberl"><i
								class="fa fa-user fa-fw"></i> Ajouter un membre</a></li>
						<li><a href="/CodeReviewMeeting/add_event"><i
								class="fa fa-calendar fa-fw"></i> Créer un rendez-vous</a></li>
					</ul></li>
			</ul>
		</nav>

		<div id="page-wrapper" class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Modifier un Utilisateur</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">
									<form action="" method="post" class="">
										<div class="form-group">
											<label for="name">Nom</label> <input value="${member.name}"
												type="text" class="input-lg form-control" name="name"
												id="name" placeholder="Nom">
										</div>
										<div class="form-group">
											<label for="email">Adresse Email</label> <input
												value="${member.email}" type="email"
												class="input-lg form-control" id="email" name="email"
												placeholder="Adresse Email">
										</div>
										<div class="form-group">
											<label for="promotion">Promotion</label> <select
												class="input-lg form-control" name="promotion"
												id="promotion">
												<option>Janvier</option>
												<option>Fevrier</option>
												<option>Mars</option>
												<option>Avril</option>
												<option>Mai</option>
												<option>Juin</option>
												<option>Juillet</option>
												<option>Aout</option>
												<option>Septembre</option>
												<option>Octobre</option>
												<option>Novembre</option>
												<option>Decembre</option>
											</select>
										</div>
										<div class="form-group">
											<label for="birthdate">Date de Naissance</label> <input
												class="input-lg form-control" type="date" name="birthdate"
												id="birthdate">
										</div>


										<div class="text-right">
											<button class="btn btn-lg btn-primary">Annuler</button>
											<button type="submit" class="btn btn-lg btn-primary">Modifier</button>
											

										</div>

									</form>
								</div>
							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
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
	<script src="/CodeReviewMeeting/js/jquery-3.1.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/CodeReviewMeeting/js/bootstrap.min.js"></script>

</body>

</html>