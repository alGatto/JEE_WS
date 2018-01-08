<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
    <title>LibraryProject</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--Import Google Icon Font-->
    <link href="./public/css/font-awesome.min.css" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="./public/css/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" href="./public/css/style.css" rel="stylesheet">

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>

<nav class="lighten-2 hide-on-large-only">
    <div class="nav-wrapper">
        <a href="#!" class="brand-logo">LibraryProject</a>
        <a href="#" data-activates="sidenav" class="button-collapse"><h4><i style="line-height: inherit" class="fa fa-bars"></i></h4></a>
    </div>
</nav>

<ul id="sidenav" class="side-nav fixed lighten-2">
    <a href="<?php echo url_for('/disconnect')?>" class="right "><i class="fa fa-eject blue-text cyan-text valign-wrapper" style="height: 100%; font-size: 1.6em"></i></a>
    <a href="<?php echo url_for('/'.$_SESSION['userId']) ?>">
        <div class="col s12 cyan-text" style="display: flex; align-items: center; justify-content: center">
            <span class="fa-stack fa-lg col s4">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-user fa-stack-1x fa-inverse white-text"></i>
            </span>
            <span class="col s8 cyan-text" style="font-size: 2.5em"><?php echo $_SESSION['firstName']?></span>
        </div>
    </a>
    <li><a href="<?php echo url_for('/dashboard')?>" class="cyan-text">Accueil</a></li>
    <li><a href="<?php echo url_for('/books')?>" class="cyan-text">Livres</a></li>
    <li><a href="<?php echo url_for('/authors')?>" class="cyan-text">Auteurs</a></li>
    <li><a href="<?php echo url_for('/categories')?>" class="cyan-text">Catégories</a></li>
    <?php if(isset($_SESSION['isAdmin']) && $_SESSION['isAdmin'] == true){?>
        <li><a href="<?php echo url_for('/loans/')?>" class="cyan-text">Prêts</a></li>
        <li><a href="<?php echo url_for('/users')?>" class="cyan-text">Comptes Utilisateurs</a></li>
    <?php }elseif (isset($_SESSION['isAdmin']) && $_SESSION['isAdmin'] == false){?>
        <li><a href="<?php echo url_for($_SESSION['userId'].'/loans/')?>" class="cyan-text">Prêts</a></li>
    <?php } ?>
</ul>
<main>
    <?php echo $content ?>
</main>
<script type="text/javascript" src="./public/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="./public/js/materialize.min.js"></script>
<script type="text/javascript">
    (function($){
        $(function(){

            $('.button-collapse').sideNav();
            $('select').material_select();
            Materialize.updateTextFields();

        });
    })(jQuery);
</script>
</body>
</html>