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

      <%--<form>--%>
        <%--<input style="height:33px; width:300px;" placeholder="Reference No"/>--%>
        <%--<span>--%>
          <%--&lt;%&ndash;<input type="image" src="img/search-icon.png" alt="Submit">&ndash;%&gt;--%>
    <%--<input class="btn1" type="button" value="Search" class="btn btn-primary"/>--%>

          <%--</span>--%>
      <%--</form>--%>


    </div>

  </div>

  <form action="UploadServlet" method="post"
        enctype="multipart/form-data">
  <div class="row">

    <div class="col-3 menu">

      <ul>
        <%
          Vehicle v= DBLink.getAdvertisement();
        %>
        <li> <input placeholder="Reg No.." name="regNo"/></li>
        <li> <input placeholder="Brand" name="brand"/></li>
        <li> <input placeholder="Model" name="model"/></li>
        <li> <input placeholder="Manufac. Yar" name="manufac"/></li>
        <li> <input placeholder="Condition" name="condition"/></li>
        <li> <input placeholder="Millage" name="millage"/></li>
        <li> <input placeholder="Body Type" name="bodyType"/></li>
        <li> <input placeholder="Transmission" name="transmission"/></li>
        <li> <input placeholder="Fuel Type" name="fuel"/></li>
        <li> <input placeholder="Engine Capacity" name="engineCC"/></li>

      </ul>

      <div align="center">
        <button class="btn2">Pev</button>
        <button class="btn2">Next</button>
      </div>
    </div>

    <div class="col-6">

      <h1>The City</h1>
      <p>Chania is the capital of the Chania region on the island of Crete. The city can be divided in two parts, the old town and the modern city.</p>



        <%--<form action="UploadServlet" method="post"--%>
              <%--enctype="multipart/form-data">--%>
          <input type="file" name="file0" size="50" />
          <br />
          <br />
          <input type="file" name="file1" size="50" />
          <br />
          <br />
          <input type="file" name="file2" size="50" />
          <br />
          <br />
          <input type="file" name="file3" size="50" />
          <br />
          <br />
          <input type="file" name="file4" size="50" />
          <br />
          <br />


          <input type="submit" value="Upload Files" />
        <%--</form>--%>



     <div>
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
    </div>

  </div>

  </form>
  <div class="footer">
    <p>Resize the browser window to see how the content respond to the resizing.</p>
  </div>
</div>
</body>
</html>
