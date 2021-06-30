<?php

/**
* Simple PHP login/logout scripts
//https://www.tutorialrepublic.com/php-tutorial/php-mysql-login-system.php
**/

// Create database connection using config file
require_once("config.php");

// Define variables and initialize with empty values
$username = $password = "";

//Task 2 Q1 
if ($_SERVER["REQUEST_METHOD"] == "POST") {
	
	// Fetch data from the form
	$username = $_POST['email'];
	$password = md5($_POST['password']);
	
	//What is hashing?
	/*
	Hashing is generating a value or values from a string of text using a mathematical function.
	
	Hashing is one way to enable security during the process of message transmission when the message is intended for a particular recipient only. A formula generates the hash, which helps to protect the security of the transmission against tampering. 
	https://www.techopedia.com/definition/14316/hashing
	*/
	
	//What is MD5?
	/*
	The MD5 hashing algorithm is a one-way cryptographic function that accepts a message of any length as input and returns as output a fixed-length digest value to be used for authenticating the original message.
	The original value cannot be retrieved once hashed.
	https://searchsecurity.techtarget.com/definition/MD5
	*/
	
	// Check connection if success / fail
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		exit(); //terminate the program and exit
	}
	
	//Formulating the SQL select statement string
	$sql = "SELECT * FROM user WHERE email = '".$username."' AND password = '".$password."'";
	
	//Execute the SQL SELECT statement
	$result = mysqli_query($mysqli, $sql);	
	
	//Retrieve the number of rows returned by the SQL SELECT statement and assign it to a local variable
	$rowcount = mysqli_num_rows($result);
	
	//From the result from the memory
	mysqli_free_result($result);	

	if($rowcount == 1) {  //Success: if result matches exactly 1 record (1 user), meaning a unique user is matched in the database by the username (email) and password

		//redirect to the landing page after login 
		header("Location:account.php"); //you are logged in successfully

	} else {
		//Failure Invalid Username or Password!	
		//Redirect to the login form page again and passing the status on the query string "message"
		header("Location:login.php?message=loginfail");		
	}
		
}
else {
/*
The username and password shall be obtained via an HTML Form.
REQUEST_METHOD is GET, display the form.
*/
	include("include/_form.php");
	
	//in specific case when user login fails and the form is reloaded, print out an alert query string "message" by printing javascript using php
	if(isset($_GET['message']) && $_GET['message'] == "loginfail") 
	{
		echo "<script>alert('Wrong Username or Password!');</script>";
	}
}

?>




