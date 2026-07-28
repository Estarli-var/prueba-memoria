/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import Jugadores.Jugador;
import conometros.Conometro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import persona1.Tablero;
import persona1.Carta;

/**
 *
 * @author emalv
 */
public class ControladorJuego {
    
    private Conometro conometro;
    private Jugador jugador;
    private Tablero tablero;
    private Carta primeraCarta;
    private Carta segundaCarta;
    private boolean bloqueado;

    public ControladorJuego(Conometro conometro, Jugador jugador, Tablero tablero, Carta primeraCarta, Carta segundaCarta) {
        this.conometro = conometro;
        this.jugador = jugador;
        this.tablero = tablero;
        this.primeraCarta = primeraCarta;
        this.segundaCarta = segundaCarta;
    }
   
    public void iniciarJuego(){
        jugador.reiniciar();
        conometro.iniciar();
        tablero.incializarTablero();
        tablero.generarCartas();
        primeraCarta= null;
        segundaCarta= null;
        bloqueado = false;
    }
    
    public void seleccionarCarta(int fila, int columna) {

        if (bloqueado) {
            return;
        }
        
        Carta cartaSeleccionada = tablero.getCartas()[fila][columna];
        
        if (cartaSeleccionada.isEstado() || cartaSeleccionada == primeraCarta) {
            return;
        }
        
        tablero.mostrarCarta(cartaSeleccionada);

        if (primeraCarta == null) {
            primeraCarta = cartaSeleccionada;
        } else {
            segundaCarta = cartaSeleccionada;
            bloqueado = true;
            
            boolean sonIguales = tablero.verificarCartas(primeraCarta, segundaCarta);

            if (sonIguales) {
                jugador.agregarParejas(); 
                limpiarTurno();

                if (tablero.validarTodaslasCartas()) {
                    finalizarJuego();
                }
            } else {
                
                jugador.sumarIntento();

                Timer tiempoEspera = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tablero.ocultarCarta(primeraCarta);
                        tablero.ocultarCarta(segundaCarta);
                        limpiarTurno();
                        
                    }
                });
                tiempoEspera.setRepeats(false);
                tiempoEspera.start();
            }
        }
    }

    private void limpiarTurno() {
        primeraCarta = null;
        segundaCarta = null;
        bloqueado = false; 
    }

    public void finalizarJuego() {
        conometro.detener();
    }
}
