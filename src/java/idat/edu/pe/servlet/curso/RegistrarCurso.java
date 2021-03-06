/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.servlet.curso;

import com.google.gson.Gson;
import idat.edu.pe.dao.CursoDAO;
import idat.edu.pe.model.Curso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis_
 */
@WebServlet(name = "RegistrarCurso", urlPatterns = {"/RegistrarCurso"})
public class RegistrarCurso extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    InputStream inputStream = request.getInputStream();
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(inputStream , StandardCharsets.UTF_8));        
//        BufferedReader reader = request.getReader();
        Curso objcurso = new Gson().fromJson(reader, Curso.class);
        boolean respuesta = false;
        if(objcurso.getIdcurso() == null){
            respuesta = new CursoDAO().RegistrarCurso(objcurso);
        }else{
            respuesta = new CursoDAO().ActualizarCurso(objcurso);
        }
        String resjson = new Gson().toJson(respuesta);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        out.print(resjson);
        out.flush();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
