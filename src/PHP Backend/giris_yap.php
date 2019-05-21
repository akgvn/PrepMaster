<?php

if ($_POST) {

    require_once "connect.php";

    $giris_kontrol = 0;

    $user_nick_name = trim($_POST["user_nick_name"]);
    $user_password = trim($_POST["user_password"]);

    if (isset($user_nick_name) && isset($user_password)) {

        if (!empty($user_nick_name) && !empty($user_password)) {

            if (strlen($user_nick_name) < 120 && strlen($user_password) < 120) {

                $kontrol = $db->prepare("SELECT * FROM users WHERE user_nick_name=? and user_password=?");
                $kontrol->execute(array($user_nick_name, $user_password));

                $giris_kontrol = $kontrol->rowCount();

                if ($giris_kontrol) {

                    echo json_encode(array("ans" => 1)); // Welcome

                } else {
                    echo json_encode(array("ans" => 2)); // Invalid logIn
                }

            } else {
                echo json_encode(array("ans" => 3)); // Long input
            }

        } else {
            echo json_encode(array("ans" => 4)); // Empty argumant
        }

    } else {
        echo json_encode(array("ans" => 5)); // Invalid variable
    }

}
