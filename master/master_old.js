//MASTER: This is everything in depth 
var animals = ['Beaver', 'Deer ','Badger'] 

//FOR LOOPS
//Forward Loop 
for (let i = 0; i < animals.length; i++) {
    console.log(animals[i])
}
  
//Reverse Loop
for (let i = animals.length - 1; i >= 0; i--) {
    console.log(animals[i])
}

//For Each 
animals.forEach(function (animal, index) {
  console.log(animal, index);
});

animals.forEach(animal => console.log(animal));
   
//For Loop 
for (const animal of animals){
    console.log(animal);
}
  