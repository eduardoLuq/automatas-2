import analizadorSemantico.AnalizadorSemantico;
import analizadorSintactico.AnalizadorSintactico;
import errores.ManejadorErrores;
import expresiones.ManejadorExpresiones;
import simbolos.TablaDeSimbolos;
import sun.misc.IOUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//grafico
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;

import java.awt.Font;

public class grafico {
	private static JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	static TablaDeSimbolos tablaDeSimbolos = new TablaDeSimbolos();

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grafico window = new grafico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

        
        FileInputStream archivoFuente = new FileInputStream("src/archivosDeEntrada/triplos.txt");

        MarkableFileInputStream markableFIS = new MarkableFileInputStream(archivoFuente);
        markableFIS.mark(1);

        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(tablaDeSimbolos,markableFIS);
        AnalizadorSemantico analizadorSemantico = new AnalizadorSemantico(tablaDeSimbolos,markableFIS);
        
        try {
            analizadorSintactico.analizar();
        }catch(analizadorSintactico.ParseException e){
            System.out.println(e.toString());
        }
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 180, 450, 300);
		frame.getContentPane().add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table1 = new JTable(modelo);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table1);
		
		Object[] alcance = tablaDeSimbolos.print("alc").toArray();
		Object[] tipo = tablaDeSimbolos.print("tipo").toArray();
		Object[] posicion = tablaDeSimbolos.print("pos").toArray();
		Object[] nombre = tablaDeSimbolos.print("nom").toArray();
		Object[] valor = tablaDeSimbolos.print("val").toArray();
		
		((DefaultTableModel) table1.getModel()).addColumn("Alcance", alcance);
		((DefaultTableModel) table1.getModel()).addColumn("Tipo", tipo);
		((DefaultTableModel) table1.getModel()).addColumn("Posicion", posicion);
		((DefaultTableModel) table1.getModel()).addColumn("Nombre", nombre);
		((DefaultTableModel) table1.getModel()).addColumn("valor", valor);
		
        
        
        
        
        

        //System.out.println("\nTabla de simbolos");
        //tablaDeSimbolos.print("pos");
        System.out.println();

        markableFIS.reset();

        try {
            analizadorSemantico.analizar();
        }catch(analizadorSemantico.ParseException e){
            System.out.println("SEMANTICO");
            System.out.println(e.toString());
        }
        
        
        JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(532, 180, 221, 300);
		frame.getContentPane().add(scrollPane_2);
		
		DefaultTableModel modelo2 = new DefaultTableModel();
		JTable table2 = new JTable(modelo2);
		scrollPane_2.setViewportView(table2);
		//Object[] expresion = ManejadorExpresiones.guardarfinal()
		//((DefaultTableModel) table2.getModel()).addColumn("Expresiones", expresion);
        
        
        
        
        

        
		ManejadorExpresiones.print();
        Thread.sleep(100);
       ManejadorErrores.print();
        Thread.sleep(100);


        //System.out.println("\nTabla de simbolos");
        //tablaDeSimbolos.print("pos");
        
        
        JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(810, 180, 450, 300);
		frame.getContentPane().add(scrollPane_1);
		
		DefaultTableModel modelo3 = new DefaultTableModel();
		JTable table3 = new JTable(modelo3);
		scrollPane_1.setViewportView(table3);
		
		
		Object[] alcance2 = tablaDeSimbolos.print("alc").toArray();
		Object[] tipo2 = tablaDeSimbolos.print("tipo").toArray();
		Object[] posicion2 = tablaDeSimbolos.print("pos").toArray();
		Object[] nombre2 = tablaDeSimbolos.print("nom").toArray();
		Object[] valor2 = tablaDeSimbolos.print("val").toArray();
		
		((DefaultTableModel) table3.getModel()).addColumn("Alcance", alcance2);
		((DefaultTableModel) table3.getModel()).addColumn("Tipo", tipo2);
		((DefaultTableModel) table3.getModel()).addColumn("Posicion", posicion2);
		((DefaultTableModel) table3.getModel()).addColumn("Nombre", nombre2);
		((DefaultTableModel) table3.getModel()).addColumn("Valor", valor2);
		
		
		
		
		
        
        
        
    }
    public grafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(30, 40, 1300, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		
		
		JLabel lblCompiladorAutomatasIi = new JLabel("Compilador Automatas II");
		lblCompiladorAutomatasIi.setFont(new Font("Arial", Font.BOLD, 35));
		lblCompiladorAutomatasIi.setForeground(Color.BLACK);
		lblCompiladorAutomatasIi.setBounds(435, 10, 410, 50);
		frame.getContentPane().add(lblCompiladorAutomatasIi);
		
		JLabel lblTablaDeSimbolos = new JLabel("Tabla de simbolos inicial");
		lblTablaDeSimbolos.setFont(new Font("Arial", Font.BOLD, 25));
		lblTablaDeSimbolos.setBounds(95, 130, 300, 30);
		frame.getContentPane().add(lblTablaDeSimbolos);
		
		JLabel lblTablaDeSimbolos_1 = new JLabel("Tabla de simbolos final");
		lblTablaDeSimbolos_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblTablaDeSimbolos_1.setBounds(890, 130, 300, 30);
		frame.getContentPane().add(lblTablaDeSimbolos_1);
		
		
		JLabel lblExpresiones = new JLabel("Expresiones");
		lblExpresiones.setFont(new Font("Arial", Font.BOLD, 25));
		lblExpresiones.setBounds(568, 130, 150, 30);
		frame.getContentPane().add(lblExpresiones);
		
		String[] alc = {"publica","protec","reservada","a","b","c","d","e","g","j","h","j","m","l","p","u","y","k"};
		  
		//ALalc.add(tablaDeSimbolos.print().get(0));
		
		
		 
		
		 //((DefaultTableModel) table2.getModel()).addColumn("Alcance", array);
		 
	        //((DefaultTableModel) table3.getModel()).addColumn("Alcance", alcance);
			//((DefaultTableModel) table3.getModel()).addColumn("Tipo", tipo);
			//((DefaultTableModel) table3.getModel()).addColumn("Posicion", posicion);
			//((DefaultTableModel) table3.getModel()).addColumn("Nombre", nombre);
			//((DefaultTableModel) table3.getModel()).addColumn("Valor", valor);
	
	}

}


