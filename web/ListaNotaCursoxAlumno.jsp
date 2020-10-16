<%@page import="idat.edu.pe.model.Alumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="scriptstyle.jsp" %>  
        <script src="Scripts/jsweb/ListaNotaCursoxAlumno.js" type="text/javascript"></script>        
    </head>
    <body>
        <%@include file="layout.jsp" %>
    <div class="card">
            <div class="card-body">
                <h5 class="card-title">Listado de alumnos</h5>
                <select id="cboalumno" class="form-control">
                    <option value="0">Seleccione</option>
                    <%
                        List<Alumno> lstalumno = (List<Alumno>) request.getAttribute("lstalumno");
                        for (Alumno objalu : lstalumno) {
                    %>
                        <option value="<%=objalu.getIdAlumno() %>"><%=objalu.getNomAlumno()+" "+objalu.getApeAlumno()%></option>                        
                    <%  }
                    %>

                </select>
                <br />
                <a class="btn btn-primary"  id="btnexportarpdf" 
                   href="ReporteNotaAlumnoController" target="_blank"
                   >Exportar a PDF</a>
                <br />
                <h5 class="card-title">Listado de cursos</h5>                
                <table id="tblcurso" class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nombre Curso</th>
                            <th scope="col">Crédito</th>
                            <th scope="col">Exa.Parcial</th>
                            <th scope="col">Exa.Final</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>                   
            </div>
        </div>         
    </body>
</html>
