<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<form action="login.htm" method="post">
	<div class="container">
	 <c:if test="${param.error != null}">          
        <p>  
            Invalid username and password.  
        </p>  
    </c:if>  
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card-group">
					<div class="card p-4">
						<div class="card-body">
							<h1>Login</h1>
							<p class="text-muted">Sign In to your account</p>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="icon-user"></i>
									</span>
								</div>
								<input class="form-control" name="username" type="text"
									placeholder="Enter Your Email"/>
							</div>
							<div class="input-group mb-4">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="icon-lock"></i>
									</span>
								</div>
								<input class="form-control" name="password" type="password"
									placeholder="Enter Your Password"/>
							</div>
							<div class="row">
								<div class="col-6">
									<button class="btn btn-primary px-4" type="submit">Login</button>
									<button class="btn btn-primary px-4" type="reset">Cancel</button>
								</div>
								<div class="col-6 text-right">
									<button class="btn btn-link px-0" type="button">Forgot
										password?</button>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>