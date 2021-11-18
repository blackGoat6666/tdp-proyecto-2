package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyListener;
import Logica.Logica;
import Tetrimino.PiezaI;
import Tetrimino.PiezaJ;
import Tetrimino.PiezaL;
import Tetrimino.PiezaO;
import Tetrimino.PiezaS;
import Tetrimino.PiezaT;
import Tetrimino.PiezaZ;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;


public class GUI {
	
	private JFrame frmTetris;
	private Logica miLogica;
	private JLabel lblTiempoTranscurrido;
	private JLabel lblGameOver;
	JLabel labels[][] = new JLabel[21][10];
	private JLabel lblpuntuacionModificable;
	Thread tiempo;
	private JButton btnJugar;
	private JLabel lblProximoTetriminoImagen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmTetris.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
	    lblTiempoTranscurrido= new JLabel("00:00");
	    lblTiempoTranscurrido.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoTranscurrido.setForeground(new Color(255, 255, 255));
		lblTiempoTranscurrido.setFont(new Font("Dialog", Font.PLAIN, 26));
		lblTiempoTranscurrido.setBounds(10, 43, 144, 34);
		lblpuntuacionModificable = new JLabel("");
		lblpuntuacionModificable.setFont(new Font("Bauhaus 93", Font.PLAIN, 50));
		lblpuntuacionModificable.setForeground(new Color(255, 255, 255));
		lblpuntuacionModificable.setBackground(new Color(255, 255, 255));
		lblpuntuacionModificable.setBounds(27, 66, 234, 58);
		lblProximoTetriminoImagen = new JLabel("");
		lblGameOver = new JLabel("");
		lblGameOver.setBounds(-39, 209, 410, 311);
		btnJugar = new JButton("Jugar");
		btnJugar.setForeground(new Color(255, 255, 255));
		btnJugar.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		btnJugar.setBounds(624, 71, 133, 64);
		btnJugar.setBackground(new Color(20, 10, 30));
		miLogica = new Logica(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTetris = new JFrame();
		frmTetris.setTitle("TETRIS");
		frmTetris.setResizable(false);
		frmTetris.getContentPane().setBackground(new Color(30,00,15));
		
		JPanel panelFondo = new Panel("/Images/fondo0.jpg");
		panelFondo.setBounds(0, 0, 784, 660);
		Border borde = new MatteBorder(10,10,10,10,new Color (10, 10, 10));
		frmTetris.getContentPane().setLayout(null);
		panelFondo.setBorder(borde);
		frmTetris.getContentPane().add(panelFondo);
		panelFondo.setLayout(null);
		
		
		panelFondo.add(lblGameOver);
		lblGameOver.setVisible(false);
		lblGameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gameOver.png")));
		
		lblProximoTetriminoImagen.setBounds(90, 330, 135, 110);
		panelFondo.add(lblProximoTetriminoImagen);
		
		
		JLabel lblproxTetrimino = new JLabel("Proximo Tetrimino");
		lblproxTetrimino.setForeground(new Color(255, 255, 255));
		lblproxTetrimino.setFont(new Font("Bauhaus 93", Font.PLAIN, 33));
		lblproxTetrimino.setBounds(26, 506, 271, 44);
		panelFondo.add(lblproxTetrimino);
		lblproxTetrimino.setVisible(false);
		
		JPanel panelPuntuacion = new JPanel();
		panelPuntuacion.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panelPuntuacion.setBackground(new Color(20, 10, 30));
		panelPuntuacion.setBounds(26, 25, 271, 148);
		panelFondo.add(panelPuntuacion);
		panelPuntuacion.setLayout(null);
		
		JLabel lblpuntuacion = new JLabel("Puntuaci\u00F3n");
		lblpuntuacion.setForeground(new Color(255, 255, 204));
		lblpuntuacion.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		lblpuntuacion.setBounds(36, 11, 189, 44);
		panelPuntuacion.add(lblpuntuacion);
		
		
		panelPuntuacion.add(lblpuntuacionModificable);
		
		Panel panelGrilla = new Panel("/Images/grilla.png");
		panelGrilla.setBackground(new Color(75, 35, 90));
		panelGrilla.setBounds(320, 25, 280, 588);
		panelGrilla.setBorder(new MatteBorder(5,5,5,5,new Color(20, 10, 30)) );
		panelFondo.add(panelGrilla);
		panelGrilla.setLayout(null);
		
		JLabel lblTetriminoFondo = new JLabel("");
		lblTetriminoFondo.setBounds(10, 239, 317, 311);
		lblTetriminoFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/proxTetrimno.png"))); 
		panelFondo.add(lblTetriminoFondo);
		panelFondo.add(btnJugar);
		
		btnJugar.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
		    comenzarJuego();
		  }
		  private void comenzarJuego() {
		    miLogica.comenzarJuego();  
		    btnJugar.setEnabled(false);
		    tiempo= new Thread(miLogica.getTimer());
		    tiempo.start();
		    lblGameOver.setVisible(false);
		    lblproxTetrimino.setVisible(true);
		  }
		});
		
		Image icon = new ImageIcon(getClass().getResource("/Images/Icono.png")).getImage();
		frmTetris.setIconImage(icon);
		
		frmTetris.setBounds(100, 100, 800, 700);
		frmTetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTetris.setBackground(new Color(0, 20, 10));
		
		JPanel panelTiempo = new JPanel();
		panelTiempo.setBackground(Color.BLACK);
		panelTiempo.setBounds(610, 549, 164, 88);
		panelFondo.add(panelTiempo);
		panelTiempo.setLayout(null);
		
		JLabel lblTiempo= new JLabel("Tiempo");
		lblTiempo.setBounds(38, 5, 87, 34);
		lblTiempo.setForeground(new Color(255, 255, 224));
		lblTiempo.setFont(new Font("Dialog", Font.PLAIN, 26));
		panelTiempo.add(lblTiempo);
		
		panelTiempo.add(lblTiempoTranscurrido);
		
	
		
		
		
		
		
		//labels de la grilla
		
		for (int filas =0; filas < 21; filas++){
	    	for (int columna =0; columna < 10; columna++) {
	    		labels[filas][columna] = new JLabel("Label" +filas+ columna);
	    		labels[filas][columna].setBounds(1+28*columna, 2+28*filas , 28, 28);
	    		labels[filas][columna].setText(null);
	    		panelGrilla.add(labels[filas][columna]);
	    	}
	    }
		// manejar eventos
		frmTetris.setFocusable(true);
		frmTetris.addKeyListener(new KeyListener() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	        	int presiona=e.getKeyCode();
	        	switch (presiona) 
	            {
	      	        case KeyEvent.VK_UP:  miLogica.girarTetrimino();
	      	                 break;
	                case KeyEvent.VK_LEFT:  miLogica.moverTetIzq();
	                         break;
	                case KeyEvent.VK_RIGHT: miLogica.moverTetDer();
	                         break;
	                case KeyEvent.VK_DOWN: miLogica.moverTetAbajo();
	                         break;
	               
	            }
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
	        }
	    });
		
		
	}
	public void setLabelTiempo(String tiempo) {
		lblTiempoTranscurrido.setText(tiempo);
	}
	public void setLabelPuntuacion(String puntuacion) {
		lblpuntuacionModificable.setText(puntuacion);
	}
	public void graficarBloque(ImageIcon imageIcon, int labelX, int labelY, String ruta) {
		labels[labelX][labelY].setIcon(imageIcon);
		labels[labelX][labelY].setText(ruta);
	}
	public String getColor(int x, int y) {
      return labels[x][y].getText();	
	}
	
	public void setGameOver() {
		lblGameOver.setVisible(true);
		btnJugar.setEnabled(true);
		lblProximoTetriminoImagen.setIcon(null);
	}
	public void graficarProximoTetrimino(ImageIcon imageIcon) {
		lblProximoTetriminoImagen.setIcon(imageIcon);
	}
}