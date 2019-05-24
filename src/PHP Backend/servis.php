<?php

require_once 'connect.php';

$x1 = rand(1, 60);
$sorgu = $db->prepare('SELECT * FROM fill_blanks WHERE id =?');
$sorgu->execute([
    $x1,
]);
$words = $sorgu->fetchALL(PDO::FETCH_ASSOC);
//print_r($words);
$array = array();

$array[] = $words[0]['sentence'];
$array[] = $words[0]['word'];

$array[] = $words[0]['meaning'];
//$array[] =$words[0]['id'];
$check = array();
$check[] = $x1;
$i = 0;
$metin = "";
do {
    $temp = $i;
    $y1 = rand(1, 60);
    if (!in_array($y1, $check)) {
        $sorgu = $db->prepare('SELECT * FROM fill_blanks WHERE id =?');
        $sorgu->execute([
            $y1,
        ]);
        $words2 = $sorgu->fetchALL(PDO::FETCH_ASSOC);
        $array[] = $words2[0]['word'];

        $check[] = $y1;
        $i++;
    }

} while ($i < 3);
$array[0] = str_replace($array[1], ".....", $array[0]); //+++++
$metin .= '{"sentence":"' . $array[0] . '"' . ',"msg1":' . '"' . $array[1] . '"' . ',"msg2":' . '"' . $array[2] . '"' . ',"msg3":' . '"' . $array[3] . '"' . ',"msg4":' . '"' . $array[4] . '"' . ',"msg5":' . '"' . $array[5] . '"' . ' ,"id":' . '"' . $x1 . '"' . '}';
//echo json_encode( $array );
echo $metin;
