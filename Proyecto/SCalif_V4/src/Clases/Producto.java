/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 * 
 * @author MHC <miguel.hrc>
 * @date 29-sep-2017
 * @time 11:44:06   
 */
public class Producto {
    private int idProducto;
    private String Tareas;
    private int Calificacion;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTareas() {
        return Tareas;
    }

    public void setTareas(String Tareas) {
        this.Tareas = Tareas;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }
}
