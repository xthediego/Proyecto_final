/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CRUD.proveedores;
/**
 *
 * @author Diego Sandoval
 */
public class proveedor extends HttpServlet {

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
            out.println("<title>Servlet proveedor</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>funcionando</h1>");
            
            proveedores p = new proveedores(Integer.parseInt(request.getParameter("txt_id")),request.getParameter("txt_proveedor"),request.getParameter("txt_nit"),request.getParameter("txt_direccion"), request.getParameter("txt_telefono")  );
            
            if("agregar".equals(request.getParameter("btn_agregar"))){
             
             
                    if(p.agregar() > 0){

                        out.println("<h1> ingreso exitoso </h1>");
                        out.println("<a href='proveedores.jsp'>regresar </a>");
                    }else{
                        out.println("<h1> error .... </h1>");
                        out.println("<a href='proveedores.jsp'>regresar </a>");
                    }
            }
            
            
             if("modificar".equals(request.getParameter("btn_modificar"))){
             if (p.modify()>0){
                        out.println("<h1> ingreso exitoso </h1>");
                        out.println("<a href='proveedores.jsp'>regresar </a>");

             }else{
             out.println("<h1> xxxxxxx No se modific?? correctamente xxxxxxxxxxxx </h1>");
             out.println("<a href='proveedores.jsp'>Return...</a>");
             }
             }
            
            ///////////codigo del boton eliminar
             if ("eliminar".equals(request.getParameter("btn_eliminar"))){
                   
             if (p.delete1()>0){
            
                 out.println("<h1> Se elimino correctamente </h1>");
                 out.println("<a href='proveedores.jsp'>regresar </a>");

             }else{
                 out.println("<h1> xxxxxxx No se elimino xxxxxxxxxxxx </h1>");
                 out.println("<a href='proveedores.jsp'>Return...</a>");
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
