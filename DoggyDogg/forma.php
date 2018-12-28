
<form action="<?php echo $_SERVER["PHP_SELF"] ?>">



<div class="form-group mx-sm-3 mb-2">
        <label for="inputBroj" class="sr-only">Prvi broj</label>
        <br>
        <input type="number" class="form-control" id="inputBroj1" placeholder="number" value="<?php 
        
        echo isset($_GET["x"]) ? $_GET["x"] : "";
        
        ?>" />
        <br>
    

<label for="inputBroj" class="sr-only">Drugi broj</label>
        <br>
        <input type="number" class="form-control" id="inputBroj2" placeholder="number" value="<?php 
        
        echo isset($_GET["y"]) ? $_GET["y"] : "";
        
        ?>" />
<br>

<input class="btn btn-primary btn-lg" type="submit" value="Submit" />

    
</div>

</form>