/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package NivelDificultad;

/**
 *
 * @author wesrm
 */
public enum Dificultad {
    PRINCIPIANTE(4, 4),  
    INTERMEDIO(4, 8),    
    AVANZADA(8, 8);      

    private final int filas;
    private final int columnas;

    Dificultad(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}