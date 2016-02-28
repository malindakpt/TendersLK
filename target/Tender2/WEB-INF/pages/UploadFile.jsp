
<%@ page import="businessLogic.Vehicle" %>
<%@ page import="businessLogic.DBLink" %>
<html>
<head>
    <title>File Uploading Form</title>
</head>
<body>

<%
    Vehicle v= DBLink.getAdvertisement();
%>
<h1> <%=v.getBrand()%></h1>
<h3>File Upload Site:</h3>
Select a file to upload: <br />

<img src="/images/img1.PNG" alt="Mountain View" style="width:304px;height:228px;">

<br>

<form action="UploadServlet" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50" />
    <br />
    <input type="submit" value="Upload File" />
</form>

<form  method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50" />
    <br/>
    <input type="submit" value="Upload File No" />
</form>
</body>
</html>