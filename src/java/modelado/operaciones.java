/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego Sandoval
 */
public class operaciones {
    String driver;
    String url;
    String uss;
    String contra;
    
    public operaciones(){
        driver = "com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost:3308/proyecto";
        uss="proyectof";
        contra="123";
    }
    
    public int loguear(String us, String pass){
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        int cont=0;
        int nivel =0;
        String sql="SELECT nivel FROM login where user='"+us+"' and password='"+pass+"'  ;";
        try{
            Class.forName(this.driver);
            conn = DriverManager.getConnection(
                    this.url ,this.uss, this.contra
            );
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                nivel = rs.getInt(1);
            }
            conn.close();
        }catch(ClassNotFoundException | SQLException e){
        
        }
        
        
    return nivel;
    }
    
}
