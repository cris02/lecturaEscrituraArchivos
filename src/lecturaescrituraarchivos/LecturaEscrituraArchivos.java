/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class LecturaEscrituraArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] numeros = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete"};
        
        //crear el archivo
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("ficheroPrueba.txt");
            
            //recorrer el fichero para escribir su contenido
            for (String numero : numeros) {
                fichero.write(numero + "\n");
            }
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(LecturaEscrituraArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
