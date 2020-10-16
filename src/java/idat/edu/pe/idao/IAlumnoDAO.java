/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.idao;

import idat.edu.pe.model.Alumno;
import idat.edu.pe.model.NotaAlumno;
import java.util.List;

/**
 *
 * @author luis_
 */
public interface IAlumnoDAO {
        public List<Alumno> ListarAlumnos();
        public Alumno ObtenerAlumno(String idalumno);
        public List<NotaAlumno> ListarNotasCurso(String idalumno);
}
