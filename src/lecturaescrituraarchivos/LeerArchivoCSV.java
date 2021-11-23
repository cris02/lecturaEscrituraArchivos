/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class LeerArchivoCSV {

    private static final String SAN_SALVADOR = "SAN SALVADOR";

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        BufferedReader bf = null; // almacena la lectura temporalmente en memoria
        FileInputStream fInputStream = null; // abre el flujo de datos para poder realizar la lectura
        StringBuilder datosFiltrados = new StringBuilder();

        try {
            
            fInputStream = new FileInputStream("C:/Users/crist/OneDrive/Desktop/dataset/ce.csv");
            bf = new BufferedReader(new InputStreamReader(fInputStream));

            String line;
            List<String> values;

            while ((line = bf.readLine()) != null) {
                values = getTokensSplit(line);
                if (SAN_SALVADOR.equals(values.get(2))) {
                    datosFiltrados.append(line).append("\n");
                }
            }

            //guardar la informacion filtrada en un archivo
            
            System.out.println("Ingrese la ruta del directorio donde desea almacenar? presione enter para alojarlo en el directorio por defecto");
            String directorio = teclado.nextLine();
            
            File directorioF;
            
            if (directorio != null && directorio.length() > 0) {
                directorioF = new File(directorio);
                if (!directorioF.isDirectory() && !directorioF.canWrite()) {
                    System.out.println("Los datos del directorio son incorrectos");
                    System.exit(0);
                } 
                
            }
            System.out.println("Ingrese el nombre del archivo");
            String nombreArchivo = teclado.nextLine();
            File ficheroEscritura = new File(directorio+"/"+nombreArchivo);
            
            File file = new File("C:/Users/crist/OneDrive/Desktop/dataset/datosFiltrados.csv");
            FileWriter fEscritura = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fEscritura);
            PrintWriter escribir = new PrintWriter(bw);
            escribir.write(datosFiltrados.toString());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeerArchivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
                if (fInputStream != null) {
                    fInputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LeerArchivoCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //System.out.println(datosFiltrados);
    }

    //metodo para separar las palabras
    public static List<String> getTokens(String line) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    //metodo para separar las palabras
    public static List<String> getTokensSplit(String str) {
        List<String> tokens;
        tokens = Arrays.asList(str.split(";"));
        return tokens;
    }

}
