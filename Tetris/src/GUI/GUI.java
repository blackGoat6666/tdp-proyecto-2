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
		
		JLabel lbl00 = new JLabel("");
		lbl00.setBounds(2, 1, 28, 28);
		lbl00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl00);
		
		JLabel lbl01 = new JLabel("");
		lbl01.setBounds(2, 29, 28, 28);
		lbl01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl01);
		
		JLabel lbl02 = new JLabel("");
		lbl02.setBounds(2, 57, 28, 28);
		lbl02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl02);
		
		JLabel lbl03 = new JLabel("");
		lbl03.setBounds(2, 85, 28, 28);
		lbl03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl03);
		
		JLabel lbl04 = new JLabel("");
		lbl04.setBounds(2, 113, 28, 28);
		lbl04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl04);
		
		JLabel lbl05 = new JLabel("");
		lbl05.setBounds(2, 141, 28, 28);
		lbl05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl05);
		
		JLabel lbl06 = new JLabel("");
		lbl06.setBounds(2, 140, 28, 28);
		lbl06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl06);
		
		JLabel lbl07 = new JLabel("");
		lbl07.setBounds(2, 168, 28, 28);
		lbl07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BloqueAmarillo.png")));
		panelGrilla.add(lbl07);
		
		JLabel lbl08 = new JLabel("");
		lbl08.setBounds(2, 196, 28, 28);
		panelGrilla.add(lbl08);
		
		JLabel lbl09 = new JLabel("");
		lbl09.setBounds(2, 224, 28, 28);
		panelGrilla.add(lbl09);
		
		JLabel lbl010 = new JLabel("");
		lbl010.setBounds(2, 252, 28, 28);
		panelGrilla.add(lbl010);
		
		JLabel lbl011 = new JLabel("");
		lbl011.setBounds(2, 280, 28, 28);
		panelGrilla.add(lbl011);
		
		JLabel lbl012 = new JLabel("");
		lbl012.setBounds(2, 308, 28, 28);
		panelGrilla.add(lbl012);
		
		JLabel lbl013 = new JLabel("");
		lbl013.setBounds(2, 336, 28, 28);
		panelGrilla.add(lbl013);
		
		JLabel lbl014 = new JLabel("");
		lbl014.setBounds(2, 364, 28, 28);
		panelGrilla.add(lbl014);
		
		JLabel lbl015 = new JLabel("");
		lbl015.setBounds(2, 392, 28, 28);
		panelGrilla.add(lbl015);
		
		JLabel lbl016 = new JLabel("");
		lbl016.setBounds(2, 420, 28, 28);
		panelGrilla.add(lbl016);
		
		JLabel lbl017 = new JLabel("");
		lbl017.setBounds(2, 448, 28, 28);
		panelGrilla.add(lbl017);
		
		JLabel lbl018 = new JLabel("");
		lbl018.setBounds(2, 476, 28, 28);
		panelGrilla.add(lbl018);
		
		JLabel lbl019 = new JLabel("");
		lbl019.setBounds(2, 504, 28, 28);
		panelGrilla.add(lbl019);
		
		JLabel lbl020 = new JLabel("");
		lbl020.setBounds(2, 532, 28, 28);
		panelGrilla.add(lbl020);
		
		JLabel lbl021 = new JLabel("");
		lbl021.setBounds(2, 560, 28, 28);
		panelGrilla.add(lbl021);
		
		
		JLabel lbl10 = new JLabel("");
		lbl10.setBounds(30, 1, 28, 28);
		panelGrilla.add(lbl10);
		
		JLabel lbl11 = new JLabel("");
		lbl11.setBounds(30, 29, 28, 28);
		panelGrilla.add(lbl11);
		
		JLabel lbl12 = new JLabel("");
		lbl12.setBounds(30, 57, 28, 28);
		panelGrilla.add(lbl12);
		
		JLabel lbl13 = new JLabel("");
		lbl13.setBounds(30, 85, 28, 28);
		panelGrilla.add(lbl13);
		
		JLabel lbl14 = new JLabel("");
		lbl14.setBounds(30, 113, 28, 28);
		panelGrilla.add(lbl14);
		
		JLabel lbl15 = new JLabel("");
		lbl15.setBounds(30, 141, 28, 28);
		panelGrilla.add(lbl15);
		
		JLabel lbl16 = new JLabel("");
		lbl16.setBounds(30, 140, 28, 28);
		panelGrilla.add(lbl16);
		
		JLabel lbl17 = new JLabel("");
		lbl17.setBounds(30, 168, 28, 28);
		panelGrilla.add(lbl17);
		
		JLabel lbl18 = new JLabel("");
		lbl18.setBounds(30, 196, 28, 28);
		panelGrilla.add(lbl18);
		
		JLabel lbl19 = new JLabel("");
		lbl19.setBounds(30, 224, 28, 28);
		panelGrilla.add(lbl19);
		
		JLabel lbl110 = new JLabel("");
		lbl110.setBounds(30, 252, 28, 28);
		panelGrilla.add(lbl110);
		
		JLabel lbl111 = new JLabel("");
		lbl111.setBounds(30, 280, 28, 28);
		panelGrilla.add(lbl111);
		
		JLabel lbl112 = new JLabel("");
		lbl112.setBounds(30, 308, 28, 28);
		panelGrilla.add(lbl112);
		
		JLabel lbl113 = new JLabel("");
		lbl113.setBounds(30, 336, 28, 28);
		panelGrilla.add(lbl113);
		
		JLabel lbl114 = new JLabel("");
		lbl114.setBounds(30, 364, 28, 28);
		panelGrilla.add(lbl114);
		
		JLabel lbl115 = new JLabel("");
		lbl115.setBounds(30, 392, 28, 28);
		panelGrilla.add(lbl115);
		
		JLabel lbl116 = new JLabel("");
		lbl116.setBounds(30, 420, 28, 28);
		panelGrilla.add(lbl116);
		
		JLabel lbl117 = new JLabel("");
		lbl117.setBounds(30, 448, 28, 28);
		panelGrilla.add(lbl117);
		
		JLabel lbl118 = new JLabel("");
		lbl118.setBounds(30, 476, 28, 28);
		panelGrilla.add(lbl118);
		
		JLabel lbl119 = new JLabel("");
		lbl119.setBounds(30, 504, 28, 28);
		panelGrilla.add(lbl119);
		
		JLabel lbl120 = new JLabel("");
		lbl120.setBounds(30, 532, 28, 28);
		panelGrilla.add(lbl120);
		
		JLabel lbl121 = new JLabel("");
		lbl121.setBounds(30, 560, 28, 28);
		panelGrilla.add(lbl121);
		
		
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