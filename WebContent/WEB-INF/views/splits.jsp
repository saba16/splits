<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Splits</title>
</head>
<style>
body {
	font: normal 14px/100% "Andale Mono", AndaleMono, monospace;
	color: #fff;
	padding: 50px;
	width: 300px;
	margin: 0 auto;
	background-color: #374954;
}

button {
	color: #0090ff;
}

input {
	color: #0090ff;
}
</style>
<script type="text/javascript">
	function splits() {
		var checkedValue = "";
		var j = 0;
		var inputElements = document.getElementsByClassName('check');
		for (var i = 0; i < inputElements.length; i++) {

			if (inputElements[i].checked) {
				if (checkedValue == "") {
					checkedValue = inputElements[i].value;
				} else {
					checkedValue = checkedValue + "," + inputElements[i].value;
				}
				j++;
			}

		}
		var amount = document.getElementById('amt').value;
		var shrd = amount / j;

		document.getElementById('shrd').value = shrd;
		document.getElementById('hsd').value = checkedValue;
		return;

	}
</script>
<h1>Splits</h1>
<form action="save.html" method="post">
	<div class="form-group" value="splits">
		<label class="col-md-4 control-label" for="rolename">Persons</label>
		<div class="col-md-4">


			<c:forEach items="${splits}" var="splits">
				<input class="check" type="checkbox" value="${splits.name}" />${splits.name}
           <!--<option value="cheese">${splits.name}</option>  -->

			</c:forEach>

			Amount:<input id="amt" type="text" name="amount"> Shared
			Amount:<input type="text" id="shrd" name="amt" value="" /> <input
				type="submit" />
			<button type="button" onclick="splits();">/splits\</button>
			<input type="hidden" id="hsd" name="hsd">
</form>

</div>
</div>



</body>
</html>