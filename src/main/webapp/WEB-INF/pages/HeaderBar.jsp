<%--
  Created by IntelliJ IDEA.
  User: MalindaK
  Date: 7/17/2016
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Album</title>
        <link rel="icon"
              type="image/png"
              href="img/symbol.png">
        <script>
            function searchList() {
                var n = document.getElementById("search-mini2").value;
                window.location.href = "/?adID=" + n;
            }
        </script>
    </head>
    <body>
        <div class="header">
            <%--<ul>--%>

                <span class="logoContainer">
                       <span class="inlineMenu"><img class="logo" src="img/symbol.png"/></span>
                       <span class="inlineMenu" style="font-size: 300%;">Album</span>
                </span>

                <span  class="hideInMobile" style="float: right; padding-top: 30px; padding-right: 40px">
                        <span class="inlineMenu" style="color: white !important;"><p class="noShadow" style=" cursor: pointer;" onclick="showContactUs()"><b>Contact Us</b></p></span>
                </span>


            <script>
                function showContactUs(){
                    swal("Voction.lk", "malindakpt@gmail.com\n0771141194", "info");
                }
            </script>

        </div>



        <div align="center">
            <form style="height:33px; max-width:500px;">
                <table style='width:100%'>
                    <tr>

                        <td>
                            <input type="search" name="search-mini" id="search-mini2" value="" data-mini="true"/>
                        </td>
                        <td style="font-size:50%; width:7em;height:10px">
                            <input type="button" data-mini="true" value="Search" onclick="searchList()">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
