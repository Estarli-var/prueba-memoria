/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugadores;

/**
 *
 * @author estar
 */
public class Jugador {
    private int puntaje;
    private int intentos;
    private int parejas;

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getParejas() {
        return parejas;
    }

    public void setParejas(int parejas) {
        this.parejas = parejas;
    }

    
    public Jugador() {
        this.puntaje = 0;
        this.intentos = 0;
        this.parejas = 0;
    }
    
    public Jugador(int puntaje, int intentos, int parejas) {
        this.puntaje = puntaje;
        this.intentos = intentos;
        this.parejas = parejas;
    }
    
    
    public void agregarParejas(){
    parejas++;
    puntaje+=100;
    }
    
    public void sumarIntento(){
    intentos++;
    puntaje-=20;
    
    if (puntaje<0) {
            puntaje=0;
        }
    }
    
    public void reiniciar(){
    puntaje=0;
    intentos=0;
    parejas=0;
    }
}
