<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet'
	href='<c:url value="/resources/chosen/chosen.css"/>'>
<script>
	window.console = window.console || function(t) {
	};
</script>
<script>
	if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	}
</script>
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
					<select data-placeholder="Your Favorite Football Teams"
						name="senderList" class="chosen-select col-sm-12" multiple
						tabindex="6">
						<option value=""></option>
						<c:forEach var="user" items="${toUser}" varStatus="index">
							<option value="${user.id}">${user.name}</option>
						</c:forEach>
					</select> <input type="submit" value="Submit">
				</div>
				<!--<form:checkbox path="receiver_list" value="${user.id}" />${user.name}</br>-->
				<p>Title</p>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<form:input class="form-control mr-sm-2" id="title" path="title"
						type="text" />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<form:textarea id="editor" rows="10" class="form-control mr-sm-2"
						id="description" path="description" placeholder="Description"></form:textarea>
				</div>
				<div class="row">
					<div class="col-6">
						<form:button class="btn btn-primary px-4" type="submit">Send</form:button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<script src="http://cdn.ckeditor.com/4.8/full-all/ckeditor.js"></script>
	<!-- <script type="text/javascript">
CKEDITOR.replace('editor',{
	skin:'moono',
	enterModel:CKEDITOR.ENTER_BR,
	shiftEnterMode: CKEDITOR.ENTER_P,
	toolbar: [{name:'basicstyle',groups:['basicsstyles'],items:['Bold','Italic','Underline',"-",'TextColor','BGColor']},
		{name: 'styles',items: ['Format','Font','FontSize']},
		{name: 'scripts',items: ['Subscript','Superscript']},
		{name: 'justify',groups: ['blocks','align'],items:['JustifyCenterLeft','JustifyCenter','JustifyRight','JustifyBlock']},
		{name: 'paragraph',groups: ['list','indent'],items:['NumberedList','BulletedList',"-",'Outdent','Indent']},
		{name: 'links',items: ['Link','Unlink']},
		{name: 'spell',groups: ['jQuerySpellchecker']}});
var ed=CKEDITOR.instances['editor'];
</script> -->
</body>
</html>