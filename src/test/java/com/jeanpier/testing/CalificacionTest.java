package com.jeanpier.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jeanpier.testing.Calificacion;

import static org.junit.jupiter.api.Assertions.*;

public class CalificacionTest {

    private Calificacion calificacion;

    @BeforeEach
    void setUp() {
        calificacion = new Calificacion();
    }

    // ==========================================================
    // 1. PRUEBAS PARA: calcularPromedio() (3 Casos de la Diapositiva)
    // ==========================================================

    @Test
    void calcularPromedio_Caso1() {
        double[] notas = {15.0, 14.0, 16.0};
        double resultado = calificacion.calcularPromedio(notas);
        System.out.println("[TEST calcularPromedio - Caso 1] Notas: [15, 14, 16] -> Promedio Obtenido: " + resultado + " (Esperado: 15.0)");
        assertEquals(15.0, resultado, 0.001);
    }

    @Test
    void calcularPromedio_Caso2() {
        double[] notas = {10.0, 12.0, 14.0};
        double resultado = calificacion.calcularPromedio(notas);
        System.out.println("[TEST calcularPromedio - Caso 2] Notas: [10, 12, 14] -> Promedio Obtenido: " + resultado + " (Esperado: 12.0)");
        assertEquals(12.0, resultado, 0.001);
    }

    @Test
    void calcularPromedio_Caso3() {
        double[] notas = {20.0, 18.0, 16.0};
        double resultado = calificacion.calcularPromedio(notas);
        System.out.println("[TEST calcularPromedio - Caso 3] Notas: [20, 18, 16] -> Promedio Obtenido: " + resultado + " (Esperado: 18.0)");
        assertEquals(18.0, resultado, 0.001);
    }

    // ==========================================================
    // 2. PRUEBAS PARA: estaAprobado() (4 Casos de la Diapositiva)
    // ==========================================================

    @Test
    void estaAprobado_Caso1_Promedio15() {
        boolean resultado = calificacion.estaAprobado(15.0);
        System.out.println("[TEST estaAprobado - Caso 1] Promedio: 15.0 -> ¿Aprobado?: " + resultado + " (Esperado: true)");
        assertTrue(resultado);
    }

    @Test
    void estaAprobado_Caso2_Promedio13_Limite() {
        boolean resultado = calificacion.estaAprobado(13.0);
        System.out.println("[TEST estaAprobado - Caso 2] Promedio: 13.0 (Límite) -> ¿Aprobado?: " + resultado + " (Esperado: true)");
        assertTrue(resultado);
    }

    @Test
    void estaAprobado_Caso3_Promedio12() {
        boolean resultado = calificacion.estaAprobado(12.0);
        System.out.println("[TEST estaAprobado - Caso 3] Promedio: 12.0 -> ¿Aprobado?: " + resultado + " (Esperado: false)");
        assertFalse(resultado);
    }

    @Test
    void estaAprobado_Caso4_Promedio05() {
        boolean resultado = calificacion.estaAprobado(5.0);
        System.out.println("[TEST estaAprobado - Caso 4] Promedio: 5.0 -> ¿Aprobado?: " + resultado + " (Esperado: false)");
        assertFalse(resultado);
    }

    // ==========================================================
    // 3. RETO: CREAR UN OCTAVO CASO DE PRUEBA Y JUSTIFICARLO
    // ==========================================================

    @Test
    void calcularPromedio_Reto_CasoInvalido() {
        System.out.println("[TEST RETO - Caso 8] Ejecutando validaciones de límites y excepciones para notas inválidas...");
        
        assertThrows(IllegalArgumentException.class, () -> {
            calificacion.calcularPromedio(new double[]{});
        });
        System.out.println("  - Sub-caso A (Arreglo vacío): Excepción IllegalArgumentException lanzada correctamente.");

        assertThrows(IllegalArgumentException.class, () -> {
            calificacion.calcularPromedio(new double[]{15.0, -1.0, 16.0});
        });
        System.out.println("  - Sub-caso B (Nota negativa -1.0): Excepción IllegalArgumentException lanzada correctamente.");

        assertThrows(IllegalArgumentException.class, () -> {
            calificacion.calcularPromedio(new double[]{15.0, 21.0, 16.0});
        });
        System.out.println("  - Sub-caso C (Nota mayor a 20 [21.0]): Excepción IllegalArgumentException lanzada correctamente.");
    }
}
