<%--
  Created by IntelliJ IDEA.
  User: MalindaK
  Date: 7/17/2016
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<div class="col-3 right">


  <div>
    <iframe class=map src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d35209.15500681015!2d79.83780309188174!3d6.9133317926346765!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae25960d359dbbf%3A0xd64947e9ab7a4c4f!2sColombo+03%2C+Colombo!5e0!3m2!1sen!2slk!4v1474998953777" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
  </div>
  <br>
  <br>
  <br>
  <div data-role="navbar">
    <ul>

      <li><a onclick="newAd()">New Ad</a></li>
      <li><a onclick="newVehicle()">Post Vehicle</a></li>
      <li><a onclick="newUser()">New User</a></li>
    </ul>

    <script>

      function newAd(){
        window.location.href="/CreateAdView";
      }
      function newVehicle(){
        window.location.href="/AddVehicle";
      }
      function newUser(){
        window.location.href="/CreateUserView";
      }
    </script>
  </div>

</div>
</body>
</html>
