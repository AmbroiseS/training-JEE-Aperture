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
		<%@ include file="menu.jsp" %>
			<div class="row">
	
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-user fa-fw"></i> Gestion des membres de la promotion ${promotion.name}
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div style="width:800px; margin:0 auto;">
							
									<div class="table-responsive">
										<table class="table table-hover table-striped">
											<thead>
												<tr>
													<th>Nom</th>
													<th>Email</th>
													<th class="text-right">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="membersOfPromotion" items="${membersOfPromotion}">
												<tr>
												
													<td>${membersOfPromotion.name}</td>
													<td>${membersOfPromotion.email}</td>
													<td class="text-right">
														

															<!--  <a href="/CodeReviewMeeting/modify_member?idUser=${membersOfPromotion.id}"
																class="btn btn-warning fa fa-pencil"> Changer de promotion</a> -->

										<a class="btn btn-sm btn-danger" data-toggle="confirmation" href="/CodeReviewMeeting/delete_member_promotion?idMember=${membersOfPromotion.id}&idPromotion=${promotion.id}"><i
																class="fa fa-trash" ></i> Supprimer de la promotion</a>
														

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
	<%@ include file="footer.jsp" %>

	<!-- jQuery -->
	<script src="/CodeReviewMeeting/js/jquery-3.1.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/CodeReviewMeeting/js/bootstrap.min.js"></script>
	
		<!--  Bootstrap add-on JavaScript -->
	
    <script src="/CodeReviewMeeting/js/bootstrap-confirmation.js"></script>
    
    <!--  Others -->
    
    <script src ="/CodeReviewMeeting/js/dashboard.js"> </script>

</body>

</html>