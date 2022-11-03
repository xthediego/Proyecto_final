/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import CRUD.Mdetalle1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Sandoval
 */
public class mdet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mdet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mdet1 at " + request.getContextPath() + "</h1>");
            
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_id_venta_detalle"))  +"</p>");
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_id_ventass"))  +"</p>");
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_id_producto"))  +"</p>");
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_cantidad"))  +"</p>");
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_precio_unitario"))  +"</p>");

            
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_id_ventas"))  +"</p>");
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_nofactura"))  +"</p>");
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_id_cliente")) +"</p>");
            out.println("<p>"+  Integer.parseInt(request.getParameter("txt_id_empleado")) +"</p>");
            out.println("<p>"+  request.getParameter("txt_serie") +"</p>");
            out.println("<p>"+  request.getParameter("txt_fechafactura") +"</p>");
            out.println("<p>"+  request.getParameter("txt_fechaingreso") +"</p>");
            
            
           
            Mdetalle1 p = new Mdetalle1(Integer.parseInt(request.getParameter("txt_id_ventas")),Integer.parseInt(request.getParameter("txt_nofactura")),Integer.parseInt(request.getParameter("txt_id_cliente")),Integer.parseInt(request.getParameter("txt_id_empleado")),request.getParameter("txt_serie"),request.getParameter("txt_fechafactura"),request.getParameter("txt_fechaingreso") );
            
            Mdetalle1 F = new Mdetalle1(Integer.parseInt(request.getParameter("txt_id_venta_detalle")),Integer.parseInt(request.getParameter("txt_id_ventass")), Integer.parseInt(request.getParameter("txt_id_producto")),Integer.parseInt(request.getParameter("txt_precio_unitario")), Integer.parseInt(request.getParameter("txt_cantidad")) );
          
            if("agregar".equals(request.getParameter("btn_agregar"))){    
                 if(p.agregar()>0){

                        out.println("<h1> ingreso exitoso </h1>");
                        out.println("<a href='Mdetalle1.jsp'>regresar </a>");
                    }else{
                        out.println("<h1> error .... </h1>");
                        out.println("<a href='Mdetalle1.jsp'>regresar </a>");
                    }
                 
                 if(F.agregar1()>0){

                        out.println("<h1> ingreso exitoso </h1>");
                        out.println("<a href='Mdetalle1.jsp'>regresar </a>");
                    }else{
                        out.println("<h1> error .... </h1>");
                        out.println("<a href='Mdetalle1.jsp'>regresar </a>");
                    }
            } 
            
            if("modificar".equals(request.getParameter("btn_modificar"))){
                    
                    if (p.modify()>0){
                               out.println("<h1> modificacion exitoso </h1>");
                               out.println("<a href='Mdetalle1.jsp'>regresar </a>");

                    }else{
                        out.println("<h1> xxxxxxx No se modificó correctamente xxxxxxxxxxxx </h1>");
                        out.println("<a href='Mdetalle1.jsp'>Return...</a>");
                    }
                    
                    if (F.modify1()>0){
                        out.println("<h1> modificacion exitosa </h1>");
                        out.println("<a href='Mdetalle1.jsp'>regresar </a>");

                    }else{
                        out.println("<h1> xxxxxxx No se modificó correctamente xxxxxxxxxxxx </h1>");
                        out.println("<a href='Mdetalle1.jsp'>Return...</a>");
                    }
             }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
