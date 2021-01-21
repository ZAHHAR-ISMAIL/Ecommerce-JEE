<%-- 
    Document   : AdminListArticles
    Created on : 1 avr. 2020, 04:44:11
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

  <title>Admin - ZAH Store</title>
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
          <a class="dropdown-item" href="../logout.php">
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
      <button class="sidebar-minimizer brand-minimizer" type="button">ILISI 2020</button>
    </div>
    <main class="main">

      <!-- Breadcrumb-->
      <ol class="breadcrumb">
        
        <li class="breadcrumb-item">
          <a href="index.php">Admin</a>
        </li>
        <li class="breadcrumb-item active">Articles</li>
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
              <a href="../logout.php" class="btn"> 
              <i class="icon-settings"></i> LOGOUT</a>
          </div>
        </li>
      </ol>


      <div id="Priciple" style="margin:5px; margin-left:10px;">
        <h1> Liste des articles: </h1>
        <div id="save" align="center" style="margin: 10px">
          <a href="addArticle.asp?action=add"><button id="ajouter_etudiant" class="btn btn-info btn-lg" >Ajouter une article</button></a>
        </div>
        <table id="liste_etudiants" class="table table-striped">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Image</th>
              <th scope="col">Nb Stock</th>
              <th scope="col">Prix</th>
              <th scope="col">Categorie</th>
              <th scope="col">Description</th>
              <th scope="col">Options</th>
            </tr>
          </thead>
          <tbody>

						<c:forEach items="${Amodel.getArticles()}" var="cl">
                    <tr>
                        <th scope="row">${cl.idArticle}</th>
                        <td>${cl.image}</td>
                        <td>${cl.nbStock}</td>
                        <td>${cl.prix}</td>
                        <td>${cl.categorie}</td>
                        <td>${cl.description}</td>
                        
                        <td>
              
                        <a  href="modifier_eleve.php?id=${cl.idArticle}"><img src="img\\modifier.png" title="modifier"></a>
                        <a  href="supprimer_etudiant.php?id=${cl.idArticle}"><img src="img\\supp.png" title="supprimer"></a>
                        <a  href="detail_eleve.php?id=${cl.idArticle}"><img src="img\\detail.png" title="detail"></a>
                        </td>
                    </tr>
            </c:forEach>
          
          </tbody>
        </table>
      </div>

    </main>

  </div>
  <script>
    $(document).ready(function () {
      $('#liste_etudiants').DataTable({
        //dom: 'B<"clear">lfrtip',
        dom: 'Bfrtip',
        responsive: true,
        "info":     true,
        buttons: [{
          extend: 'print',
          customize: function (win) {
            $(win.document.body)
              .css('font-size', '10pt')
              .prepend(
                '<img src="http://datatables.net/media/images/logo-fade.png" style="position:absolute; top:0; left:0;" />'
              );

            $(win.document.body).find('table')
              .addClass('compact')
              .css('font-size', 'inherit');
          }
        }]
      });
    });
  </script>
  <!--  necessary plugins-->
  <script src="js\DataTables\datatables.min.js"></script>
  <script src="js\bootstrap.min.js"></script>
  <script src="js/main2.js"></script>
</body>

</html>

