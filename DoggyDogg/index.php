<?php include_once "konfig.php" ?>

<!DOCTYPE html>
<html>
<head>
<?php include_once "head.php" ?>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><?php echo $naslov ?></a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Sign up  <i class="fa fa-user-plus"></i></a></li>
        <li><a class="button expanded" href="login1.php">Login<i class="fa fa-user"></i></a></li>
      </ul>
    </div>
  </div>
 </nav>


	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div id="content">
					<h1><?php echo $naslov ?></h1>
					<h3>If you are bored and don't know where to go<br> come here and Walk My Doggy Dog!</h3>
					<hr>
					<button class="btn btn-default btn-lg"><i class="fa fa-paw fa-fw"></i> Get Started</button>
          <div>
          <br>
            <img id="DoggyImg" style="" src="http://png.clipart-library.com/images4/13/walking-dogs-clipart-7.png" alt="Image"
              width="640" height="427" />
          </div>
				</div>
			</div>
		</div>
	</div>

  <?php include_once "skripte.php" ?>

</body>
</html>
