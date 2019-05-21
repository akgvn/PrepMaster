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
        // Get all rows w/ this user & word, which hasn't been asked yet.
        $stmt = $db->prepare("SELECT * FROM schedule WHERE user_id=:uid AND word_id=wid AND asked=:ask");
        $stmt->bindparam(":uid", $user_id);
        $stmt->bindparam(":wid", $word_id);
        $stmt->bindparam(":ask", 0);

        $stmt->execute();
    } catch (PDOException $e) {
        echo $e->getMessage();
        exit; // FIXME Send error code?
    }

    $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

    if (count($rows) == 0) {
        // This word wasn't scheduled before.

        $efactor = 2.5;
        $repeat = 0;

    } else if (count($rows) == 1) {
        // TODO Prepare the variables for INSERTing to DB.

        try {
            // Update the scheduled row as asked.
            $stmt = $db->prepare("UPDATE schedule SET asked=1 WHERE qid=:qi");
            $stmt->bindparam(":qi", $rows["qid"]);
            $stmt->execute();
        } catch (PDOException $e) {
            echo $e->getMessage();
            exit; // FIXME Send error code?
        }

        $efactor = easiness($rows["efactor"], $grade);
        $intrvl = interval($rows["repeat_time"], $efactor, $rows["old_interval"]); // Number of days from now.
        
        // TODO find the date to schedule here.
    } else {
        // TODO Shouldn't happen. Add error for this.
    }

    // TODO Do the INSERTION

    $stmt = $db->prepare("INSERT INTO schedule(word_id, user_id, date, efactor, repeat_time, old_interval) 
    VALUES(:wid, :uid, :dte, :ef, :rt, :oi)");
    

} else {
    echo "Invalid request!";
}

// App requests questions to ask to the user.
if (isset($_POST["remind"]) && isset($_POST["user_id"])) {
    // TODO
} else {
    echo "Invalid request!"; // FIXME Send error code with JSON?
}
