<?php  
 require "init.php"; 
$FirstName			= "John";
$LastName           = "Doe";
$Address            = "10 Main st, Somewhere, ST, India";
$City               = "Coimbatore";
$Dist               = "Coimbatore";
$State              = "TN";
$HomePhone          = "422-2970079'";
$MobilePhone        = "1001001000";
$EmailAddress       = "kavsri25@yahoo.com";
$Sex                = "1";
$Partiyatra         = "1";
$Stu_Balvikas       = "1";
$Guru_Balvikas      = "0";
$Education          = "Graduate";
$Occupation         = "Salaried";
$Skill              = "Music";
$Lang_cd            = "HINDI,ENGLISH,Marathi";
$disastertraining   = "1";
$sevafrequency      = "Monthly";
$inareas            = "Bhajan,Gram Seva,Balvikash,District Seva Events,Medical Camps";
 
 $sql_query = "insert into per_details values(
 "$FirstName"
,"$LastName"
,"$Address"
,"$City"
,"$Dist"
,"$State"
,"$HomePhone"
,"$MobilePhone"
,"$EmailAddress"
,"$Sex"
,"$Partiyatra"
,"$Stu_Balvikas"
,"$Guru_Balvikas"
,"$Education"
,"$Occupation"
,"$Skill"
,"$Lang_cd"
,"$disastertraining"
,"$sevafrequency"
,"$inareas");";   
 if(mysqli_query($con,$sql_query))
{
	echo "<h3> Data insertion success...</h3>";
	
}
else
{
	echo "Data insertion error..".mysqli_error($con);
}
 ?> 