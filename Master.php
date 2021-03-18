<?php
//ARRAYS
//Associative Array 
$age = array("Frodo"=>25, "Bilbo"=>27, "David"=>23);
$age = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43");

echo json_encode($age);

//Loop Over 
foreach($age as $name => $age) {
  echo "Key=" . $name . ", Value=" . $age;
  echo "<br>";
}

//CLASS
class Fruit {
  public $name;
  public $color;

  function __construct($name, $color) {
    $this->name = $name;
    $this->color = $color;
  }
  function get_name() {
    return $this->name;
  }
  function get_color() {
    return $this->color;
  }
}


?>


