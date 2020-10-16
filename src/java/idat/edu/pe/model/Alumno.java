/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.model;

/**
 *
 * @author luis_
 */
public class Alumno {
    private String IdAlumno;
    private String NomAlumno;
    private String ApeAlumno;

    public Alumno(String IdAlumno, String NomAlumno, String ApeAlumno) {
        this.IdAlumno = IdAlumno;        
        this.NomAlumno = NomAlumno;
        this.ApeAlumno = ApeAlumno;
    }
    
    public String getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(String IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public String getApeAlumno() {
        return ApeAlumno;
    }

    public void setApeAlumno(String ApeAlumno) {
        this.ApeAlumno = ApeAlumno;
    }

    public String getNomAlumno() {
        return NomAlumno;
    }

    public void setNomAlumno(String NomAlumno) {
        this.NomAlumno = NomAlumno;
    }    
}
