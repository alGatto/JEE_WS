<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:12
 */
function dashboard(){
    if(isset($_SESSION['isConnected']) && $_SESSION['isConnected']==true){
        return render('dash.html.php','dashboard.html.php');
    }else{
        header("Location: localhost:8080".$_SERVER['PHP_SELF'].'?/login');
    }
}