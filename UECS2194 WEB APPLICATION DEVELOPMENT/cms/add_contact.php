<?php include 'include/header.php'; ?>
<?php include 'include/nav.php'; ?>


<?php
include_once 'dbconfig.php';

if(isset($_POST['btn-save']))
{
 // variables for input data
      $Name = $_POST['Name'];
      $Email = $_POST['Email'];
      $Title = $_POST['Title'];
      $Message = $_POST['Message'];
    // variables for input data

 // sql query for inserting data into database
 
$sql_query="INSERT INTO se_1703648_contact (`Name`,`Email`,`Title`,`Message`) VALUES('".$Name."','".$Email."','".$Title."','".$Message."')";
 // sql query for inserting data into database
 
 // sql query execution function
 if(mysqli_query($con,$sql_query))
 {
  ?>
  <script type="text/javascript">
  alert('Visitors added Successfully ');
  window.location.href='contactMe.php';
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

<style>
.error {color: #FF0000;}
</style>

<script>
function validateForm(event) {

  var name = document.getElementById("Name").value,
    email = document.getElementById("Email").value,
    title = document.getElementById("Title").value,
    message = document.getElementById("Message").value,
    emailMatch = /^\[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Z]{2,4}$/,
    errors = [];

      if (!name){
      errors.push("The Name is required");
    }
    if (!email){
      errors.push("The email is required.");
    } else if (!emailMatch.test(email)){
      errors.push("The email must be formated as follows: name@domain.com.");
    }
          if (!title){
      errors.push("The Name is required");
    }
          if (!message){
      errors.push("The Name is required");
    }
}

</script>


</head>
<body>
<center>

<div id="header">
 <div id="content">
    <img src="/img/msg.jpg" width=25%> </>
    </div>
            <label style=" color: white">Leave a Message!</label>
</div>
<div class="form-container">

    <form name ="validate" method="post" enctype="multipart/form-data" >




            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Name</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Name"
                    id="Name" required placeholder="Input your Name here:"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Email</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="email" class="input-field" name="Email"
                    id="Email" required placeholder="Input your Email here:"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Title</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="Title"
                    id="Title" required placeholder="Input your Title here:"/>
            </div>

            <div class="input-row">
                <label style="padding-top: 20px; color: white; font-size: 18px; font-family: Verdana;">Message</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="textarea" class="input-field" name="Message"
                    id="Message" required placeholder="Input your Message here:"/>
            </div>
<br>
<button type="submit" name="btn-save"><strong>Send Message</strong></button>

    </form>
    </div>
</div>
<br>
    <td align="center"><a href="contactMe.php">Contact Me!</a></td>

</center>
</body>
</html>