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
        Vehicle v= DBLink.getVehicle(0);
      %>
      <li> <%=v.getRegNo()%></li>
      <li> <%=v.getBrand()%></li>
      <li> <%=v.getModel()%></li>
      <li> <%=v.getYear()%></li>
      <li><%=v.getCondition()%></li>
      <li><%=v.getMileage()%></li>
      <li><%=v.getBodyType()%></li>
      <li> <%=v.getTransmission()%></li>
      <li> <%=v.getFuel()%></li>
      <li><%=v.getEngineCC()%></li>
      <li> <%=v.getDescription()%></li>
    </ul>

    <div align="center">
      <button class="btn2">Pev</button>
      <button class="btn2">Next</button>
    </div>
  </div>

  <div class="col-6">

    <h1>The City</h1>
    <p>Chania is the capital of the Chania region on the island of Crete. The city can be divided in two parts, the old town and the modern city.</p>


  <div id="jssor_1" style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 600px; height: 400px; overflow: hidden; visibility: hidden;">
    <!-- Loading Screen -->
    <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
      <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
      <div style="position:absolute;display:block;background:url('img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
    </div>
    <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">
      <div data-p="112.50" style="display: none;">
        <img data-u="image" src="data:image/png;base64,<%=v.getHtmlPhoto0()%>" />
        <div data-u="thumb">
          <img src="data:image/png;base64,<%=v.getHtmlPhoto0()%>" />

        </div>
      </div>
      <div data-p="112.50" style="display: none;">
        <img data-u="image" src="data:image/png;base64,<%=v.getHtmlPhoto1()%>" />
        <div data-u="thumb">
          <img src="data:image/png;base64,<%=v.getHtmlPhoto1()%>" />

        </div>
      </div>
      <div data-p="112.50" style="display: none;">
        <img data-u="image" src="data:image/png;base64,<%=v.getHtmlPhoto2()%>" />
        <div data-u="thumb">
          <img src="data:image/png;base64,<%=v.getHtmlPhoto2()%>" />

        </div>
      </div>
      <div data-p="112.50" style="display: none;">
        <img data-u="image" src="data:image/png;base64,<%=v.getHtmlPhoto3()%>" />
        <div data-u="thumb">
          <img src="data:image/png;base64,<%=v.getHtmlPhoto3()%>" />

        </div>
      </div>
      <div data-p="112.50" style="display: none;">
        <img data-u="image" src="data:image/png;base64,<%=v.getHtmlPhoto4()%>" />
        <div data-u="thumb">
          <img src="data:image/png;base64,<%=v.getHtmlPhoto4()%>" />

        </div>
      </div>
    </div>
    <!-- Thumbnail Navigator -->
    <div data-u="thumbnavigator" class="jssort16" style="position:absolute;left:0px;bottom:0px;width:600px;height:100px;" data-autocenter="1">
      <!-- Thumbnail Item Skin Begin -->
      <div data-u="slides" style="cursor: default;">
        <div data-u="prototype" class="p">
          <div data-u="thumbnailtemplate" class="t"></div>
        </div>
      </div>
      <!-- Thumbnail Item Skin End -->
    </div>
    <!-- Bullet Navigator -->
    <div data-u="navigator" class="jssorb03" style="bottom:116px;right:16px;">
      <!-- bullet navigator item prototype -->
      <div data-u="prototype" style="width:21px;height:21px;">
        <div data-u="numbertemplate"></div>
      </div>
    </div>
    <a href="http://www.jssor.com" style="display:none">Slideshow Maker</a>
  </div>
  </div>

  <div class="col-31 right">
    <%--<div align="center" style="visibility: hidden";>--%>
      <%--<button class="btn2">Pev</button>--%>
      <%--<button class="btn2">Next</button>--%>
    <%--</div>--%>
    <ul>
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
      </ul>
  </div>

</div>


<div class="footer">
  <p>Resize the browser window to see how the content respond to the resizing.</p>
</div>
</div>
</body>
</html>
