<?php

require_once "connect.php";

$name = trim($_GET["user_name"]);
$score = trim($_GET["user_score"]);
$true = trim($_GET["user_true"]);
$false = trim($_GET["user_false"]);

if ($_GET) {

    if (isset($name) && isset($score) && isset($true) && isset($false)) {

        if (!empty($name) && !empty($score) && !empty($true) && !empty($false)) {

            $cek = $db->prepare("SELECT * FROM users WHERE user_nick_name=?");
            $cek->execute(array($name));

            foreach ($cek as $yaz) {

                $score = $score + $yaz["user_score"];

                $true = $true + $yaz["user_true_ans"];

                $false = $false + $yaz["user_false_ans"];

            }

            $query = $db->prepare("UPDATE users SET
                     user_score = :new_score , user_true_ans = :new_true , user_false_ans = :new_false
                     WHERE user_nick_name = :name");
            $update = $query->execute(array(
                "new_score" => $score,
                "new_true" => $true,
                "new_false" => $false,
                "name" => $name,
            ));

            if ($update) {
                echo json_encode(array("ans" => 3));
            }
//UPDATE EDİLDİ
            else {
                echo json_encode(array("ans" => 2));
            }
//UPDATE OLMADI

        } else {
            echo json_encode(array("ans" => 1)); //BOŞ BİR DEĞİŞKEN GÖNDEREMEZSİNİZ
        }

    } else {
        echo json_encode(array("ans" => 0)); //TANIMSIZ DEĞİŞKEN.
    }

}
