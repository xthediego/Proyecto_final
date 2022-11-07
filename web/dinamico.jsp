<%-- 
    Document   : dinamico
    Created on : 27 oct 2022, 0:09:47
    Author     : yoc91
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.menu" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.Map.Entry"%>
<!DOCTYPE html>
<html>
 
    <head>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu dinamico</title>
        
        <style>
            .nav{
                width: 30%
                
                
            }
            .cont{
                display: flex;
                flex-direction: row;
                justify-content: center;
                
            }
            .s a{
               text-decoration: none; 
            }
            
        </style>
        
    </head>
    <body>
        
        <center><h1>Menu Dinamico</h1></center>
        
        
        <div class="cont">  
            
            <div>    
      <% menu menu = new menu();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = menu.leer();
                    out.println("<ul class='nav'>");
                    //Inicio For
                    for (int t= 0; t<tabla.getRowCount(); t++){
                       
                                                     
                            if(tabla.getValueAt(t,2).equals("0")){
                                            out.println("<li>"+ tabla.getValueAt (t,1));
                                            out.println("</li>");
                                            }
                                            //Inicio Producto
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("1")){
                                                                    out.println("<ul>");
                                                                    out.println("<li>"+ tabla.getValueAt (t,1) + "</li>" );
                                                                    out.println("</ul>"); 
                                                       } 
                                                       out.println("</ul>");
                                            // Fin Producto
                                            
                                            //Inicio Ventas 2
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("3")){
                                                                    
                                                                    out.println("<li>"+ tabla.getValueAt (t,1));
                                                                    out.println("</li>");
                                                                    
                                                        }
                                            if(tabla.getValueAt(t,2).equals("5")){
                                                                    out.println("<ul>");
                                                                    out.println("<li>"+ tabla.getValueAt (t,1) + "</li>" );
                                                                    out.println("</ul>"); 
                                                       } 
                                                       out.println("</ul>");
                                                       //Fin Ventas 2
                                                       
                                            //Inicio compras 3
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("7")){
                                                                    
                                                                    out.println("<li>"+ tabla.getValueAt (t,1));
                                                                    out.println("</li>");
                                                                    
                                                        }
                                                       out.println("</ul>");
                                            //Fin compras 3
            
                                            //Fin del For
                                           }                         
                           out.println("</ul>");
                  %>
            </div>
            <div>
                <ul>
                    <div class="s"><a href="productos.jsp">#</a></div>
                    
                    <br>
                    <div class="s"><a href="marcas.jsp">#</a></div>
                    <br>
                    <div class="s"><a href="Mdetalle1.jsp">#</a></div>
                   
                    <div class="s"><a href="clientes.jsp">#</a></div>
                    <br>
                    <div class="s"><a href="empleado.jsp">#</a></div>
                    <br>
                    <div class="s"><a href="puesto.jsp">#</a></div>
                    <br>
                    <div class="s"><a href="Mdetalle2.jsp">#</a></div>
                    <br>
                    <div class="s"><a href="proveedores.jsp">#</a></div>
                    <br>
                    <div class="s"><a href="report.jsp">#</a></div>
                </ul>
                
            </div>
        
        </div>       
          
        
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
