
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import Jugadores.Jugador;
import cronometros.Cronometro;
import javax.swing.Timer;
import tablero.Tablero;
import cartas.Carta;

/**
 *
 * @author emalv
 */
public class ControladorJuego {
    
    private Cronometro cronometro;
    private Jugador jugador;
    private Tablero tablero;   
    private Carta primeraCarta;
    private Carta segundaCarta;
    private boolean bloqueado;

    public ControladorJuego(Cronometro conometro, Jugador jugador, Tablero tablero, Carta primeraCarta, Carta segundaCarta) {
        this.cronometro = conometro;
        this.jugador = jugador;
        this.tablero = tablero;
        this.primeraCarta = primeraCarta;
        this.segundaCarta = segundaCarta;
    }
   
    public void iniciarJuego(){
        jugador.reiniciar();
        cronometro.iniciar();
        tablero.inicializarTablero();
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

                Timer tiempoEspera = new Timer(1000, e -> {
                    tablero.ocultarCarta(primeraCarta);
                    tablero.ocultarCarta(segundaCarta);
                    limpiarTurno();
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
        cronometro.detener();
    }
}
