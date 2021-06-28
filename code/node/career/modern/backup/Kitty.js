const mongoose = require('mongoose')
const Schema = mongoose.Schema;


//Simple Kitty
const kittySchema = new mongoose.Schema({
    name: String
  });

  kittySchema.methods.speak = function () {
    const greeting = this.name
      ? "Meow name is " + this.name
      : "I don't have a name";
    console.log(greeting);
  }


const Kitten = mongoose.model('Kitten', kittySchema);
const silence = new Kitten({ name: 'Silence' });
const fluffy = new Kitten({ name: 'fluffy' });
console.log(silence.name); // 'Silence'
fluffy.speak();



