<?php
/**
* Simple PHP CRUD Script
**/

// Create database connection using config file
include_once("config.php");

// Fetch all users data from database
$result = mysqli_query($mysqli, "SELECT * FROM announcement ORDER BY id DESC");
?>

<html>
<head>    
    <title>Homepage</title>
	
<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>
<a href="add.php">Add New Announcement</a><br/><br/>

    <table width='80%' border=1 >

    <tr>
        <th>Subject</th> <th>Message</th> <th>Type</th> <th>Posted Date</th> <th> Action </th>
    </tr>
    <?php  
    while($ann_data = mysqli_fetch_array($result)) {         
        echo "<tr>";
        echo "<td>".$ann_data['subject']."</td>";
        echo "<td>".$ann_data['message']."</td>";
        echo "<td>".$ann_data['type']."</td>"; 
		echo "<td>".$ann_data['posted']."</td>";		
        echo "<td><a href='edit.php?id=$ann_data[id]'>Edit</a> | <a href='delete.php?id=$ann_data[id]'>Delete</a></td></tr>";        
    }
    ?>
    </table>
</body>
</html>
