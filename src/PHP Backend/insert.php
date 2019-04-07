<?php

	// INSERT INTO table_name SET col1 = value1;
	
	$db->query('INSERT INTO fill_blanks SET word="range(n)",meaning="variety,kinds",sentence="I saw a range of colours/patterns on the carpet"');

	$db->query('INSERT INTO fill_blanks SET word="principal(n)",meaning="manager",sentence="There are seven theachers and a principal at the school"');
	$db->query('INSERT INTO fill_blanks SET word="encourage(v)",meaning="persuade",sentence="My parents encourage me when thing were not going well at school"');
	$db->query('INSERT INTO fill_blanks SET word="enhance(v)",meaning="improve",sentence="I need to enhance my English ability to pass exam."');
	$db->query('INSERT INTO fill_blanks SET word="evidence(n)",meaning="something that makes you believe that something is true or exists.",sentence="There is no scientific evidence that the drug is addictive."');
	$db->query('INSERT INTO fill_blanks SET word="expand(v)",meaning="to become larger in size,number,or,amount,or to make something become larger.",sentence="Sydney s popilation expanded rapidly in the 1960 s."');


	
	$x1 = rand(0,5);

	$sorgu = $db -> prepare('SELECT * FROM fill_blanks WHERE id =?');
	$sorgu->execute([
		$x1
	]);
	$words = $sorgu->fetchALL(PDO::FETCH_ASSOC);

	print_r($words);

	
	
?>
