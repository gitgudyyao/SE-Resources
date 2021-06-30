<?php
// include database connection file
include_once("config.php");

// Check if form is submitted for user update, then redirect to homepage after update
if(isset($_POST['update']))
{	
	$id = $_POST['id'];
	
		$subject = $_POST['subject'];
		$message = $_POST['message'];
		$type = $_POST['type'];
		
	// update user data
	$result = mysqli_query($mysqli, "UPDATE announcement SET subject='$subject',message='$message',type='$type',posted='".date("Y-m-d H:i:s")."' WHERE id=$id");
	
	// Redirect to homepage to display updated user in list
	header("Location: index.php");
}
?>
<?php
// Display selected user data based on id
// Getting id from url
$id = $_GET['id'];

// Fetech user data based on id
$result = mysqli_query($mysqli, "SELECT * FROM announcement WHERE id=$id");

while($ann_data = mysqli_fetch_array($result))
{
	$subject = $ann_data['subject'];
	$message = $ann_data['message'];
	$type = $ann_data['type'];
	$posted = date("Y-m-d H:i:s");
}
?>
<html>
<head>	
	<title>Edit Announcement Data</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<a href="index.php">Home</a>
	<br/><br/>
	
	<form  name="update_user" method="post" action="edit.php" >
		<table border="0">
			<tr> 
				<td>Subject</td>
				<td><input type="text" name="subject" value=<?php echo $subject;?>></td>
			</tr>
			<tr> 
				<td>Message</td>
				<td><input type="text" name="message" value=<?php echo $message;?>></td>
			</tr>
			<tr> 
				<td>Type</td>
				<td>
				<select name="type">
						<option value="a" <?php if($type == 'a') echo "selected";?>>a</option>
						<option value="b" <?php if($type == 'b') echo "selected";?>>b</option>
						<option value="c" <?php if($type == 'c') echo "selected";?>>c</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value=<?php echo $_GET['id'];?>></td>
				<td><input type="submit" name="update" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>

