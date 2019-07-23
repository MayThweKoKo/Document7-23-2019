<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form class="message" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/message_send.htm"
		modelAttribute="message">
	<div class="container">
			<div class="card-body">
				<h1>Sending Message</h1>
				
				<p>To</p>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<c:forEach var="user" items="${toUser}">
					<form:checkbox path="receiver_list" value="${user.id}"/>${user.name}</br>
					</c:forEach>
				
					
				</div>
				<p>Title</p>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<form:input class="form-control mr-sm-2" id="title" path="title"  type="text"/>
				</div>
				<%-- <div class="input-group mb-3">
					<select class="custom-select">
						<option value="">Select</option>
						<c:forEach var="file" items="${receiver_list}">
							<form:option value="${receiver.id}">
								<c:out value="${receiver.name}" />
							</form:option>
						</c:forEach>
					</select>
				</div> --%>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<form:textarea rows="10"  class="form-control mr-sm-2"  id="description" path="description" placeholder="Description"></form:textarea>
				</div>
				<div class="row">
					<div class="col-6">
						<form:button class="btn btn-primary px-4" type="submit">Send</form:button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>