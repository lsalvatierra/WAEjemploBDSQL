/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.dao;

import idat.edu.pe.bd.BDConnection;
import idat.edu.pe.idao.IAlumnoDAO;
import idat.edu.pe.model.Alumno;
import idat.edu.pe.model.NotaAlumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class AlumnoDAO implements  IAlumnoDAO {

    @Override
    public List<Alumno> ListarAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        BDConnection coneBD = new BDConnection();
       Connection con = coneBD.conectar();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("{call sp_ListarAlumno}");
            while(rs.next()){
                lista.add(
                   new Alumno(rs.getString(1), 
                           rs.getString(2), 
                           rs.getString(3))
                );            
            }
            rs.close();
            st.close();
            coneBD.desconectar();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Alumno ObtenerAlumno(String idalumno) {
        Alumno objAlumno = null;
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.conectar();
        try {
            PreparedStatement pst 
                    = con.prepareStatement(
                            "{call sp_AutenticarAlumno(?)}");
            pst.setString(1, idalumno);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                objAlumno = new Alumno(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
            rs.close();
            pst.close();
            coneBD.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objAlumno;         
    }

    @Override
    public List<NotaAlumno> ListarNotasCurso(String idalumno) {
        List<NotaAlumno> lista = new ArrayList<>();
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.conectar();
        try {
            PreparedStatement pst 
                    = con.prepareStatement(
                            "{call sp_ObtenerNotasAlumno(?)}");
            pst.setString(1, idalumno);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista.add(new NotaAlumno(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDouble(4)
                ));
            }
            rs.close();
            pst.close();
            coneBD.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista; 
    }
    
}
