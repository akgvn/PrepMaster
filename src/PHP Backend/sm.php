<?php

require_once "connect.php";
require_once "supermemo.php";

// POST request will come

if (!(isset($_POST["answered"]) || isset($_POST["remind"]))) {
    echo "Invalid request!";
}

// User answered a question on the app.
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
        
        $efactor = 2.5;
        $repeat = 0;

    } else {
        // TODO Prepare the variables for INSERTing to DB.
    }

} else {
    echo "Invalid request!";
}

// App requests questions to ask to the user.
if (isset($_POST["remind"]) && isset($_POST["user_id"])) {
    // TODO
} else {
    echo "Invalid request!"; // FIXME Send error code with JSON?
}
