
package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Sandoval
 */
public class empleados {
    private int id_empleado,id_puesto,genero;
    private String nombres,apellidos,direccion,telefono,DPI,fecha_nacimiento,fecha_inicio_labores,fechaingreso;
    //private byte genero;
    

    private conexion cn;
    
    public empleados(){}

    public empleados(int id_empleado, int id_puesto, String fecha_nacimiento, String fecha_inicio_labores, String fechaingreso, String nombres, String apellidos, String direccion, String telefono, String DPI, int genero) {
        this.id_empleado = id_empleado;
        this.id_puesto = id_puesto;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_inicio_labores = fecha_inicio_labores;
        this.fechaingreso = fechaingreso;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.DPI = DPI;
        this.genero = genero;
        
    }
    


    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_inicio_labores() {
        return fecha_inicio_labores;
    }

    public void setFecha_inicio_labores(String fecha_inicio_labores) {
        this.fecha_inicio_labores = fecha_inicio_labores;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    
    
      
    
    //AGREGAMOS SQL
    
    public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO empleados(nombres,apellidos,direccion,telefono,DPI,genero,fecha_nacimiento,id_puesto,fecha_inicio_labores,fechaingreso) VALUES(?,?,?,?,?,?,?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setString(1,getNombres());
            parametro.setString(2,getApellidos());
            parametro.setString(3,getDireccion());
            parametro.setString(4,getTelefono());
            parametro.setString(5,getDPI());
            parametro.setInt(6,getGenero());
            parametro.setString(7,getFecha_nacimiento());
            parametro.setInt(8,getId_puesto());
            parametro.setString(9,getFecha_inicio_labores());
            parametro.setString(10,getFechaingreso());
            
            
            
            retorno = parametro.executeUpdate();
            cn.close_conexion();
        }catch(SQLException ex){
        
            System.out.println(ex.getMessage());
            retorno=0;
        }
            return retorno;
    }
    
    //SELECC leer
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new conexion();
            cn.abrir_conexion();
            String query="SELECT id_empleado as id, nombres,apellidos,direccion,telefono,DPI,genero,fecha_nacimiento,id_puesto,fecha_inicio_labores,fechaingreso FROM empleados;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezados[]= {"id","nombres","apellidos","direccion","telefono","DPI","genero","fecha_nacimiento","id_puesto","fecha_inicio_labores","fechaingreso"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[11];
            while(consulta.next()){
                
                datos[0]= consulta.getString("id");
                datos[1]= consulta.getString("nombres");
                datos[2]= consulta.getString("apellidos");
                datos[3]= consulta.getString("direccion");
                datos[4]= consulta.getString("telefono");
                datos[5]= consulta.getString("DPI");
                datos[6]= consulta.getString("genero");
                datos[7]= consulta.getString("fecha_nacimiento");
                datos[8]= consulta.getString("id_puesto");
                datos[9]= consulta.getString("fecha_inicio_labores");
                datos[10]= consulta.getString("fechaingreso");
                
                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
    
    //imprimer generos select 
    //select para empleados
    private int id_genero;
    //private String genero; ya inicializado arriba
    
    public HashMap txt_genero(){
        HashMap<String,String> dropp = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_genero as id,genero FROM generos;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                dropp.put(consulta.getString("id"), consulta.getString("genero"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return dropp;
    }
    
    ///////////////////////////////////////////////////////////////////////
    
     public int modify(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "update empleados set nombres=?,apellidos=?,direccion=?,telefono=?,DPI=?,genero=?,fecha_nacimiento=?,id_puesto=?,fecha_inicio_labores=?,fechaingreso=? where id_empleado=?";
                           
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            ///////////////////////////////////////////////////////////////////////////////
            parametro.setString(1,this.getNombres());
            parametro.setString(2,this.getApellidos());
            parametro.setString(3,this.getDireccion());
            parametro.setString(4,this.getTelefono());
            parametro.setString(5,this.getDPI());
            parametro.setInt(6, this.getGenero());
            parametro.setString(7, this.getFecha_nacimiento());
            parametro.setInt(8, this.getId_puesto());
            parametro.setString(9, this.getFecha_inicio_labores());
            parametro.setString(10, this.getFechaingreso());
            parametro.setInt(11, this.getId_empleado());            
            ////////////////////////////////////////////////////////////////////////////////

            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
         return retorno;
     }
     
     //**********************************codigo de eliminar
       public int delete1(){
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "delete from empleados  where id_empleado=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_empleado());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    }
    
    //////////////////////////////////////////////////////////////////////
    
    
    public HashMap empleado(){
        HashMap<String,String> drop = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_empleado as ids,nombres FROM empleados;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                drop.put(consulta.getString("ids"), consulta.getString("nombres"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return drop;
    }
    
}
