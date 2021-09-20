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
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;


public class GUI {
	
	private JFrame frmTetris;

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
		
		JPanel panel = new Panel("/Images/fondo0.jpg");
		panel.setBounds(0, 0, 784, 660);
		Border borde = new MatteBorder(10,10,10,10,new Color (10, 10, 10));
		frmTetris.getContentPane().setLayout(null);
		panel.setBorder(borde);
		frmTetris.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Proximo Tetrimino");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Bauhaus 93", Font.PLAIN, 33));
		lblNewLabel_3.setBounds(26, 506, 271, 44);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel_1.setBackground(new Color(20, 10, 30));
		panel_1.setBounds(26, 25, 271, 148);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puntuaci\u00F3n");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		lblNewLabel.setBounds(36, 11, 189, 44);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("0000000\r\n");
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 50));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(27, 66, 234, 58);
		panel_1.add(lblNewLabel_1);
		
		Panel panel_2 = new Panel("/Images/grilla.png");
		panel_2.setBackground(new Color(75, 35, 90));
		panel_2.setBounds(320, 25, 280, 588);
		panel_2.setBorder(new MatteBorder(5,5,5,5,new Color(20, 10, 30)) );
		panel.add(panel_2);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 239, 317, 311);
		lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/proxTetrimno.png"))); 
		panel.add(lblNewLabel_2);
		
		Image icon = new ImageIcon(getClass().getResource("/Images/Icono.png")).getImage();
		frmTetris.setIconImage(icon);
		
		frmTetris.setBounds(100, 100, 800, 700);
		frmTetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTetris.setBackground(new Color(0, 20, 10));
	}
}
