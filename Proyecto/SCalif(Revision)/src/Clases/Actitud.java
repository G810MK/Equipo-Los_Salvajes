/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author Usuario lenovo
 */
public class Actitud {
    private int idActitud;
    private int Asistencia;
    private String Fecha;
    private int Unidad;

    public int getUnidad() {
        return Unidad;
    }

    public void setUnidad(int Unidad) {
        this.Unidad = Unidad;
    }

    public int getIdActitud() {
        return idActitud;
    }

    public void setIdActitud(int idActitud) {
        this.idActitud = idActitud;
    }

    public int getAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(int Asistencia) {
        this.Asistencia = Asistencia;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
