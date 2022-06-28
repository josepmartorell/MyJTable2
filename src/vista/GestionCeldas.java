/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*Esta es una de las clases principales ya que determina el aspecto visual de la tabla específicamente hablando
  de las celdas, fuentes, componentes gráficos que queramos vincular entre otros aspectos, para este proceso 
  heredamos de la clase DefaultTableCellRenderer y sobreescribimos el método getTableCellRendererComponent() 
  que será llamado cada que se escuche algún evento sobre la tabla y así definir las acciones sobre las 
  celdas.*/

package vista;

/**
 *
 * @author jtech
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*Esta es una de las clases principales ya que determina el aspecto visual de la tabla específicamente 
  hablando de las celdas, fuentes, componentes gráficos que queramos vincular entre otros aspectos, para 
  este proceso heredamos de la clase DefaultTableCellRenderer y sobreescribimos el método 
  getTableCellRendererComponent() que será llamado cada que se escuche algún evento sobre la tabla y así 
  definir las acciones sobre las celdas.*/

public class GestionCeldas extends DefaultTableCellRenderer{
 
 private String tipo="text";

 //se definen por defecto los tipos de datos a usar
 private final Font normal = new Font( "Verdana",Font.PLAIN ,12 );
 private final Font bold = new Font( "Verdana",Font.BOLD ,12 );
 //etiqueta que almacenará el icono a mostrar
 private final JLabel label = new JLabel();
 //iconos disponibles para ser mostrados en la etiqueta dependiendo de la columna que lo contenga
 private final ImageIcon iconoGuardar = new ImageIcon(getClass().getResource("/recursos/ico_guardar.png"));
 private final ImageIcon iconoBuscar = new ImageIcon(getClass().getResource("/recursos/ico_buscar.png"));
    
 public GestionCeldas(){
  
 }


//constructor explicito con el tipo de dato que tendrá la celda
 public GestionCeldas(String tipo){
  this.tipo=tipo;
 }

 @Override
 public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
  
        /*Este metodo controla toda la tabla, podemos obtener el valor que contiene definir que celda está 
         *seleccionada, la fila y columna al tener el foco en ella. cada evento sobre la tabla invocará a este 
         *metodo. Definimos colores por defecto
         */

        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color( 192, 192, 192);
        Color colorFondoSeleccion=new Color( 140, 140 , 140);
     
        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
         //Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.white);
        }
                
        /*
         * Se definen los tipos de datos que contendrán las celdas basado en la instancia que
         * se hace en la ventana de la tabla al momento de construirla
         */
        if( tipo.equals("texto"))
        {
         //si es tipo texto define el color de fondo del texto y de la celda así como la alineación
            if (focused) {
       colorFondo=colorFondoSeleccion;
      }else{
       colorFondo= colorFondoPorDefecto;
      }
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value );
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
            this.setBackground( (selected)? colorFondo :Color.WHITE); 
            this.setFont(normal);   
            //this.setFont(bold);
            return this;
        }
         
        //si el tipo es icono entonces valida cual icono asignar a la etiqueta.
        if( tipo.equals("icono"))
        {
            if( String.valueOf(value).equals("PERFIL") )
            {
             label.setIcon(iconoBuscar);
            }
            else if( String.valueOf(value).equals("EVENTO") )
            {
             label.setIcon(iconoGuardar);
            }
            label.setHorizontalAlignment( JLabel.LEFT );
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            //return boton;
            return label;
        }
        
        //definie si el tipo de dato el numerico para personalizarlo
        if( tipo.equals("numerico"))
        {           
         if (focused) {
        colorFondo=colorFondoSeleccion;
       }else{
        colorFondo=colorFondoPorDefecto;
       }
         // System.out.println(value);
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );            
            this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );    
            this.setBackground( (selected)? colorFondo :Color.WHITE);
           // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
            this.setFont(bold);            
            return this;   
        }
  
  return this; 
 }
}

