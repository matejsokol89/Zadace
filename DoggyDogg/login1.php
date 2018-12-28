<?php include_once "konfig.php" ?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="login.css" />
    
    <script src="main.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
    <body>
        <form class="loginform" action="autoriziraj.php">

       
        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                    <h1>Login</h1>
                </div>
    
                <div class="login-form">
                    <div class="control-group">
                    <input type="text" class="login-field" name="email" value="" placeholder="username" id="login-name">
                    <label class="login-field-icon fui-user" for="login-name"></label>
                    </div>
    
                    <div class="control-group">
                    <input type="password" name="password" class="login-field" value="" placeholder="password" id="login-pass">
                    <label class="login-field-icon fui-lock" for="login-pass"></label>
                    </div>
    
                    <input type="submit" class="btn btn-primary btn-large btn-block" value="Login" href="#"></input>
                    <a class="login-link" href="#">Lost your password?</a>

                    <?php 
if(isset($_GET["g"])):
  switch ($_GET["g"]):
    case '1':
      echo "Obavezno email i lozinka";
      break;
    case '2':
      echo "Email i lozinka ne smiju biti prazni";
      break;
    case '3':
      echo "Email i lozinka ne odgovaraju";
      break;
    case '4':
      echo "Obavezno se prijavite";
      break;
    case '5':
      echo "Odjavljeni ste, ponovo se prijavite";
      break;
  endswitch;
endif;
?>
                </div>
   
            </div>
        </div>

  
    </form>


    </body>
</html>

