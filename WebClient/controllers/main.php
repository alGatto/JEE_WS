<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:12
 */
function main_page(){
    if(!isset($_SESSION['isConnected']) || $_SESSION['isConnected']!=true){
        header("Location: http://localhost:8080".$_SERVER['PHP_SELF'].'?/login');
    }else{
        header("Location: http://localhost:8080".$_SERVER['PHP_SELF'].'?/dashboard');
    }
}