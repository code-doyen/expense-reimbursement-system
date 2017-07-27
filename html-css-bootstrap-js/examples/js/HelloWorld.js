/**
 * javascript examples : @yuvarajd@revature.com (Yuvi)
 */

//alert("Hello World!!!"); //very bad practice hence should not get into production code 
/*
 * //"use strict"; var msg = "Hello World!!!"; var i = 123; console.log(msg);
 * function f1(){ var x = document.getElementById("sButton"); x.innerHTML = "<p>This
 * is a sample</p>"; }
 */


var x = document.getElementById("results");
x.innerHTML = "<p>This is modified by JavaScript</p>";

//create a simple function - with global scope variables
var x = 10;
var y = 20;
function f1(){
	return x * y;
}
console.log(f1());


/*var a = 2, b = 3;
function add(){
	return a + b;
}
console.log(add());
console.log(add());
console.log(add());*/

//var a, b;
/*function add(){
	a = 2, b = 3;
	return a + b;
}
console.log(add());
console.log(add());
console.log(add());*/

/*sub();				//function hoisting 
console.log(sub());		//function hoisting

function sub(){
	var a = 2, b = 1;
	return a - b;
}*/

var f = 0;
function f2(){
	f += 1;
	console.log("value of f", f);
}

f2();
f2();
f2();	//f will print 3.

function f3(){
	var ff = 0;
	ff += 1;
	console.log("value of ff", ff);
}

f3();
f3();
f3();	//how many ever times you call the value will always be printed as 1

//nested functions
function f4(){
	var fff = 0;
	function add3f(){
		fff += 1;
		console.log("value of fff", fff);
	}
	add3f();
}				

f4();
f4();
f4();			//this will always print 1. 
//add3f();		- can't access the function outside the function

//what is anonymous function?
//function without any name is anonymous function

var x = function(){ return true};
console.log("value of is anonymous function x is ", x());

//what is self-invoking functions?
//function can call themselves. really, how?
(function (){
	var jsVariable = "Hello World!!!!";
	console.log("value of jsVariable is ", jsVariable);
})();

//example for closures
//anonymous function and self-invoking function concepts are used in this example
//
var foo = (function (){
	var bar = 0;
	return function(){return bar += 1};
})();

foo();				//value of foo returns 1
console.log(foo());
console.log(foo());
console.log(foo());
console.log(foo());	//prints 5

/*var myvariable
function foo(){
	var one = function bar(){
		myvariable = myvariable + 1;
	};
	
	one();
	console.log("value of myvariable");
	console.log(myvariable);	
}
//var myvar1=1;
function add(){
	myvar1 = 1;
	myvar1 = myvar1 + 1;
	console.log(myvar1);
}

add();
add();
add();*/