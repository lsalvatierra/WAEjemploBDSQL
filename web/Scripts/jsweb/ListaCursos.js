$(document).on("click", "#btnagregarcurso", function () {
    $("#txtnomcurso").val("");
    $("#txtcredcurso").val("");
    $("#hddidcurso").val("0");
    $("#modalcurso").modal("show");
});
$(document).on("click", ".btnactualizarcurso", function () {
    $("#txtnomcurso").val($(this).attr("data-nomcurso"));
    $("#txtcredcurso").val($(this).attr("data-credcurso"));
    $("#hddidcurso").val($(this).attr("data-codcurso"));
    $("#modalcurso").modal("show");
});
$(document).on("click", "#btnregistrarcurso", function () {
    //console.log($("#hddidcurso").val());
    if ($("#hddidcurso").val() === "0") {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: "/WAEjemploBDSQL/RegistrarCurso",
            data: JSON.stringify({
                nomcurso: $("#txtnomcurso").val(),
                credito: $("#txtcredcurso").val()
            }),
            success: function (data, textStatus, jqXHR) {
                if (data) {
                    alert("Se registró el curso correctamente.");
                    ListarCursos();
                } else {
                    alert("Ocurrio un error en la base de datos.");
                }
            }
        });
    } else {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: "/WAEjemploBDSQL/RegistrarCurso",
            data: JSON.stringify({
                idcurso: $("#hddidcurso").val(),
                nomcurso: $("#txtnomcurso").val(),
                credito: $("#txtcredcurso").val()
            }),
            success: function (data, textStatus, jqXHR) {
                if (data) {
                    alert("Se actualizó el curso correctamente.");
                    ListarCursos();
                } else {
                    alert("Ocurrio un error en la base de datos.");
                }
            }
        });
    }
    $("#modalcurso").modal("hide");
});
$(document).on("click", ".btneliminarcurso", function () {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: '/WAEjemploBDSQL/EliminarCurso',
        data: JSON.stringify({
            idcurso: $(this).attr("data-codcurso")
        }),
        success: function (data, textStatus, jqXHR) {
            if (data) {
                alert("Se eliminó el curso correctamente.");
                ListarCursos();
            } else {
                alert("Ocurrió un error en la base de datos.");
            }
        }
    });

});
function ListarCursos(){
    $.ajax({
        type: 'POST',
        url: "/WAEjemploBDSQL/ListarCursos",
        dataType: 'json',
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            $("#tblcurso > tbody").html("");
            $.each(data, function(index, value){
                $("#tblcurso > tbody").append("<tr>"+
                        "<td>"+value.idcurso+"</td>"+
                        "<td>"+value.nomcurso+"</td>"+
                        "<td>"+value.credito+"</td>"+
                        "<td><button type='button' class='btn btn-info btnactualizarcurso'"+
                                " data-codcurso='"+value.idcurso+"' "+
                                " data-nomcurso='"+value.nomcurso+"' "+
                                " data-credcurso='"+value.credito+"' "+
                                ">Actualizar</button></td>"+
                        "<td><button type='button' class='btn btn-danger btneliminarcurso'"+
                                " data-codcurso='"+value.idcurso+"' "+
                                ">Eliminar</button></td>"+                                
                        "</tr>");                
            });
        }
        
    });   
}