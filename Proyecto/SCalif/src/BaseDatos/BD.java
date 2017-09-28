/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

/**
 * 
 * @author MHC <miguel.hrc>
 * @date 25-sep-2017
 * @time 12:47:44   
 */
public class BD {
    Conexion mConexion = new Conexion();
    public BD(){
        try{
            mConexion.Conectar("localhost", "calificaciones", "root", "1234aszx");
        }catch(Exception error){
            System.out.println(error.toString());
        }
    }
    
    //Agregar 
}
