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

import Logica.Logica;
import Timer.Timer;

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
    private JLabel lblpuntuacionModificable;
    Thread tiempo;
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
        lblpuntuacionModificable = new JLabel("0000000\r\n");
        lblpuntuacionModificable.setFont(new Font("Bauhaus 93", Font.PLAIN, 50));
        lblpuntuacionModificable.setForeground(new Color(255, 255, 255));
        lblpuntuacionModificable.setBackground(new Color(255, 255, 255));
        lblpuntuacionModificable.setBounds(27, 66, 234, 58);
        miLogica = new Logica(lblTiempoTranscurrido,lblpuntuacionModificable);
        initialize();
        tiempo=new Thread(miLogica.getTimer());
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
		
		
		JLabel lblproxTetrimino = new JLabel("Proximo Tetrimino");
		lblproxTetrimino.setForeground(new Color(255, 255, 255));
		lblproxTetrimino.setFont(new Font("Bauhaus 93", Font.PLAIN, 33));
		lblproxTetrimino.setBounds(26, 506, 271, 44);
		panelFondo.add(lblproxTetrimino);
		
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
		
		JLabel lblpuntuacionModificable = new JLabel("0000000\r\n");
		lblpuntuacionModificable.setFont(new Font("Bauhaus 93", Font.PLAIN, 50));
		lblpuntuacionModificable.setForeground(new Color(255, 255, 255));
		lblpuntuacionModificable.setBackground(new Color(255, 255, 255));
		lblpuntuacionModificable.setBounds(27, 66, 234, 58);
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
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setForeground(new Color(255, 255, 255));
		btnJugar.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		btnJugar.setBounds(624, 71, 133, 64);
		btnJugar.setBackground(new Color(20, 10, 30));
		panelFondo.add(btnJugar);
		
		btnJugar.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
		    comenzarJuego();
		    btnJugar.setEnabled(false);
		  }
		  private void comenzarJuego() {
		    miLogica.comenzarJuego();  
		    tiempo.start();
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
		
		JLabel labels[][] = new JLabel[10][21];
        for (int i =  0; i < 10; i++) {
            for (int j =  0; j < 21; j++) {
                labels[i][j] = new JLabel("Label" + i+ j);
                labels[i][j].setBounds(2+28*i, 1+28*j, 28, 28);
                labels[i][j].setText(null);
                panelGrilla.add(labels[i][j]);
            }
         }
		
		/*for (int i = 2; i <10; i++) {
			for (int j= 0; j < 21; j++) {
				//String label = "lbl"+ String.valueOf(i)+ String.valueOf(j);
				JLabel "lbl"+ String.valueOf(i)+ String.valueOf(j) = new JLabel("");
			}
		}*/
		// manejar eventos
		frmTetris.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode () == KeyEvent.VK_UP) {
					miLogica.girarTetrimino();
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					miLogica.moverTetIzq();
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					miLogica.moverTetDer();
				}
			}
		});
	}
	public void setLabelTiempo(String tiempo) {
	  lblTiempoTranscurrido.setText(tiempo);
	}
}