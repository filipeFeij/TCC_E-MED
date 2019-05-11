package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import ValidacaoDeDados.ValidaCPF;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class inscricao extends JFrame {


	private JPanel contentPane;
	private JTextField usuario;
	private JTextField senha;
	private JTextField cpf;
	String CPF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscricao frame = new inscricao();
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
	public inscricao() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		
		JLabel lblLogin = new JLabel("Us\u00FAario:");
		
		senha = new JTextField();
		senha.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		
		cpf = new JTextField();
		cpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				CPF =cpf.getText();
				
				// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
					if (ValidaCPF.isCPF(CPF) == true){	
				try {
					//É CHAMADO DA CLASSE CONEXÃO
				 conexao paciente = new conexao();
					paciente.getConnection();
						Connection conexao1;
						// A CONEXÃO É FEITA ATRAVES DO DRIVERMANEGER QUE FAZ A PONTE DO BD COM O ECLIPSE	
					conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
//É CRIADA UMA VARIAVEL PARA CONTER A FUNÇÃO DE INSERIR NO BANCO DE DADOS
			   String Query = " INSERT INTO login(usuario,senha,cpf) VALUES (?,?,?)";
//COM O PREPAREDsTATEMENT QUE É UM RECURSO USADO PARA EXECUTAR AS MESMAS INSTRUÇOES DO BANCO DE DADOS E NELA É COLOCADA A CONEXÇÃO E DPS A QUERY QUE CONTEM O COMANDO SQL
			   PreparedStatement stmt = (PreparedStatement) conexao1.prepareStatement(Query);
			   // AQUI SÃO OS CAMPOS EXISTENTES NO DESIGN E OS NUMEROS ESTÃO NA ORDEM DOS ? DE CIMA OUSEJA ELES VÃO INSERIR EXATAMENTE NO NUEMERO DO SEU PARAMETRO
			          stmt.setString(1,usuario.getText());
			          stmt.setString(2,senha.getText()); 
			            stmt.setString(3,cpf.getText());
			  
		       //SE O CADASTRO FOI UM SUCESSO APARECE UM MENSAGEM DE DADOS INSERIDOS COM SUCESSO
	JOptionPane.showMessageDialog(null," Cadastro conluido!");
           	// SÃO FECHADA AS FUNÇOES ABERTAS
			    stmt.executeUpdate();
			    stmt.close();
			    conexao1.close();
			              //CASO DE EERRO NA INSERCÇÃO DO BANCO DE DADOS IRA APARECER UMA MENSAGEM DE ERRO MAIS OQ NO SQL ESTA ERRADO
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "erro" + ex.toString());
			}}else{
	        	JOptionPane.showMessageDialog(null, "CPF inválido!");
				}
			
			
			
			}
			
			
			
			
			
		});
		btnCadastrar.setBackground(new Color(102, 205, 170));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				login obj = new login();
			     obj.setVisible(true);
			     dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("    ");
		lblNewLabel.setIcon(new ImageIcon("D:\\logopanel.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLogin)
								.addComponent(lblSenha)
								.addComponent(lblCpf))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVoltar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))
					.addGap(51))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastrar)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnVoltar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
