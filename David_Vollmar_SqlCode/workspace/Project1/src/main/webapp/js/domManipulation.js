var test;
function Ajax(page, type, element){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			console.log(xhttp.responseText);
			var ajaxObject = JSON.parse(xhttp.responseText);
			test =ajaxObject;
			setValues(ajaxObject, element, page);
			
		}
	}
	xhttp.open(type, 'http://localhost:8080/Project1/' + page, true);
	//Sending request to endpoint
	xhttp.send();
}

function AjaxUpdate(url, element){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			
			setValues(xhttp.responseText, element);
		}
	}
	xhttp.open('GET', 'http://localhost:8080/Project1/' + url, true);
	//Sending request to endpoint
	xhttp.send();
}
//sending the DOM after reciening JSON
function setValues(response, elem, tbl){
		
	if(elem === "dynamicTable" && tbl ==="listAllDetails.ajax"){
		var table = "<tr>";
		for(var i = 0; i < response.length; i++){
	        	table += "<td>"+response[i].username+"</td><td>"+response[i].password+"</td><td>"+response[i].firstName+"</td><td>"+response[i].lastName
	        	+"</td><td>"+response[i].phone+"</td><td>"+response[i].email+"</td><td>"+response[i].position+"</td>";
	    }
		table += "</tr>";
		document.getElementById(elem).innerHTML = table;
    }
	else if(elem === "dynamicTable" && (tbl ==="pendingStaffRequests.ajax" || tbl ==="resolvedStaffRequests.ajax")){
		var table = "";
		for(var i = 0; i < response.length; i++){
	        	table += "<tr><td>"+response[i].id+"</td><td>"+"<td>"+response[i].fullname+"</td><td>"+response[i].amount+"</td><td>"+response[i].description+"</td><td>"+response[i].date_submitted
	        	+"</td><td>"+response[i].date_approved+"</td><td>"+response[i].approve_by+"</td><td>"+response[i].status+"</td><td>"+response[i].type+"</td></tr>";
	    }
		
	
		
		document.getElementById(elem).innerHTML = table;
    }
	else document.getElementById(elem).innerHTML = response;
}

