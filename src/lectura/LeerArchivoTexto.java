/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import excepciones.ArchivoNoValidoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de realizar la lectura de un archivo mediante una ruta especificada, se lanzan excepciones cuando se tenga
 * problemas de lectura con el archivo o ruta.
 * @author Emanuel Mejia
 * @version 1.0
 */
public class LeerArchivoTexto {
    
    private String rutaArchivo;

    public LeerArchivoTexto(String ruta) {
        this.rutaArchivo = ruta;
    }

    /**
     * Valida que la ruta tenga una extensión correcta (.txt), lee el archivo linea por linea y se verifica que cada linea
     * cumpla con los requisitos dados para el programa.
     *
     * @return Cada linea del contenido del archivo en un lista de string.
     * @throws ArchivoNoValidoException Se lanzan si el archivo o ruta no cumple con las condiciones.
     */
    
    public List<String> LeerArchivo() throws ArchivoNoValidoException {
        List<String> contenidotexto = new ArrayList<>();
         if(!verificarExtensionValida(rutaArchivo)){
               throw new ArchivoNoValidoException("La extensión del archivo no es correcta. Recuerde que el archivo debe tener extensión .txt");
          }
        try {
            // Se abre el fichero y se hace la respectiva creacion de BufferedReader
            File archivo = new File(rutaArchivo);
            FileReader Filereader = new FileReader(archivo);
            BufferedReader BufferArchivo = new BufferedReader(Filereader);
            if (!verificacionArhivoVacio(archivo)) {
                throw new ArchivoNoValidoException("No se encuentra ninguna información en el archivo");
            } else {
                String linea;
                while ((linea = BufferArchivo.readLine()) != null) {
                    String [] lineapartida = linea.split(",");
                    if (verificacionLinea(lineapartida)) {
                        contenidotexto.add(linea);
                    } else {
                        throw new ArchivoNoValidoException("Este archivo contiene información diferente a estudiantes y materias , no se pueden realizar las operaciones");
                    }
                }
            }
        } catch (IOException e) {
            throw new ArchivoNoValidoException("La ruta no es correcta, no existe un archivo para esta ruta, por favor vuelva a escribirla");
        }
        return contenidotexto;
    }

    /**
     * Valida que la linea de texto cumpla con la estructura básica del formato de información. 
     * que no tenga mas o menos campos de los requeridos.
     * @return True si la linea cumple con la estructura, false si no cumple con el requisito.
     */
    private boolean verificacionLinea(String [] lineasPartidas) {
        if(lineasPartidas.length!=4){
            return false;
        }
        return true;
    }
    
     /**
     * Valida que el archivo que hemos encontrado con la ruta especificada no sea un archivo en blanco, es decir se verifica 
     * que contenga información.
     * @return True si el archivo contiene información, false si el archivo está en blanco o sin información.
     */

    private boolean verificacionArhivoVacio(File archivo){
    int tamaño = (int) archivo.length();
    if (tamaño == 0) {
        return false;
       }
    return true;
    }
    
     /**
     * Valida que el archivo tenga una extensión valida, es decir .txt para este caso. No se permiten extensiones diferentes
     * @return True si el archivo tiene la extensión valida .txt, false si tiene otra extensión.
     */
    
    private boolean verificarExtensionValida(String ruta){
        String[] rutapartida = ruta.split("\\."); 
        if(rutapartida[rutapartida.length-1].equals("txt")){
            return true;
        }
        return false;
    }
    
}
