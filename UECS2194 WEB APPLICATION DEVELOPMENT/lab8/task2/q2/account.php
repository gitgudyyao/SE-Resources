<?php

session_start();

if(!isset($_SESSION['id'])) //User not logged in, Session Id object does not exist 
{
	header("Location:login.php?message=notloggedin");
}
else
{
	echo "You are logged in as ".$_SESSION['login_user']."<br>";
	echo "<a href='logout.php'>Logout</a>";
}
?>