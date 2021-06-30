<!DOCTYPE HTML>  
<html>
<head>
</head>
<body>  

<form method="post" action="<?php echo $_SERVER["PHP_SELF"];?>">  
  Name: <input type="text" name="username">
  <br><br>
  E-mail: <input type="text" name="email">
  <br><br>  
  Gender:
  <input type="radio" name="gender" value="female">Female
  <input type="radio" name="gender" value="male">Male
  <br><br>
  <input type="submit" name="submit" value="Submit">  
</form>



</body>
</html>
