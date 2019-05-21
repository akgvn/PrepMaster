<?php

require_once "connect.php";
require_once "supermemo.php";

// POST request will come

// App requests questions to ask to the user.
if (isset($_POST["remind"]) && isset($_POST["user_id"])) {
    // TODO
} else {
    echo "Invalid request!"; // FIXME Send error code with JSON?
}

?>