/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6ingsw1;

import control.ProcesoListado;
import excepciones.ArchivoNoValidoException;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Mejia
 */
public class Tarea6IngSw1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        String urlArchivo = JOptionPane.showInputDialog("Ingrese la ruta del archivo.");
        ProcesoListado procesolistado = new ProcesoListado();
        String consolidado = procesolistado.mostrarConsolidado(urlArchivo);
        JOptionPane.showMessageDialog(null, consolidado);
        } catch (ArchivoNoValidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
