package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JButton btnEntrar;
	private JPasswordField JPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() 
			
			
			
			{
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\logoprog.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 307);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\login_105181.png"));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			// AQUI FORÃO PRÉDEFINIDOS OS LOGINS E SENHAS NOS TEXTFIELDS
			if(textUsuario.getText().equals("admin") && JPasswordField.getText().equals("admin")) {
			// LOGO DEPOIS QUE OS DADOS FOREM INSERIDOS CORRETAMENTE ELE CHAMARA A TELA DE CADASTRO QUE É NOSSO MENU 
				cadastro obj = new cadastro();
			     obj.setVisible(true);
			     dispose();
			    
			     //CASO A SENHA OU USUARIO ESTIVEREM ERRADOS UMA MESNAGEM DE USUARIOE OU SENHAS INCORRETOS
			}else {
				JOptionPane.showMessageDialog(null,"Usuario ou Senha INCORRETOS");
			}
			
			}
			
			
		});
		btnEntrar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(102, 205, 170));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio :");
		
		JLabel lblSenha = new JLabel("Senha :");
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				inscricao obj = new inscricao();
			     obj.setVisible(true);
			     dispose();
			
			
			
			
			}
			
			
			
			
			
		});
		btnCadastrarse.setForeground(SystemColor.windowBorder);
		btnCadastrarse.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon("D:\\logopanel.png"));
		lblLogin.setForeground(new Color(51, 0, 153));
		lblLogin.setFont(new Font("Terminator Two", Font.PLAIN, 30));
		
		JPasswordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsurio)
								.addComponent(lblSenha))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(JPasswordField)
								.addComponent(textUsuario, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addGap(21))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCadastrarse, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
									.addGap(13)))
							.addGap(62))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addGap(24))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsurio)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(JPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEntrar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrarse)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
