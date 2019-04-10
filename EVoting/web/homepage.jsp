<%-- 
    Document   : homepage
    Created on : Apr 9, 2019, 8:42:20 PM
    Author     : afrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="Models.Election" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eVoting || Homepage</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <style>
             .brand-logo{
                 margin-left: 10px;
             }
             .btn{
                margin-right: 20px;
                margin-left:10px;
             }
             body{
                    background: linear-gradient(to right bottom, #f7efdc, #e9d9d5);
                    background-size: cover;
                    background-position: center;
            }
            #section_election{
                height: 50vh;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <nav >
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo">eVoting</a>
                    <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="#section_castVote">Cast Vote</a></li>
                        <li><a href="#section_result">Result</a></li>
                        <c:if test="${param.isLogin!=null}">
                            <li><a href="#">Edit Profile</a></li>
                        </c:if>
                        <li>
                            <c:choose>
                                <c:when test="${param.isLogin==null}">
                                    <form method="post" action="/LoginController">
                                        <input type="submit" value="Login" class="btn white-text">
                                    </form>
                                </c:when>
                                <c:when test="${param.isLogin!=null}">
                                        <form method="post" action="/LogoutController">
                                            <input type="submit" value="Logout" class="btn white-text">
                                        </form>
                                </c:when>       
                                <c:otherwise>
                                    <form method="post" action="/LoginController">
                                        <input type="submit" value="Login" class="btn white-text">
                                    </form>
                                </c:otherwise>
                            </c:choose>
                           
                           
                        </li>
                    </ul>
                </div>
            </nav>
            <!-- Mobile navbar -->
            <ul class="sidenav" id="mobile-demo">
                    <li><a href="sass.html">Sass</a></li>
                    <li><a href="badges.html">Components</a></li>
                    <li><a href="collapsible.html">Javascript</a></li>
                    <li><a href="mobile.html">Mobile</a></li>
            </ul>

            <!-- Running Election -->
            <div class="section" id="section_election">
                <table class="highlight centered responsive-table">
                   <h3>Running Election</h2>
                    <thead>
                        <tr>
                            <th>Election Name</th>
                            <th>Start Time</th>
                            <th>End Time</th>
                           
                        </tr>
                    </thead>
            
                    <tbody>
                        <tr >
                           <td>${setElectionInfo.getElectionName()}</td>
                           <td>${setElectionInfo.getElectionStart()}</td>
                           <td>${setElectionInfo.getElectionEnd()}</td>
                           
                        </tr>
                    </tbody>
                </table>
                                
            </div>

            <!-- Cast Vote -->
            <div class="section" id="section_castVote">
                    <ul class="collapsible expandable collection with-header">
                        <li class="collection-header"><h4>Candidate Names</h4></li>
                         <li>
                            <div class="collapsible-header">
                                <i class="material-icons">filter_drama</i>
                                 First
                            </div>
                            <div class="collapsible-body">
                                    <form>
                                        <li class="btn">Vote</li>
                                     </form>
                            </div>
                        </li>
                       
                    </ul>
            </div>


        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
        <script>
             $(document).ready(function(){
                 $('.sidenav').sidenav();
                
            });
            var elem = document.querySelector('.collapsible.expandable');
            var instance = M.Collapsible.init(elem, {
             accordion: false
}           );
            
        </script>
    </body>

</html>
