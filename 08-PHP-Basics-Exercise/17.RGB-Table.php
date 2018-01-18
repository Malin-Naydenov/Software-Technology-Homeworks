<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        table * {
            border: 1px solid black;
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>
            Red
        </td>
        <td>
            Green
        </td>
        <td>
            Blue
        </td>
    </tr>
    <?php
    $red = [];
    $green = [];
    $blue = [];

    for ($i = 51; $i <= 255; $i += 51) {
        $redColor = "rgb($i,0,0)";
        $greenColor = "rgb(0,$i,0)";
        $blueColor = "rgb(0,0,$i)";

        array_push($red, $redColor);
        array_push($green, $greenColor);
        array_push($blue, $blueColor);
    }

    $index = 0;
    for ($row = 1; $row <= 5; $row++) {
        echo "<tr>";
        for ($col = 1; $col <= 3; $col++) {
            if ($col === 1) {
                echo "<td style='background-color: $red[$index]'></td>";
            } else if ($col === 2) {
                echo "<td style='background-color: $green[$index]'></td>";
            } else {
                echo "<td style='background-color: $blue[$index]'></td>";
            }
        }
        $index++;
        echo "</tr>";
    }
    echo "</tr>";
    ?>
</table>
</body>
</html>