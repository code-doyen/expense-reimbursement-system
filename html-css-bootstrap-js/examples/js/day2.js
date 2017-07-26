/**
 * 
 */

	
/*	var empIDValue = document.createElement("input");
	var empFirstValue = document.createElement("input");
	var empLastValue = document.createElement("input");
	var brValue = document.createElement("br");*/
/*	var formElement = document.getElementById("newForm");
	formElement.appendChild(empIDValue);
	formElement.appendChild(empFirstValue);
	formElement.appendChild(empLastValue);
	formElement.appendChild(brValue);*/	
window.onload = function(){
	document.getElementById("submitButton").addEventListener("click",addEmployee);
	document.getElementById("clearButton").addEventListener("click",clearTextFields);
} 

function addEmployee(){
	var empID = document.getElementById("employeeid").value;		// grab the values from employee id
	var fname = document.getElementById("firstname").value;
	var lname = document.getElementById("lastname").value;

	console.log(empID + " : " + fname + ", "+ lname);			//print the values (retrieved values) on console
	var trElement = document.createElement("tr");				//create a new element for tr
	var empIDValue = document.createElement("td");				//create a new element for td
	var empFirstValue = document.createElement("td");
	var empLastValue = document.createElement("td");
	var brValue = document.createElement("br");					//create a new element for br
	
	empIDValue.textContent = empID;
	empFirstValue.textContent = fname;
	empLastValue.textContent = lname;
	//console.log(empIDValue.value + " : " + empFirstValue.value + ", "+ empLastValue.value);
	trElement.appendChild(empIDValue);
	trElement.appendChild(empFirstValue);
	trElement.appendChild(empLastValue);
	var tableElement = document.getElementById("dynamicTable");
	tableElement.appendChild(trElement);
	trElement.appendChild(brValue);
}


function clearTextFields(){
	document.getElementById("employeeid").value = "";
	document.getElementById("firstname").value = "";
	document.getElementById("lastname").value = "";
}






