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
    $b = 1;
    $fib = 0;

    $arr = [];
    for ($i = 1; $i <= $n; $i++) {
        $fib = $a + $b;
        $b = $a;
        $a = $fib;
        array_push($arr, $fib);
    }
    echo implode(" ", $arr);
}
?>
</body>
</html>