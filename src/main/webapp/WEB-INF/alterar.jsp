<!DOCTYPE html>
<%@page import="model.BookStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<% Book book = (Book) request.getAttribute("book"); %>

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
						<table class="table table-bordered table-dark table-hover">
						  <thead>
						    <tr>
						      <th>#</th>
						      <th>Nome</th>
						      <th>Autor</th>
						      <th>Data</th>
						      <th>Status</th>
						      <th>Salvar</th>
						    </tr>
						  </thead>
						  <tbody>
					
						  	<% 
						  		out.print("<form action=alterar?action=alterar&id="+book.getId()+ " method='POST'>");
						   		out.print("<tr>");
								    out.print("<th scope='row'>1</th>");
								    out.print("<td>"+book.getName()+"</td>");
								    out.print("<td>"+book.getAuthor().getName()+"</td>");
								    String dateStr = book.getDate().toString();
								    DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
								    DateFormat formatter1 = new SimpleDateFormat("dd-mm-yyyy");
								    out.print("<td>"+formatter1.format(formatter.parse(dateStr))+"</td>");
								    out.print("<td><select name='status' style='background-color: #454d55; border-color: #454d55; color: white;'>");
								   	
								    if (book.getBookStatus().equals(BookStatus.DISPONIVEL)){
								    	out.print("<option value='DISPONIVEL' selected>DISPONIVEL</option>");
									    out.print("<option value='INDISPONIVEL'>INDISPONIVEL</option>");
									    out.print("<option value='EMPRESTADO'>EMPRESTADO</option>");
								    }else if (book.getBookStatus().equals(BookStatus.INDISPONIVEL)){
								    	out.print("<option value='DISPONIVEL'>DISPONIVEL</option>");
									    out.print("<option value='INDISPONIVEL' selected>INDISPONIVEL</option>");
									    out.print("<option value='EMPRESTADO'>EMPRESTADO</option>");
								    }else{
								    	out.print("<option value='DISPONIVEL'>DISPONIVEL</option>");
									    out.print("<option value='INDISPONIVEL'>INDISPONIVEL</option>");
									    out.print("<option value='EMPRESTADO' selected>EMPRESTADO</option>");
								    }
								    
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

