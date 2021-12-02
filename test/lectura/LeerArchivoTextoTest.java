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
 *
 * @author Emanuel Mejia
 */
public class LeerArchivoTextoTest {
    
    public LeerArchivoTextoTest() {
    }

    @Test (expected = ArchivoNoValidoException.class)
    public void testLeerArchivoInformaciónIncorrecta() throws Exception {
        String ruta ="C:\\Users\\emanu\\OneDrive\\Escritorio\\archivo.txt";
        LeerArchivoTexto lectorarchivotexto = new LeerArchivoTexto(ruta);
        List<String> resultado = lectorarchivotexto.LeerArchivo();
    }
    
       @Test (expected = ArchivoNoValidoException.class)
    public void testLeerArchivoNoExistente() throws Exception {
        String ruta ="ruta ficticia que no existe";
        LeerArchivoTexto lectorarchivotexto = new LeerArchivoTexto(ruta);
        List<String> resultado = lectorarchivotexto.LeerArchivo();
    }
    
    
    
}
