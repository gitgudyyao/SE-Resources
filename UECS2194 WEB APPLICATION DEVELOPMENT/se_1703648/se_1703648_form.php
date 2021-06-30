<html>
<head>
<title>Employee Form</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
    <br>
    <div class="form-container">
        <form name="frmContact" id="" frmContact"" method="post"
            action="" enctype="multipart/form-data"
            onsubmit="return validateContactForm()">

            <div class="input-row">
                <label style="padding-top: 20px; font-size: 18px; font-family: Verdana;">Name</label> <span
                    id="userName-info" class="info"></span><br /> <input
                    type="text" class="input-field" name="userName"
                    id="userName" />
            </div>
            <div class="input-row">
                <label style="font-size: 18px; font-family: Verdana;">Email</label> <span id="userEmail-info"
                    class="info"></span><br /> <input type="text"
                    class="input-field" name="userEmail" id="userEmail" />
            </div>
            <div class="input-row">
                <label style="font-size: 18px; font-family: Verdana;">Staff Number</label> <span id="subject-info"
                    class="info"></span><br /> <input type="text"
                    class="input-field" name="staffNo" id="staffNo" />
            </div>
            <div class="input-row">
                <label style="font-size: 18px; font-family: Verdana;">Phone Number</label> <span id="subject-info"
                    class="info"></span><br /> <input type="text"
                    class="input-field" name="phone" id="phone" />
            </div>
                <input type="submit" name="send" class="btn-submit"
                    value="Add Employee" />

                <div id="statusMessage"> 
                        <?php
                        if (! empty($message)) {
                            ?>
                            <p class='<?php echo $type; ?>Message'><?php echo $message; ?></p>
                        <?php
                        }
                        ?>
                    </div>
            </div>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-2.1.1.min.js"
        type="text/javascript"></script>
    <script type="text/javascript">
        function validateContactForm() {
            var valid = true;

            $(".info").html("");
            $(".input-field").css('border', '#e0dfdf 1px solid');
            var userName = $("#userName").val();
            var userEmail = $("#userEmail").val();
            var staffNo = $("#staffNo").val();
            var phone = $("#phone").val();
            
            if (userName == "") {
                $("#userName-info").html("“Please field out this fields!”.");
                $("#userName").css('border', '#e66262 1px solid');
                valid = false;
            }
            if (userEmail == "") {
                $("#userEmail-info").html("“Please field out this fields!”.");
                $("#userEmail").css('border', '#e66262 1px solid');
                valid = false;
            }
            if (!userEmail.match(/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/))
            {
                $("#userEmail-info").html("Invalid Email Address.");
                $("#userEmail").css('border', '#e66262 1px solid');
                valid = false;
            }

            if (subject == "") {
                $("#subject-info").html("Required.");
                $("#staffNo").css('border', '#e66262 1px solid');
                valid = false;
            }
            if (content == "") {
                $("#userMessage-info").html("“Please field out this fields!”.");
                $("#phone").css('border', '#e66262 1px solid');
                valid = false;
            }
            return valid;
        }
</script>
</body>
</html>