<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
 <%@ include file="menu.jsp" %>

        <div id="page-wrapper" class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Ajouter un membre</h1>
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
                                            <label for="name">Nom</label>
                                            <input type="text" class="input-lg form-control" name="name" id="name" placeholder="Nom">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Adresse Email</label>
                                            <input type="email" class="input-lg form-control" id="email" name="email" placeholder="Adresse Email">
                                        </div>
                                        <div class="form-group">
                                            <label for="promotion">Promotion</label>
                                            <select class="input-lg form-control" name="promotion" id="promotion">
                                                
                                                 <c:forEach var="promotion" items="${promotions}"> 
                                                      <option>${promotion.name}</option>
                          						</c:forEach>  
                                                
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="birthdate">Date de Naissance</label>
                                            <input class="input-lg form-control" type="date" name="birthdate" id="birthdate">
                                        </div>
                                        

                                        <div class="text-right">
                                            <button type="submit" class="btn btn-lg btn-primary">Enregistrer</button>
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
<%@ include file="footer.jsp" %>

    <!-- jQuery -->
    <script src="/CodeReviewMeeting/js/jquery-3.1.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/CodeReviewMeeting/js/bootstrap.min.js"></script>

</body>

</html>