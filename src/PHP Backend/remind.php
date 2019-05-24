<?php

require_once "connect.php";
require_once "supermemo.php";
require_once "wordgetter.php";

// POST request will come

// App requests questions to ask to the user.
if (isset($_POST["user_nick_name"])) {

    $user_nick_name = $_POST["user_nick_name"];
    $asked = 0;
    $dte = date("Y-m-d");

    try {
        // Get all scheduled questions for this user, which hasn't been asked yet.
        $stmt = $db->prepare("SELECT * FROM schedule WHERE user_nick_name=:uid AND asked=:ask AND date=:dte LIMIT 1");
        $stmt->bindparam(":uid", $user_nick_name);
        $stmt->bindparam(":ask", $asked);
        $stmt->bindparam(":dte", $dte);

        $stmt->execute();
    } catch (PDOException $e) {
        echo $e->getMessage();
        exit; // FIXME Send error code?
    }

    // TODO Check for questions and return them!

    $rows = $stmt->fetch(PDO::FETCH_ASSOC);

    //print_r($rows);

    // echo "<br><br>";

    if (count($rows) == 0) {
        // TODO return null;
        // $metin = '{"sentence":"' . " " . '"' . ',"msg1":' . '"' . " " . '"' . ',"msg2":' . '"' . " " . '"' . ',"msg3":' . '"' . " ". '"' . ',"msg4":' . '"' . " " . '"' . ',"msg5":' . '"' . " " . '"' . ' ,"id":' . '"' . " " . '"' . '}';
        echo json_encode(array("sentence" => " ", "msg1" => " ", "msg2" => " ", "msg3" => " ", "msg4" => " ", "msg5" => " ", "id" => " "));
    } else {
        $wid = $rows["word_id"];
        retjson($wid, $db);
    }

} else {
    echo "Invalid request!"; // FIXME Send error code with JSON?
}

?>