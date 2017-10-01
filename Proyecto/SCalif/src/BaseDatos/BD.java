/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import Clases.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    //Modificar actitud
    public void modificarActitud(Actitud mActitud) throws SQLException{
        String SQL = "update actitud set Asistencia='?1', Fecha='?2' where idActitud = '?3'";
        SQL = SQL.replace("?1", String.valueOf(mActitud.getAsistencia()));
        SQL = SQL.replace("?2", String.valueOf(mActitud.getFecha()));
        SQL = SQL.replace("?3", String.valueOf(mActitud.getIdActitud()));
        mConexion.ejecutarActualizacion(SQL);
    }   
    
    //Modificar alumno
    public void modificarAlumno(Alumno mAlumno) throws SQLException{
        String SQL = "update alumno set NC = '?1', Nombre = '?2' where idAlumno = '?3'";
        SQL = SQL.replace("?1", String.valueOf(mAlumno.getNC()));
        SQL = SQL.replace("?2", mAlumno.getNombre());
        SQL = SQL.replace("?3", String.valueOf(mAlumno.getIdAlumno()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Modificar desempeño
    public void modificarDesempeño(Desempeño mDesempeño) throws SQLException{
        String SQL = "update desempeno set Trabajo = '?1', Calificacion = '?2' where idDesempeno = '?3'";
        SQL = SQL.replace("?1", mDesempeño.getTrabajo());
        SQL = SQL.replace("?2", String.valueOf(mDesempeño.getCalificacion()));
        SQL = SQL.replace("?3", String.valueOf(mDesempeño.getIdDesempeño()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Modificar Evaluacion diagnostica
    public void modificarEval_Diagnostica(Eval_Diagnostica mEval_Diagnostica) throws SQLException{
        String SQL = "update evaluacion_diagnostica set Calificacion = '?1' where idEvaluacion_diagnostica = '?2'";
        SQL = SQL.replace("?1", String.valueOf(mEval_Diagnostica.getCalificacion()));
        SQL = SQL.replace("?2", String.valueOf(mEval_Diagnostica.getIdEval_Diagnostica()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    // Modificar evaluacion general
    public void modificarEval_General(Eval_General mEval_General) throws SQLException{
        String SQL = "update evaluacion_general set Total = '?1' where idEvaluacion_general = '?2'";
        SQL = SQL.replace("?1", String.valueOf(mEval_General.getTotal()));
        SQL = SQL.replace("?2", String.valueOf(mEval_General.getIdEval_General()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    // Modificar evaluacion unidad
    public void modificarEval_Unidad(Eval_Unidad mEval_Unidad) throws SQLException{
        String SQL = "update evaluacion_unidad set Unidad = '?1', Conocimiento = '?2' where idEvaluacion_unidad = '?3'";
        SQL = SQL.replace("?1", String.valueOf(mEval_Unidad.getUnidad()));
        SQL = SQL.replace("?2", String.valueOf(mEval_Unidad.getCal_Conocimiento()));
        SQL = SQL.replace("?3", String.valueOf(mEval_Unidad.getIdEvalUnidad()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    // Modificar lista
    public void modificarLista(Lista mLista) throws SQLException{
        String SQL = "update lista set Materia = '?1', Grupo = '?2', Semetre = '?3' where idLista = '?4'";
        SQL = SQL.replace("?1", mLista.getMateria());
        SQL = SQL.replace("?2", mLista.getGrupo());
        SQL = SQL.replace("?3", String.valueOf(mLista.getSemestre()));
        SQL = SQL.replace("?4", String.valueOf(mLista.getIdLista()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    // Modificar producto
    public void modificarProducto(Producto mProducto) throws SQLException{
        String SQL = "update producto set Tareas = '?1', Calificacion = '?2' where idProducto = '?3'";
        SQL = SQL.replace("?1", String.valueOf(mProducto.getTareas()));
        SQL = SQL.replace("?2", String.valueOf(mProducto.getCalificacion()));
        SQL = SQL.replace("?3", String.valueOf(mProducto.getIdProducto()));
        mConexion.ejecutarActualizacion(SQL);
    }
    
    //Obtener lista actitud
    public List<Actitud> consultarActitud() throws SQLException{
        List<Actitud> lista= new ArrayList();
        String SQL = "select * from actitud inner join alumno on actitud.alumno_idAlumno = Alumno.idAlumno";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
            Actitud mActitud = new Actitud();
	    Alumno mAlumno = new Alumno();
	    mAlumno.setIdAlumno(consulta.getInt("IdAlumno"));
	    mAlumno.setNC(consulta.getInt("NC"));
	    mAlumno.setNombre(consulta.getString("Nombre"));
            mActitud.setIdActitud(consulta.getInt("idActitud"));
            mActitud.setAsistencia(consulta.getInt("Asistensia"));
            mActitud.setFecha(consulta.getDate("Fecha"));
            lista.add(mActitud);
        }
        return lista;
    }
    
    //Obtener lista alumnos
    public List<Alumno> consultarAlumno() throws SQLException{
        List<Alumno> lista= new ArrayList();
        String SQL = "select * from alumno";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
            Alumno mAlumno = new Alumno();
            mAlumno.setIdAlumno(consulta.getInt("idAlumno"));
            mAlumno.setNC(consulta.getInt("NC"));
            mAlumno.setNombre(consulta.getString("Nombre"));
            lista.add(mAlumno);
        }
        return lista;
    }
    
    //Obtener lista desempeño
    public List<Desempeño> consultarDesempeno() throws SQLException{
        List<Desempeño> lista= new ArrayList();
        String SQL = "select * from desempeno inner join alumno on desempeno.alumno_idAlumno = Alumno.idAlumno";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
            Desempeño mDesempeño = new Desempeño();
	    Alumno mAlumno = new Alumno();
	    mAlumno.setIdAlumno(consulta.getInt("IdAlumno"));
	    mAlumno.setNC(consulta.getInt("NC"));
	    mAlumno.setNombre(consulta.getString("Nombre"));
            mDesempeño.setIdDesempeño(consulta.getInt("idDesempeno"));
            mDesempeño.setTrabajo(consulta.getString("Trabajo"));
            mDesempeño.setCalificacion(consulta.getInt("Calificacion"));
            lista.add(mDesempeño);
        }
        return lista;
    }
    
    //Obtener lista evaluacion diagnostica
    public List<Eval_Diagnostica> consultarEvalDiag() throws SQLException{
        List<Eval_Diagnostica> lista= new ArrayList();
        String SQL = "select * from evaluacion_diagnostica inner join alumno on evaluacion_diagnostica.alumno_idAlumno = Alumno.idAlumno";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
            Eval_Diagnostica mEval_Diagnostica = new Eval_Diagnostica();
	    Alumno mAlumno = new Alumno();
	    mAlumno.setIdAlumno(consulta.getInt("IdAlumno"));
	    mAlumno.setNC(consulta.getInt("NC"));
	    mAlumno.setNombre(consulta.getString("Nombre"));
            mEval_Diagnostica.setIdEval_Diagnostica(consulta.getInt("idEvaluacion_diagnostica"));
            mEval_Diagnostica.setCalificacion(consulta.getDouble("Calificacion"));
            lista.add(mEval_Diagnostica);
        }
        return lista;
    }
}

