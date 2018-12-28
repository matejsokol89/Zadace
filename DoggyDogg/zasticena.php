
<style>
table{
    border-collapse: collapse;

}


td, th {
  width: 4rem;
  height: 2rem;
  border: 1px solid white;
  text-align: center;
}
tr {
  background: steelblue;
  border-color: white;
}
body {
  padding: 1rem;
}


</style>

<?php
include_once "konfig.php";

if(!isset($_SESSION["user"])){
    header("location: login1.php?g=4");
    exit;
}
?>

<!doctype html>
<html class="no-js" lang="en" dir="ltr">
  <head>
    <?php include_once "head.php" ?>
  </head>
  <body>

  <div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div id="content">
					<h1><?php echo $naslov ?></h1>
					
          <hr>
          <div class="large-3 cell">
          <a class="btn btn-primary btn-lg" href="logout.php">Logout</a>
        </div>	
         
        </div>
      </div>
    </div>   
  </div>

  <div class="container">
		<div class="row">
			<div class="col-lg-12" style="display: flex; justify-content: center; padding-top:2rem">
				<div id="content1">
                <?php include_once "forma.php"; ?>
                <?php include_once "spiralna.php"; ?>
 </div>
      </div>
    </div>   
  </div>
    
  


    <?php include_once "skripte.php" ?>
  </body>
</html>
