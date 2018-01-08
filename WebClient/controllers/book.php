<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:12
 */
function getBook($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/books/".$id;
    $url1 = "http://localhost:8080/JEE_WS/api/rest/categories/";
    $result = get($url);
    $cat = get($url1);
    return render('books/book.html.php','dashboard.html.php',array("book"=>$result, "categories"=>$cat));
};

function getBookByCat($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/books";
    $result = get($url);
    $save = array();
    foreach (json_decode($result) as $book){
        if(isset($book->category) && $book->category->id == $id){
            array_push($save,$book);
        }
    }
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        return render('books/books.html.php','dashboard.html.php',array("books"=>json_encode($save)));
    }else{
        return render('books/books.html.php','dashboard.html.php',array("books"=>json_encode($save)));

    }
};

function deleteBook($id){
    $url = "http://localhost:8080/JEE_WS/api/rest/books/delete/".$id;
    $result = delete($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/books');
        die();
    }else{
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/books');
        die();
    }
};

function allBooks(){
    $url = "http://localhost:8080/JEE_WS/api/rest/books";
    $result = get($url);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        return render('books/books.html.php','dashboard.html.php',array("books"=>$result));
    }else{
        return render('books/books.html.php','dashboard.html.php',array("books"=>$result));

    }
};

function addBook(){
    if(isset($_POST['isbn'])){
        $post = $_POST;
        unset($post["action"]);
        $result = post('http://localhost:8080/JEE_WS/api/rest/books/add', $post);
        if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
            flash("error","inconnu");
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/books/add');
            die();
        }else {
            header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/books/'.json_decode($result)->id);
            die();
        }
    }else{
        $url1 = "http://localhost:8080/JEE_WS/api/rest/categories/";
        $result = get($url1);
        return render('books/book.html.php','dashboard.html.php',array("book"=>"","categories"=>$result));
    }
};

function updateBook($id){
    $post = $_POST;
    unset($post["action"]);
    $post["id"] = $id;
    $result = post('http://localhost:8080/JEE_WS/api/rest/books/update/'.$id, $post);
    if(intval($result) != 200 && intval($result)<=503 && intval($result)>=400){
        flash("error","inconnu");
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/books/'.$id);
        die();
    }else {
        header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/books/'.$id);
        die();
    }
};