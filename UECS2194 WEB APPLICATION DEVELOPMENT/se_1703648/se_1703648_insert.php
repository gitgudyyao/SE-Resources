<!DOCTYPE html>
<html>
<head>
<h1 style="text-align: center; font-size: 30px; font-family: Arial;
">Employee Form</h1>
<style>
table {
border-collapse: collapse;
width: 100%;
color: #588c7e;
text-align: center;
}
th {
background-color: #588c7e;
color: white;
}
tr:nth-child(even) {background-color: #f2f2f2}
</style>

</head>
<body>
<table>
<tr>
<th>ID</th>	
<th>Staff No.</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
</tr>

<?php
if(!empty($_POST["send"])) {
	$name = $_POST["userName"];
	$email = $_POST["userEmail"];
	$staffNo = $_POST["staffNo"];
	$phone = $_POST["phone"];

	$conn = mysqli_connect("localhost", "root", "", "wad_ptest") or die("Connection Error: " . mysqli_error($conn));
	mysqli_query($conn, "INSERT INTO se_1703648_staff (name, email,staffNo,phone) VALUES ('" . $name. "', '" . $email. "','" . $staffNo. "','" . $phone. "')");
	$insert_id = mysqli_insert_id($conn);


$sql = "SELECT id, name, email, staffNo, phone FROM se_1703648_staff";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
// output data of each row
while($row = $result->fetch_assoc()) {
echo "<tr><td>" . $row["id"] . "</td><td>" . $row["staffNo"] . "</td><td>". $row["name"]. "</td><td>" . $row["email"] . "</td><td>"
. $row["phone"]. "</td></tr>";
}
echo "</table>";
} else { echo "0 results"; }
$conn->close();

	//if(!empty($insert_id)) {
	   $message = "Your information is saved successfully.";
	   $type = "success";
	//}
}
require_once "se_1703648_form.php";
?>
</table>
</body>
</html>