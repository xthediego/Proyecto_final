/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

/**
 *
 * @author Diego Sandoval
 */
class Customer {
    private int id_imagen;
    private String name;
    private String photo;

    public Customer() {
        
    }
    public Customer(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    
    
    
}
