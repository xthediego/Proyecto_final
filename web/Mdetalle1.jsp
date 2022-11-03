

<%@page import="CRUD.productos"%>
<%@page import="CRUD.empleados"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="CRUD.Mdetalle1"%>
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
        
        <h1>FORMULARIO Maestro_Detalle(1)</h1> 
                
        <a href="clientes.jsp">redireccionar a formulario clientes</a> 
        <a href="empleado.jsp">redireccionar a formulario empeado</a>

                <div class="container">

                    <form action="mdet1" method="post" class="form-group">

                        <label for="lbl_id_ventas" >id-ventas</label>
                        <input type="number" name="txt_id_ventas" id="txt_id_ventas" class="form-control"  value="0" readonly><!--readonly-->

                        <label for="lbl_nofactura" >nofactura</label>
                        <input type="number" name="txt_nofactura" id="txt_nofactura" class="form-control">

                        <label for="lbl_serie" >Serie</label>
                        <input type="text" name="txt_serie" id="txt_serie" class="form-control">
                        
                        <label for="lbl_fechafactura" >Fecha-factura</label>
                        <input type="text" name="txt_fechafactura" id="txt_fechafactura" class="form-control">
                        
                        <label for="lbl_id_cliente" >Id_cliente</label>
                        <select name="txt_id_cliente" id="txt_id_cliente" class="form-control">
                                <% 

                                    Mdetalle1 E = new Mdetalle1();
                                    HashMap<String,String> dropp = E.txt_clientes();
                                    for(String i: dropp.keySet()){

                                        out.println("<option value= '" + i + "'>" + dropp.get(i) + "</option> ");
                                    }


                            %>
                            
                        
                        </select>
                        
                        <label for="lbl_id_empleado" >Id_empledo</label>
                        <select name="txt_id_empleado" id="txt_id_empleado" class="form-control">
                                <% 

                                    empleados empleado = new empleados();
                                    HashMap<String,String> drop = empleado.empleado();
                                    for(String i: drop.keySet()){

                                        out.println("<option value= '" + i + "'>" + drop.get(i) + "</option> ");
                                    }


                            %>
                          
                        
                        </select>
                        
                        <label for="lbl_fechaingreo" >Fecha-ingreso</label>
                        <input type="text" name="txt_fechaingreso" id="txt_fechaingreso" class="form-control">
                        
                        
                        
                        
                        
                        <label for="lbl_id_venta_detalle" >Id_venta_detalle</label>
                        <input type="number" name="txt_id_venta_detalle" id="txt_id_venta_detalle" class="form-control" readonly>
                        
                        <label for="lbl_id_ventass" >Id_ventas</label>
                        <input type="number" name="txt_id_ventass" id="txt_id_ventass" class="form-control" >
                        
                        
                        <label for="lbl_id_producto" >Id_producto</label>
                        <select name="txt_id_producto" id="txt_id_producto" class="form-control">
                                <% 

                                    productos f = new productos();
                                    HashMap<String,String> droppa = f.txt_producto();
                                    for(String i: dropp.keySet()){

                                        out.println("<option value= '" + i + "'>" + droppa.get(i) + "</option> ");
                                    }


                            %>
                            
                        
                        </select>
                        
                        <label for="lbl_cantidad" >Cantidad</label>
                        <input type="number" name="txt_cantidad" id="txt_cantidad" class="form-control">
                        
                        <label for="lbl_precio_unitario" >Precio unitario</label>
                        <input type="number" name="txt_precio_unitario" id="txt_precio_unitario" class="form-control">
                        
                        
                        <br>
                        
                        <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                        <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                        <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger">Eliminar</button> 
                     
                        
                        
                    </form> 
                            
                </div>
        
        
        
        <div class="container">

                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>id_venta</th>
                            <th>nofactura</th>
                            <th>serie</th>
                            <th>fechafactura</th>
                            <th>id_cliente</th> 
                            <th>id_empleado</th>
                            <th>fechaingreso</th>
                            
                            <th>id_venta_detalle</th>
                            <th>id_ventass</th>
                            <th>id_producto</th>
                            <th>cantida</th>
                            <th>precio_unitario</th> 
                            
                          </tr>
                        </thead>
                        <tbody id="tbl_mdt">
                            <%                 
                            Mdetalle1 o = new Mdetalle1();
                            DefaultTableModel tabla = new DefaultTableModel();
                            tabla = o.leer();

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
                                    out.println("<td>" + tabla.getValueAt(t, 11) + "</td>");
                                   

                                out.println("</tr>");
                            }
                            %>
                        </tbody>
                    </table>     
                </div> 
                        
                <script>
                    $('#tbl_mdt').on('click','tr td',function(evt){

                       var target,id_ventas,nofactura,serie,fechafactura,id_cliente,id_empleado,fechaingreso,id_venta_detalle,id_venta,id_producto,cantidad,precio_unitario; 
                        target = $(event.target);  
                        
                           id_ventas = target.parent("tr").find("td").eq(0).html();
                           nofactura= target.parent("tr").find("td").eq(1).html();
                           serie= target.parent("tr").find("td").eq(2).html();
                           fechafactura= target.parent("tr").find("td").eq(3).html();
                           id_cliente= target.parent("tr").find("td").eq(4).html();
                           id_empleado = target.parent("tr").find("td").eq(5).html();
                           fechaingreso= target.parent("tr").find("td").eq(6).html();
                           
                           id_venta_detalle= target.parent("tr").find("td").eq(7).html();
                           id_venta= target.parent("tr").find("td").eq(8).html();
                           id_producto= target.parent("tr").find("td").eq(9).html();
                           cantidad= target.parent("tr").find("td").eq(10).html();
                           precio_unitario= target.parent("tr").find("td").eq(11).html();
                           

                           $('#txt_id_ventas').val(id_ventas);
                           $('#txt_nofactura').val(nofactura);
                           $('#txt_serie').val(serie);
                           $('#txt_fechafactura').val(fechafactura);
                           $('#txt_id_cliente').val(id_cliente);
                           $('#txt_id_empleado').val(id_empleado);
                           $('#txt_fechaingreso').val(fechaingreso);
                           
                           $('#txt_id_venta_detalle').val(id_venta_detalle);
                           $('#txt_id_ventass').val(id_venta);
                           $('#txt_id_producto').val(id_producto);
                           $('#txt_cantidad').val(cantidad);
                           $('#txt_precio_unitario').val(precio_unitario);
                           
                           
                           
                    });
                </script> 
        
    </body>
</html>
