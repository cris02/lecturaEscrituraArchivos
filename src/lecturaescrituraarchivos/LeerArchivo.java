/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class LeerArchivo {
    
    public static void main(String[] args) {
        File fichero = new File("ficheroPrueba.txt");
        Scanner leer = null;
        
        try {
            //leer el archivo
            leer = new Scanner(fichero);
            
            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                System.out.println(linea);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (leer != null) {
                leer.close();
            }
        }
    }
    
}
