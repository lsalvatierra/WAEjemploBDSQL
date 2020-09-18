
package idat.edu.pe.idao;

import idat.edu.pe.model.Curso;
import java.util.List;

public interface ICursoDAO {
    
    public List<Curso> ListarCursos();
    public boolean RegistrarCurso(Curso objcurso);
    public boolean ActualizarCurso(Curso objcurso);
    public boolean EliminarCurso(String idcurso);
   
    
}
