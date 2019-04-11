<%-- 
    Document   : voterVerify
    Created on : Apr 9, 2019, 8:16:00 PM
    Author     : afrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voter verify</title>
         <!--Import Google Icon Font-->
         <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
         <!-- Compiled and minified CSS -->
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    </head>
    <body>
        <div class="container">
            <main>
            
                
            <form class="col s12" action="/VoterVerifyController?action=verify"method="POST">
                    <div class="row col s12">
                        <div class="input-field col s6">
                            <input value="${securityQuestion}" id="sQuestion" type="text" class="validate" readonly>
                            <label class="active" for="sQuestion">Security Question</label>
                        </div>
                    </div>
                    <div class="row col s12">
                        <div class="input-field col s6">
                                <input id="answer" type="text" class="validate" name="securityAnswer">
                                <label class="active" for="answer">Answer</label>
        
                        </div>
                    </div>
                    <div class="row col s12">
                        <input type="submit" value="Verify" class="btn teal white-text" id="verify">
                        
                    </div>
                   
            </form>
           </main>
        </div>
        <!-- Scripts -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script>
             $(document).ready(function() {
                     M.updateTextFields();
             });
             
             $("#verify").click(function(){
                 alert("If you give right answer, cookies will be saved for better user experience!");
             });
        </script>
    </body>
</html>
