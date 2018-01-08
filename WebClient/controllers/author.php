<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:12
 */

function getAuthor($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/authors/".$id;
    $result = get($url);
    return render('authors/author.html.php','dashboard.html.php',array("author"=>$result));
};

function deleteAuthor($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/authors/delete/".$id;
    $result = delete($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/authors');
        die();
    }else{
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/authors');
        die();
    }

};

function allAuthors(){
    $url = "http://localhost:8080/JEE_WS/api/rest/authors";
    $result = get($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        return render('authors/authors.html.php','dashboard.html.php',array("authors"=>$result));
    }else{
        return render('authors/authors.html.php','dashboard.html.php',array("authors"=>$result));

    }

};

function addAuthor(){
    if(isset($_POST['firstname'])){
        $post = $_POST;
        unset($post["action"]);
        $result = post('http://localhost:8080/JEE_WS/api/rest/authors/add', $post);
        if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
            flash("error","inconnu");
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/authors/add');
            die();
        }else {
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/authors/'.json_decode($result)->id);
            die();
        }
    }else{
        return render('authors/author.html.php','dashboard.html.php',array("author"=>""));
    }

};

function updateAuthor($id){
    $post = $_POST;
    unset($post["action"]);
    $post["id"] = $id;
    $result = post('http://localhost:8080/JEE_WS/api/rest/authors/update/'.$id, $post);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/authors/'.$id);
        die();
    }else {
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/authors/'.$id);
        die();
    }
};