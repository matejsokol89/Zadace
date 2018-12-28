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
  background: lightblue;
  border-color: white;
}
body {
  padding: 1rem;
}


</style>

<?php
  $x = isset($_GET["x"]) ? $_GET["x"] : 5;
  $y = isset($_GET["y"]) ? $_GET["y"] : 5;
  



$spirala =array(

  array('$x'),

  array('$y'));

echo "<table>";
 $vrijednost = 1;
 $minStupac = 0;
 $minRed = 0;
 $maxStupac = $y - 1;
 $maxRed = $x-1;


while ($vrijednost <= $x * $y) {
    
    for ($i = $maxStupac; $i >= $minStupac; $i--) {
        $spirala[$maxRed][$i] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $x * $y) {
            break;
        }
        
    }
    for ($i = $maxRed -1 ; $i >= $minRed; $i--) {
        $spirala[$i][$minStupac] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $x * $y) {
            break;
        }
    }
    for ($i = $minStupac +1; $i <= $maxStupac; $i++) {
        $spirala[$minRed][$i] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $x * $y) {
            break;
        }
    }
    for ($i = $minRed + 1; $i < $maxRed ; $i++) {
        $spirala[$i][$maxStupac] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $x * $y) {
            break;
        }
    }
    $maxRed--;
    $maxStupac--;
    $minRed++;
    $minStupac++;
}
echo "<tr>";
for ($i = 0; $i < $x; $i++) {
    for ($j = 0; $j < $y; $j++) {
         //var_dump($spirala[$i][$j], PHP_EOL);
         echo "<td>" ,$spirala[$i][$j], "</td>";
        
    }
    //echo("<br>");
    echo "</tr>";

}
echo "</table>";

