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
            <% String n = request.getParameter("vID");
                Vehicle v = DBLink.getVehicle(Integer.parseInt(n));
            %>
            <li>Brand : <%=v.getBrand()%>
            </li>
            <li>Reg No :  <%=v.getRegNo()%>
            </li>
            <li>Model :  <%=v.getModel()%>
            </li>
            <li>Manufac. Year :  <%=v.getYear()%>
            </li>
            <%--<li><%=v.getCondition()%></li>--%>
            <li>Millage : <%=v.getMileage()%>
            </li>
            <%--<li><%=v.getBodyType()%></li>--%>
            <li>Transmission :  <%=v.getTransmission()%>
            </li>
            <li>Fuel Type :  <%=v.getFuel()%>
            </li>
            <li>Engine CC :<%=v.getEngineCC()%>
            </li>
            <li><%=v.getDescription()%>
            </li>
            <li id="vID"><%=v.getID()%>
            </li>
        </ul>

        <script>
            var loadDone0=false;
            var loadDone1=false;
            var loadDone2=false;
            var loadDone3=false;

            var gWidth=600;
            var gHeight=600;

            load1image0();
            function load1image0() {
                $.ajax({
                    url: "/imageDownload?img=0&vID=<%=v.getID()%>", success: function (result) {
                        if (result.startsWith("null")) {
                            document.getElementById("img00").src = "img/noImage.JPG";
                        } else {
                            var image = document.getElementById("img00");
                            gWidth = image.width ;
                            gHeight = image.height;

//                            if(image.width > screen.width ){
//                                gHeight=200;
//                            }

                            var tempImg = document.createElement('img');

                            tempImg.addEventListener('load', function() {
                                image.src = result;

                                if(gWidth>tempImg.width ) {
                                    image.style.left =  (gWidth-tempImg.width)/2+"px";
                                    image.style.top =   (gHeight-tempImg.height)/2+"px";
                                    image.style.width = tempImg.width + "px";
                                    image.style.height = tempImg.height + "px";
                                }else{
                                    image.style.left =  0+"px";
                                    image.style.top =   0+"px";
                                    image.style.width = gWidth+ "px";
                                    image.style.height =  tempImg.height*gWidth/tempImg.width + "px";
                                }
                            });
                            tempImg.src = result;
                        }
                        loadDone0=true;
                        load1image1();
                    }
                });
            }
            function load1image1() {
                    $.ajax({
                        url: "/imageDownload?img=1&vID=<%=v.getID()%>", success: function (result) {
                            if (result.startsWith("null")) {
                                document.getElementById("img10").src = "img/noImage.JPG";
                            } else {
                                var image = document.getElementById("img10");
                                var tempImg = document.createElement('img');

                                tempImg.addEventListener('load', function() {
                                    image.src = result;

                                    if(gWidth>tempImg.width ) {
                                        image.style.left =  (gWidth-tempImg.width)/2+"px";
                                        image.style.top =   (gHeight-tempImg.height)/2+"px";
                                        image.style.width = tempImg.width + "px";
                                        image.style.height = tempImg.height + "px";
                                    }else{
                                        image.style.left =  0+"px";
                                        image.style.top =   0+"px";
                                        image.style.width = gWidth+ "px";
                                        image.style.height =  tempImg.height*gWidth/tempImg.width + "px";
                                    }

                                });
                                tempImg.src = result;
                            }
                            loadDone1=true;
                            load1image2();
                        }
                    });

                }
            function load1image2() {
                        $.ajax({
                            url: "/imageDownload?img=2&vID=<%=v.getID()%>", success: function (result) {
                                if (result.startsWith("null")) {
                                    document.getElementById("img20").src = "img/noImage.JPG";
                                } else {
                                    var image = document.getElementById("img20");
                                    var tempImg = document.createElement('img');

                                    tempImg.addEventListener('load', function() {
                                        image.src = result;

                                        if(gWidth>tempImg.width ) {
                                            image.style.left =  (gWidth-tempImg.width)/2+"px";
                                            image.style.top =   (gHeight-tempImg.height)/2+"px";
                                            image.style.width = tempImg.width + "px";
                                            image.style.height = tempImg.height + "px";
                                        }else{
                                            image.style.left =  0+"px";
                                            image.style.top =   0+"px";
                                            image.style.width = gWidth+ "px";
                                            image.style.height =  tempImg.height*gWidth/tempImg.width + "px";
                                        }

                                    });
                                    tempImg.src = result;
                                }
                                loadDone2=true;
                                load1image3();
                            }
                        });

            }
            function load1image3() {
                        $.ajax({
                            url: "/imageDownload?img=3&vID=<%=v.getID()%>", success: function (result) {
                                if (result.startsWith("null")) {
                                    document.getElementById("img30").src = "img/noImage.JPG";
                                } else {
                                    var image = document.getElementById("img30");
                                    var tempImg = document.createElement('img');

                                    tempImg.addEventListener('load', function() {
                                        image.src = result;

                                        if(gWidth>tempImg.width ) {
                                            image.style.left =  (gWidth-tempImg.width)/2+"px";
                                            image.style.top =   (gHeight-tempImg.height)/2+"px";
                                            image.style.width = tempImg.width + "px";
                                            image.style.height = tempImg.height + "px";
                                        }else{
                                            image.style.left =  0+"px";
                                            image.style.top =   0+"px";
                                            image.style.width = gWidth+ "px";
                                            image.style.height =  tempImg.height*gWidth/tempImg.width + "px";
                                        }

                                    });
                                    tempImg.src = result;
                                }
                                loadDone3=true;
                            }
                        });

            }

        </script>
        <script>
            function deleteVehicle() {
                var email = prompt("Please enter your Email", "a");
                if (email != null) {
                    var vID = document.getElementById("vID").innerHTML;
                    //  alert("asd "+vID);
                    var password = prompt("Please enter your Password", "");
                    if (password != null) {


                        $.post('DeleteVehicle', {email: email, password: password, vID: vID},
                                function (returnedData) {
                                    if (returnedData == "1") {
                                        window.location.href = "/?msg=Vehicle Deleted Successfully &#926;";
                                    } else {
                                        swal("Oops... unable to delete vehicle", returnedData, "error");
                                    }

                                }).fail(function () {
                                    swal("Oops...", "Unknown error occured", "error");
                                }
                        );
                    }
                }
            }
        </script>
    </div>
    <div class="col-6" style="position:relative">
<div onclick="plusDivs(1)">
        <img id="img00" class="mySlides" style="position: relative ;width:100%; max-height: 450px;"
             src="img/loading2.gif">
        <img id="img10" class="mySlides" style="position: relative;width:100%; max-height: 450px;"
             src="img/loading2.gif">
        <img id="img20" class="mySlides" style="position: relative;width:100%; max-height: 450px;"
             src="img/loading2.gif">
        <img id="img30" class="mySlides" style="position: relative;width:100%; max-height: 450px;"
             src="img/loading2.gif">c

        <%--<a class="w3-btn-floating" style="position:absolute;top:45%;left:0" onclick="plusDivs(-1)"><</a>--%>
        <%--<a class="w3-btn-floating" style="position:absolute;top:45%;right:0" onclick="plusDivs(1)">></a>--%>
</div>
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
                if (n > x.length) {
                    slideIndex = 1
                }
                if (n < 1) {
                    slideIndex = x.length
                }
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                x[slideIndex - 1].style.display = "block";
            }

            //  setInterval(function(){ plusDivs(1); }, 5000);
        </script>

        <div style="width:100px">
            <input type="button" onclick="deleteVehicle()" value="Delete">

        </div>


    </div>
    <% if (v!=null && v.getLocation() != null) { %>

    <div class="col-3 right">


        <div>
            <%=v.getLocation()%>
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

                function newAd() {
                    window.location.href = "/CreateAdView";
                }
                function newVehicle() {
                    window.location.href = "/AddVehicle";
                }
                function newUser() {
                    window.location.href = "/CreateUserView";
                }
            </script>
        </div>

    </div>
    <% } else {%>
    <jsp:include page='RightColumn.jsp'/>
    <% } %>
</div>
<jsp:include page='Footer.jsp'/>
</body>
</html>

