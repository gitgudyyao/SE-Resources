<?php include 'include/header.php'; ?>
<?php include 'include/nav.php'; ?>

<?php
include_once 'dbconfig.php';


if(isset($_GET['delete_id']))
{
 $sql_query="DELETE FROM se_1703648_diary WHERE id=".$_GET['delete_id'];
 mysqli_query($con,$sql_query);
 header("Location: $_SERVER[PHP_SELF]");
}
if(isset($_GET['changestatus_id']))
{
 $sql_query="UPDATE se_1703648_diary SET `status`='".$_GET['status']."' WHERE id=".$_GET['changestatus_id'];
 mysqli_query($con,$sql_query);
 header("Location: $_SERVER[PHP_SELF]");
}
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Core PHP Crud functions By PHP Code Builder</title>
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
function edt_id(id)
{
  window.location.href='edit_diary.php?edit_id='+id;
}
function view_id(id)
{
  window.location.href='view_diary.php?view_id='+id;
}
function delete_id(id)
{
 if(confirm('Are you sure you want to delete this?'))
 {
  window.location.href='myDiary.php?delete_id='+id;
 }
}
function changestatus_id(id,status)
{
  window.location.href='myDiary.php?changestatus_id='+id+'&status='+status;
}
</script>
</head>
<body>
<center>

<div id="header">
 <div id="content">
<h1 style=" color: white">Dear Diary...<h1>
    </div>
</div>
  <img src="/img/diary.jpg" width=25%> </>


  <br>
<div id="body">
 <div id="content">
    <table align="center">
    <tr>

    </tr>
    <th>Entry</th>
    <th>Title</th>
    <th>Category</th>
    <th>Message</th>
    <th>Date</th>
   
    <th colspan="2">Actions</th>
    </tr>
    <?php
 $sql_query="SELECT * FROM se_1703648_diary ORDER BY currentDate DESC";
 $result_set=mysqli_query($con,$sql_query);
 $i=1;
 while($row=mysqli_fetch_row($result_set))
 {
  ?>
        <tr>
        <td align="center" ><?php echo $i; ?></td>
        <td align="center" > <a > <?php echo $row[1]; ?> </a> </td>
        <td align="center" > <a > <?php echo $row[2]; ?> </a> </td>
        <td align="center" > <a > <?php echo $row[3]; ?> </a> </td>
        <td align="center" > <a > <?php echo $row[4]; ?> </a> </td>
        <td align="center"><a href="javascript:edt_id('<?php echo $row[0]; ?>')">Edit</a></td>
        <td align="center"><a href="javascript:delete_id('<?php echo $row[0]; ?>')">Delete</a></td>
        </tr>
        <?php
       $i++;  
 }
 ?>
    </table>
    </div>
</div>

</center>
</body>
</html>