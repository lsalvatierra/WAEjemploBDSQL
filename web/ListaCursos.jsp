<%@page import="java.util.List"%>
<%@page import="idat.edu.pe.model.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="scriptstyle.jsp" %>  
        <script src="Scripts/jsweb/ListaCursos.js" type="text/javascript"></script>
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
                <table class="table" id="tblcurso">
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
    <div class="modal fade" id="modalcurso" tabindex="-1" role="dialog" 
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Curso</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="txtnomcurso">Ingrese el nombre del curso:</label>
                            <input type="text" class="form-control" id="txtnomcurso" name="txtnomcurso">                        
                        </div>
                        <div class="form-group">
                            <label for="txtcredcurso">Ingrese el crédito del curso:</label>
                            <input type="text" class="form-control" id="txtcredcurso" name="txtcredcurso">
                        </div>
                        <input type="hidden" id="hddidcurso" name="hddidcurso" value="0" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="btnregistrarcurso">Guardar</button>
                    </div>
                </div>
            </div>
        </div>                        
    </body>
</html>
