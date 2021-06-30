<?php include 'include/header.php'; ?>
<?php include 'include/nav.php'; ?>


<?php
include_once 'dbconfig.php';?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style.css" type="text/css" />

<style>
table {
border-collapse: collapse;
width: 50%;
color: #588c7e;
text-align: center;
}
th {
background-color: #588c7e;
color: white;
text-align: center;
}



tr:nth-child(even) {background-color: #f2f2f2}
</style>

<script type="text/javascript">

function view_id(id)
{
  window.location.href='view_contact.php?view_id='+id;
}

</script>

</head>
<body>
<center>
<div class>
<div id="header">
 <div id="content">
<h1 style=" color: white">List of Messages!<h1>
    </div>
</div>
  <img src="/img/yay.jpg" width=30%> </>
  <br>

<table align="center">
    <tr>
    <th align="center">No.</th>
    <th align="center">Visitor Name</th>
    <th align="center">Email</th>
    <th align="center">Title</th>
    <th align="center">Message</th>

   
    </tr>
    <?php
 $sql_query="SELECT * FROM se_1703648_contact ORDER BY id DESC";
 $result_set=mysqli_query($con,$sql_query);
 $i= 1;
 while($row=mysqli_fetch_row($result_set))
 {
  ?>
        <tr>
        <td  ><?php echo $i; ?></td>
        <td  > <a> <?php echo $row[1]; ?> </a> </td>
        <td  > <a> <?php echo $row[2]; ?> </a> </td>
        <td  > <a> <?php echo $row[3]; ?> </a> </td>
        <td  > <a> <?php echo $row[4]; ?> </a> </td>
        </tr>
        <?php
       $i++;  
 }
 ?>
    </table>
</

</center>
</body>
</html>