<?php include 'include/header.php'; ?>
<?php include 'include/nav.php'; ?>


<?php
include_once 'dbconfig.php';

if(isset($_POST['btn-save']))
{
 // variables for input data
     $Title = $_POST['Title'];
      $Category = $_POST['Category'];
      $Message = $_POST['Message'];
      $CurrentDate = $_POST['CurrentDate'];
    // variables for input data

 // sql query for inserting data into database
 
$sql_query="INSERT INTO se_1703648_diary (`Title`,`Category`,`Message`,`CurrentDate`) VALUES('".$Title."','".$Category."','".$Message."','".$CurrentDate."')";
 // sql query for inserting data into database
 
 // sql query execution function
 if(mysqli_query($con,$sql_query))
 {
  ?>
  <script type="text/javascript">
  alert('Diary added Successfully ');
  window.location.href='myDiary.php';
  </script>
  <?php
 }
 else
 {
  ?>
  <script type="text/javascript">
  alert('error occured while inserting your data');
  </script>
  <?php
 }
 // sql query execution function
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
  <img src="/img/diary.png" width=10%> </>
       
    </div>
     <label style=" color: white">Dear Diary, Today...</label>
</div>
<div class="form-container">

    <form method="post" enctype="multipart/form-data" >


            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Title</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Title"
                    id="Title" required placeholder="Input your Title:"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Category</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Category"
                    id="Category" required placeholder="Input your Category:"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Message</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Message"
                    id="Message" required placeholder="Input your Message:"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Date</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="date" class="input-field" name="CurrentDate"
                    id="CurrentDate" required placeholder="Input your Current Date:"/>
            </div>
<br>
<button type="submit" name="btn-save"><strong>Save Details</strong></button>

    </form>
    </div>
</div>

</center>
</body>
</html>