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
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Mejia
 */
public class LeerArchivoTexto {
    
    private String rutaArchivo;

    public LeerArchivoTexto(String ruta) {
        this.rutaArchivo = ruta;
    }

    /**
     * Lee y valida los respectivos datos del archivo.
     *
     * @return tendremos el retorno de la lista con los numeros que hemos
     * encontrado en el archivo
     * @throws ValidacionesException se encargará de validar los formatos y la
     * existencia del archivo.
     */
    
    public List<String> LeerArchivo() throws ArchivoNoValidoException {
        List<String> contenidotexto = new ArrayList<>();
        try {
            // Se abre el fichero y se hace la respectiva creacion de BufferedReader
            File archivo = new File(rutaArchivo);
            FileReader Filereader = new FileReader(archivo);
            BufferedReader BufferArchivo = new BufferedReader(Filereader);
            if (!VerificacionArhivo(archivo)) {
                throw new ArchivoNoValidoException("No se encuentra ninguna información en el archivo");
            } else {
                String linea;
                while ((linea = BufferArchivo.readLine()) != null) {
                    String [] lineapartida = linea.split(",");
                    if (VerificacionLinea(lineapartida)) {
                        contenidotexto.add(linea);
                    } else {
                        throw new ArchivoNoValidoException("Este archivo contiene información diferente a lineas de estudiantes, no se pueden realizar las operaciones");
                    }
                }
            }
        } catch (IOException e) {
            throw new ArchivoNoValidoException("La ruta no es correcta, no existe un archivo para esta ruta, por favor vuelva a escribirla");
        }
        return contenidotexto;
    }

    /**
     * Realiza la verificación sobre si el dato que obtenemos, corresponde a un
     * numero
     *
     * @param lineaDato --> linea del archivo que se está leyenndo
     * @return verdadero si corresponde a un numero o falso si no corresponde
     */
    private boolean VerificacionLinea(String [] lineasPartidas) {
        if(lineasPartidas.length!=4){
            return false;
        }
        return true;
    }

    private boolean VerificacionArhivo(File archivo){
    int tamaño = (int) archivo.length();
    if (tamaño == 0) {
        return false;
       }
    return true;
    }
}
