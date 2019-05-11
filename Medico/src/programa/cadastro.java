package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class cadastro extends JFrame { 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro frame = new cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\logoprog.png"));
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 455);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setForeground(new Color(112, 128, 144));
		btnFechar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnFechar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\cancel_96921.png"));
		btnFechar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				 System.exit(0);
			
			}
		});
		
		JButton btnCadastroPaciente = new JButton("Cadastro Paciente");
		btnCadastroPaciente.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\medical-29_icon-icons.com_73943.png"));
		btnCadastroPaciente.setBackground(UIManager.getColor("Button.background"));
		btnCadastroPaciente.setForeground(new Color(0, 0, 0));
		btnCadastroPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cadastropaciente obj = new cadastropaciente();
			     obj.setVisible(true);
			     dispose();
			     
			}
		});
		
		JButton btnAgendaConsultas = new JButton("Agenda Consultas");
		btnAgendaConsultas.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\medical-11_icon-icons.com_73929.png"));
		btnAgendaConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			agendaconsultas obj = new agendaconsultas();
			     obj.setVisible(true);
			     dispose();
			}
		});
		
		JButton btnCadastroMdico = new JButton("Cadastro M\u00E9dico");
		btnCadastroMdico.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\medical-29_icon-icons.com_73943.png"));
		btnCadastroMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				cadastromedico obj = new cadastromedico();
			     obj.setVisible(true);
			     dispose();
				
			}
		
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setForeground(new Color(100, 149, 237));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 105, 225));
		
		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\medical-22_icon-icons.com_73922.png"));
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				relatorio obj = new relatorio();
			     obj.setVisible(true);
			     dispose();
				
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(267))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(274)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRelatrio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(btnAgendaConsultas, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 121, Short.MAX_VALUE)
						.addComponent(btnCadastroMdico, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(btnCadastroPaciente, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addGap(226))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCadastroPaciente, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAgendaConsultas, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnCadastroMdico, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnRelatrio, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
					.addGap(28))
		);
		
		JLabel lblEmed = new JLabel("");
		lblEmed.setIcon(new ImageIcon("D:\\logopanel.png"));
		lblEmed.setForeground(new Color(0, 0, 139));
		lblEmed.setFont(new Font("Terminator Two", Font.PLAIN, 33));
		panel.add(lblEmed);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblEmed}));
		contentPane.setLayout(gl_contentPane);
	}
}
