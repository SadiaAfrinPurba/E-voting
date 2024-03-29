<%-- 
    Document   : homepage
    Created on : Apr 9, 2019, 8:42:20 PM
    Author     : afrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
                             <%
                               String username= (String) session.getAttribute("isLogin");                     
                               if (username != null) {
                             %>
                         <li><a href="#">Edit Profile</a></li>

                            <% } 
                            %>
                                
              
                        <li>
                             <%
                               String username1= (String) session.getAttribute("isLogin");                     
                               if (username1 == null) {
                             %>
                        <form method="post" action="/login.jsp">
                           <input type="submit" value="Login" class="btn white-text">
                         </form>

                            <% } else if(username1 != null) {%>
                                  <form method="POST" action="/UserController?action=logout">
                                      <input type="submit" value="Logout" class="btn white-text">
                                 </form>
                              <% }
                          else  { %>
                            <form method="post" action="/login.jsp">
                                <input type="submit" value="Login" class="btn white-text">
                             </form>
                           <% } %>

                           
                           
                        </li>
                    </ul>
                </div>
            </nav>
            <!-- Mobile navbar -->
            <ul class="sidenav" id="mobile-demo">
                    <li><a href="#section_castVote">Cast Vote</a></li>
                    <li><a href="#section_result">Result</a></li>
                    <c:if test="${param.isLogin!=null}">
                        <li><a href="editProfile.jsp">Edit Profile</a></li>
                     </c:if>
                    
            </ul>

            <!-- Running Election -->
            <div class="section" id="section_election">
                <table class="highlight centered responsive-table">
                   <h3>Running Election</h3>
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
                        <li class="collection-header"><h4>Candidate</h4></li>
                        <c:forEach items="${setCandidateInfo}" var="candidate">
                         <li>
                            <div class="collapsible-header">
                                <img src="data:image/jpg;base64,${candidate.base64Image}" class=" circle responsive-img materialboxed" width="100" height="100"/>
                               
                                 <c:out value="${candidate.candidateName}" />
                            </div>
                            <div class="collapsible-body">
                                    <table>
                 
                                            <tbody>
                                              <tr>
                                                <td>Education</td>
                                                <td><c:out value="${candidate.candidateEducation}" /></td>
                                                
                                              </tr>
                                              <tr>
                                                <td>Hometown</td>
                                                <td><c:out value="${candidate.candidateHometown}" /></td>
                                                
                                              </tr>
                                              <tr>
                                                <td>Previous Election Experience</td>
                                                <td><c:out value="${candidate.candidateExp}" /></td>
                                                
                                              </tr>
                                              <tr>
                                                <td>Promised to do</td>
                                                <td><c:out value="${candidate.candidateAgenda}" /></td>
                                                
                                              </tr>
                                            </tbody>
                                          </table>
                                <%
                                 String username2= (String) session.getAttribute("isLogin");
                                 String voted = (String) session.getAttribute("alreadyVoted");
                                 if (username2 == null || voted != null) {
                                %>                
                                 <form class="center-align">
                                    <input type="submit" value="Vote" class="btn disabled">
                                 </form>

                                 <% } else {
                                  %>
                                <form method="POST" action="/UserController?action=vote" class="center-align">
                                    <input id="vote" type="submit" value="Vote ${candidate.candidateID}" class="btn" name="vote" onclick="getCID()">
                
                                </form>
                                <% }
                                %>                
                                
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
                 
            </div>

            <!-- Result Showcase -->
            <div class="section" id="section_result">
                    <table class="highlight centered responsive-table">
                       <h3>Standings</h2>
                        <thead>
                            <tr>
                                <th>Candidate Name</th>
                                <th>Vote Count</th>
                               
                               
                            </tr>
                        </thead>
                
                        <tbody> 
                            <c:forEach items="${setResultInfo}" var="result">
                            <tr class="highlight">
                               <td><c:out value="${result.candidateName}" /></td>
                               <td><c:out value="${result.voteCount}" /></td>
                               
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                                    
            </div>


        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
        <script>
             $(document).ready(function(){
                 $('.sidenav').sidenav();
                 $('.materialboxed').materialbox();
                 
                
            });
            var elem = document.querySelector('.collapsible.expandable');
            var instance = M.Collapsible.init(elem, {
             accordion: false
             });
             function getCID() {
                 var cID = document.getElementById("vote").name;
                 console.log(cID)
             }
            
        </script>
    </body>

</html>
