/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Usuario lenovo
 */
public class Desempeño {
    private int idDesempeño;
    private String Trabajo;
    private int Calificacion;
    private String UnidadD;

    public String getUnidadD() {
        return UnidadD;
    }

    public void setUnidadD(String UnidadD) {
        this.UnidadD = UnidadD;
    }

    public int getIdDesempeño() {
        return idDesempeño;
    }

    public void setIdDesempeño(int idDesempeño) {
        this.idDesempeño = idDesempeño;
    }

    public String getTrabajo() {
        return Trabajo;
    }

    public void setTrabajo(String Trabajo) {
        this.Trabajo = Trabajo;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }
    
}
