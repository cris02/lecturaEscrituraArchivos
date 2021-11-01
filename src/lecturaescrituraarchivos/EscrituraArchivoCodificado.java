/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class EscrituraArchivoCodificado {

    /*
        escritura con codificacion utf-8
     */
    public static void main(String[] args) {
        
        String[] numeros = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete"};
        Writer escribir = null;
        try {
            escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ficheroCodificado.txt"), "UTF-8"));

            //recorremos el archivo para escribir
            for (String numero : numeros) {
                try {
                    escribir.write(numero + "\n");
                } catch (IOException ex) {
                    System.out.println("Mensaje de excepcion de escritura: " + ex.getMessage());
                }
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EscrituraArchivoCodificado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(EscrituraArchivoCodificado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
