<?php
// WHILE
$i = 0;
while ($i < 5) {
    echo "Number: $i<br>";
    $i++;
}
// DO WHILE
do {
    echo "Number: $i<br>";
    $i++;
} while ($i < 5);

// FOR EACH
$array = [1, 2, 3, 4, 5];
foreach ($array as $value) {
    echo "Value: $value<br>";
}

// FOR
for ($i = 0; $i < 5; $i++) {
    echo "Number: $i<br>";
}
