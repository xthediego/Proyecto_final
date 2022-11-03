<%@page import="CRUD.productos" %> 
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page import="CRUD.marcas" %>
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
        
        <h1>FORMULARIO Productos</h1>   <a href="marcas.jsp">redirigirse a marcas</a>

                <div class="container">

                    <form action="producto" method="post" class="form-group">

                        <label for="lbl_id" >id</label>
                        <input type="number" name="txt_id" id="txt_id" class="form-control"  value="0" readonly><!--readonly-->


                        <label for="lbl_producto" >Producto</label>
                        <input type="text" name="txt_producto" id="txt_producto" class="form-control"  required>
                        
                        <label for="lbl_idmarca" >Marca</label>
                        
                        <select name="txt_idmarca" id="txt_idmarca" class="form-control">
                    
                            <% 

                                    productos S = new productos();
                                    HashMap<String,String> drop = S.txt_idmarca();
                                    for(String i: drop.keySet()){

                                        out.println("<option value= '" + i + "'>" + drop.get(i) + "</option> ");
                                    }


                            %>
                        
                        </select>
                            
                            
                        <label for="lbl_descripcion" >Descripcion</label>
                        <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control"  required>
                        
                        <label for="lbl_imagen" >Imagen</label>
                        <input type="text" name="txt_imagen" id="txt_imagen" class="form-control"  required>
                        
                        
                        <label for="lbl_precio_costo" >Precio_costo</label>
                        <input type="number" name="txt_precio_costo" id="txt_precio_costo" class="form-control"  required>
                        
                        <label for="lbl_precio_venta" >Precio_venta</label>
                        <input type="number" name="txt_precio_venta" id="txt_precio_venta" class="form-control"  required>
                        
                        
                        <label for="lbl_existencia" >Existencia</label>
                        <input type="number" name="txt_existencia" id="txt_existencia" class="form-control"  required>
                        
                        
                        
                        
                        <label for="lbl_fecha_ingreso" >Fecha ingreso</label>
                        <input type="text" name="txt_fecha_ingreso" id="txt_fecha_ingreso" class="form-control"  required>

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
                            <th>producto</th>
                            <th>idmarca</th>
                            <th>descripcion</th>
                            <th>imagen</th> 
                            <th>precio_costo</th>
                            <th>precio_venta</th>  
                            <th>existencia</th>                           
                            <th>fecha_ingreso</th>  
                             
                          </tr>
                        </thead>
                        <tbody id="tbl_productos">
                            <%                 
                            productos p = new productos();
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
                                    

                                out.println("</tr>");
                            }
                            %>
                        </tbody>
                    </table>     
                </div> 
                        
                <script>
                    $('#tbl_productos').on('click','tr td',function(evt){

                       var target,id_producto,producto,idmarca,descripcion,imagen,precio_costo,precio_venta,existencias,fecha_ingreso; 
                        target = $(event.target);  
                        
                           id_producto = target.parent("tr").find("td").eq(0).html();
                           producto= target.parent("tr").find("td").eq(1).html();
                           idmarca= target.parent("tr").find("td").eq(2).html();
                           descripcion= target.parent("tr").find("td").eq(3).html();
                           imagen= target.parent("tr").find("td").eq(4).html();
                           precio_costo= target.parent("tr").find("td").eq(5).html();
                           precio_venta= target.parent("tr").find("td").eq(6).html();
                           existencias= target.parent("tr").find("td").eq(7).html();
                           fecha_ingreso= target.parent("tr").find("td").eq(8).html();
                          
                           

                           $('#txt_id').val(id_producto);
                           $('#txt_producto').val(producto);
                           $('#txt_idmarca').val(idmarca);
                           $('#txt_descripcion').val(descripcion);
                           $('#txt_imagen').val(imagen);
                           $('#txt_precio_costo').val(precio_costo);
                           $('#txt_precio_venta').val(precio_venta);
                           $('#txt_existencia').val(existencias);
                           $('#txt_fecha_ingreso').val(fecha_ingreso);
                           
                           
                    });
                </script> 
        
        
        
    </body>
</html>
