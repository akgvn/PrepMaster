<?php

/*
qid
word_id
user_id
date
efactor
asked
 */

require_once "connect.php";
require_once "supermemo.php";

// POST request will come

if (!(isset($_POST["answered"]) || isset($_POST["remind"]))) {
    echo "Invalid request!";
}

if (isset($_POST["answered"]) && isset($_POST["user_id"]) && isset($_POST["word_id"]) && isset($_POST["grade"])) {
    $user_id = $_POST["user_id"]; // user logged in right now
    $word_id = $_POST["word_id"]; // id of the word that user answered
    $grade = $_POST["grade"]; // Out of five

    // TODO

} else {
    echo "Invalid request!";
}


if (isset($_POST["remind"]) && isset($_POST["user_id"])) {
    // TODO
}
else {
    echo "Invalid request!";
}