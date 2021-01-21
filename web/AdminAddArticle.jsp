<%-- 
    Document   : AdminAddArticle
    Created on : 1 avr. 2020, 06:44:46
    Author     : ISMAIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
  <base href="./">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
  <meta name="author" content="Łukasz Holeczek">
  <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
  <title>Add Article</title>
  <!-- Icons-->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style2.css" rel="stylesheet">
  <script src="js\jquery.min.js"></script>

  <!-- <link href="vendors/pace-progress/css/pace.min.css" rel="stylesheet"> -->
</head>

<body class="app header-fixed sidebar-fixed aside-menu-fixed sidebar-lg-show">
  <header class="app-header navbar">
    <button class="navbar-toggler sidebar-toggler d-lg-none mr-auto" type="button" data-toggle="sidebar-show">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">
      <img class="navbar-brand-full" src="img/logo.png" width="89" height="25" alt="CoreUI Logo">
      <img class="navbar-brand-minimized" src="img/brand/sygnet.svg" width="30" height="30" alt="CoreUI Logo">
    </a>
    <button class="navbar-toggler sidebar-toggler d-md-down-none" type="button" data-toggle="sidebar-lg-show">
      <span class="navbar-toggler-icon"></span>
    </button>
    <ul class="nav navbar-nav d-md-down-none">
      <li class="nav-item px-3">
        <a class="nav-link" href="index.php">Principale</a>
      </li>
      <li class="nav-item px-3">
        <a class="nav-link" href="#">Users</a>
      </li>
      <li class="nav-item px-3">
        <a class="nav-link" href="#">Settings</a>
      </li>
    </ul>
    <ul class="nav navbar-nav ml-auto">
      <li class="nav-item d-md-down-none">
        <a class="nav-link" href="#">
          <i class="icon-bell"></i>
          <span class="badge badge-pill badge-danger">ILISI 2020</span>
        </a>
      </li>
      <li class="nav-item d-md-down-none">
        <a class="nav-link" href="#">
          <i class="icon-list"></i>
        </a>
      </li>
      <li class="nav-item d-md-down-none">
        <a class="nav-link" href="#">
          <i class="icon-location-pin"></i>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
          <img class="img-avatar" src="img/avatars/6.jpg" alt="admin@bootstrapmaster.com">
        </a>
        <div class="dropdown-menu dropdown-menu-right">
          <div class="dropdown-header text-center">
            <strong>Account</strong>
          </div>
          <a class="dropdown-item" href="#">
            <i class="fa fa-bell-o"></i> Updates
            <span class="badge badge-info">42</span>
          </a>
          <a class="dropdown-item" href="#">
            <i class="fa fa-envelope-o"></i> Messages
            <span class="badge badge-success">42</span>
          </a>
          <a class="dropdown-item" href="#">
            <i class="fa fa-tasks"></i> Tasks
            <span class="badge badge-danger">42</span>
          </a>
          <a class="dropdown-item" href="#">
            <i class="fa fa-comments"></i> Comments
            <span class="badge badge-warning">42</span>
          </a>
          <div class="dropdown-header text-center">
            <strong>Settings</strong>
          </div>
          <a class="dropdown-item" href="#">
            <i class="fa fa-user"></i> Profile</a>
          <a class="dropdown-item" href="#">
            <i class="fa fa-wrench"></i> Settings</a>
          <a class="dropdown-item" href="#">
            <i class="fa fa-usd"></i> Payments
            <span class="badge badge-secondary">42</span>
          </a>
          <a class="dropdown-item" href="#">
            <i class="fa fa-file"></i> Projects
            <span class="badge badge-primary">42</span>
          </a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">
            <i class="fa fa-shield"></i> Lock Account</a>
          <a class="dropdown-item" href="#">
            <i class="fa fa-lock"></i> Logout</a>
        </div>
      </li>
    </ul>
    <button class="navbar-toggler aside-menu-toggler d-md-down-none" type="button" data-toggle="aside-menu-lg-show">
      <span class="navbar-toggler-icon"></span>
    </button>
    <button class="navbar-toggler aside-menu-toggler d-lg-none" type="button" data-toggle="aside-menu-show">
      <span class="navbar-toggler-icon"></span>
    </button>
  </header>
  <div class="app-body">
    <div class="sidebar">
      <nav class="sidebar-nav">
       <ul class="nav">
               
            <li class="nav-item">
              <a class="nav-link" href="index.php">
                <i class="text-value-sm text-primary"></i> <div class="text-value-sm text-primary">Principale</div>
              </a>
            </li>
            <li class="nav-item">
                <div class="card-body p-0 d-flex align-items-center">
                    <i class="fa fa-cogs bg-primary p-4 font-2xl mr-3"></i>
                    <div>
                      <div class="text-value-sm text-primary">Gestion</div>
                      <div class="text-muted text-uppercase font-weight-bold small"></div>
                    </div>
                  </li> 
            <li class="nav-item">
              <a class="nav-link" href="Etudiants.php">
                <i class="nav-icon icon-speedometer"></i> Articles
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="professeurs.php">
                <i class="nav-icon icon-speedometer"></i> Panier
              </a>
            </li>
           
            
            
          </ul>
      </nav>
      <button class="sidebar-minimizer brand-minimizer" type="button">b</button>
    </div>
    <main class="main">

      <!-- Breadcrumb-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">Home</li>
        <li class="breadcrumb-item">
          <a href="index.php">Admin</a>
        </li>
        <li class="breadcrumb-item active">Principale</li>
        <!-- Breadcrumb Menu-->
        <li class="breadcrumb-menu d-md-down-none">
          <div class="btn-group" role="group" aria-label="Button group">
            <a class="btn" href="#">
              <i class="icon-speech"></i>
            </a>
            <a class="btn" href="index.php">
              <i class="icon-graph"></i> Principale</a>
            <a class="btn" href="#">
              <i class="icon-settings"></i>  Settings</a>
          </div>
        </li>
      </ol>


      <div id="Priciple" style="margin:5px; margin-left:10px;">
      <div class="container">
        <div id="Register">
            <h1 style="border-bottom: 2px solid #3498db;margin-bottom: 5%;">Add new article</h1>
            <div class="container center_div">
                <form id="Register_form" class="col-lg-10" action="adminServlet" method="POST"">

                    <div class="form-row">
                        <div class="col-md-4 mb-2">
                            <label for="validationCustom01">Image</label>
                            <input type="text" class="form-control" name="i" id="Nom" placeholder="Nom" required>
                            
                        </div>
                        <div class="col-md-4 mb-2">
                            <label for="validationCustom02">Nb stock</label>
                            <input type="text" class="form-control" name="n" id="Prénom" placeholder="Prénom"
                                required>
                           
                        </div>
                    </div>

                    <div class="form-row">

                        <div class="col-md-8 mb-4">
                            <label for="validationCustom05">Prix</label>

                            <input type="text" class="form-control" name="p" id="date" placeholder="" required>
                            
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-8 mb-4">
                            <label for="validationCustom04">Categorie</label>
                            <input type="text" class="form-control" name="c" id="tel" placeholder="Telephone"
                                required>
                            
                        </div>
                    </div>

                    <div class="form-row">
                            <div class="col-md-8 mb-4">
                                <label for="validationCustom04">Description</label>
                                <input type="text" class="form-control" name="d"  placeholder="Adresse"
                                required>
                            </div>
                    </div>

                    


                    <input class="pull-right btn btn-primary btn-sm" type="submit" value="addArticle" name="action">
        
                </form>
            </div>
        </div>
        
    </div>
        
      </div>

    </main>

  </div>
  
  <!--  necessary plugins-->
  <script src="js\DataTables\datatables.min.js"></script>
  <script src="js\bootstrap.min.js"></script>
  <script src="js/main2.js"></script>
</body>

</html>
