package Classes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscripcionTest {

    @Test
    public void testAprobadaWithAllCorrelativasApproved() {
        Asignatura asignatura1 = new Asignatura("Matemáticas", Collections.emptyList());
        Asignatura asignatura2 = new Asignatura("Física", Collections.singletonList(asignatura1));
        Asignatura asignatura3 = new Asignatura("Química", Collections.singletonList(asignatura2));

        Alumno alumno = new Alumno(Arrays.asList(asignatura1, asignatura2));

        Inscripcion inscripcion = new Inscripcion(Arrays.asList(asignatura1, asignatura2, asignatura3), alumno);

        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testAprobadaWithSomeCorrelativasNotApproved() {
        Asignatura asignatura1 = new Asignatura("Matemáticas", Collections.emptyList());
        Asignatura asignatura2 = new Asignatura("Física", Collections.singletonList(asignatura1));
        Asignatura asignatura3 = new Asignatura("Química", Collections.singletonList(asignatura2));

        Alumno alumno = new Alumno(Collections.singletonList(asignatura1));

        Inscripcion inscripcion = new Inscripcion(Arrays.asList(asignatura1, asignatura2, asignatura3), alumno);

        assertFalse(inscripcion.aprobada());
    }

    @Test
    public void testAprobadaWithNoCorrelativas() {
        Asignatura asignatura1 = new Asignatura("Matemáticas", Collections.emptyList());
        Asignatura asignatura2 = new Asignatura("Física", Collections.emptyList());
        Asignatura asignatura3 = new Asignatura("Química", Collections.emptyList());

        Alumno alumno = new Alumno(Collections.emptyList());

        Inscripcion inscripcion = new Inscripcion(Collections.emptyList(), alumno);

        assertTrue(inscripcion.aprobada());
    }
}