<?php
    
     try{
         $db = new PDO('mysql:host=localhost;dbname=u8250606_chard;charset=utf8','u8250606_user22C','DUpj07B2');
         }catch(PDOException $e){
             echo $e -> getMessage();
         }
        
         function turkce($php){
             $php = str_replace("&#305;","ı",$php);
             $php = str_replace("&#304;","İ",$php);
             $php = str_replace("&#252;","ü",$php);
             $php = str_replace("&#220;","Ü",$php);
             $php = str_replace("&#287;","ğ",$php);
             $php = str_replace("&#286;","Ğ",$php);
             $php = str_replace("&#246;","ö",$php);
             $php = str_replace("&#214;","Ö",$php);
             $php = str_replace("&#351;","ş",$php);
             $php = str_replace("&#350;","Ş",$php);
             $php = str_replace("&#231;","ç",$php);
             $php = str_replace("&#199;","Ç",$php);
             return $php;
         }
         //user_score= user_true_ans-(user_false/4);
        
         $ereyim = array();
        
         $i = 0;
        
         $cek = $db -> query( "SELECT * FROM users ORDER BY user_score DESC LIMIT 25" );
        
         foreach( $cek as $yaz )
         {
             //echo "turkcesiz : " . $yaz[ 'user_nick_name' ] . "<br>";
             // echo "turkceli : " . turkce( $yaz[ "user_nick_name" ] ) . "<br>";
             $ereyim[ 0 ][ $i ] = turkce( $yaz[ "user_nick_name" ] );
             $ereyim[ 1 ][ $i ] = $yaz[ "user_score" ];
             $i++;
            
         }
        
         echo json_encode( $ereyim );
        
        
         ?>