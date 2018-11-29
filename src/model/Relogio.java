/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author computador
 */
public class Relogio implements Runnable {

    private JLabel lblHora;

    public Relogio(JLabel lblHora) {
        this.lblHora = lblHora;
    }
    
   
    
    @Override
    public void run() {
        while(true){
            try {
                LocalTime hora=LocalTime.now();
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
                String hora2=hora.format(formatter);
                lblHora.setText(hora2);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Relogio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
