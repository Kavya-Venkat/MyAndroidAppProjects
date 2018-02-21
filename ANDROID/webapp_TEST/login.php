<?php
require "init.php";
$user_name="kavya123";
$user_pass="kavya@23123";

$sql_query="select name from user_info where user_name like '$user_name' and user_pass like '$user_pass';";

$result=mysqli_query($con,$sql_query);

if(mysqli_num_rows($result)>0)
{
	$row =mysqli_fetch_assoc($result);
	$name=$row["name"];
	echo "<h3> Hello World!!!!!!".$name."</h3>";
}
else
{
	echo "no info available";
}
?>