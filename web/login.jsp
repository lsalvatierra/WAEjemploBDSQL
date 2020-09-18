<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include  file="scriptstyle.jsp" %>
        <script src="Scripts/jsweb/login.js" type="text/javascript"></script>        
    </head>
    <body>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title text-center">AUTENTICACIÓN</h5>
                <form  method="post" action="AutenticacionController" id="formlogin">
                    <div class="form-group">
                        <label for="txtusuario">Ingrese usuario:</label>
                        <input type="text" class="form-control" id="txtusuario" name="txtusuario">  
                        <span id="errorusuario" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="txtpassword">Ingrese password:</label>
                        <input type="password" class="form-control" id="txtpassword" name="txtpassword">
                        <span id="errorpassword" class="text-danger"></span>
                    </div>                    
                    <button type="button" id="btnlogin" class="btn btn-primary">Guardar</button>
                </form>
                <%
                    if (request.getAttribute("msglogin") != null) {
                %>
                <div class="alert alert-danger" role="alert">
                    <%=request.getAttribute("msglogin").toString()%>
                </div>                    
                <%  }
                %>    
            </div>
        </div>        
    </body>
</html>
