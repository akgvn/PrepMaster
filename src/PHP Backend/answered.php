<?php

require_once "connect.php";
require_once "supermemo.php";

// POST request will come

// User answered a question on the app.
if (isset($_POST["user_nick_name"]) && isset($_POST["word_id"]) && isset($_POST["grade"])) {
    $user_nick_name = $_POST["user_nick_name"]; // the user logged in right now
    $word_id = $_POST["word_id"]; // id of the word user answered
    $grade = $_POST["grade"]; // Out of five
    $asked = 0;

    print_r($_POST); // FIXME delete this later

    // Schedule reminding time!

    try {
        // Get all rows w/ this user & word, which hasn't been asked yet.
        $stmt = $db->prepare("SELECT * FROM schedule WHERE user_nick_name=:uid AND word_id=:wid AND asked=:ask");
        $stmt->bindparam(":uid", $user_nick_name);
        $stmt->bindparam(":wid", $word_id);
        $stmt->bindparam(":ask", $asked);

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
        $intrvl = 1;
        $repeats = 0;

    } else if (count($rows) == 1) {
        // Prepare the variables for INSERTing to DB.

        $row = $rows; // Copy the question data.

        try {
            // Update the scheduled row as asked.
            $stmt = $db->prepare("UPDATE schedule SET asked=1 WHERE qid=:qi");
            $stmt->bindparam(":qi", $row["qid"]);
            $stmt->execute();
        } catch (PDOException $e) {
            echo $e->getMessage();
            exit; // FIXME Send error code?
        }

        $repeats = $row["repeat_time"] + 1;
        $efactor = easiness($row["efactor"], $grade);
        $intrvl = interval($repeats, $efactor, $row["old_interval"]); // Number of days from now.

    } else {
        // TODO Shouldn't happen. Add error for this.
    }

    $scheduled_date = date("Y-m-d", strtotime("+" . $intrvl . " days"));

    echo $scheduled_date; // FIXME for testing

    try {
        // Schedule the word.
        $stmt = $db->prepare("INSERT INTO schedule(word_id, user_nick_name, date, efactor, repeat_time, old_interval)
        VALUES(:wid, :uid, :dte, :ef, :rt, :oi)");

        $stmt->bindparam(":uid", $user_nick_name);
        $stmt->bindparam(":wid", $word_id);
        $stmt->bindparam(":dte", $scheduled_date);
        $stmt->bindparam(":ef", $efactor);
        $stmt->bindparam(":rt", $repeats);
        $stmt->bindparam(":oi", $intrvl);

        $stmt->execute();
    } catch (PDOException $e) {
        echo $e->getMessage();
        exit; // FIXME Send error code?
    }

} else {
    echo "Invalid request!";
}

?>