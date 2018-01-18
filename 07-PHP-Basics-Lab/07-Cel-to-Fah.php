<form>
    Celsius: <input type="text" name="cel"/>
    <input type="submit" value="Convert">
    <?php if (isset($_GET['cel'])) {
        $cel = $_GET['cel'];
        $fah = doubleval($_GET['cel']) * 1.8 + 32;
        $result = "$cel &deg;C = $fah &deg;F";
        echo $result;
    } ?>
</form>
<form>
    Fahrenheit: <input type="text" name="fah"/>
    <input type="submit" value="Convert">
    <?php if (isset($_GET['fah'])) {
        $fah = $_GET['fah'];
        $cel = (doubleval($_GET['fah']) - 32) / 1.8;
        $result = "$fah &deg;F = $cel &deg;C";
        echo $result;
    } ?>
</form>
