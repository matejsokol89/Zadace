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
 $prviBroj = 5;
$spirala =array(
    array('$prviBroj'),
    array('$prviBroj'));

echo "<table>";
 $vrijednost = 1;
 $minStupac = 0;
 $minRed = 0;
 $maxStupac = $prviBroj - 1;
 $maxRed = $prviBroj-1;


while ($vrijednost <= $prviBroj * $prviBroj) {
    
    for ($i = $maxStupac; $i >= $minStupac; $i--) {
        $spirala[$maxRed][$i] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $prviBroj * $prviBroj) {
            break;
        }
        
    }
    for ($i = $maxRed -1 ; $i >= $minRed; $i--) {
        $spirala[$i][$minStupac] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $prviBroj * $prviBroj) {
            break;
        }
    }
    for ($i = $minStupac +1; $i <= $maxStupac; $i++) {
        $spirala[$minRed][$i] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $prviBroj * $prviBroj) {
            break;
        }
    }
    for ($i = $minRed + 1; $i < $maxRed ; $i++) {
        $spirala[$i][$maxStupac] = $vrijednost;
        $vrijednost++;
        if ($vrijednost > $prviBroj * $prviBroj) {
            break;
        }
    }
    $maxRed--;
    $maxStupac--;
    $minRed++;
    $minStupac++;
}
echo "<tr>";
for ($i = 0; $i < $prviBroj; $i++) {
    for ($j = 0; $j < $prviBroj; $j++) {
         //var_dump($spirala[$i][$j], PHP_EOL);
         echo "<td>" ,$spirala[$i][$j], "</td>";
        
    }
    //echo("<br>");
    echo "</tr>";

}
echo "</table>";