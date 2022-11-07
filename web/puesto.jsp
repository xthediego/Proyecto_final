<%@page session="true" %>
<%@page import="CRUD.puestos" %> 
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        
        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
        
        <% 
            HttpSession sesion = request.getSession();
            String usuario;
            String nivel;
            
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("user")!=null ){
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();
                out.print( "<a href='login.jsp?cerrar=true'>"+ usuario +"<h5>Cerrar Sesion</h5></a>  " );
                
            }else{
                out.print(" <script>location.replace('login.jsp'); </script>   ");
            }
            
        %>
        
        <h1><center>FORMULARIO PUESTOS</center> </h1> 
        <a href="empleado.jsp">redirigirse a empleado</a>
        <br> 
        <a href="dinamico.jsp">redireccionar a menu</a> 
        
                <div class="container">

                    <form action="puesto" method="post" class="form-group">

                        <label for="lbl_id" >id</label>
                        <input type="number" name="txt_id" id="txt_id" class="form-control"  value="0" readonly>

                        <label for="lbl_puesto" >puestos</label>
                        <input type="text" name="txt_puesto" id="txt_puesto" class="form-control"  required>


                        <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                        <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                        <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger">Eliminar</button> 
                     

                    </form>

                </div>
                <div class="container">

                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>id</th>
                            <th>puestos</th>                                    
                          </tr>
                        </thead>
                        <tbody id="tbl_puesto">
                            <%                 
                            puestos p = new puestos();
                            DefaultTableModel tabla = new DefaultTableModel();
                            tabla = p.leer();

                            for(int t=0; t<tabla.getRowCount();t++){

                                    out.println("<td>" + tabla.getValueAt(t, 0) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");

                                out.println("</tr>");
                            }
                            %>
                        </tbody>
                    </table>     
                </div> 
                        
                <script>
                    $('#tbl_puesto').on('click','tr td',function(evt){

                       var target,id_puesto,puesto; 
                        target = $(event.target);                   
                           id_puesto = target.parent("tr").find("td").eq(0).html();
                           puesto= target.parent("tr").find("td").eq(1).html();
                           

                           $('#txt_id').val(id_puesto);
                           $('#txt_puesto').val(puesto);
                           
                    });
                </script> 
        
    </body>
</html>
