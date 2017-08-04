window.onload = function(){
		//Adds Listener to the check button, and executes getUsername function
		//document.getElementById('process').addEventListener('click', AjaxPage());
		//document.getElementById('view').addEventListener('click', AjaxProcess());
		//document.getElementById('profile').addEventListener('click', AjaxProfile());
		document.getElementById('updateProfile').addEventListener('click', AjaxUpdate());
		
}

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

function AjaxProcess(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			
			setValues(xhttp.responseText);
		}
	}
	xhttp.open('GET', "process.html", true);
	//Sending request to endpoint
	xhttp.send();
}


function AjaxView(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			
			setValues(xhttp.responseText);
		}
	}
	xhttp.open('GET', "view.html", true);
	//Sending request to endpoint
	xhttp.send();
}
function AjaxProfile(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			
			setValues(xhttp.responseText);
		}
	}
	xhttp.open('GET', "profile.html", true);
	//Sending request to endpoint
	xhttp.send();
}
function AjaxUpdateProfile(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		//If ready state is done and http status is ok
		if(xhttp.readyState == 4 && xhttp.status ==200){
			//Grabbing JSON object from response body
			//This executes last within this functions
			
			setValues(xhttp.responseText);
		}
	}
	xhttp.open('GET', "updateProfile.html", true);
	//Sending request to endpoint
	xhttp.send();
}
//sending the DOM after reciening JSON
function setValues(response){
	document.getElementById('content').innerHTML = response;
}

