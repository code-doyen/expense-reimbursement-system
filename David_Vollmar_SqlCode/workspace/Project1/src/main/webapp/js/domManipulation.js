
function Ajax(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			console.log(xhttp.responseText);
			var ajaxObject = JSON.parse(xhttp.responseText);
			setValues(ajaxObject);
		}
	}
	xhttp.open('GET', 'login.html', true);
	//Sending request to endpoint
	xhttp.send();
}

function AjaxUpdate(url){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			
			setValues(xhttp.responseText);
		}
	}
	xhttp.open('GET', url, true);
	//Sending request to endpoint
	xhttp.send();
}
//sending the DOM after reciening JSON
function setValues(response){
	document.getElementById('content').innerHTML = response;
}

