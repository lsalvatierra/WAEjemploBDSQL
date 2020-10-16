$(document).ready(function(){
    $("#btnexportarpdf").hide(); 
});
$(document).on("change", "#cboalumno", function () {
    $.ajax({
        type: 'post',
        url: '/WAEjemploBDSQL/NotaAlumno',
        data: JSON.stringify({
            IdAlumno: $("#cboalumno").val()
        }),
        success: function (data, textStatus, jqXHR) {
            $("#tblcurso > tbody").html("");
            if (data.length > 0) {
                $.each(data, function (index, value) {
                    $("#tblcurso > tbody").append("<tr>" +
                            "<td>" + value.nomcurso + "</td>" +
                            "<td>" + value.credito + "</td>" +
                            "<td>" + value.exaparcial + "</td>" +
                            "<td>" + value.exafinal + "</td>" +
                            "</tr>");
                });
                var link = "ReporteNotaAlumnoController?idalumno=" + $("#cboalumno").val();
                $("#btnexportarpdf").attr('href', link);                
                $("#btnexportarpdf").show(); 
            }else{
                $("#btnexportarpdf").attr('href', "#");
                $("#btnexportarpdf").hide(); 
            }
        }
    });
    
});