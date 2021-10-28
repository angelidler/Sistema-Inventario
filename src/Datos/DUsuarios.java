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
public class DUsuarios {
    
   private String  NombreUs, Usuario, ClaveUs, Perfil;
      private int IdUsuario;
      
       public DUsuarios(String NombreUs, String Usuario, String ClaveUs, String Perfil, int IdUsuario) {
        this.NombreUs = NombreUs;
        this.Usuario = Usuario;
        this.ClaveUs = ClaveUs;
        this.Perfil = Perfil;
        this.IdUsuario = IdUsuario;
    }
       public DUsuarios(){
           
       }

    public void setNombreUs(String NombreUs) {
        this.NombreUs = NombreUs;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setClaveUs(String ClaveUs) {
        this.ClaveUs = ClaveUs;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUs() {
        return NombreUs;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getClaveUs() {
        return ClaveUs;
    }

    public String getPerfil() {
        return Perfil;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

   
  
            
}
