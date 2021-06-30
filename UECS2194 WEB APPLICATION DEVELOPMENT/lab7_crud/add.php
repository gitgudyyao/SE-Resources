<html>
<head>
	<title>Add Users</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<a href="index.php">Go to Home</a>
	<br/><br/>

	<form action="add.php" method="post" name="form1">
		<table width="25%" border="0">
			<tr> 
				<td>Subject</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr> 
				<td>Message</td>
				<td><input type="text" name="message"></td>
			</tr>
			<tr> 
				<td>Type</td>
				<td>
					<select name="type">
						<option value="a">a</option>
						<option value="b">b</option>
						<option value="c">c</option>
					</select>
				</td>
			</tr>
			<tr> 
				<td></td>
				<td><input type="submit" name="Submit" value="Add"></td>
			</tr>
		</table>
	</form>
	
	<?php

	// Check If form submitted, insert form data into announcement table.
	if(isset($_POST['Submit'])) {
		$subject = $_POST['subject'];
		$message = $_POST['message'];
		$type = $_POST['type'];
		
		// include database connection file
		include_once("config.php");
				
		// Insert user data into table
		$result = mysqli_query($mysqli, "INSERT INTO announcement(subject,message,type,posted) VALUES('$subject','$message','$type','".date("Y-m-d H:i:s")."')");
		
		// Show message when user added
		echo "Announcement added successfully. <a href='index.php'>View Announcements</a>";
	}
	?>
</body>
</html>
