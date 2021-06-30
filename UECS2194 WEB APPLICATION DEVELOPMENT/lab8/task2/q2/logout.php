<?php
   session_start();
   unset($_SESSION["id"]);
   unset($_SESSION["login_user"]);  
   session_destroy();   
  
   header('Location:login.php');
?>