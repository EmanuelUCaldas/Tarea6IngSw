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
 * Esta clase realiza el proceso de conversión del archivo a la estructura basica (Estudiante - Materia)
 * @author Emanuel Mejia
 * @version 1.0
 */
public class ProcesamientoLectorEstudiante {

    public ProcesamientoLectorEstudiante() {
    }
    
    public List<Estudiante> getContenido(String ruta) throws ArchivoNoValidoException {
        LeerArchivoTexto leer = new LeerArchivoTexto(ruta);
        List<String> contenido = leer.LeerArchivo();
        return convertirArchivo(contenido);
    }
      /**
     *  Convierte cada linea en un estudiante con su respectiva información (Código y Nombre)
     * @return Lista de todos los estudiantes que se crearon.
     */
    
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
    
    /**
     *  Verifica si un estudiante ya se encuentra en la lista de estudiantes creados.
     * @return True si el estudiante ya existe (Se le asignan las materias previamente). False si el estudiante no ha sido creado.
     */
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
