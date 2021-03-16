<?php 
VARIABLE TYPES:
Integers − are whole numbers, without a decimal point, like 4195.
Doubles − are floating-point numbers, like 3.14159 or 49.1.
Booleans − have only two possible values either true or false.
NULL − is a special type that only has one value: NULL.
NULL is a special data type which can have only one value. 
A variable of data type NULL is a variable that has no value assigned to it. 
$var = NULL;
Strings − are sequences of characters, like ‘PHP supports string operations.’
Arrays − are named and indexed collections of other values.
Objects − are instances of programmer-defined classes, which can package up both other 
kinds of values and functions that are specific to the class.
Resources − are special variables that hold references to resources external to PHP

ARRAYS:
Indexed Array – An array with a numeric index is known as the indexed array. 
Associative Array – An array with strings as index is known as the associative array. 
Multidimensional Array – An array containing one or more arrays is known as multidimensional array.

Constants: define("MINSIZE", 50);_LINE_ – It represents the current line number of the file.
 _FILE_ – It represents the full path and filename of the file. 
 If used inside an include,the name of the included file is returned.
_FUNCTION_ – It represents the function name.
_CLASS_ – It returns the class name as it was declared.
_METHOD_ – It represents the class method name.

PHP4	PHP5
PHP4 Constructor have same name as the Class name.
Constructors are named as _construct and Destructors as _destruct().
PHP4 Everything is passed by value.
PHP5 All objects are passed by references.
PHP4  does not declare a class as abstract
PHP5 allows to declare a class as abstract
PHP4 It doesn’t have static methods and properties in a class
PHP5 It allows to have static Methods and Properties in a class

What is the difference between $message and $$message in PHP?
They are both variables. But $message is a variable with a fixed name. 
$$message is a variable whose name is stored in $message. 
For example, if $message contains “var”, $$message is the same as $var.

The final keyword in a method declaration indicates that the method cannot be overridden by subclasses. 
A class that is declared final cannot be subclassed. 
is particularly useful when we are creating an immutable class like the String class.
Properties cannot be declared final, only classes and methods may be declared as final.

We use the operator ‘==’ to test if two objects are instanced from the same class and have same attributes and equal values. 
We can also test if two objects are referring to the same instance of the same class by the use of the identity operator ‘===’.

Abstract Classes
Abstract classes cannot be instantiated but they can be extended.

ERRORS
The different types of error in PHP are:
E_ERROR– A fatal error that causes script termination.
E_WARNING– Run-time warning that does not cause script termination.
E_PARSE– Compile time parse error.
E_NOTICE– Run time notice caused due to error in code.
E_CORE_ERROR– Fatal errors that occur during PHP initial startup.
E_CORE_WARNING– Warnings that occur during PHP initial startup.
E_COMPILE_ERROR– Fatal compile-time errors indication problem with script.
E_USER_ERROR– User-generated error message.
E_USER_WARNING– User-generated warning message.
E_USER_NOTICE- User-generated notice message.
E_STRICT– Run-time notices.
E_RECOVERABLE_ERROR– Catchable fatal error indicating a dangerous error
E_ALL– Catches all errors and warnings.
