<?php  
 require "init.php"; 
$FirstName			= $_POST["FirstName"];		 
$LastName           = $_POST["LastName"];         
$Address            = $_POST["Address"];          
$City               = $_POST["City"];             
$Dist               = $_POST["Dist"];             
$State              = $_POST["State"];            
$HomePhone          = $_POST["HomePhone"];        
$MobilePhone        = $_POST["MobilePhone"];      
$EmailAddress       = $_POST["EmailAddress"];
$CnvtSex			= $_POST["Sex"];     
$Sex                = (int)$CnvtSex;
$CnvtPartiyatra		= $_POST["Partiyatra"];           
$Partiyatra         = (int)$CnvtPartiyatra; 
$CnvtStuBv      	= $_POST["Stu_Balvikas"];
$Stu_Balvikas       = (int)$CnvtStuBv;
$CnvtBVguru			= $_POST["Guru_Balvikas"];
$Guru_Balvikas      = (int)$CnvtBVguru;    
$Education          = $_POST["Education"];       
$Occupation         = $_POST["Occupation"];       
$Skill              = $_POST["Skill"];    
$Lang_cd            = $_POST["Lang_cd"];
$CnvtAge			= $_POST["Age"];        
$Age				= (int)$CnvtAge;
$sevafrequency      = $_POST["sevafrequency"];  
$interest            = $_POST["inareas"];     


 $sql_query = "insert into per_details values(
 '$FirstName'
,'$LastName'
,'$Address'
,'$City'
,'$Dist'
,'$State'
,'$HomePhone'
,'$MobilePhone'
,'$EmailAddress'
,'$Sex'
,'$Partiyatra'
,'$Stu_Balvikas'
,'$Guru_Balvikas'
,'$Education'
,'$Occupation'
,'$Skill'
,'$Lang_cd'
,'$Age'
,'$sevafrequency'
,'$interest');"; 

if(mysqli_query($con,$sql_query))
{
	 echo "Data insertion success..Welcome ";
	
}
else
{
	echo "Data insertion error..".mysqli_error($con);
}

 ?> 