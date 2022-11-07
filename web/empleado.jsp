<%@page import="CRUD.empleados" %> 
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page import="CRUD.puestos" %>
<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
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
        
        <h1><center>FORMULARIO EMPLEADOS</center></h1>   
        <a href="puesto.jsp">redirigirse a puestos</a>
        <br>
        <a href="dinamico.jsp">redireccionar a menu</a> 

                <div class="container">

                    <form action="empleado" method="post" class="form-group">

                        <label for="lbl_id" >id</label>
                        <input type="number" name="txt_id" id="txt_id" class="form-control"  value="0" readonly><!--readonly-->


                        <label for="lbl_nombres" >Nombres</label>
                        <input type="text" name="txt_nombres" id="txt_nombres" class="form-control"  required>
                        
                        <label for="lbl_apellidos" >Apellidos</label>
                        <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control"  required>
                        
                        <label for="lbl_direccion" >Direccion</label>
                        <input type="text" name="txt_direccion" id="txt_direccion" class="form-control"  required>
                        
                        <label for="lbl_telefono" >Telefono</label>
                        <input type="text" name="txt_telefono" id="txt_telefono" class="form-control"  required>
                        
                        
                        <label for="lbl_DPI" >DPI</label>
                        <input type="text" name="txt_DPI" id="txt_DPI" class="form-control"  required>
                        
                        
                        <label for="lbl_genero" >Genero</label>
                        
                        <select name="txt_genero" id="txt_genero" class="form-control">
                    
                            <% 

                                    empleados E = new empleados();
                                    HashMap<String,String> dropp = E.txt_genero();
                                    for(String i: dropp.keySet()){

                                        out.println("<option value= '" + i + "'>" + dropp.get(i) + "</option> ");
                                    }


                            %>
                        
                        </select>
                            
                        
                        <label for="lbl_fecha_nacimiento" >Fecha_nacimiento</label>
                        <input type="text" name="txt_fecha_nacimiento" id="txt_fecha_nacimiento" class="form-control"  required>
                        
                        <label for="lbl_id_puesto" >Puesto</label>
                        
                        <select name="txt_id_puesto" id="txt_id_puesto" class="form-control">
                    
                            <% 

                                    puestos S = new puestos();
                                    HashMap<String,String> drop = S.txt_id_puesto();
                                    for(String i: drop.keySet()){

                                        out.println("<option value= '" + i + "'>" + drop.get(i) + "</option> ");
                                    }


                            %>
                        
                        </select>
                        
                        <label for="lbl_fecha_inicio_labores" >Fecha inicio de Labores</label>
                        <input type="text" name="txt_fecha_inicio_labores" id="txt_fecha_inicio_labores" class="form-control"  required>
                        
                        <label for="lbl_fechaingreso" >Fecha ingreso</label>
                        <input type="text" name="txt_fechaingreso" id="txt_fechaingreso" class="form-control"  required>

                        <br>
                        <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">agregar</button>                    
                         <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                        <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger">Eliminar</button> 
                    </form> 
                            
                </div>
        
                                
        
                </div>
                <div class="container">

                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>id</th>
                            <th>nombres</th>
                            <th>apellidos</th>
                            <th>direccion</th>
                            <th>telefono</th> 
                            <th>DPI</th>
                            <th>genero</th>  
                            <th>fecha_nacimiento</th>
                            <th>Id_puesto</th>
                            <th>fecha_inicio_labores</th>
                            <th>fechaingreso</th>  
                             
                          </tr>
                        </thead>
                        <tbody id="tbl_empleados">
                            <%                 
                            empleados p = new empleados();
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
                                    out.println("<td>" + tabla.getValueAt(t, 8) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 9) + "</td>");
                                    out.println("<td>" + tabla.getValueAt(t, 10) + "</td>");

                                out.println("</tr>");
                            }
                            %>
                        </tbody>
                    </table>     
                </div> 
                        
                <script>
                    $('#tbl_empleados').on('click','tr td',function(evt){

                       var target,id_empleado,nombres,apellidos,direccion,telefono,DPI,genero,fecha_nacimiento,id_puesto,fecha_inicio_labores,fechaingreso; 
                        target = $(event.target);  
                        
                           id_empleado = target.parent("tr").find("td").eq(0).html();
                           nombres= target.parent("tr").find("td").eq(1).html();
                           apellidos= target.parent("tr").find("td").eq(2).html();
                           direccion= target.parent("tr").find("td").eq(3).html();
                           telefono= target.parent("tr").find("td").eq(4).html();
                           DPI= target.parent("tr").find("td").eq(5).html();
                           genero= target.parent("tr").find("td").eq(6).html();
                           fecha_nacimiento= target.parent("tr").find("td").eq(7).html();
                           id_puesto= target.parent("tr").find("td").eq(8).html();
                           fecha_inicio_labores= target.parent("tr").find("td").eq(9).html();
                           fechaingreso= target.parent("tr").find("td").eq(10).html();
                           

                           $('#txt_id').val(id_empleado);
                           $('#txt_nombres').val(nombres);
                           $('#txt_apellidos').val(apellidos);
                           $('#txt_direccion').val(direccion);
                           $('#txt_telefono').val(telefono);
                           $('#txt_DPI').val(DPI);
                           $('#txt_genero').val(genero);
                           $('#txt_fecha_nacimiento').val(fecha_nacimiento);
                           $('#txt_id_puesto').val(id_puesto);
                           $('#txt_fecha_inicio_labores').val(fecha_inicio_labores);
                           $('#txt_fechaingreso').val(fechaingreso);
                           
                    });
                </script> 
        
                
                
    </body>
</html>
