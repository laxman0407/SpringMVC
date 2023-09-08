<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.tech.model.Customer" %>

   
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function addData() {
	alert("do you want to add data?")
	document.myform.action="register.jsp";
	document.myform.submit();
}
function deleteData() {
	alert("do you want to delete data?")
	document.myform.action="delete";
	document.myform.submit();
	
}
function updateData() {
	alert("do you want to update data")
	document.myform.action="edit";
	document.myform.submit();
}
function addMoney() {
	document.myform.action="deposit";
	document.myform.submit();
	
}
function withdrawMoney() {
	document.myform.action="withdraw";
	document.myform.submit();
	
}
</script>
<meta charset="ISO-8859-1">
<title>Success page</title>
</head>
<body>
<form name="myform">
<table border="3" style="margin:auto;margin-top:200px;width:50%; background-color: pink ">
<tr style="background-color: lightgreen">
<td>Select</td>
<td>AadhaarNumber</td>
<td>AccountNumber</td>
<td>Customer Name</td>
<td>Mobile Number</td>
<td>Customer Address</td>
<td>UserName</td>
<td>Password</td>
<td>Account Balance</td>
</tr>

<tr>
<c:forEach items="${data}" var="acc">
<td><input type="radio" name="rd" value="${acc.addharNo}"></td>
<td><c:out value="${acc.addharNo}"></c:out></td>
<td><c:out value="${acc.accountNumber }"></c:out></td>
<td><c:out value="${acc.cusName}"></c:out></td>
<td><c:out value="${acc.cusMobileNumber}"></c:out></td>
<td><c:out value="${acc.cusAddress}"></c:out></td>
<td><c:out value="${acc.userName}"></c:out></td>
<td><c:out value="${acc.password}"></c:out></td>
<td><c:out value="${acc.totalAmount}"></c:out></td>
</tr>
</c:forEach>
<tr>
<td><input type="button" value="AddData" style="background: lightgreen" onclick="addData()"></td>
<td><input type="button" value="DeleteData" style="background: yellow" onclick="deleteData()"></td>
<td><input type="button" value="UpdateData" style="background: lightblue" onclick="updateData()"></td>
<td><input type="button" value="Addmoney" onclick="addMoney()" style="background: lightgreen"></td>
<td><input type="button" value="WithdrawMoney" onclick="withdrawMoney()" style="background: lightblue"></td>
</tr>
</table>
</form>
</body>
</html>