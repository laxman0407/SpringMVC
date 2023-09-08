<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update data page</title>
</head>
<body>
<form action="update">
<pre>
<h2>
Customer AadhaarNumber:<input type="hidden" name="addharNo" value="${data.addharNo}">

Account Number:        <input type="hidden" name="accountNumber" value="${data.accountNumber}">

Customer Name:         <input type="text" name="cusName" value="${data.cusName}">

Customer Mobile Number:<input type="text" name="cusMobileNumber" value="${data.cusMobileNumber}">

Customer Address:      <input type="text" name="cusAddress" value="${data.cusAddress}">

UserName:              <input type="text" name="userName" value="${data.userName}">

Password:              <input type="text" name="password" value="${data.password}">

Account Balance:       <input type="hidden" name="totalAmount" value="${data.totalAmount}">

<input type="submit" value="Update" style="background: pink">
</h2>
</pre>
</form>
</body>
</html>