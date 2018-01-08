<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:12
 */

function login(){
    if(isset($_POST['login']) && isset($_POST['password'])){
        $login = $_POST['login'];
        $pwd = $_POST['password'];
        $result = post('http://localhost:8080/JEE_WS/api/rest/connect', array('login'=>$login, 'password'=>$pwd));
        if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
            set("error","true");
            return html('login.html.php');
        }else {
            $result = json_decode($result);
            $_SESSION['isConnected'] = true;
            $_SESSION['firstName'] = $result->firstName;
            $_SESSION['lastName'] = $result->lastName;
            $_SESSION['login'] = $result->login;
            $_SESSION['userId'] = $result->id;
            $_SESSION['profile'] = $result->profilePicture;
            $_SESSION['accountState'] = $result->accountState;
            $_SESSION['isAdmin'] = ($result->isAdmin)?true:false;
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/dashboard');
        }
    }elseif(isset($_SESSION['isConnected']) && $_SESSION['isConnected'] == true){
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/dashboard');
        die();
    }else{
        return html('login.html.php');
    }
}

function register(){
    if(isset($_POST['firstname'])){
        $post = $_POST;
        unset($post["action"]);
        $result = post('http://localhost:8080/JEE_WS/api/rest/users/add', $post);
        if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
            flash("error","inconnu");
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/register');
            die();
        }else {
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/register');
            die();
        }
    }else{
        return html('register.html.php');
    }
}