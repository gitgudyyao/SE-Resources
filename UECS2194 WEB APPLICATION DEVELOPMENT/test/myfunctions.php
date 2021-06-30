<?php

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}

function is_empty($data)
{
	if(empty($data))
	{
		return true;
	}
	else
	{
		return false;
	}
}
?>