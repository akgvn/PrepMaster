<?php

/*
qid
word_id
user_id
date
efactor
asked
repeat_time
old_interval
 */

require_once "connect.php";
require_once "supermemo.php";

// POST request will come

if (!(isset($_POST["answered"]) || isset($_POST["remind"]))) {
    echo "Invalid request!";
}

if (isset($_POST["answered"]) && isset($_POST["user_id"]) && isset($_POST["word_id"]) && isset($_POST["grade"])) {
    $user_id = $_POST["user_id"]; // the user logged in right now
    $word_id = $_POST["word_id"]; // id of the word user answered
    $grade = $_POST["grade"]; // Out of five

    print_r($_POST); // FIXME delete this later

    // Schedule reminding time!

    try {
        $stmt = $db->prepare("SELECT * FROM schedule WHERE user_id=:uid AND word_id=wid");
        $stmt->bindparam(":uid", $user_id);
        $stmt->bindparam(":wid", $word_id);

        $stmt->execute();
    } catch (PDOException $e) {
        echo $e->getMessage();
        exit; // FIXME Send error code?
    }

    $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

    if (!(count($rows) > 0)) {
        // This word wasn't scheduled before.
        // TODO
    }

} else {
    echo "Invalid request!";
}

if (isset($_POST["remind"]) && isset($_POST["user_id"])) {
    // TODO
} else {
    echo "Invalid request!";
}
