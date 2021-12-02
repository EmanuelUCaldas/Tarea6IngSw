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
 *
 * @author Emanuel Mejia
 */
public class ProcesoListado {
    
    private ProcesamientoLectorEstudiante procesamientoLectorEstudiante; 
    private List<Estudiante> estudiantes;

    public ProcesoListado() {
        procesamientoLectorEstudiante = new ProcesamientoLectorEstudiante();
        estudiantes = new ArrayList();
    }
    
    public String mostrarConsolidado(String ruta) throws ArchivoNoValidoException{
        estudiantes = procesamientoLectorEstudiante.getContenido(ruta);
        String consolidados = "";
        for (Estudiante listadoEstudiantes: estudiantes) {
            consolidados+=listadoEstudiantes.getNombre()+ " " + listadoEstudiantes.conteoMaterias()+ " materias \n";
        }
        return consolidados;
    }
}
