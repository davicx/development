const functions = require('./functions');

test ('properly adds two numbers', () => {
    expect(functions.sum(2, 2)).toBe(4);
})