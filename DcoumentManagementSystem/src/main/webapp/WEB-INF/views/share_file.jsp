<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function searchUser() {    
    
    
    var user = $('#user').val();    
    var inputUser = $('#inputUser').val();     
    
    $.ajax({    
     type : "Get",     
     url : "getDepartmentList.html",     
     data : "user=" + user + "&inputUser=" + inputUser,    
     success : function(response) {    
      alert(response);     
     },    
    });    
   }    
</script>
</head>
<body>
<form method="get">
To<input id="user" type="text">
<input id="inputUser" type="text">
<button type="button" value="Search" onclick="searchUser();">Search</button>
</form>
</body>
</html>