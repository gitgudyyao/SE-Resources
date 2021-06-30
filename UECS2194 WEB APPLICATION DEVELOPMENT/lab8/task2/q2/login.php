<?php

/**
* Simple PHP login/logout scripts
	//References
	//https://www.tutorialrepublic.com/php-tutorial/php-mysql-login-system.php
	//https://www.formget.com/login-form-in-php/
**/

// Create database connection using config file
require_once("config.php");

// Define variables and initialize with empty values
$username = $password = "";

//Task 2 Q1 & Q2 
if ($_SERVER["REQUEST_METHOD"] == "POST") {
	
	// Fetch data from the form
	$username = $_POST['email'];
	$password = md5($_POST['password']);
	
	// Check connection
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		exit();
	}
	
	$sql = "SELECT * FROM user WHERE email = '".$username."' AND password = '".$password."'";
	
	$result = mysqli_query($mysqli, $sql);
	$row = mysqli_fetch_array($result);
	$rowcount = mysqli_num_rows($result);
		
	

	if($rowcount == 1) {  //if result matches exactly 1 record (1 user)
		
		//create session object
		session_start();
		$_SESSION["id"] = $row['id'];
		$_SESSION["login_user"] = $row['email'];
		
		mysqli_free_result($result);
		
		//redirect to landing page after log in
		header("Location:account.php"); //you are logged in successfully

	} else {
		//Invalid Username or Password!	
		header("Location:login.php?message=loginfail");		
	}
		
}
else {
	include("include/_form.php");
	if(isset($_GET['message']) && $_GET['message'] == "loginfail")
	{
		echo "<script>alert('Wrong Username or Password!');</script>";
	}
	elseif(isset($_GET['message']) && $_GET['message'] == "notloggedin")
	{
		echo "<script>alert('Your session is timed out.');</script>";
	}
}

?>




