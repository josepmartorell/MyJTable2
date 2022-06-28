/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author jtech
 */
import javax.swing.table.DefaultTableModel;


public class ModeloTabla extends DefaultTableModel{
 
 String[] titulos;
 Object[][] datos;

 public ModeloTabla() {
 }
 
 public ModeloTabla(Object[][] datos, String[] titulos) {
  super();
  this.titulos=titulos;
  this.datos=datos;
  setDataVector(datos, titulos);
 }
 
 @Override
 public boolean isCellEditable (int row, int column)
 {
     //Definimos si una celda puede ser o no editable
     return !(column!=Utilidades.PERFIL && column!=Utilidades.EVENTO && column!=Utilidades.NOTA1 && column!=Utilidades.NOTA2 && column!=Utilidades.NOTA3);
 }
}

