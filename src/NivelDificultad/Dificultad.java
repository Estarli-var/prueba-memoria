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
    PRINCIPIANTE(4),
    INTERMEDIO(8),
    AVANZADA(16);
        
    private final int difiMedidas;

    public int getDifiMedidas() {
        return difiMedidas;
    }

    Dificultad(int difiMedidas) {
        this.difiMedidas = difiMedidas;
    }
    
    
    

}
