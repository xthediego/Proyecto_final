<%-- 
    Document   : login
    Created on : 1/11/2022, 08:04:34 PM
    Author     : Diego Sandoval
--%>

<%@page import="modelado.operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            .conteiner{
                max-width: 30%;
                margin-left: auto;
                margin-right:auto ;
                
                
            }
            
        </style>
    </head>
    <body>
        
        <hr>
        <h1 align="center">FORMULARIO DE ACCESO</h1>
        <hr>
        
        <form action="login.jsp" method="post">
         
        <div class="conteiner">  
           <div class="form-group">
                <label for="usr">Name:</label>
                <input type="text" name="txtUsuario" class="form-control" id="usr">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" name="txtContra" class="form-control" id="pwd">
            </div>
            
            
                <!--Usuario: <input type="text" name="txtUsuario" ><br>
                Contraseña <input type="text" name="txtContra" ><br>-->
            
                <input type="submit" name="btnIngresar" value="Ingresar" ><br>
         
        </div>  
        </form>
        
        <%
          operaciones op = new operaciones();
          if(request.getParameter("btnIngresar")!=null){
              String nombre=request.getParameter("txtUsuario");
              String contra=request.getParameter("txtContra");
              
              switch(op.loguear( nombre,contra)){
               case 1:
                   HttpSession sesion = request.getSession();
                   sesion.setAttribute("user", nombre);
                   sesion.setAttribute("nivel", "1");
                   response.sendRedirect("dinamico.jsp");
                   break;
               default:
                   out.write("usuario no existe, o contraseña invalida");
                   break;
           }
              
          }
          
          if(request.getParameter("cerrar")!=null){
              session.invalidate();
          }
          
          
        %>
        
        
        <a href="main.jsp">main</a>
        
        
        
      
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
          
    </body>
</html>
