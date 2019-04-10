<%-- 
    Document   : register
    Created on : Apr 10, 2019, 4:43:34 PM
    Author     : afrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : login
    Created on : Apr 10, 2019, 4:28:28 PM
    Author     : afrin
--%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>eVoting || Register</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <style>
    body {
      display: flex;
      min-height: 100vh;
      flex-direction: column;
    }

    main {
      flex: 1 0 auto;
    }

    body {
      background: linear-gradient(to right bottom, #f7efdc, #e9d9d5);
    }

    .input-field input[type=date]:focus + label,
    .input-field input[type=text]:focus + label,
    .input-field input[type=email]:focus + label,
    .input-field input[type=password]:focus + label {
      color: #e91e63;
    }

    .input-field input[type=date]:focus,
    .input-field input[type=text]:focus,
    .input-field input[type=email]:focus,
    .input-field input[type=password]:focus {
      border-bottom: 2px solid #e91e63;
      box-shadow: none;
    }
  </style>
</head>

<body>
  <div class="section"></div>
  <main>
    <center>
      
      <div class="section"></div>
      <c:if test="${error == "false"}">
            <h4 class="red-text">Username or email is already taken! </h4>
      </c:if>
      <h4 class="red-text">Username or email is already taken! </h4>
      <h5 class="indigo-text">Please, register an account</h5>
      <div class="section"></div>

      <div class="container">
        <div class="z-depth-1 grey lighten-4 row " style="display: inline-block; padding: 30px 45px 0px 45px; border: 1px solid #EEE;">

          <form class="col s12" method="POST" action="/UserController?action=register" >
            <div class='row s12'>
              <div class='col s12'>
              </div>
            </div>

            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='text' name='username' id='username' required/>
                <label for='username'>User Name</label>
              </div>
            </div>

            <div class='row '>
              <div class='input-field col s12'>
                <input class='validate' type='text' name='phoneNo' id='phoneNo' required/>
                <label for='phoneNo'>Phone No</label>
              </div>
              
            </div>
            <div class='row '>
                <div class='input-field col s12'>
                  <input class='validate' type='email' name='email' id='email' required/>
                  <label for='email'>Email</label>
                </div>
                
            </div>
            <div class='row '>
                <div class='input-field col s12'>
                  <input class='validate' type='password' name='password' id='password' required/>
                  <label for='password'>Password</label>
                </div>
                
            </div>
  

            <br />
            <center>
              <div class='row'>
                <button type='submit' name='btn_register' class='col s12 btn btn-large waves-effect'>Register</button>
              </div>
            </center>
          </form>
        </div>
      </div>
      
    </center>

    <div class="section"></div>
    <div class="section"></div>
  </main>

  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
</body>

</html>

