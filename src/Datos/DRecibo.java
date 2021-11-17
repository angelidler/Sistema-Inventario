/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Tecnico
 */
public class DRecibo {

    private int idRecibo;
    private String PersonaRecibe, PersonaEntrega;
    private Date Fecha;

    public DRecibo() {

    }

    public DRecibo(int idRecibo, String PersonaRecibe, String PersonaEntrega, Date Fecha) {

        this.PersonaRecibe = PersonaRecibe;
        this.PersonaEntrega = PersonaEntrega;
        this.Fecha = Fecha;
    }

    public void setPersonaRecibe(String PersonaRecibe) {
        this.PersonaRecibe = PersonaRecibe;
    }

    public void setPersonaEntrega(String PersonaEntrega) {
        this.PersonaEntrega = PersonaEntrega;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public String getPersonaRecibe() {
        return PersonaRecibe;
    }

    public String getPersonaEntrega() {
        return PersonaEntrega;
    }

    public Date getFecha() {
        return Fecha;
    }

    public int getIdRecibo() {
        return idRecibo;
    }

}
