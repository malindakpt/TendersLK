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
    <link rel="stylesheet" href="css/sweetalert.css"/>

    <link href="img/CB.png" rel="icon" type="image/x-icon"/>

</head>
<body>
<div>

    <jsp:include page='HeaderBar.jsp'/>
    <div class="row">
        <jsp:include page='LeftColumn.jsp'/>

        <div class="col-6">
            <form style="max-width: 500px;">
                <div>
                    <p><input id="topic" class="inputText" placeholder="Advertisement Name / Description" type="text"/>
                    </p>

                    <p><input id="expDate" type="date" min="2000-01-02" id="datepicker"></p>

                    <p><input id="noVehi" class="inputText" placeholder="No Of Vehicles" type="number" min="1" max="5"/>
                    </p>

                    <p>

                    <div data-role="collapsible">
                        <h4>How to add location</h4>
                        <ul data-role="listview">
                            <li>Open Google maps</li>
                            <li>Search a location</li>
                            <li>Click on share button</li>
                            <li>Select Embed Map</li>
                            <li>Copy and pase location URL here</li>
                        </ul>
                    </div>
                    <a style=" text-decoration: none;" href="https://www.google.lk/maps/" target="_blank">Open Map</a>
                    <input id="location" class="inputText" placeholder="Location" value=""/>
                    </p>

                    <p><input id="email" class="inputText" placeholder="Email Address" type="text"/></p>

                    <p><input id="pwd" class="inputText" placeholder="Password" type="password"/></p>

                    <div style="width:200px">
                        <input type="button" value="Create Advertisement" onclick="createAd()">
                    </div>
                </div>
            </form>
            <div class="hideInMobile" style="min-height:300px;"></div>
        </div>

        <script>

            function uploadData() {
                var topic = document.getElementById("topic").value;
                var expDate = document.getElementById("expDate").value;
                var noVehi = document.getElementById("noVehi").value;
                var email = document.getElementById("email").value;
                var pwd = document.getElementById("pwd").value;
                var location = document.getElementById("location").value;

                $.post('CreateAdvertisement', {
                            topic: topic,
                            expDate: expDate,
                            noVehi: noVehi,
                            email: email,
                            pwd: pwd,
                            location: location
                        },
                        function (result) {
                            if (result === "") {
                                swal("Advertisement Created", "" + topic + " ", "success");
                            } else {
                                swal("Oops...", result, "error");
                            }

                        }).fail(function () {
                            alert("error");
                        }
                );
            }
            function createAd() {
                var topic = document.getElementById("topic").value;
                var expDate = document.getElementById("expDate").value;
                var noVehi = document.getElementById("noVehi").value;
                var email = document.getElementById("email").value;
                var pwd = document.getElementById("pwd").value;
                var location = document.getElementById("location").value;

                if (topic == "" || expDate == "" || noVehi == "" || email == "" || pwd == "") {
                    swal("Oops...", "You have to fill all the fields", "error");
                } else {

                    swal({
                        title: "Creating new advertisement",
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

        <jsp:include page='RightColumn.jsp'/>
    </div>
    <jsp:include page='Footer.jsp'/>
</body>
</html>
