/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Tecnico
 */
public class DLineas {
    
     private int id;
    private String Lineas;
  public DLineas(int id, String Lineas) {
        this.id = id;
        this.Lineas = Lineas;
    }
    public DLineas(){
        
    }
    
   

    public int getId() {
        return id;
    }

    public String getLineas() {
        return Lineas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLineas(String Lineas) {
        this.Lineas = Lineas;
    }

  


   
    
}
