<%@ page import="businessLogic.DBLink" %>
<%@ page import="businessLogic.Vehicle" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/slider.css">
<link rel="stylesheet" type="text/css" href="css/theam.css">

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jssor.slider.mini.js"></script>
<script type="text/javascript" src="js/slider.js"></script>


<meta name="viewport" content="width=device-width, initial-scale=1.0">

  <style>

    .center {
      margin: auto;
      width: 60%;
      border: 3px solid #73AD21;
      padding: 10px;
    }

    .btn1{
       height:33px;
      width:70px;
      margin-top: 10px
    }

    .btn2{
      background-color: #6E6E6E;

      height:33px;
      width:70px;
      margin: 10px
    }
  </style>

</head>
<body style="background-color:lightgrey;">
<%--<body style="background-color:#CEE3F6;">--%>


<div >
<div class="header">

  <div>

    <img src="img/logo1.PNG"/>
  </div>





  <div align="center">

      <form>
    <input style="height:33px; width:300px;" placeholder="Reference No"/>
        <span>
          <%--<input type="image" src="img/search-icon.png" alt="Submit">--%>
    <input class="btn1" type="button" value="Search" class="btn btn-primary"/>

          </span>
      </form>


  </div>

</div>


<div class="row">

  <div class="col-3 menu">

    <ul>
      <%
        Vehicle v= DBLink.getAdvertisement();
      %>
      <li> <input placeholder="Reg No.."/></li>
      <li> <input placeholder="Brand"/></li>
      <li> <input placeholder="Model"/></li>
      <li> <input placeholder="Manufac. Yar"/></li>
      <li> <input placeholder="Condition"/></li>
      <li> <input placeholder="Millage"/></li>
      <li> <input placeholder="Body Type"/></li>
      <li> <input placeholder="Transmission"/></li>
      <li> <input placeholder="Fuel Type"/></li>
      <li> <input placeholder="Engine Capacity"/></li>
      <%--<li> <%=v.getBrand()%></li>--%>
      <%--<li> <%=v.getModel()%></li>--%>
      <%--<li> <%=v.getYear()%></li>--%>
      <%--<li><%=v.getCondition()%></li>--%>
      <%--<li><%=v.getMileage()%></li>--%>
      <%--<li><%=v.getBodyType()%></li>--%>
      <%--<li> <%=v.getTransmission()%></li>--%>
      <%--<li> <%=v.getFuel()%></li>--%>
      <%--<li><%=v.getEngineCC()%></li>--%>
      <%--<li> <%=v.getDescription()%></li>--%>
    </ul>

    <div align="center">
      <button class="btn2">Pev</button>
      <button class="btn2">Next</button>
    </div>
  </div>

  <div class="col-6">

    <h1>The City</h1>
    <p>Chania is the capital of the Chania region on the island of Crete. The city can be divided in two parts, the old town and the modern city.</p>

    <div>
      <form action="UploadServlet0" method="post"
            enctype="multipart/form-data">
        <input type="file" name="file" size="50" />
        <br />
        <input type="submit" value="Upload File" />
      </form>
    </div>

    <div>
      <form action="UploadServlet1" method="post"
            enctype="multipart/form-data">
        <input type="file" name="file" size="50" />
        <br />
        <input type="submit" value="Upload File" />
      </form>
    </div>

    <div>
      <form action="UploadServlet2" method="post"
            enctype="multipart/form-data">
        <input type="file" name="file" size="50" />
        <br />
        <input type="submit" value="Upload File" />
      </form>
    </div>

    <div>
      <form action="UploadServlet3" method="post"
            enctype="multipart/form-data">
        <input type="file" name="file" size="50" />
        <br />
        <input type="submit" value="Upload File" />
      </form>
    </div>


    <div>
      <form action="UploadServlet4" method="post"
            enctype="multipart/form-data">
        <input type="file" name="file" size="50" />
        <br />
        <input type="submit" value="Upload File" />
      </form>
    </div>


  </div>

  <div class="col-31 right">
    <%--<div align="center" style="visibility: hidden";>--%>
      <%--<button class="btn2">Pev</button>--%>
      <%--<button class="btn2">Next</button>--%>
    <%--</div>--%>

    <div class="aside">
      <h2>What?</h2>
      <p>Chania is a city on the island of Crete.</p>
      <h2>Where?</h2>
      <p>Crete is a Greek island in the Mediterranean Sea.</p>
      <h2>How?</h2>
      <p>You can reach Chania airport from all over Europe.</p>
      <h2>What?</h2>
      <p>Chania is a city on the island of Crete.</p>
      <h2>Where?</h2>
      <p>Crete is a Greek island in the Mediterranean Sea.</p>
      <h2>How?</h2>
      <p>You can reach Chania airport from all over Europe.</p>
    </div>
  </div>

</div>


<div class="footer">
  <p>Resize the browser window to see how the content respond to the resizing.</p>
</div>
</div>
</body>
</html>
