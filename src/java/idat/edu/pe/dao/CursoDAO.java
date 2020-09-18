
package idat.edu.pe.dao;

import idat.edu.pe.bd.BDConnection;
import idat.edu.pe.idao.ICursoDAO;
import idat.edu.pe.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements ICursoDAO {

    @Override
    public List<Curso> ListarCursos() {
        List<Curso> lista = new ArrayList<>();
        BDConnection conexionBD = new BDConnection();
        Connection conec = conexionBD.conectar();
        try{
            Statement statement = conec.createStatement();
            ResultSet result = statement.executeQuery("{call sp_MantListarCursos}");
            while(result.next()){
                lista.add(new Curso(result.getString(1),
                        result.getString(2),
                        result.getInt(3)
                ));
            }
            result.close();
            statement.close();
            conexionBD.desconectar();
        }catch(SQLException ex){
            ex.printStackTrace();
        }        
        return lista;
    }

    @Override
    public boolean RegistrarCurso(Curso objcurso) {
        BDConnection conexionBD = new BDConnection();
        Connection conec = conexionBD.conectar();
        Boolean respuesta = false;
        try{
            PreparedStatement pstatement = 
                    conec.prepareStatement("{call sp_MantRegistrarCurso(?,?)}");
            pstatement.setString(1, objcurso.getNomcurso());
            pstatement.setInt(2, objcurso.getCredito());
            pstatement.execute();
            respuesta = pstatement.getUpdateCount() > 0;
            pstatement.close();
            conexionBD.desconectar();
        }catch(SQLException ex){
        
        }
        return respuesta;
    }

    @Override
    public boolean ActualizarCurso(Curso objcurso) {
        BDConnection conexionBD = new BDConnection();
        Connection conec = conexionBD.conectar();
        Boolean respuesta = false;
        try{
            PreparedStatement pstatement = 
                    conec.prepareStatement("{call sp_MantActualizarCurso(?,?,?)}");
            pstatement.setString(1, objcurso.getIdcurso());
            pstatement.setString(2, objcurso.getNomcurso());
            pstatement.setInt(3, objcurso.getCredito());
            pstatement.execute();
            respuesta = pstatement.getUpdateCount() > 0;
            pstatement.close();
            conexionBD.desconectar();
        }catch(SQLException ex){
        
        }
        return respuesta;
    }

    @Override
    public boolean EliminarCurso(String idcurso) {
        BDConnection conexionBD = new BDConnection();
        Connection conec = conexionBD.conectar();
        Boolean respuesta = false;
        try{
            PreparedStatement pstatement = 
                    conec.prepareStatement("{call sp_MantEliminarCurso(?)}");
            pstatement.setString(1, idcurso);
            pstatement.execute();
            respuesta = pstatement.getUpdateCount() > 0;
            pstatement.close();
            conexionBD.desconectar();
        }catch(SQLException ex){
        
        }
        return respuesta;        
    }
    
}
