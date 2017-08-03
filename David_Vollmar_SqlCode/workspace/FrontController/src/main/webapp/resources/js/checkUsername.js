window.onload = function(){
		//Adds Listener to the check button, and executes getUsername function
		document.getElementById('checkButton').addEventListener('click', getUsername);
		
}

function getUsername(){
	//Getting the username from input field
	var username = document.getElementById('username').value;
	console.log("Executing AJAX for username: "+ username);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			var ajaxObject = JSON.parse(xhttp.responseText);
			setValues(ajaxObject);
		}
	}
	xhttp.open('POST', 'http://localhost:8080/Project1/checkUsername.ajax?username='+username, true);
	//Sending request to endpoint
	xhttp.send();
}
//sending the DOM after reciening JSON
function setValues(response){
	document.getElementById('message').innerHTML = response.message;
}