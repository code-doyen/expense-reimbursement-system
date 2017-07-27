
//alert("HelloWorld");
	document.getElementById('results').innerHTML = "<p>This is modified by javascript </p>";
var x =10;
var y = 20;
	
function f1(){
	return x*y;
}
console.log(f1());

function add(){
	return x+y;
}
console.log(add());


console.log(add2()); //hoisting
function add2(){
	x=3;
	y=5;
	return x+y;
}


//Closure
foo();
foo();
foo();
function foo(){ 
	var mya = 0;
	var one = function bar(){
		mya+=1;
	}
	one();
	console.log("value of mya");
	console.log(mya);
}

add();
var m = 1;
function add(){
	m+=1;
	console.log(m);
}
add();
add();