<?php

require_once "connect.php";
require_once "supermemo.php";

// POST request will come

// App requests questions to ask to the user.
if (isset($_POST["user_id"])) {

    $user_id = $_POST["user_id"];
    $asked = 0;

    try {
        // Get all scheduled questions for this user, which hasn't been asked yet.
        $stmt = $db->prepare("SELECT * FROM schedule WHERE user_id=:uid AND asked=:ask AND date=:dte");
        $stmt->bindparam(":uid", $user_id);
        $stmt->bindparam(":ask", $asked);
        $stmt->bindparam(":dte", date("Y-m-d"));

        $stmt->execute();
    } catch (PDOException $e) {
        echo $e->getMessage();
        exit; // FIXME Send error code?
    }

    // TODO Check for questions and return them!

    $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // TODO send null if no questions
    // TODO otherwise send first question

} else {
    echo "Invalid request!"; // FIXME Send error code with JSON?
}
