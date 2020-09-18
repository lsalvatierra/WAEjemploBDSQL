<%@page import="java.util.List"%>
<%@page import="idat.edu.pe.model.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="scriptstyle.jsp" %>        
    </head>
    <body>
        <%@include file="layout.jsp" %>
        <div class="card">
            <div class="card-body">
                <%
                    List<Curso> lstcursos = (List<Curso>) request.getAttribute("lstcursos");
                %>
                <h5 class="card-title">Listado de cursos:</h5>
                <button type="button" class="btn btn-info" id="btnagregarcurso">Registrar</button>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Nombre Curso</th>
                            <th scope="col">Crédito</th>
                            <th scope="col">Actualizar</th>
                            <th scope="col">Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Curso objcurso : lstcursos) {
                        %>
                        <tr>
                            <td><%=objcurso.getIdcurso()%></td>
                            <td><%=objcurso.getNomcurso()%></td>
                            <td><%=objcurso.getCredito()%></td>
                            <td>
                                <button class="btn btn-primary btnactualizarcurso"
                                        data-codcurso="<%=objcurso.getIdcurso()%>"   
                                        data-nomcurso="<%=objcurso.getNomcurso()%>"
                                        data-credcurso="<%=objcurso.getCredito()%>"
                                        >
                                    Actualizar</button>
                            </td>
                            <td><button class="btn btn-danger btneliminarcurso" 
                                        data-codcurso="<%=objcurso.getIdcurso()%>" 
                                        >
                                    Eliminar</button>
                            </td>
                        </tr> 
                        <%  }
                        %>

                    </tbody>
                </table>
            </div>
        </div>        
    </body>
</html>
