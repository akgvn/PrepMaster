<?php
	// INSERT INTO table_name SET col1 = value1;
	
	/*$db->query('INSERT INTO fill_blanks SET word="range(n)",meaning="variety,kinds",sentence="I saw a range of colours/patterns on the carpet"');
	$db->query('INSERT INTO fill_blanks SET word="principal(n)",meaning="manager",sentence="There are seven theachers and a principal at the school"');
	$db->query('INSERT INTO fill_blanks SET word="encourage(v)",meaning="persuade",sentence="My parents encourage me when thing were not going well at school"');
	$db->query('INSERT INTO fill_blanks SET word="enhance(v)",meaning="improve",sentence="I need to enhance my English ability to pass exam."');
	$db->query('INSERT INTO fill_blanks SET word="evidence(n)",meaning="something that makes you believe that something is true or exists.",sentence="There is no scientific evidence that the drug is addictive."');
	$db->query('INSERT INTO fill_blanks SET word="expand(v)",meaning="to become larger in size,number,or,amount,or to make something become larger.",sentence="Sydney s popilation expanded rapidly in the 1960 s."');
*/
	require_once 'connect.php';
	
	$x1 = rand(1,6);
	$sorgu = $db -> prepare('SELECT * FROM fill_blanks WHERE id =?' );
	$sorgu->execute([
		$x1
	]);
	$words = $sorgu->fetchALL(PDO::FETCH_ASSOC);
	//print_r($words);
	$array = array();
	
	$array[] =$words[0]['sentence'];
	$array[] =$words[0]['word'];

	$array[] =$words[0]['meaning'];
	$check=array();
	$check[]=$x1;
	$i=0;
	$metin = "";
	do{
		$temp=$i;
		$y1 = rand(1,25);
		if(!in_array($y1, $check))
		{
			$sorgu = $db -> prepare('SELECT * FROM fill_blanks WHERE id =?' );
			$sorgu->execute([
			$y1
				]);
			$words2 = $sorgu->fetchALL(PDO::FETCH_ASSOC);
			$array[] =$words2[0]['word'];
			
			$check[]=$y1;
			$i++;
		}
		
	}while($i<3);
	 $array[0] = str_replace($array[1],".....",$array[0]);//+++++
	$metin .= '{"sentence":"' . $array[0] . '"' . ',"msg1":' . '"' .$array[1] . '"' . ',"msg2":'. '"' .$array[2].'"'.   ',"msg3":'. '"' .$array[3].'"'.  ',"msg4":'. '"' .$array[4].'"'. ',"msg5":'. '"' .$array[5].'"'. '}';
		//echo json_encode(  $array );
			echo $metin;
		
	
	//print_r($array);
	
	/*
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
		
	*/
	
	
	
	
	
?>
