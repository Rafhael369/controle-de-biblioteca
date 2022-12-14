<!DOCTYPE html>
<%@page import="model.BookStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<% String erro = (String)request.getAttribute("erro"); %>

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
	<div class="container">
	<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
					<% 
						if (erro != null){
							out.println("<h4 style='align:center; color:red'> <b> Preencha o formulário corretamente! </b></h4>"); 
						}
					%>
						<table class="table table-bordered table-dark table-hover">
						  <thead>
						    <tr>
						      <th>#</th>
						      <th>Nome</th>
						      <th>Email</th>
						      <th>Senha</th>
						      <th>Type</th>
						      <th>Salvar</th>
						    </tr>
						  </thead>
						  <tbody>
					
						  	<% 
						  		out.print("<form action='inserir_usuario?action=inserir2' method='POST'>");
						   		out.print("<tr>");
								    out.print("<th scope='row'>1</th>");
								    out.print("<td> <input required minlength='2' maxlength='100' type='text' name='name' style='background-color: #454d55; border-color: #454d55; color: white;'> </input> </td>");
								    out.print("<td> <input required minlength='2' maxlength='50' type='email' name='email' style='background-color: #454d55; border-color: #454d55; color: white;'> </input> </td>");
								    out.print("<td> <input required type='password' name='password' style='background-color: #454d55; border-color: #454d55; color: white;'> </input> </td>");
								    out.print("<td><select name='type' style='background-color: #454d55; border-color: #454d55; color: white;'>");
								    out.print("<option value='adm' selected>Administrador</option>");
									out.print("<option value='user'>Usuario</option>");	    
								    out.print("</select> </td>");
								    out.print("<td> <button type='submit' style='text-align: center; color:grey;' class='fa fa-save'></button></td>");
						      	out.print("</tr> </form>");
						    %>
						   
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	</body>
</html>

