<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("book"); %>
<% Boolean session2 = (Boolean) request.getAttribute("session"); %>
<html lang="en">
  	<head>
	  	<title>Biblioteca</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	   
	    <!-- dashboard -->
		<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="dashboard/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

	</head>
	<body>
	<jsp:include page="navbar.jsp" />
	<section class="ftco-section">
		<!--DASHBOARD  -->
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Livros</h2>
					<a href='inserir?action=inserir' style='color: blue;'>Inserir</a><a>|</a><a href='dashboard' style='color: #ff00dd;'>Refresh</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-bordered table-dark table-hover">
						  <thead>
						    <tr>
						      <th>#</th>
						      <th>Nome</th>
						      <th>Autor</th>
						      <th>Data</th>
						      <th>Status</th>
						      <th>Alterar</th>
						      <th>Excluir</th>
						    </tr>
						  </thead>
						  <tbody>
						  	<% 
						  		int number = 1;
								for(Book book : books){
						   			out.print("<tr>");
									    out.print("<th scope='row'>"+number+"</th>");
									    out.print("<td>"+book.getName()+"</td>");
									    out.print("<td>"+book.getAuthor().getName()+"</td>");
									    String dateStr = book.getDate().toString();
									    DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
									    DateFormat formatter1 = new SimpleDateFormat("dd-mm-yyyy");
									    out.print("<td>"+formatter1.format(formatter.parse(dateStr))+"</td>");
									    out.print("<td>"+book.getBookStatus()+"</td>");
									    out.print("<td> <a href='alterar?action=alterar&id="+book.getId()+"' style='text-align: center; color:grey;' class='fa fa-pencil'></a></td>");
									    out.print("<td> <a href='excluir?action=excluir&id="+book.getId()+"' style='text-align: center; color:red;' class='fa fa-remove'></a></td>");
						      		out.print("</tr>");
						      		number += 1;
						      		
								}
						    %>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

  <script src="dashboard/js/jquery.min.js"></script>
  <script src="dashboard/js/popper.js"></script>
  <script src="dashboard/js/bootstrap.min.js"></script>
  <script src="dashboard/js/main.js"></script>

	</body>
</html>

