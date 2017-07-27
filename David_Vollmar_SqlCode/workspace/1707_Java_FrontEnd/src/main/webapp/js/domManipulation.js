
window.onload = function(){
	document.getElementById('submitButton').addEventListener('click', addEmployee);
	document.getElementById('resetButton').addEventListener('click', clearTextFields);
}


function addEmployee(){

var empID = document.getElementById('employeeid').value;
var fName = document.getElementById('firstname').value;
var lName = document.getElementById('lastname').value;


console.log(empID + " : "+ fName +", "+lName);

var empIDValue = document.createElement('td');
var empFirstValue = document.createElement('td');
var empLastValue = document.createElement('td');
var brValue = document.createElement('br');
var trElement = document.createElement('tr');

empIDValue.textContent = empID;
empFirstValue.textContent = fName;
empLastValue.textContent = lName;

console.log(empIDValue.textContent + " : "+ empFirstValue.textContent +", "+empLastValue.textContent);

//var formElement = document.getElementById('newForm');
//formElement.appendChild(empIDValue);
//formElement.appendChild(empFirstValue);
//formElement.appendChild(empLastValue);
//formElement.appendChild(brValue);
var tableElement = document.getElementById('dynamicTable');
trElement.appendChild(empIDValue);
trElement.appendChild(empFirstValue);
trElement.appendChild(empLastValue);
trElement.appendChild(brValue);
tableElement.appendChild(trElement);
}

function clearTextFields(){
	document.getElementById('employeeid').value="";
	document.getElementById('firstname').value="";
	document.getElementById('lastname').value="";
	
}