<!DOCTYPE HTML>  
<html>
<head>
</head>
<body>  

<h2>PHP Form Validation Example</h2>
<form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
    <p class="staffNo">
      <input type="text" name="staffNo" id="staffNo" placeholder="Enter your staff number" >
      <label for="staffNo">staffNo</label>
    </p>
    
    <p class="name">
      <input type="text" name="name" id="name" placeholder="Enter your name man" >
      <label for="name">name</label>
    </p>
    
    <p class="email">
      <input type="text" name="email" id="email" placeholder="email" >
      <label for="email">email</label>
    </p>    
  
    <p class="phone">
      <input type="text" name="phone" id="phone" placeholder="phone" >
      <label for="phone">phone</label>
    </p>    
    

  <br><br>
  <input type="submit" name="submit" value="Submit">  
</form>



</body>
</html>
