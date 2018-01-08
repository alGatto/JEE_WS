<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:11
 */
function getProfile($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/".$id;
    $result = get($url);
    return render('users/user.html.php','dashboard.html.php',array("user"=>$result));
};

function deleteUser($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/users/delete/".$id;
    $result = delete($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/users');
        die();
    }else{
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/users');
        die();
    }
};

function allUsers(){
    $url = "http://localhost:8080/JEE_WS/api/rest/users";
    $result = get($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        return render('users/users.html.php','dashboard.html.php',array("users"=>$result));
    }else{
        return render('users/users.html.php','dashboard.html.php',array("users"=>$result));

    }
};

function addUser(){
    if(isset($_POST['firstName'])){
        $post = $_POST;
        unset($post["action"]);
        $result = post('http://localhost:8080/JEE_WS/api/rest/users/add', $post);
        if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
            flash("error","inconnu");
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/users/add');
            die();
        }else {
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/users/'.json_decode($result)->id);
            die();
        }
    }else{
        return render('users/user.html.php','dashboard.html.php',array("user"=>""));
    }
};

function updateUser($id){
    $post = $_POST;
    unset($post["action"]);
    $post["id"] = $id;
    $result = post('http://localhost:8080/JEE_WS/api/rest/users/update/'.$id, $post);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/'.$id);
        die();
    }else {
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/'.$id);
        die();
    }
};