<?php include 'include/header.php'; ?>
<?php include 'include/nav.php'; ?>
 
<?php
include_once 'dbconfig.php';

if(isset($_GET['edit_id']))
{
 $sql_query="SELECT * FROM se_1703648_diary WHERE id=".$_GET['edit_id'];
 $result_set=mysqli_query($con,$sql_query);
 $fetched_row=mysqli_fetch_array($result_set,MYSQLI_ASSOC);
}
if(isset($_POST['btn-update']))
{
 // variables for input data
     
   $Title = $_POST['Title'];
          
   $Category = $_POST['Category'];
          
   $Message = $_POST['Message'];
          
   $CurrentDate = $_POST['CurrentDate'];
        // variables for input data

 // sql query for update data into database
  $sql_query="UPDATE se_1703648_diary SET `Title`='$Title',`Category`='$Category',`Message`='$Message',`CurrentDate`='$CurrentDate' WHERE id=".$_GET['edit_id'];

 // sql query for update data into database
 
 // sql query execution function
 if(mysqli_query($con,$sql_query))
 {
  ?>
  <script type="text/javascript">
  alert('Diary updated successfully!');
  window.location.href='myDiary.php';
  </script>
  <?php
 }
 else
 {
  ?>
  <script type="text/javascript">
  alert('error occured while updating data');
  </script>
  <?php
 }
 // sql query execution function
}
if(isset($_POST['btn-cancel']))
{
 header("Location: myDiary.php");
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
<center>

<div id="header">
 <div id="content">
<img src="/img/try.jpg" width=10%> </>
    </div>
</div>


<div class="form-container">

    <form method="post" enctype="multipart/form-data" >

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Title</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Title"
                    id="Title"  value="<?php echo $fetched_row['Title'] ?>"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Category</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Category"
                    id="Category" value="<?php echo $fetched_row['Category'] ?>"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Message</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Message"
                    id="Message" value="<?php echo $fetched_row['Message'] ?>"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Current Date</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="date" class="input-field" name="CurrentDate"
                    id="CurrentDate" value="<?php echo $fetched_row['CurrentDate'] ?>"/>
            </div>
<br>
<button type="submit" name="btn-update"><strong>Update Details</strong></button>
    <button type="submit" name="btn-cancel"><strong>Cancel</strong></button>
    </form>
    </div>
</div>
<br>

</center>
</body>
</html>