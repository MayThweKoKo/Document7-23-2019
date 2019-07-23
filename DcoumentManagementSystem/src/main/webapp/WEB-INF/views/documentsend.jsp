<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="card-body">
			<h1>Sending Your File</h1>
			<p>From</p>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
				</div>
				<input class="form-control mr-sm-2" multiple="multiple" type="search" placeholder="Search Receive Teacher">
			</div>
			<p>To/</p>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
				</div>
				<input type="text" class="form-control mr-sm-2" id="w-input-search" value="" autocomplete="off">
				<button class="btn btn-primary" type="button">Search</button>
			</div>
			<p>Subject</p>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
				</div>
				<input class="form-control mr-sm-2" multiple="multiple" type="search" placeholder="Say Something" >
			</div>
			<div class="input-group mb-4">
				<input class="form-control" type="File" placeholder="Selected Your File">
			</div>
			<div class="row">
				<div class="col-6">
					<button class="btn btn-primary px-4" type="button">Send</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>