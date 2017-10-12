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
    
    //Obtener lista evaluacion general
    public List<Eval_General> consultarGeneral() throws SQLException{
        List<Eval_General> lista= new ArrayList();
    String SQL = "select * from (evaluacion_general inner join evaluacion_unidad on evaluacion_general.evaluacion_unidad_idevaluacion_unidad = evaluacion_unidad.idEvaluacion_unidad) inner join Alumno on Alumno.idAlumno = evaluacion_unidad.Alumno_idAlumno";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
        Eval_Unidad mEval_Unidad = new Eval_Unidad();
        Eval_General mEval_General = new Eval_General();
        Alumno mAlumno = new Alumno();
        mEval_Unidad.setIdEvalUnidad(consulta.getInt("idEvaluacion_unidad"));
        mEval_Unidad.setUnidad(consulta.getInt("Unidad"));
        mEval_Unidad.setCal_Conocimiento(consulta.getInt("Conocimiento"));
        mEval_Unidad.setCaL_Producto(consulta.getInt("Producto"));
        mEval_Unidad.setCal_Desempeno(consulta.getInt("Desempeno"));
        mEval_Unidad.setCaL_Actitud(consulta.getDouble("Actitud"));
        mAlumno.setIdAlumno(consulta.getInt("IdAlumno"));
        mAlumno.setNC(consulta.getInt("NC"));
        mAlumno.setNombre(consulta.getString("Nombre"));            
            mEval_General.setIdEval_General(consulta.getInt("idEvaluacion_diagnostica"));
            mEval_General.setTotal(consulta.getDouble("Toltal"));
            lista.add(mEval_General);
        }
        return lista;
    }
    
    //Obtener lista evaluacion unidad
    public List<Eval_Unidad> consultarUnidad() throws SQLException{
        List<Eval_Unidad> lista= new ArrayList();
        String SQL = "select * from evaluacion_unidad inner join alumno on evaluacion_unidad.alumno_idAlumno = Alumno.idAlumno";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
            Eval_Unidad mEval_Unidad = new Eval_Unidad();
        Alumno mAlumno = new Alumno();
        mAlumno.setIdAlumno(consulta.getInt("IdAlumno"));
        mAlumno.setNC(consulta.getInt("NC"));
        mAlumno.setNombre(consulta.getString("Nombre"));
            mEval_Unidad.setIdEvalUnidad(consulta.getInt("idEvaluacion_unidad"));
            mEval_Unidad.setUnidad(consulta.getInt("Unidad"));
            mEval_Unidad.setCal_Conocimiento(consulta.getDouble("Conocimiento"));
            mEval_Unidad.setCal_Desempeno(consulta.getDouble("Desempeno"));
            mEval_Unidad.setCaL_Actitud(consulta.getDouble("Actitud"));
            lista.add(mEval_Unidad);
        }
        return lista;
    }
    
    //Obtener lista
    public List<Lista> consultarLista() throws SQLException{
        List<Lista> lista= new ArrayList();
    String SQL = "select * from lista inner join alumno on lista.idLista = Alumno.Lista_idLista";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
            Lista mLista = new Lista();
        Alumno mAlumno = new Alumno();
        mAlumno.setIdAlumno(consulta.getInt("IdAlumno"));
        mAlumno.setNC(consulta.getInt("NC"));
        mAlumno.setNombre(consulta.getString("Nombre"));
            mLista.setIdLista(consulta.getInt("idLista"));
            mLista.setMateria(consulta.getString("Materia"));
            mLista.setGrupo(consulta.getString("Grupo"));
            mLista.setSemestre(consulta.getInt("Semestre"));
            lista.add(mLista);
        }
        return lista;
    }
    
    //Obtener lista producto
    public List<Producto> consultarProducto() throws SQLException{
        List<Producto> lista= new ArrayList();
        String SQL = "select * from producto inner join alumno on producto.alumno_idAlumno = Alumno.idAlumno";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while(consulta.next()){
            Producto mProducto = new Producto();
        Alumno mAlumno = new Alumno();
        mAlumno.setIdAlumno(consulta.getInt("IdAlumno"));
        mAlumno.setNC(consulta.getInt("NC"));
        mAlumno.setNombre(consulta.getString("Nombre"));
            mProducto.setIdProducto(consulta.getInt("idProducto"));
            mProducto.setTareas(consulta.getString("Tareas"));
            mProducto.setCalificacion(consulta.getInt("Calificacion"));
            lista.add(mProducto);
        }
        return lista;
    }
     //Obtener lista de materias
    public List<Lista> consultarListaMateria() throws SQLException {
        List<Lista> lista = new ArrayList();
        String SQL = "select distinct Materia from Lista";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while (consulta.next()) {
            Lista mLista = new Lista();
            mLista.setMateria(consulta.getString("Materia"));
            lista.add(mLista);
        }
        return lista;
    }
    
    //Obtener lista grupo
    public List<Lista> consultarListaCarrera(String Materia) throws SQLException {
        List<Lista> lista = new ArrayList();
        String SQL = "select distinct Carrera from Lista where Materia = '" + Materia +  "'";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while (consulta.next()) {
            Lista mLista = new Lista();
            mLista.setCarrera(consulta.getString("Carrera"));
            lista.add(mLista);
        }
        return lista;
    }
    
    //Obtener lista semestre
    public List<Lista> consultarListaSemestres(String Materia) throws SQLException {
        List<Lista> lista = new ArrayList();
        String SQL = "select distinct Semestre from Lista where Materia = '" + Materia +  "'";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while (consulta.next()) {
            Lista mLista = new Lista();
            mLista.setSemestre(consulta.getInt("Semestre"));
            lista.add(mLista);
        }
        return lista;
    }
    
    //Obtener lista Grupo
    public List<Lista> consultarListaGrupo(String Materia) throws SQLException {
        List<Lista> lista = new ArrayList();
        String SQL = "select distinct Grupo from Lista where Materia = '" + Materia +  "'";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while (consulta.next()) {
            Lista mLista = new Lista();
            mLista.setGrupo(consulta.getString("Grupo"));
            lista.add(mLista);
        }
        return lista;
    }
    
    //Obtener id Lista
    public List<Lista> consultarListarID(String Materia, String Carrera, String Grupo, String Semestre) throws SQLException {
        List<Lista> lista = new ArrayList();
        String SQL = "select idLista from Lista where Materia = '" + Materia +  "' and Carrera = '" + Carrera + "' and Grupo = '" + Grupo + "'and Semestre = '" + Semestre + "'";
        ResultSet consulta = mConexion.ejecutarConsulta(SQL);
        while (consulta.next()) {
            Lista mLista = new Lista();
            mLista.setIdLista(consulta.getInt("idLista"));
            lista.add(mLista);
        }
        return lista;
    }
    
    public void Cargar(String ID, String Ruta) throws SQLException{
        Ruta = Ruta.replace('\\', '/');
        String SQL = "LOAD DATA LOCAL INFILE '" + Ruta + "' INTO TABLE alumno FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n' (NC, Nombre) SET Lista_idLista = '" + ID + "'";
        mConexion.ejecutarActualizacion(SQL);
    }
}