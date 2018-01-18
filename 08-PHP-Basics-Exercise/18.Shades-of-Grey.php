<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
<?php
$index = 0;
for ($row = 1; $row <= 5; $row++) {
    for ($col = 1; $col <= 10; $col++) {
        $color = "rgb($index,$index,$index)";
        echo "<div style='background-color: $color'></div>";
        $index += 5;
    }
    $index++;
    echo "</br>";
}
?>
</body>
</html>