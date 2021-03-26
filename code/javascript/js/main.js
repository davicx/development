"use strict";

//Classes
class Rectangle {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
  
  // Getter
  get area() {
    return this.calcArea();
  }

  // Method
  calcArea() {
    return this.height * this.width;
  }
}

const square = new Rectangle(10, 10);

console.log(square.area);  


/*
class Rectangle {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
}

const p = new Rectangle(4,2); // ReferenceError

//Unnamed
let Rectangle = class {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
};
console.log(Rectangle.name);


//Named
let RectangleTwo = class Rectangle2 {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
};
console.log(RectangleTwo.name);
*/

//String Primitive
var message = 'hello hi. hiya there';

//String Object
const messageString = new String('hello hi. hiya there');

console.log(message.slice);
