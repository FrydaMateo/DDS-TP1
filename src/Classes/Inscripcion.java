package Classes;
import java.util.Collection;

public class Inscripcion {
    private final Collection<Asignatura> asignaturas;
    private final Alumno alumno;

    public Inscripcion(Collection<Asignatura> asignaturas, Alumno alumno) {
        this.asignaturas = asignaturas;
        this.alumno = alumno;
    }

    public boolean aprobada() {
        for (Asignatura asignatura : asignaturas) {
            for (Asignatura correlativa : asignatura.Correlativas()) {
                if (!hasAsignaturaApproved(alumno, correlativa)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasAsignaturaApproved(Alumno alumno, Asignatura asignatura){
        for (Asignatura tempAsignatura : alumno.Aprobadas()) {
            if (tempAsignatura.Name().equals(asignatura.Name())) {
                return true;
            }
        }
        return false;
    }
}
