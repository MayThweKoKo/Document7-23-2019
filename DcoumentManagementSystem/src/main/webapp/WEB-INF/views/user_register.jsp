<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/jquery/3.4.1/js/jquery.min.js" />'>
</head>
<body>
	<table>
		<form:form class="user" method="post" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/user_register.htm"
			modelAttribute="user_registerDTO">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6">
						<div class="card mx-4">
						<div class="card-body p-4">
							<h3>Please type your information!</h3>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										id="name" path="name" placeholder="Enter Your name" />

								</div>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										id="address" path="address" placeholder="Enter Your Address" />
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										id="phone" path="phno" placeholder="Enter Your Phone" />
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										id="nrc" path="nrc" placeholder="Enter Your Nrc NO" />
								</div>
								<div class="form-group">
									<form:input type="file" class="form-control form-control-user"
										id="photo" path="photo" placeholder="Enter Your photo" />
				
							</div>
							<div class="form-group">
								<form:input type="text" class="form-control form-control-user"
									id="email" path="email" placeholder="Enter Your Email Address" />

							</div>
							<div class="form-group">
								<form:password class="form-control form-control-user"
									id="password" path="password" placeholder="Enter Your Password" />
							</div>
							<div class="form-group">
								<form:select path="department_id" class="custom-select">
									<option value="">Select</option>
									<c:forEach var="department" items="${department_list}">
										<form:option value="${department.id}">
											<c:out value="${department.department}" />
										</form:option>
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group">
								<form:select path="role_id" class="custom-select">
									<option value="">Select</option>
									<c:forEach var="role" items="${role_list}">
										<form:option value="${role.id}">
											<c:out value="${role.role_level}" />
										</form:option>
									</c:forEach>
								</form:select>
							</div>
							<button class="btn btn-primary px-4" type="submit">Submit</button>
							&nbsp;&nbsp;
							<button class="btn btn-primary px-4" type="reset">Cancel</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form:form>
	</table>
</body>
</html>
