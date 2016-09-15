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


</head>
<body>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
</script>


<div >

<jsp:include page='HeaderBar.jsp'/>
<div class="row">
  <jsp:include page='LeftColumn.jsp'/>

  <div class="col-6">
    <form action="CreateAdvertisement" method="post" style="max-width: 500px;">
      <div>
        <p> <input name="topic" class="inputText" placeholder="Advertisement Name"type="text"/></p>
        <p> <input name="expDate" class="inputText" placeholder="Expire Date" type="text" id="datepicker"></p>
        <p> <input name="noVehi" class="inputText" placeholder="No Of Vehicles"type="text"/></p>
        <p> <input name="email" class="inputText" placeholder="Email Address"type="text"/></p>
        <p> <input name="pwd" class="inputText" placeholder="Password"type="password"/></p>


          <div style="width:200px">
              <input type="submit" value="Create Advertisement">
          </div>
      </div>
    </form>
  </div>


  <jsp:include page='RightColumn.jsp'/>
</div>
  <jsp:include page='Footer.jsp'/>
</body>
</html>
