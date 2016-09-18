<%@ page import="businessLogic.Vehicle" %>
<%@ page import="businessLogic.DBLink" %>
<%@ page import="java.util.List" %>
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

<jsp:include page='HeaderBar.jsp'/>
<div class="row">
  <jsp:include page='LeftColumn.jsp'/>
  <div class="col-6">

    <form action="CreateAdvertisement" method="post">
      <div id="resultDev" >
        <h2 style="color: #04B404;">
          <% String msg=request.getParameter("msg");
          if(msg!=null){
            %>
          <%=msg%>
          <% } %>

        </h2>
        <h2>All Tender Notices in one Place</h2>
        <ul data-role="listview" data-inset="true">
        <%String n = request.getParameter( "adID" );%>
        <% List<Vehicle> vList= DBLink.getAdVehicles(n);
          if(vList.size()>0){
        for (int i=0;i<vList.size();i++) {
        Vehicle v=vList.get(i);%>

        <li onclick="loadVehicle<%=v.getID()%>()">
            <a>
                <img id="th<%=i%>" style="width:80px;height:80px" src="img/loading.gif">
                <h2><%=v.getBrand()%></h2>
                <p><%=v.getYear()%> : Reg No. <%=v.getRegNo()%> :  <%=v.getFuel()%> Enginr CC : <%=v.getEngineCC()%></p>
            </a>
            <script>
                $.ajax({url: "/imageDownload?small=1&img=0&vID=<%=v.getID()%>", success: function(result){
                    if(result.startsWith("null")) {
                        document.getElementById("th<%=i%>").src = "img/noImageSmall.jpg";
                    }else{
                        document.getElementById("th<%=i%>").src = result;
                    }
                }});
                function loadVehicle<%=v.getID()%>(vID){
                  console.log("LLLL");
                  window.location="/loadItem?vID=<%=v.getID()%>" ;
                }
              </script>
        </li>
        <% }}else{ %>

          <h1>Enter a valied Ref no and click Search</h1>
          <%}%>
        </ul>
      </div>
    </form>

    <h1>How to use</h1>
    <p>Find any tender notice reference number and search here. You can find all the detailed information and images relevant for the notice</p>
  </div>

<jsp:include page='RightColumn.jsp'/>
</div>
<jsp:include page='Footer.jsp'/>
</body>
</html>

