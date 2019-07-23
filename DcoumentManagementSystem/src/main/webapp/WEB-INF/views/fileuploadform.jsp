<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<script type="text/javascript" src="jquery-1.2.6.min.js"></script>
<title>Spring MVC file upload</title>
</head>
<body>
  <h2>Spring MVC file upload</h2>
  <h3>Please select a file to upload !</h3>
  <div style="text-align: center">
  <form:form method="post" enctype="multipart/form-data"
   modelAttribute="uploadedFile" action="success.htm">
   <table>
    <tr>
     <td>Upload File: </td>
     <td><input type="file" name="file" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="file" />
     </td>
    </tr>
    <tr>
     <td> </td>
     <td><input type="submit" value="Upload" />
     </td>
     <td> </td>
    </tr>
   </table>
  </form:form>
  </div>
</body>
</html>

