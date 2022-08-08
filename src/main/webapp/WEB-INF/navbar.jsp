<!doctype html>
<% String type = (String) request.getAttribute("type"); %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="navbar/fonts/icomoon/style.css">

    <link rel="stylesheet" href="navbar/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="navbar/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="navbar/css/style.css">

    <title>Biblioteca</title>
  </head>
  <body>


    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
   
    
    <header class="site-navbar js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-6 col-xl-2">
            <h1 class="mb-0 site-logo"><a href="#" style="color:white;">Biblioteca</a></h1>
          </div>

          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
              	<% 
					if (type.equals("adm")){
						out.println("<li><a href='inserir_usuario?action=inserir' class='nav-link' style='color: white;'><b>CADASTRAR USUARIO</b></a></li>"); 
					}
				%>
                <li><a href="logout" class="nav-link" style="color: white;"><b>SAIR</b></a></li>
              </ul>
            </nav>
          </div>


          <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle float-right"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
      
    </header>
  

  
    
    

    <script src="navbar/js/jquery-3.3.1.min.js"></script>
    <script src="navbar/js/popper.min.js"></script>
    <script src="navbar/js/bootstrap.min.js"></script>
    <script src="navbar/js/jquery.sticky.js"></script>
    <script src="navbar/js/main.js"></script>
  </body>
</html>