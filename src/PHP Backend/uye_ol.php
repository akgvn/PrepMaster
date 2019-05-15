<?php

        try{
    $db = new PDO('mysql:host=localhost;dbname=u8250606_chard','u8250606_user22C','DUpj07B2');
}catch(PDOException $e){
    echo $e -> getMessage();
}


if( $_POST )
{


	$email_kontrol = 0;
	$isim_kontrol  = 0;


	$tarih = date( "Y-m-d" );
	$saat  = date( "H:i" );
	$isim  = trim( $_POST[ "user_nick_name" ] );
	$email = trim( $_POST[ "user_email" ] );
	$sifre = trim( $_POST[ "user_password" ] );



	if( isset( $isim ) && isset( $email ) && isset( $sifre ) )
	{

		if( !empty( $isim ) && !empty( $email ) && !empty( $sifre ) )
		{

			if( strlen( $isim ) < 120 && strlen( $email ) < 120 && strlen( $sifre ) < 120  )
			{

				$cek = $db -> prepare( "SELECT * FROM users WHERE user_nick_name=?" );
				$cek -> execute( array( $isim ) );

				$isim_kontrol = $cek -> rowCount();

				$cek = $db -> prepare( "SELECT * FROM users WHERE user_email=?" );
				$cek -> execute( array( $email ) );
			
				$email_kontrol = $cek -> rowCount();

				if( !$isim_kontrol )
				{

					if( !$email_kontrol )
					{

						$ekle = $db -> prepare( "INSERT INTO users SET user_date=? , user_hour=? , user_nick_name=? , user_email=? , user_password=?" );

						$ekle -> execute( array( $tarih , $saat , $isim , $email , $sifre ) );

						echo json_encode( array( "ans" => 6 ) );

					}
					else
					{
						echo json_encode( array( "ans" => 5 ) );//KAYITLI EMAİL
					}

				}
				else
				{
					echo json_encode( array( "ans" => 4 ) );//KAYITLI USERNAME
				}

			}
			else
			{
				echo json_encode( array( "ans" => 3 ) );//FAZLA KARAKTER TUŞLAMASI
			}

		}
		else
		{
			echo json_encode( array( "ans" => 2 ) );//BOŞ DEĞER HATASI
		}

	}
	else
	{
		echo json_encode( array( "ans" => 1 ) );//SİSTEM HATASI
	}


}


?>