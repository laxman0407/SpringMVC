<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Amount page</title>
</head>
<body>
<form action="depo">
<pre>
AadhaarNumber       :<input type="hidden" name="addharNo" value="${data.addharNo}">

enter deposit Amount:<input type="text" name="totalAmount">

<input type="submit" value="save" style="background: lightblue">
</pre>
</form>

</body>
</html>