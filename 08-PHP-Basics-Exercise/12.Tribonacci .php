<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num"/>
    <input type="submit"/>
</form>
<?php
if (isset($_GET['num'])) {
    $n = intval($_GET['num']);

    $a = 0;
    $b = 0;
    $c = 1;

    $arr = [];
    for ($i = 1; $i <= $n; $i++) {
        $fib = $a + $b + $c;
        array_push($arr, $fib);
        $c = $b;
        $b = $a;
        $a = $fib;
    }

    echo implode(" ", $arr);
}
?>
</body>
</html>