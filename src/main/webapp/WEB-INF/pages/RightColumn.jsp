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
  <div class="aside">
    <h2>What?</h2>
    <p>Your Advertisements are going Here.</p>
    <h2>What?</h2>
    <p>Your Advertisements are going Here.</p>
    <h2>What?</h2>
    <p>Your Advertisements are going Here.</p>
 </div>
  <br>
  <br>
    <br>
  <div data-role="navbar">
    <ul>
      <li><a onclick="search1()">Search</a></li>
      <li><a onclick="newAd()">Advertise</a></li>
      <li><a onclick="newVehicle()">Add Vehicle</a></li>
      <li><a onclick="newUser()">New User</a></li>
    </ul>

      <script>
          function search1(){
              window.location.href="/";
          }
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
