/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import excepciones.ArchivoNoValidoException;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias en el metodo de lectura de archivo.
 * @author Emanuel Mejia
 * @version 1.0
 */
public class LeerArchivoTextoTest {
    
    public LeerArchivoTextoTest() {
    }
    
     /**
     * Prueba para el metodo "LeerArchivoTexto" en la cual el archivo que ingresa no contiene la estructura
     * permitida para el ejercicio de conteo de materias. Lanza excepción
     */

    @Test (expected = ArchivoNoValidoException.class)
    public void testLeerArchivoInformaciónIncorrecta() throws Exception {
        String ruta ="C:\\Users\\emanu\\OneDrive\\Escritorio\\archivo.txt";
        LeerArchivoTexto lectorarchivotexto = new LeerArchivoTexto(ruta);
        List<String> resultado = lectorarchivotexto.LeerArchivo();
    }
    
     /**
     * Prueba para el metodo "LeerArchivoTexto" en la cual se le ingresa una ruta que no existe y se espera
     * que el programa lance excepción.
     */
    
       @Test (expected = ArchivoNoValidoException.class)
    public void testLeerArchivoNoExistente() throws Exception {
        String ruta ="ruta ficticia que no existe";
        LeerArchivoTexto lectorarchivotexto = new LeerArchivoTexto(ruta);
        List<String> resultado = lectorarchivotexto.LeerArchivo();
    }
    
}
