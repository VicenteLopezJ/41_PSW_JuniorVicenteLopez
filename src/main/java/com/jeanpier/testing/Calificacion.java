package com.jeanpier.testing;

public class Calificacion {


    public double calcularPromedio(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("La lista de notas no puede estar vacía o ser nula.");
        }
        double suma = 0;
        for (double nota : notas) {
            if (nota < 0 || nota > 20) {
                throw new IllegalArgumentException("La nota debe estar en el rango de 0 a 20.");
            }
            suma += nota;
        }
        return suma / notas.length;
    }


    public boolean estaAprobado(double promedio) {
        if (promedio < 0 || promedio > 20) {
            throw new IllegalArgumentException("El promedio debe estar en el rango de 0 a 20.");
        }
        return promedio >= 13.0;
    }
}
