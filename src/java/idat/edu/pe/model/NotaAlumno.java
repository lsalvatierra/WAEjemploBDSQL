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
public class NotaAlumno {
    private String nomcurso;
    private int credito;
    private double exaparcial;
    private double exafinal;

    public NotaAlumno(String nomcurso, int credito, double exaparcial, double exafinal) {
        this.nomcurso = nomcurso;
        this.credito = credito;
        this.exaparcial = exaparcial;
        this.exafinal = exafinal;
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

    public double getExaparcial() {
        return exaparcial;
    }

    public void setExaparcial(double exaparcial) {
        this.exaparcial = exaparcial;
    }

    public double getExafinal() {
        return exafinal;
    }

    public void setExafinal(double exafinal) {
        this.exafinal = exafinal;
    }
}
