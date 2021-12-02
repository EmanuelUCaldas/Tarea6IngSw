/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import entidades.Estudiante;
import excepciones.ArchivoNoValidoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanuel Mejia
 */
public class ProcesamientoLectorEstudiante {

    public ProcesamientoLectorEstudiante() {
    }
    
    public List<Estudiante> getContenido(String ruta) throws ArchivoNoValidoException {
        LeerArchivoTexto leer = new LeerArchivoTexto(ruta);
        List<String> contenido = leer.LeerArchivo();
        return convertirArchivo(contenido);
    }
    
    public List<Estudiante> convertirArchivo (List<String> contenido){
        List<Estudiante> estudiantes = new ArrayList();

        for (int x = 0; x<contenido.size(); x++) {
            String[] contenidoLinea = contenido.get(x).split(",");
            if(!verificarEstudianteExiste(contenidoLinea, estudiantes)){
                Estudiante nuevoEstudiante = new Estudiante(contenidoLinea[0],contenidoLinea[1]);
                String[] datosMatricula = {contenidoLinea[2],contenidoLinea[3]};
                nuevoEstudiante.agregarMatricula(datosMatricula);
                estudiantes.add(nuevoEstudiante);
            }
        }
        return estudiantes;
    }
    
    public boolean verificarEstudianteExiste(String[] estudiante, List<Estudiante> estudiantes){
        for (Estudiante estudianteListado: estudiantes) {
            if(estudiante[0].equals(estudianteListado.getIdentificacion())){
                String[] datosMatricula = {estudiante[2],estudiante[3]};
                estudianteListado.agregarMatricula(datosMatricula);
                return true;
            }
        }
        return false;
    }
    

}
