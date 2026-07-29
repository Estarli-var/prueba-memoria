/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablero;

import cartas.Carta;
import persona1.Dificultad;

/**
 *
 * @author wesrm
 */
public class Tablero {
    
    private Carta[][] cartas;
    private Dificultad dificultad;
    private String[] listaUsada = {};
    
    public Carta[][] getCartas() {
        return cartas;
    }
    
    public void setCartas(Carta[][] cartas) {
        this.cartas = cartas;
    }
    
    @Override
    public String toString() {
        return "Tablero{" + "cartas=" + cartas + '}';
    }
    
    public Dificultad getDificultad() {
        return dificultad;
    }
    
    public String[] getListaUsada() {
        return listaUsada;
    }
    
    public void setListaUsada(String[] listaUsada) {
        this.listaUsada = listaUsada;
    }
    
    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }
    
    public void incializarTablero() {
        for (int i = 0; i < (dificultad.getDifiMedidas() * dificultad.getDifiMedidas()); i++) {
            boolean indicador = true;
            String[] vecTemp = new String[listaUsada.length + 1];
            int val1 = (int) (Math.random() * dificultad.getDifiMedidas());
            int val2 = (int) (Math.random() * dificultad.getDifiMedidas());
            String generado = val1 + "-" + val2;
            for (int j = 0; j < listaUsada.length; j++) {
                if (listaUsada[j].equals(generado)) {
                    i--;
                    indicador = false;
                    break;
                }
                vecTemp[j] = listaUsada[j];
            }
            if (indicador) {
                vecTemp[listaUsada.length] = generado;
                listaUsada = vecTemp;
            }
        }
    }
    
    public Tablero(Dificultad dificultad) {
        this.dificultad = dificultad;
        this.cartas = new Carta[this.dificultad.getDifiMedidas()][this.dificultad.getDifiMedidas()];
        this.incializarTablero();
        this.generarCartas();
    }
    
    public void generarCartas() {
        int numeroCarta = 1;
        System.out.println(listaUsada.length);
        for (int i = 0; i < listaUsada.length; i++) {
            
            for (int j = 0; j < 2; j++) {
                System.out.println(i);
                System.out.println(listaUsada[i]);
                String[] valores = listaUsada[i].split("-");
                cartas[Integer.valueOf(valores[0])][Integer.valueOf(valores[1])] = new Carta(("carta_" + numeroCarta), ("carta" + numeroCarta));
                if (j == 0) {
                    i++;
                    
                }
            }
            numeroCarta++;
            
        }
    }
    
    public boolean verificarCartas(Carta carta1, Carta carta2) {
        if (carta1.getNombre().equals(carta2.getNombre())) {
            carta1.setEstado(true);
            carta2.setEstado(true);
            return true;
        } else {
            carta1.setEstado(true);
            carta2.setEstado(true);
            return false;
            
        }
        
    }
    
    public boolean validarTodaslasCartas() {
        for (int i = 0; i < dificultad.getDifiMedidas(); i++) {
            for (int j = 0; j < dificultad.getDifiMedidas(); j++) {
                if (!cartas[i][j].isEstado()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void mostrarCarta(Carta carta) {
        carta.setEstado(true);
    }
    
    public void ocultarCarta(Carta carta) {
        carta.setEstado(false);
    }
    
}
