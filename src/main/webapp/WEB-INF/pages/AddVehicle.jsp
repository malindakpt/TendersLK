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
</head>
<body>

<jsp:include page='HeaderBar.jsp'/>


<div class="row">
    <form id="vehicleData">
        <div class="col-3 col-m-3 menu">
            <ul>

                <li><input id="adID" class="input1" placeholder="Ad ID" name="adID"/></li>
                <li><input id="email" class="input1" placeholder="Email" name="email"/></li>
                <li><input id="password" class="input1" type="password" placeholder="Password" name="password"/></li>

                <%--<li><input type="button" value="Start Create Ad." onclick="startAdCreation()"></li>--%>

                <li><input id="regNo" class="input1" placeholder="Reg No.." name="regNo"/></li>
                <li><input id="brand" class="input1" placeholder="Brand" name="brand"/></li>
                <li><input id="model" class="input1" placeholder="Model" name="model"/></li>
                <li><input id="year" class="input1" placeholder="Manufac. Yar" name="year"/></li>
                <li><input id="millage" class="input1" placeholder="Millage" name="millage"/></li>
                <li><input id="transmission" class="input1" placeholder="Transmission" name="transmission"/></li>
                <li><input id="fuel" class="input1" placeholder="Fuel Type" name="fuel"/></li>
                <li><input id="cc" class="input1" placeholder="Engine Capacity" name="cc"/></li>

                <li><textarea id="desc" placeholder="Description" name="desc" cols="33" rows="3"></textarea></li>

                <input id="imgHolder0" style="display: none;" name=imgH0/>
                <input id="imgHolder1" style="display: none;" name=imgH1/>
                <input id="imgHolder2" style="display: none;" name=imgH2/>
                <input id="imgHolder3" style="display: none;" name=imgH3/>
                <input id="imgHolder4" style="display: none;" name=imgH4/>


            </ul>

        </div>

        <div class="col-6 col-m-9">
            <script type="text/javascript">
                var img0;
                var img1;
                var img2;
                var img3;
                var img4;

                oFReader = new FileReader(), rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;

                oFReader.onload = function (oFREvent) {

                    var img = new Image();
                    img.onload = function () {
                        var canvas = document.createElement("canvas");
                        var ctx = canvas.getContext("2d");
                        canvas.width = 600;
                        canvas.height = 450;
                        ctx.drawImage(img, 0, 0, img.width, img.height, 0, 0, canvas.width, canvas.height);
                        document.getElementById("prev" + window.idx).src = canvas.toDataURL();

                        if (window.idx === 0) {
                            img0 = canvas.toDataURL();
                        } else if (window.idx === 1) {
                            img1 = canvas.toDataURL();
                        } else if (window.idx === 2) {
                            img2 = canvas.toDataURL();
                        } else if (window.idx === 3) {
                            img3 = canvas.toDataURL();
                        } else if (window.idx === 4) {
                            img4 = canvas.toDataURL();
                        }
                    }
                    img.src = oFREvent.target.result;
                };

                function loadImageFile(idx) {
                    console.log(idx);
                    window.idx = idx;
                    if (document.getElementById("img" + idx).files.length === 0) {
                        return;
                    }
                    var oFile = document.getElementById("img" + idx).files[0];
                    if (!rFilter.test(oFile.type)) {
                        alert("You must select a valid image file!");
                        return;
                    }
                    oFReader.readAsDataURL(oFile);
                }
            </script>

            <div style="width:250px">
                <input id="img0" type="file" name="file0" size="50" onchange="loadImageFile(0);"/>
                <img id="prev0" style="width:100px;height:70px;"/>
                <br/>
                <br/>
                <input id="img1" type="file" name="file1" size="50" onchange="loadImageFile(1);"/>
                <img id="prev1" style="width:100px;height:70px;"/>
                <br/>
                <br/>
                <input id="img2" type="file" name="file2" size="50" onchange="loadImageFile(2);"/>
                <img id="prev2" style="width:100px;height:70px;"/>
                <br/>
                <br/>
                <input id="img3" type="file" name="file3" size="50" onchange="loadImageFile(3);"/>
                <img id="prev3" style="width:100px;height:70px;"/>
                <br/>

                <%--For the momemnt only 4 photos are allowed to  upload--%>

                <%--<br/>--%>
                <%--<input id="img4" type="file" name="file4" size="50" onchange="loadImageFile(4);"/>--%>
                <%--<img id="prev4" style="width:100px;height:70px;"/>--%>
                <%--<br/>--%>


            </div>

            <div style="width:150px">
                <input type="button" onclick="submitVehicle()" value="Add Vehicle">
            </div>

        </div>


    </form>

    <script>
        var regNo;
        var brand;
        var model;
        var year;
        var millage;
        var transmission;
        var fuel;
        var cc;
        var desc;
        var adID;
        var email;
        var password;

        function uploadPhoto2(time) {
            $.post('Photo2UploadServlet', {
                        regNo: regNo,
                        adID: adID,
                        email: email,
                        time: time,
                        img2: img2,
                        img3: img3,
                        pwd: password

                    },
                    function (result) {
                        if (result === "") {
                            swal("Vehicle Added ! ", "" + email + " ", "success");
                        } else {
                            swal("Oops...", result, "error");
                        }

                    }
            ).fail(function () {
                        alert("error");

                    })

        }
        ;

        function submitVehicle() {
            regNo = document.getElementById("regNo").value;
            brand = document.getElementById("brand").value;
            model = document.getElementById("model").value;
            year = document.getElementById("year").value;
            millage = document.getElementById("millage").value;
            transmission = document.getElementById("transmission").value;
            fuel = document.getElementById("fuel").value;
            cc = document.getElementById("cc").value;
            desc = document.getElementById("desc").value;
            adID = document.getElementById("adID").value;
            email = document.getElementById("email").value;
            password = document.getElementById("password").value;


            function validateUserAdvertisement() {

                $.post('ValidateUserAdvertisement', {email: email, password: password, adID: adID},
                        function (result) {
                            if (result !== "") {
                                swal("Oops...", result, "error");
                            } else {


                                var time = new Date().toLocaleString();
                                // document.getElementById("vehicleData").submit();
                                $.post('UploadServlet', {
                                            regNo: regNo,
                                            brand: brand,
                                            model: model,
                                            year: year,
                                            millage: millage,
                                            transmission: transmission,
                                            fuel: fuel,
                                            cc: cc,
                                            desc: desc,
                                            adID: adID,
                                            email: email,
                                            pwd: password,
                                            time: time,
                                            //Images
                                            img0: img0,
                                            img1: img1,

                                        },
                                        function (result) {
                                            if (result === "") {
                                                //If success, upload remaining 2 photos
                                                uploadPhoto2(time);
                                            } else {
                                                swal("Oops...", result, "error");
                                            }

                                        }).fail(function () {
                                            //Unexeocted Error
                                            alert("error");
                                        })
                            }

                        }).fail(function () {
                            swal("Oops...", "Check your internet connection", "error");
                        }
                );

            }

//

            if (regNo == "") {
                swal("Oops...", "Invalid Registration No", "error");
            } else if (brand == "") {
                swal("Oops...", "Invalid Brand", "error");
            } else if (model == "") {
                swal("Oops...", "Invalid Model", "error");
            } else if (year == "" || isNaN(year)) {
                swal("Oops...", "Invalid Manufacturing Year", "error");
            } else if (millage == "" || isNaN(millage)) {
                swal("Oops...", "Invalid Millage", "error");
            } else if (transmission == "") {
                swal("Oops...", "Invalid Transmission Type", "error");
            } else if (fuel == "") {
                swal("Oops...", "Invalid Fuel Type", "error");
            } else if (cc == "" || isNaN(cc)) {
                swal("Oops...", "Invalid Engine Capacity", "error");
            } else if (desc == "") {
                swal("Oops...", "Invalid Description", "error");
            } else if (adID == "") {
                swal("Oops...", "Invalid Add ID", "error");
            } else if (email == "") {
                swal("Oops...", "Invalid Email", "error");
            } else if (password == "") {
                swal("Oops...", "Invalid Password", "error");
            } else if (img0 == "" && img1 == "" && img2 == "" && img3 == "") {
                swal("Oops...", "You Should upload at-least one image", "error");
//            }
//            else if (Aimg0 !== "" && !Aimg0.match(/\.(jpg|JPG|JPEG|jpeg|png|PNG|)$/)) {
//                swal("Oops...", "Invalid Image in image 1", "error");
//            } else if (Aimg1 !== "" && !Aimg1.match(/\.(jpg|JPG|JPEG|jpeg|png|PNG|)$/)) {
//                swal("Oops...", "Invalid Image in image 2", "error");
//            } else if (Aimg2 !== "" && !Aimg2.match(/\.(jpg|JPG|JPEG|jpeg|png|PNG|)$/)) {
//                swal("Oops...", "Invalid Image in image 3", "error");
//            } else if (Aimg3 !== "" && !Aimg3.match(/\.(jpg|JPG|JPEG|jpeg|png|PNG|)$/)) {
//                swal("Oops...", "Invalid Image in image 4", "error");
//            } else if (Aimg4 !== "" && !Aimg4.match(/\.(jpg|JPG|JPEG|jpeg|png|PNG|)$/)) {
//                swal("Oops...", "Invalid Image in image 5", "error");
            } else {
                validateUserAdvertisement();
            }

        }


    </script>

    <jsp:include page='RightColumn.jsp'/>

</div>
<jsp:include page='Footer.jsp'/>

</body>
</html>

