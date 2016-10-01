<%@ page import="businessLogic.DBLink" %>
<%@ page import="businessLogic.Vehicle" %>
<%@ page import="businessLogic.StatusManager" %>
<!DOCTYPE html>
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css/theam.css">
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <link rel="stylesheet" href="css/jquery.mobile-1.4.5.min.css">
  <script src="js/jquery.mobile-1.4.5.min.js"></script>

  <script src="js/sweetalert.min.js"></script>
  <link rel="stylesheet" href="css/sweetalert.css" />

  <link href="img/CB.png" rel="icon" type="image/x-icon" />

<body>
<jsp:include page='HeaderBar.jsp'/>
<div class="row">
  <jsp:include page='LeftColumn.jsp'/>

    <div class="col-6">
      <%--<form action="CreateUser" method="post">--%>
        <div style="width:300px">

          <p> <input id="email" class="inputText" placeholder="Email Address" type="text"></p>
          <p> <input id="phone" class="inputText" placeholder="Phone Number"type="text"/></p>
          <p> <input id="pwd1" class="inputText" placeholder="Password"type="password"/></p>
          <p> <input id="pwd2" class="inputText" placeholder="Re-Type Password"type="password"/></p>



        </div>

        <div style="width:150px">
          <input type="button" onclick="createUser()" value="Create User">
        </div>
      <%--</form>--%>
<script>
  function uploadData(){
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var pwd1 = document.getElementById("pwd1").value;
    var pwd2 = document.getElementById("pwd2").value;

    $.post('CreateUser', {email: email, phone: phone, pwd1: pwd1, pwd2 :pwd2},
            function (result) {
              if(result==="") {
                swal("Account Created", "" + email + " ", "success");
              }else{
                swal("Oops...", result, "error");
              }

            }).fail(function () {
              alert("error");
            }
    );
  }
  function createUser() {
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var pwd1 = document.getElementById("pwd1").value;
    var pwd2 = document.getElementById("pwd2").value;

    if(pwd1 !== pwd2){
      swal("Oops...", "Password misatch", "error");
    }else {

      swal({
            title: "Creating your profile",
            text: "Are  you sure ?",
            type: "info",
            showCancelButton: true,
            closeOnConfirm: false,
            showLoaderOnConfirm: true
      }, function () {
            uploadData();
      });

    }
  }
</script>

        <div class="hideInMobile" style="min-height:350px;"> </div>
    </div>

    <jsp:include page='RightColumn.jsp'/>
  </div>
  <jsp:include page='Footer.jsp'/>
</body>
</html>
