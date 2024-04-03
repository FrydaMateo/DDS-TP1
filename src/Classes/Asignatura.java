package Classes;

import java.util.Collection;

public record Asignatura(String Name, Collection<Asignatura> Correlativas) {

}
