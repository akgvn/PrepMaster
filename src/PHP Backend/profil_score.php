<?php

require_once "connect.php";

function turkce($php)
{
    $php = str_replace("&#305;", "ı", $php);
    $php = str_replace("&#304;", "İ", $php);
    $php = str_replace("&#252;", "ü", $php);
    $php = str_replace("&#220;", "Ü", $php);
    $php = str_replace("&#287;", "ğ", $php);
    $php = str_replace("&#286;", "Ğ", $php);
    $php = str_replace("&#246;", "ö", $php);
    $php = str_replace("&#214;", "Ö", $php);
    $php = str_replace("&#351;", "ş", $php);
    $php = str_replace("&#350;", "Ş", $php);
    $php = str_replace("&#231;", "ç", $php);
    $php = str_replace("&#199;", "Ç", $php);

    return $php;
}

if ($_POST) {

    $isim = trim($_POST["user_nick_name"]); // receive user_nick_name from App

    if (isset($isim)) {

        if (!empty($isim)) {

            if (strlen($isim) <= 120) {

                $arraym = array();

                $y1 = $isim;

                $sorgu = $db->prepare("SELECT * FROM users WHERE user_nick_name=?"); // check data base and assign $sorgu

                $sorgu->execute(array($y1));

                if ($sorgu->rowCount()) {

                    foreach ($sorgu as $yaz) {

                        // $arraym[0] = turkce($yaz["user_nick_name"]);
                        $arraym[0] = $yaz["user_score"];
                        $arraym[1] = $yaz["user_true_ans"];
                        $arraym[2] = $yaz["user_false_ans"];

                    }

                    $metin .= '{"user_score":' . '"' . $arraym[0] . '"' . ',"user_true_ans":' . '"' . $arraym[1] . '"' . ',"user_false_ans":' . '"' . $arraym[2] . '"' . '}';

                    echo $metin;

                } else {

                    $hata_kodu = "";

                    echo $metin .= '{"user_score":' . '"' . $hata_kodu . '"' . ',"user_true_ans":' . '"' . $hata_kodu . '"' . ',"user_false_ans":' . '"' . $hata_kodu . '"' . '}';

                }

            }

        }

    }

} else {
    echo "istek yok";
}
