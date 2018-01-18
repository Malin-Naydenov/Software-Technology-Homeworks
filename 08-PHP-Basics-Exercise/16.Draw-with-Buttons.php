<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<body>
<?php
for ($row = 1; $row <= 5; $row++) {
    if ($row === 1 || $row === 5) {
        for ($col = 1; $col <= 5; $col++) {
            echo "<button style=\"background-color: blue\">1</button>";
        }
    } else {
        for ($col = 1; $col <= 5; $col++) {
            if ($col === 1) {
                echo "<button style=\"background-color: blue\">1</button>";
            } else {
                echo "<button>0</button>";
            }
        }
    }
    echo "</br>";
}
for ($row = 1; $row <= 4; $row++) {
    if ($row !== 4) {
        for ($col = 1; $col <= 5; $col++) {
            if ($col === 5) {
                echo "<button style=\"background-color: blue\">1</button>";
            } else {
                echo "<button>0</button>";
            }
        }
    } else {
        for ($col = 1; $col <= 5; $col++) {
            echo "<button style=\"background-color: blue\">1</button>";
        }
    }
    echo "</br>";
}
?>
</body>
</html>