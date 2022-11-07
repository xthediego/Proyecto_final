<%@page import="CRUD.Mdetalle2"%>
<%@page import="CRUD.productos"%>
<%@page import="CRUD.proveedores"%>

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
        
        <h1><center> MAESTRO DETALLE(2)</center></h1> 
               <a href="dinamico.jsp">redireccionar a menu</a> 

                <div class="container">

                    <form action="mdet2" method="post" class="form-group">

                        <label for="lbl_id_compra" >Id compra</label>
                        <input type="number" name="txt_id_compra" id="txt_id_compra" class="form-control"  value="0" readonly>

                         <label for="lbl_no_orden_compra" >Numero de orden de compra</label>
                        <input type="number" name="txt_no_orden_compra" id="txt_no_orden_compra" class="form-control">
                        
                        <label for="lbl_proveedores" >Proveedores</label>
                        <select name="txt_proveedores" id="txt_proveedores" class="form-control">
                               
                            <% 

                                    proveedores g = new proveedores();
                                    HashMap<String,String> drop = g.proveedores();
                                    for(String i: drop.keySet()){

                                        out.println("<option value= '" + i + "'>" + drop.get(i) + "</option> ");
                                    }


                            %>
                            
                        </select>
                        
                        
                         <label for="lbl_fecha_orden" >Fecha orden</label>
                        <input type="texte" name="txt_fecha_orden" id="txt_fecha_orden" class="form-control">
                        
                         <label for="lbl_fecha_ingreso" >Fecha ingreso</label>
                        <input type="text" name="txt_fecha_ingreso" id="txt_fecha_ingreso" class="form-control">
                        
                        <!--finaliza codigo de compras************************ -->
                        
                         <label for="lbl_id_compra_detalle" >Id compras detalle</label>
                         <input type="number" name="txt_id_compra_detalle" id="txt_id_compra_detalle" class="form-control"  value="0" readonly><!--readonly-->
                         
                         <label for="lbl_id_compra" >Id compras</label>
                         <input type="number" name="txt_id_compraa" id="txt_id_compraa" class="form-control"   >
                           
                         <label for="lbl_id_producto" >Id producto</label>
                         <select name="txt_id_producto" id="txt_id_producto" class="form-control">
                                <% 

                                    productos f = new productos();
                                    HashMap<String,String> droppa = f.txt_producto();
                                    for(String i: droppa.keySet()){

                                        out.println("<option value= '" + i + "'>" + droppa.get(i) + "</option> ");
                                    }


                            %>
                            
                        
                        </select>
                        
                         <label for="lbl_cantidad" >Cantidad</label>
                         <input type="number" name="txt_cantidad" id="txt_cantidad" class="form-control">
                        
                         <label for="lbl_pcu" >Precio costo unitario</label>
                         <input type="number" name="txt_pcu" id="txt_pcu" class="form-control">                        
                        
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
                            <th>Id compra</th>
                            <th>Numero de orden de compra </th>
                            <th>Id proveedores </th>
                            <th>Fecha orden</th>
                            <th>Fecha ingreso</th> 
                            
                            
                            <th>Id compras detalle</th>
                            <th>Id compras</th>
                            <th>Id producto</th> 
                            <th>Cantidad</th>
                            <th>Precio costo unitario</th>

                            
                          </tr>
                        </thead>
                        <tbody id="tbl_mdt">
                            <%                 
                            Mdetalle2 o = new Mdetalle2();
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

                                out.println("</tr>");
                            }
                            %>
                        </tbody>
                    </table>     
                </div> 
                        
                <script>
                    $('#tbl_mdt').on('click','tr td',function(evt){

                       var target,id_compra,no_orden_compra,id_proveedores,fecha_orden,fecha_ingreso,id_compra_detalle,id_compraa,id_producto,cantidad,pcu; 
                        target = $(event.target);  
                        
                           id_compra = target.parent("tr").find("td").eq(0).html();
                           no_orden_compra= target.parent("tr").find("td").eq(1).html();
                           id_proveedores= target.parent("tr").find("td").eq(2).html();
                           fecha_orden= target.parent("tr").find("td").eq(3).html();
                           fecha_ingreso= target.parent("tr").find("td").eq(4).html();
                           
                           id_compra_detalle = target.parent("tr").find("td").eq(5).html();
                           id_compraa = target.parent("tr").find("td").eq(6).html();
                           id_producto= target.parent("tr").find("td").eq(7).html();
                           cantidad= target.parent("tr").find("td").eq(8).html();
                           pcu= target.parent("tr").find("td").eq(9).html();
                          

                           $('#txt_id_compra').val(id_compra);
                           $('#txt_no_orden_compra').val(no_orden_compra);
                           $('#txt_proveedores').val(id_proveedores);
                           $('#txt_fecha_orden').val(fecha_orden);
                           $('#txt_fecha_ingreso').val(fecha_ingreso);
                           
                           
                           $('#txt_id_compra_detalle').val(id_compra_detalle);
                           $('#txt_id_compraa').val(id_compraa);
                           $('#txt_id_producto').val(id_producto);
                           $('#txt_cantidad').val(cantidad);
                           $('#txt_pcu').val(pcu);
                   });
                </script> 
        
    </body>
</html>
