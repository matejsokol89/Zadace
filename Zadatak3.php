<?php

//Za primljeni GET parametar x ispiši sve
//parne brojeve od tog broja do 0

// for ($x=0; $x<=$broj; $x++)
// {
//     if( $x%2!=1)
//     {
//     echo $x.", ";
//     }
// }



// for($broj; $broj>0; $broj--)
// {
//     if( $broj%2!=1)
//     {
//     echo $broj.", ", "<br />";
//     }
// }



if (isset($_GET['num'])) {
    $num = intval($_GET['num']);
    for ($num; $num > 0; $num--) {
        if ($num % 2 !=1) {
            echo $num . " ";
        }
    }
}