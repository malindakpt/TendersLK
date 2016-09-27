<%@ page import="businessLogic.Vehicle" %>
<%@ page import="businessLogic.DBLink" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/theam.css">
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <link rel="stylesheet" href="css/jquery.mobile-1.4.5.min.css">
  <script src="js/jquery.mobile-1.4.5.min.js"></script>
  <script src="js/sweetalert.min.js"></script>
  <link rel="stylesheet" href="css/sweetalert.css"/>
  <%--<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">--%>

  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<jsp:include page='HeaderBar.jsp'/>
<div class="row">
  <div class="col-3 menu">
<style>
  li {
    text-align: center;
  }
</style>
    <ul>

      <% String n = request.getParameter( "vID" );
        Vehicle v= DBLink.getVehicle(Integer.parseInt(n));
      %>
      <li> <%=v.getRegNo()%></li>
      <li> <%=v.getBrand()%></li>
      <li> <%=v.getModel()%></li>
      <li> <%=v.getYear()%></li>
      <%--<li><%=v.getCondition()%></li>--%>
      <li><%=v.getMileage()%></li>
      <%--<li><%=v.getBodyType()%></li>--%>
      <li> <%=v.getTransmission()%></li>
      <li> <%=v.getFuel()%></li>
      <li><%=v.getEngineCC()%></li>
      <li> <%=v.getDescription()%></li>
      <li id="vID"> <%=v.getID()%></li>
    </ul>

    <script>
      $.ajax({url: "/imageDownload?img=0&vID=<%=v.getID()%>", success: function(result){
        if(result.startsWith("null")){
          document.getElementById("img00").src = "img/noImage.JPG";
        }else{
          document.getElementById("img00").src =result;
        }

      }});

      $.ajax({url: "/imageDownload?img=1&vID=<%=v.getID()%>", success: function(result){
        if(result.startsWith("null")){
          document.getElementById("img10").src = "img/noImage.JPG";
        }else{
          document.getElementById("img10").src = result;
        }


      }});
      $.ajax({url: "/imageDownload?img=2&vID=<%=v.getID()%>", success: function(result){
        if(result.startsWith("null")){
          document.getElementById("img20").src = "img/noImage.JPG";
        }else{
          document.getElementById("img20").src = result;
        }


      }});
      $.ajax({url: "/imageDownload?img=3&vID=<%=v.getID()%>", success: function(result){
        if(result.startsWith("null")){
          document.getElementById("img30").src = "img/noImage.JPG";
        }else{
          document.getElementById("img30").src = result;
        }


      }});
      <%--$.ajax({url: "/imageDownload?img=4&vID=<%=v.getID()%>", success: function(result){--%>
        <%--if(result.startsWith("null")){--%>
          <%--document.getElementById("img40").src = "img/noImage.JPG";--%>
        <%--}else{--%>
          <%--document.getElementById("img40").src =result;--%>
        <%--}--%>


      <%--}});--%>

    </script>
    <script>
      function deleteVehicle() {
        var email= prompt("Please enter your Email", "a");
        if (email!= null) {
          var vID = document.getElementById("vID").innerHTML;
          //  alert("asd "+vID);
          var password= prompt("Please enter your Password", "");
          if (password!= null) {



            $.post('DeleteVehicle', { email: email, password : password, vID :vID},
                    function(returnedData){
                        if(returnedData=="1"){
                          window.location.href="/?msg=Vehicle Deleted Successfully &#926;";
                        }else{
                          swal("Oops... unable to delete vehicle", returnedData, "error");
                        }

                    }).fail(function(){
                      swal("Oops...", "Unknown error occured", "error");
                    }
            );
          }
        }
      }
    </script>
  </div>
  <div class="col-6" style="position:relative">

    <img id="img00" class="mySlides" style="width:100%; max-height: 600px;" onclick="plusDivs(1) "  src="img/loading2.gif">
    <img id="img10"  class="mySlides" style="width:100%; max-height: 600px;" onclick="plusDivs(1)"  src="img/loading2.gif">
    <img id="img20"  class="mySlides"  style="width:100%; max-height: 600px;" onclick="plusDivs(1)"  src="img/loading2.gif">
    <img id="img30"  class="mySlides" style="width:100%; max-height: 600px;" onclick="plusDivs(1)"  src="img/loading2.gif">
    <%--<img id="img40"  class="mySlides" style="width:100%; max-height: 600px;" onclick="plusDivs(1)">--%>

    <a class="w3-btn-floating" style="position:absolute;top:45%;left:0" onclick="plusDivs(-1)"><</a>
    <a class="w3-btn-floating" style="position:absolute;top:45%;right:0" onclick="plusDivs(1)">></a>

    <script>
      var slideIndex = 1;
      showDivs(slideIndex);


      function plusDivs(n) {
        showDivs(slideIndex += n);
      }

      function showDivs(n) {
        var sWidth = screen.width;
        var i;
        var x = document.getElementsByClassName("mySlides");
        if (n > x.length) {slideIndex = 1}
        if (n < 1) {slideIndex = x.length}
        for (i = 0; i < x.length; i++) {
          x[i].style.display = "none";
        }
        x[slideIndex-1].style.display = "block";
      }

    //  setInterval(function(){ plusDivs(1); }, 5000);
    </script>

    <div style="width:100px">
      <input type="button" onclick="deleteVehicle()" value="Delete">

    </div>





</div>
  <%  if(v.getLocation()!=null){ %>

  <div class="col-3 right">


    <div>
      <%=v.getLocation()%>
      <%--<iframe class=map src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d35209.15500681015!2d79.83780309188174!3d6.9133317926346765!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae25960d359dbbf%3A0xd64947e9ab7a4c4f!2sColombo+03%2C+Colombo!5e0!3m2!1sen!2slk!4v1474998953777" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>--%>
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
  <% } else {%>
  <jsp:include page='RightColumn.jsp'/>
  <% }  %>
</div>
<jsp:include page='Footer.jsp'/>
</body>
</html>

