<?php
require "init.php";
$name="KAVYA";
$user_name="kavya123";
$user_pass="kavya@23123";

$sql_query="insert into user_info values('$name','$user_name','$user_pass');";
if(mysqli_query($con,$sql_query))
{
	echo "<h3> Data insertion success...</h3>";
	
}
else
{
	echo "Data insertion error..".mysqli_error($con);
}
?>
