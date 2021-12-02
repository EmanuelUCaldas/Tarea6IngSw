/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que alberga la estructura de información básica de un estudiante.
 * @author Emanuel Mejia
 * @version 1.0
 */
public class Estudiante {
    
    private String identificacion;
    private String nombre;
    private List<Materia> materias;

    public Estudiante(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    
    /**
     * Método que busca la materia de un estudiante mediante un for y el respectivo codigo de la materia.
     * @return True si el estudiante ya tiene una matricula en esa materia, de lo contrario false.
     */
    
    public Boolean buscarMateira(String codigoMateria){
        for (int i = 0; i < materias.size(); i++) {
            if (this.materias.get(i).getCodigo().equals(codigoMateria)) {
                return true;
            }
        }
        return false;
      }
    
      /**
     * Método que realiza el proceso de matricula de una materia a un estudiante..
     * @return True si pudo realizar la matricula correctamente, de lo contrario false.
     */
    
   
    public Boolean agregarMatricula (String[] materia){
        if (!this.buscarMateira(materia[0])) {
            Materia newMateria = new Materia(materia[0], materia[1]);
            this.materias.add(newMateria);
            return true;
        }
        return false;
    }
    
    public int conteoMaterias(){
        return materias.size();
    }
}
