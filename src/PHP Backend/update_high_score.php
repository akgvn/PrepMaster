<?php
    
try{
    $db = new PDO('mysql:host=localhost;dbname=u8250606_chard;charset=utf8','u8250606_user22C','DUpj07B2');
}catch(PDOException $e){
    echo $e -> getMessage();
}
        

$id    = trim( $_GET[ "user_id" ] );
$name  = trim( $_GET[ "user_name" ] );
$score = trim( $_GET[ "user_score" ] );
$true  = trim( $_GET[ "user_true" ] );
$false = trim( $_GET[ "user_false" ] );


if( $_GET )
{

    if( isset( $id ) && isset( $name ) && isset( $score ) && isset( $true ) && isset($false ) )
    {

        if( !empty( $id ) && !empty( $name ) && !empty( $score ) && !empty( $true ) && !empty( $false ) )
        {

            $query = $db->prepare("UPDATE users SET
            user_score = :new_score , user_true_ans = :new_true , user_false_ans = :new_false
            WHERE user_id = :id and user_nick_name = :name");
            $update = $query->execute(array(
                "new_score" => $score,
                "new_true" => $true,
                "new_false" => $false,
                "id" => $id,
                "name" => $name
            ));

            if( $update )
                echo json_encode( array( "ans" => 3 ) );//UPDATE EDİLDİ
            else
                echo json_encode( array( "ans" => 2 ) );//UPDATE OLMADI

        }
        else
        {
            echo json_encode( array( "ans" => 1 ) );//BOŞ BİR DEĞİŞKEN GÖNDEREMEZSİNİZ
        }

    }
    else
    {
        echo json_encode( array( "ans" => 0 ) );//TANIMSIZ DEĞİŞKEN.
    }

}

        
?>