<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href="../css/style.css" /> <!--  external -->
	
<title>Customer Login</title>
</head>
<body>
	<header>
		<h3>Welcome to login page</h3>
	</header>
	<section>
		<div>
		<form method="POST" action="login.do">
			<input placeholder="Username" name="username" /> 
			<input placeholder="Password" type="password" name="password" />
			<input type="submit" value="Login" />
		</form>
		</div>
		<div>
			<p style="text-align: left; width: 50%">This is a paragraph left aligned</p>
			<p style="text-align: right; width: 50%">This is a paragraph right aligned</p>
		</div>
		<table>
			
			<tbody>
				<theader>Column Header</theader>
				<tr>
					<td id="row1">Row1, Col1</td>
				</tr>
				<tr>
					<td id="row2">Row2, Col1</td>
				</tr>
				<tr>
					<td id="row3">Row3, Col1</td>
				</tr>
				<tr>
					<td id="row4">Row4, Col1</td>
				</tr>
			</tbody>
			<tfooter>footer</tfooter>
		</table>
	</section>
	<footer></footer>
</body>
</html>