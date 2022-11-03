/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import CRUD.imagen;
import DAO.imagenDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Diego Sandoval
 */
public class img extends HttpServlet {

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
            out.println("<title>Servlet img</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet img at " + request.getContextPath() + "</h1>");
            imagen p=new imagen();
            
            String accion=request.getParameter("accion");
            
            switch(accion){
                case "Guardar":
                    ArrayList<String>lista=new ArrayList<>();
                    imagenDAO pdao=new imagenDAO();
                      try{
                          FileItemFactory file = new DiskFileItemFactory();
                          ServletFileUpload fileUpload=new ServletFileUpload(file);
                          List items=fileUpload.parseRequest(request);
                          for(int i=0; i<items.size(); i++){
                              FileItem fileItem=(FileItem)items.get(i);
                              if(!fileItem.isFormField()){
                                  File f= new File("C:\\Users\\Diego Sandoval\\Desktop\\Diego (2)\\img"+fileItem.getName());
                                  fileItem.write(f);
                                  p.setArchivo(f.getAbsolutePath());
                              }else{
                                  lista.add(fileItem.getString());
                              }
                          }
                          p.setNombre(lista.get(0));
                          pdao.agregar(p);
                      }catch(Exception ex){
                      
                      }  
                    request.getRequestDispatcher("img?accion=Listar").forward(request, response);
                    break;
                case "Listar":
                    request.getRequestDispatcher("imagen.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            
            /*if("agregar".equals(request.getParameter("btn_agregar"))){    
                 
                int id=Integer.parseInt(request.getParameter("txt_id"));
                String nom= request.getParameter("txt_nombre");
                Part part =request.getPart("txt_imagen");
                
                InputStream inputStream=part.getInputStream();
                
                p.setId_imagen(id);
                p.setNombre(nom);
               
                p.agregar();
 
                        out.println("<h1> ingreso exitoso </h1>");
                        out.println("<a href='imagen.jsp'>regresar </a>");
                    
            } */
            
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
