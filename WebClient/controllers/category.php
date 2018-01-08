<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:13
 */
function getCategory($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/categories/".$id;
    $result = get($url);
    return render('categories/category.html.php','dashboard.html.php',array("category"=>$result));
};

function deleteCategory($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/categories/delete/".$id;
    $result = delete($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/categories');
        die();
    }else{
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/categories');
        die();
    }
};

function allCategories(){
    $url = "http://localhost:8080/JEE_WS/api/rest/categories";
    $result = get($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        return render('categories/categories.html.php','dashboard.html.php',array("categories"=>$result));
    }else{
        return render('categories/categories.html.php','dashboard.html.php',array("categories"=>$result));

    }
};

function addCategory(){
    if(isset($_POST['name'])){
        $post = $_POST;
        unset($post["action"]);
        $result = post('http://localhost:8080/JEE_WS/api/rest/categories/add', $post);
        if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
            flash("error","inconnu");
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/categories/add');
            die();
        }else {
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/categories/'.json_decode($result)->id);
            die();
        }
    }else{
        return render('categories/category.html.php','dashboard.html.php',array("category"=>""));
    }
};

function updateCategory($id){
    $post = $_POST;
    unset($post["action"]);
    $post["id"] = $id;
    $result = post('http://localhost:8080/JEE_WS/api/rest/categories/update/'.$id, $post);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/categories/'.$id);
        die();
    }else {
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/categories/'.$id);
        die();
    }
};