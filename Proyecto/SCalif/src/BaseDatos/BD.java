/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import Clases.*;
import java.sql.SQLException;

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
    
    //Agregar Lista
    public void agregarLista(Lista mLista) throws SQLException{
        String SQL = "insert into Lista values (null, '?1', '?2', '?3' )";
        SQL = SQL.replace("?1", mLista.getMateria());
        SQL = SQL.replace("?2", mLista.getGrupo());
        SQL =SQL.replace("?3", String.valueOf(mLista.getSemestre()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Agreagar Lista general
    public void agregarEval_general(Eval_General mEval_General, Eval_Unidad mEval_Unidad) throws SQLException{
        String SQL = "insert into evaluacion_general values (null, '?1', '?2')";
        SQL = SQL.replace("?1", String.valueOf(mEval_Unidad.getIdEvalUnidad()));
        SQL = SQL.replace("?2", String.valueOf(mEval_General.getTotal()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Agregar Alumno
    public void agregarAlumno(Alumno mAlumno, Lista mLista) throws SQLException{
        String SQL = "insert into alumno values (null, '?1', '?2', '?3')";
        SQL = SQL.replace("?1", String.valueOf(mLista.getIdLista() ));
        SQL = SQL.replace("?2", String.valueOf(mAlumno.getNC()));
        SQL = SQL.replace("?3", mAlumno.getNombre());
        mConexion.ejecutarActualizacion(SQL);
        
    }
    
    public void agregarEva_Diagnostica(Eval_Diagnostica mEval_Diagnostica, Alumno mAlumno) throws SQLException{
        String SQL = "insert into evaluacion_diagnostica values (null, '?1', '?2')";
        SQL = SQL.replace("?1", String.valueOf(mAlumno.getIdAlumno()));
        SQL = SQL.replace("?2", String.valueOf(mEval_Diagnostica.getCalificacion()));
        mConexion.ejecutarActualizacion(SQL);
                
    }
    //Agregar Actitud
    public void agregarActitud(Actitud mActitud, Alumno mAlumno) throws SQLException{
       String SQL = "insert into actitud values (null, '?1', '?2', '?3')";
       SQL = SQL.replace("?1", String.valueOf(mAlumno.getIdAlumno()));
       SQL =SQL.replace("?2", String.valueOf(mActitud.getAsistencia()));
       SQL = SQL.replace("?3", String.valueOf(mActitud.getFecha()));
       mConexion.ejecutarActualizacion(SQL);
    }
    
    //Agregar Desempeño
    public void agregarDesempeño(Desempeño mDesempeño, Alumno mAlumno) throws SQLException{
        String SQL = "insert into desempeno values (null, '?1', '?2','?3')";
        SQL = SQL.replace("?1", String.valueOf(mAlumno.getIdAlumno()));
        SQL = SQL.replace("?2", mDesempeño.getTrabajo());
        SQL = SQL.replace("?3", String.valueOf(mDesempeño.getCalificacion()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Agregar Eval_Unidad
    public void agregarEval_Unidad(Eval_Unidad mEval_Unidad, Alumno mAlumno) throws SQLException{
        String SQL = "insert into evaluacion_unidad values (null, '?1', '?2', '?3', '?4', '?5', '?6')";
        SQL = SQL.replace("?1", String.valueOf(mAlumno.getIdAlumno()));
        SQL = SQL.replace("?2", String.valueOf(mEval_Unidad.getUnidad()));
        SQL = SQL.replace("?3", String.valueOf(mEval_Unidad.getCal_Conocimiento()));
        SQL = SQL.replace("?4", String.valueOf(mEval_Unidad.getCaL_Producto()));
        SQL = SQL.replace("?5", String.valueOf(mEval_Unidad.getCal_Desempeno()));
        SQL = SQL.replace("?6", String.valueOf(mEval_Unidad.getCaL_Actitud()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Agregar Producto
    public void agregarProducto(Producto mProducto, Alumno mAlumno) throws SQLException{
        String SQL = "insert into producto values (null, '?1', '?2', '?3')";
        SQL = SQL.replace("?1", String.valueOf(mAlumno.getIdAlumno()));
        SQL = SQL.replace("?2", mProducto.getTareas());
        SQL = SQL.replace("?3", String.valueOf(mProducto.getCalificacion()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar producto
    public void eliminarProducto(int ID) throws SQLException{
        String SQL = "delete from producto where idProducto = '?1'";
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar lista
    public void eliminarlista(int ID) throws SQLException{
        String SQL = "delete from lista where idLista = '?1'";
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar evaluacion unidad
    public void eliminarEvaUnidad(int ID) throws SQLException{
        String SQL = "delete from evaluacion_unidad where idProducto = '?1'";    
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar evaluacion general
    public void eliminarGeneral(int ID) throws SQLException{
        String SQL = "delete from evaluacion_general where idEvaluacion_general = '?1'";    
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar evaluacion diagnostica
    public void eliminarDiagnostica(int ID) throws SQLException{
        String SQL = "delete from evaluacion_diagnostica where idEvaluacionDiagnostica = '?1'";
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar desempeño
    public void eliminarDesempeno(int ID) throws SQLException{
        String SQL = "delete from desempeno where idDesempeno = '?1'";    
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar alumno
    public void eliminarAlumno(int ID) throws SQLException{
        String SQL = "delete from alumno where idAlumno = '?1'";    
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Eliminar actitud
    public void eliminarActitud(int ID) throws SQLException{
        String SQL = "delete from actitud where idActitud = '?1'";    
        SQL = SQL.replace("?1", String.valueOf(ID));
        mConexion.ejecutarActualizacion(SQL);
    }
    
}

