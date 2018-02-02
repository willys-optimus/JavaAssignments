<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page errorPage="error.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic e-commerce</title>
<link rel="stylesheet" href="Resources/masterStyleSheet.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/scripts.js"> </script>
</head>
<body>
<div>
<%
String id = request.getParameter("userId");
String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
String connectionUrl = "jdbc:sqlserver://LENOVOLAPTOP\\\\SQL:1433;" + 
  						"databaseName=ServletAssignment;user=su;password=root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Basic e-commerce site</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#D3D3D3">
<td><b>Name</b></td>
<td><b>Description</b></td>
<td><b>Price</b></td>
<td><b>Quantity</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl);
statement=connection.createStatement();
String sql ="SELECT * FROM items";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<form name="addCart" action = "addToCart" method = "get" onsubmit="return validateQty();">
<tr bgcolor="#DEB887">
<td><input type="hidden" name="name" value=<%=resultSet.getString("itemName") %>><%=resultSet.getString("itemName") %></td>
<td><%=resultSet.getString("itemDesc") %></td>
<td><input type="hidden" name="price" value=<%=resultSet.getInt("itemPrice") %> ><%=resultSet.getString("itemPrice") %></td>
<td><input type ="text" name="quantity" size="5" value="0"><td><input type="submit" value="Add to cart"></td>
</tr>
</form>
<% 
}


} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</div>
</body>
</html>