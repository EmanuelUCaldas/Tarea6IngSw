/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Clase Excepción para cuando se presenten errores en la lectura de los archivos.
 * @author Emanuel Mejia
 * @version 1.0
 */
public class ArchivoNoValidoException extends Exception {

    public ArchivoNoValidoException(String string) {
        super(string);
    }
    
}
