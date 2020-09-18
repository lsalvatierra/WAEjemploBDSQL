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
public class Curso {
    private String idcurso;
    private String nomcurso;
    private int credito;

    public Curso(String idcurso, String nomcurso, int credito) {
        this.idcurso = idcurso;
        this.nomcurso = nomcurso;
        this.credito = credito;
    }
    

    public String getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(String idcurso) {
        this.idcurso = idcurso;
    }

    public String getNomcurso() {
        return nomcurso;
    }

    public void setNomcurso(String nomcurso) {
        this.nomcurso = nomcurso;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
    
    
}
