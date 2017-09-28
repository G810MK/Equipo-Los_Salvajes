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
 * @time 12:49:31   
 */
import java.sql.*;
public class Conexion {
    private Connection conexion;
    private Statement comando;
   
    @SuppressWarnings("empity-statement")
    public boolean Conectar(String Host, String BD, String User, String Password) throws Exception{
        try{
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            this.conexion = DriverManager.getConnection("jdbc:mysql://" + Host + "/" + BD, User, Password);
            this.comando = conexion.createStatement();
            return true;
        }catch(SQLException exc){
            System.out.println("Error " + exc.toString());
            return false;
        }
    }
    public ResultSet ejecutarConsulta(String instruccionQL) throws SQLException{
        ResultSet resultado = this.comando.executeQuery(instruccionQL);
        return resultado;
    }
    
    public int ejecutarActualizacion(String instruccionDML) throws SQLException {
        int FilasAfectadas;
        FilasAfectadas = this.comando.executeUpdate(instruccionDML);
        System.out.println(instruccionDML + "Ejecutada");
        return FilasAfectadas;
    }

}
