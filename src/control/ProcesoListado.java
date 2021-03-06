/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Estudiante;
import excepciones.ArchivoNoValidoException;
import java.util.ArrayList;
import java.util.List;
import lectura.ProcesamientoLectorEstudiante;

/**
 * Esta clase contiene los estudiantes y hace el proceso de envío de información de los mismos.
 * @author Emanuel Mejia
 * @version 1.0
 */

public class ProcesoListado {
    
    private ProcesamientoLectorEstudiante procesamientoLectorEstudiante; 
    private List<Estudiante> estudiantes;

    public ProcesoListado() {
        procesamientoLectorEstudiante = new ProcesamientoLectorEstudiante();
        estudiantes = new ArrayList();
    }
    
     /**
     * Método que envía la información completa de cada estudiante con su respectivo número de materias
     * @return String con los datos de los estudiantes y el número de materias.
     * @throws ArchivoNoValidoException Corrupción del archivo.
     */
    
    public String mostrarConsolidado(String ruta) throws ArchivoNoValidoException{
        estudiantes = procesamientoLectorEstudiante.getContenido(ruta);
        String consolidados = "";
        for (Estudiante listadoEstudiantes: estudiantes) {
            consolidados+=listadoEstudiantes.getNombre()+ " " + listadoEstudiantes.conteoMaterias()+ " materias \n";
        }
        return consolidados;
    }
}
