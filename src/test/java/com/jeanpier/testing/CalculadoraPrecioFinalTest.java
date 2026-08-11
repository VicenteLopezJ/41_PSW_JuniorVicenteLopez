package com.jeanpier.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jeanpier.testing.CalculadoraPrecioFinal;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraPrecioFinalTest {

    private CalculadoraPrecioFinal calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraPrecioFinal();
    }

    // ==========================================================
    // PRUEBAS PARA: calcularPrecioFinal() (4 Casos de la Diapositiva)
    // ==========================================================

    @Test
    void calcularPrecioFinal_Caso1_Precio100_Descuento10() {
        // Precio: 100, Descuento: 10% -> Esperado: 90
        double resultado = calculadora.calcularPrecioFinal(100, 10);
        System.out.println("[TEST calcularPrecioFinal - Caso 1] Precio: 100, Descuento: 10% -> Precio Final Obtenido: " + resultado + " (Esperado: 90.0)");
        assertEquals(90.0, resultado, 0.001);
    }

    @Test
    void calcularPrecioFinal_Caso2_Precio200_Descuento20() {
        // Precio: 200, Descuento: 20% -> Esperado: 160
        double resultado = calculadora.calcularPrecioFinal(200, 20);
        System.out.println("[TEST calcularPrecioFinal - Caso 2] Precio: 200, Descuento: 20% -> Precio Final Obtenido: " + resultado + " (Esperado: 160.0)");
        assertEquals(160.0, resultado, 0.001);
    }

    @Test
    void calcularPrecioFinal_Caso3_Precio50_Descuento0() {
        // Precio: 50, Descuento: 0% -> Esperado: 50 (sin descuento, precio no cambia)
        double resultado = calculadora.calcularPrecioFinal(50, 0);
        System.out.println("[TEST calcularPrecioFinal - Caso 3] Precio: 50, Descuento: 0% -> Precio Final Obtenido: " + resultado + " (Esperado: 50.0)");
        assertEquals(50.0, resultado, 0.001);
    }

    @Test
    void calcularPrecioFinal_Caso4_Precio500_Descuento50() {
        // Precio: 500, Descuento: 50% -> Esperado: 250
        double resultado = calculadora.calcularPrecioFinal(500, 50);
        System.out.println("[TEST calcularPrecioFinal - Caso 4] Precio: 500, Descuento: 50% -> Precio Final Obtenido: " + resultado + " (Esperado: 250.0)");
        assertEquals(250.0, resultado, 0.001);
    }

    // ==========================================================
    // CASO EXTRA (5.°): Descuento del 100% -> Precio final debe ser 0
    // Justificación: Es importante verificar el caso extremo donde el
    // descuento es total (100%), lo que debería resultar en un precio
    // final de 0. Esto valida que la fórmula maneja correctamente el
    // límite superior del descuento sin producir valores negativos.
    // ==========================================================

    @Test
    void calcularPrecioFinal_Caso5_Precio300_Descuento100() {
        // Precio: 300, Descuento: 100% -> Esperado: 0.0 (producto gratis)
        double resultado = calculadora.calcularPrecioFinal(300, 100);
        System.out.println("[TEST calcularPrecioFinal - Caso 5 EXTRA] Precio: 300, Descuento: 100% -> Precio Final Obtenido: " + resultado + " (Esperado: 0.0)");
        assertEquals(0.0, resultado, 0.001);
    }
}
