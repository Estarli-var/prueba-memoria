/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cronometros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author estar
 */
public class Cronometro {
   private Timer timer;
   private int segundos;
   private int minutos;
   private boolean corriendo;
   
   public Cronometro() {
        this.segundos = 0;
        this.minutos = 0;
        this.corriendo = false;
   
   this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador();
            }
        });
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
        
    }
  
    
   public void contador(){
   segundos++;
   if(segundos>=60){
   segundos=0;
   minutos++;
   }
   }
   public void iniciar() {
        if (!corriendo) {
            corriendo = true;
            timer.start();
        }
    }
   public void detener(){
       if (corriendo) {
        corriendo=false;
        timer.stop();
       }
   }
   
   public void reiniciar(){
   detener();
   segundos=0;
   minutos=0;
   corriendo=false;
   }
   
}
