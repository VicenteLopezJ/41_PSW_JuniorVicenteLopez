package com.jeanpier.testing;

public class CalculadoraPrecioFinal {

    public double calcularPrecioFinal(
            double precio,
            double descuento) {

        return precio - (precio * descuento / 100);
    }
}
