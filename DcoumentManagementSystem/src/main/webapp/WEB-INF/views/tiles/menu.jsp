<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'>
<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />'>
<link rel="stylesheet" href='<c:url value="/webjars/jquery/3.4.1/js/jquery.min.js" />'>
</head>
<body>
		<ul class="nav ">
			<li class="nav-item"><a class="nav-link" href="index.htm">
					<i class="3x fas fa-envelope-square"></i>Home
			</a></li>
			<li class="nav-link">Theme</li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/user_register.htm' />">
					<i class="fas fa-registered"></i> Register
			</a></li>
			<li class="nav-link">ALL LABELS</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false"> <i
					class="fas fa-caret-square-down"></i>File 
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="file_upload.htm">File Upload</a> <a
						class="dropdown-item" href="#two">File Share</a>
					<div role="separator" class="dropdown-divider"></div>
					<a class="dropdown-item" href="my_file.htm">My File</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/documentsend.htm' />">
					<i class="fas fa-star"></i>Document <span
					class="badge badge-light">4</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/view_message.htm' />">
					<i class="fas fa-share-square"></i>Send Message <span
					class="badge badge-primary">NEW</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/view_receivedMessage.htm'/>">
					<i class="fas fa-file-alt"></i>Drafts <span
					class="badge badge-primary">NEW</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="index.html">
					<i class="fas fa-trash-alt"></i> Trash <span
					class="badge badge-primary">NEW</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="index.html">
					<i class="fas fa-outdent"></i>Outbox <span
					class="badge badge-primary">NEW</span>
			</a></li>
			<li class="nav-item">
			<a class="nav-link nav-link-danger"
				href="<c:url value='/logout.htm'/>" target="_top"> <i class="nav-icon icon-layers"></i>Logout
			</a></li>
		</ul>
</body>
</html>
