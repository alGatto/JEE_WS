<?php
/**
 * Created by PhpStorm.
 * User: algattuso
 * Date: 08/01/2018
 * Time: 21:13
 */

//Requete post via curl
function post($url,$params){
    global $proxy_url, $proxy_type;
    $curl = curl_init($url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($curl, CURLOPT_POST, true);
    curl_setopt($curl, CURLOPT_POSTFIELDS, http_build_query($params)); // On passe les paramètres au travers de la fonction http_build_query
    $curl_response = curl_exec($curl);
    $info = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    curl_close($curl);
    if($info != 200){
        return $info;
    }else {
        return $curl_response;
    }
};

function delete($path)
{
    $url = $path;
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL,$url);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
    curl_setopt($ch, CURLOPT_HEADER, false);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    $result = curl_exec($ch);
    $info = curl_getinfo($ch, CURLINFO_HTTP_CODE);
    curl_close($ch);

    if($info != 200){
        return $info;
    }else {
        return $result;
    }
};

function get($path){
    $ch = curl_init();
    curl_setopt($ch,CURLOPT_URL,$path);
    curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
    $output=curl_exec($ch);
    $info = curl_getinfo($ch, CURLINFO_HTTP_CODE);
    curl_close($ch);
    if($info != 200){
        return $info;
    }else {
        return $output;
    }
};

function disconnect(){
    session_destroy();
    header("Location: http://localhost:8888".$_SERVER['PHP_SELF'].'?/login');
    die();
}