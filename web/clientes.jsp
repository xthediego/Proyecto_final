<%@page import="CRUD.clientes" %> 
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page import="java.util.HashMap" %>
<%@page session="true" %>
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
        
        <h1><center>FORMULARIO CLIENTES</center></h1> 
        <a href="dinamico.jsp">redireccionar a menu</a> 
        

                <div class="container">

                    <form action="cliente" method="post" class="form-group">

                        <label for="lbl_id" >id</label>
                        <input type="number" name="txt_id" id="txt_id" class="form-control"  value="0" readonly><!--readonly-->


                        <label for="lbl_nombres" >Nombres</label>
                        <input type="text" name="txt_nombres" id="txt_nombres" class="form-control"  required>
                        
                        <label for="lbl_apellidos" >Apellidos</label>
                        <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control"  required>
                        
                        <label for="lbl_nit" >Nit</label>
                        <input type="text" name="txt_nit" id="txt_nit" class="form-control"  required>
    
                        
                        <label for="lbl_genero" >Genero</label>
                        
                        <select name="txt_genero" id="txt_genero" class="form-control">
                    
                            <% 

                                    clientes E = new clientes();
                                    HashMap<String,String> dropp = E.txt_genero();
                                    for(String i: dropp.keySet()){

                                        out.println("<option value= '" + i + "'>" + dropp.get(i) + "</option> ");
                                    }


                            %>
                        
                        </select>
                            
                        
                        <label for="lbl_telefono" >Telefono</label>
                        <input type="text" name="txt_telefono" id="txt_telefono" class="form-control"  required>     
                        
                        <label for="lbl_correo_electronico" >Correo electronico</label>
                        <input type="text" name="txt_correo_electronico" id="txt_correo_electronico" class="form-control"  required>
                        
                        <label for="lbl_fechaingreso" >Fecha Ingreso</label>
                        <input type="text" name="txt_fechaingreso" id="txt_fechaingreso" class="form-control"  required>

                     
                        <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                        <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                        <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger">Eliminar</button> 

                    </form> 
                            
                </div>
                            
                            
                            
                </div>
                <div class="container">

                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>Id</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Nit</th>
                            <th>Genero</th>
                            <th>Telefono</th> 
                            <th>Correo_electronico</th>                           
                            <th>Fechaingreso</th>  
                             
                          </tr>
                        </thead>
                        <tbody id="tbl_clientes">
                            <%                 
                            clientes p = new clientes();
                            DefaultTableModel tabla = new DefaultTableModel();
                            tabla = p.leer();

                            for(int t=0; t<tabla.getRowCount();t++){

                                    out.println("<td>" + tabla.getValueAt(t, 0) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 6) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 7) + "</td>");

                                out.println("</tr>");
                            }
                            %>
                        </tbody>
                    </table>     
                </div> 
                        
                <script>
                    $('#tbl_clientes').on('click','tr td',function(evt){

                       var target,id_cliente,nombres,apellidos,nit,genero,telefono,correo_electronico,fechaingreso; 
                        target = $(event.target);  
                        
                           id_cliente = target.parent("tr").find("td").eq(0).html();
                           nombres= target.parent("tr").find("td").eq(1).html();
                           apellidos= target.parent("tr").find("td").eq(2).html();
                           nit= target.parent("tr").find("td").eq(3).html();
                           genero= target.parent("tr").find("td").eq(4).html();
                           telefono= target.parent("tr").find("td").eq(5).html();               
                           correo_electronico= target.parent("tr").find("td").eq(6).html();                          
                           fechaingreso= target.parent("tr").find("td").eq(7).html();
                           

                           $('#txt_id').val(id_cliente);
                           $('#txt_nombres').val(nombres);
                           $('#txt_apellidos').val(apellidos);
                           $('#txt_nit').val(nit);
                           $('#txt_genero').val(genero);
                           $('#txt_telefono').val(telefono);
                           $('#txt_correo_electronico').val(correo_electronico);                          
                           $('#txt_fechaingreso').val(fechaingreso);
                           
                    });
                </script> 
        
        
    </body>
</html>
