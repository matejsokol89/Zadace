<?php

include_once "konfig.php" ;
unset($_SESSION["user"]);
session_destroy();
header("location: login1.php?g=5");