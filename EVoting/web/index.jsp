<%-- 
    Document   : index
    Created on : Apr 9, 2019, 2:05:53 PM
    Author     : afrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>E-voting</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <style>
                header{
                    
                    background-image:  url(hero.jpg); 
                    background-size: cover;
                    background-position: center;
                    height: 90vh;
    
                }
                @media screen and (max-width: 670px) {
                    header{
                        min-height: 500px;
                    }
                }
                body{
                    background: linear-gradient(to right bottom, #f7efdc, #e9d9d5);
                }
                
    
        </style>
    </head>
    <body>
        <div class="container">
            <header></header>
            <div class="center-align">
                <a class="btn waves-effect red modal-trigger" href="#modal-enter">Enter</a>
            </div>

            <!-- Enter Modal Structure -->
            <div id="modal-enter" class="modal">
                <div class="modal-content">
                    <div class="row">
                        <form class="col s12" action="/VoterVerifyController?action=securitycheck" method="POST">
                            <div class="row">
                                <div class="input-field col s12">
                                    <i class="material-icons prefix">fingerprint</i>
                                    <input id="nID" type="text" name="nid" class="validate" required>
                                    <label for="nID">NID</label>
                                </div>

                            </div>
                            <div class="input-field col s12">
                                <i class="material-icons prefix">face</i>
                                <input id="name" type="text" name="Name" class="validate" required>
                                <label for="name">Name</label>
                            </div>
                            <div class="row center-align">
                                <input type="submit" value="Next" name="next" class="btn waves-effect teal white-text">
                                                 
                            </div>
                               
                          
                         </form>
                       </div>
                    </div>

                </div>
     
                

            </div>

        </div>
        
       <!-- Scripts -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script src="main.js"></script>
        <script>
            $(document).ready(function(){
                $('.modal').modal();
                $('.collapsible').collapsible();
               
            });
        
        </script>
    </body>
</html>

