package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import ValidacaoDeDados.ValidaCPF;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class cadastromedico extends JFrame {

	private JPanel contentPane;
	private JTextField nomemed;
	private JTextField cpfmed;
	private JTextField rgmed;
	private JTextField crmmed;
	private JTextField datamed;
	private JTextField ruamed;
	private JTextField cepmed;
	private JTextField numeromed;
	private JTextField complementomed;
	private JTextField bairromed;
	private JTable table;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ResultSet  rsmed = null;
	ResultSet sr = null;
	ResultSet srmed = null;
	ResultSet rsdel = null;
	ResultSet rs1 = null;
	String sql = null;
	Connection conexao1 = null;
	private DefaultTableModel model;
	String CPF;
	char[] sexo;
	private JTextField cpfdel;
	private JTextField especialidadesmed;
	private JTextField contatomed;
	JComboBox comboBox = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastromedico frame = new cadastromedico();
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
	public cadastromedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\logoprog.png"));
		setTitle("Cadastro M\u00E9dico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 741);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 105, 225));
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCpf = new JLabel("CPF:");
		
		JLabel lblRg = new JLabel("RG:");
		
		JLabel lblCrm = new JLabel("CRM:");
		
		JLabel lblSituao = new JLabel("Data de Nascimento:");
		
		JLabel lblTipodeContato = new JLabel(" Contato:");
		
		JLabel lblEspecialidades = new JLabel("Especialidades:");
		
		nomemed = new JTextField();
		nomemed.setColumns(10);
		
		cpfmed = new JTextField(1);
	
				
				
				
			
				
	
		cpfmed.setColumns(10);
		
		rgmed = new JTextField();
		rgmed.setColumns(10);
		
		crmmed = new JTextField();
		crmmed.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\lolo.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			//VALIDAÇÃO DE CPF CHAMANDO DA CLASSE VALIDAÇÃO DE CPF                                                                 
		CPF =cpfmed.getText();
			
				// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
					if (ValidaCPF.isCPF(CPF) == true){	
			//CADASTRAR AQUI COMEÇA A PARTE DE CADASTRO DOS DADOS DO PACIENTE
// A CONEXÃO É FEITA ATRAVES DO DRIVERMANEGER QUE FAZ A PONTE DO BD COM O ECLIPSE
				try {
					//É CHAMADO DA CLASSE CONEXÃO
				 conexao paciente = new conexao();
					paciente.getConnection();
						Connection conexao1;
						// A CONEXÃO É FEITA ATRAVES DO DRIVERMANEGER QUE FAZ A PONTE DO BD COM O ECLIPSE	
					conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
//É CRIADA UMA VARIAVEL PARA CONTER A FUNÇÃO DE INSERIR NO BANCO DE DADOS
			   String Query = " INSERT INTO medicos(nome, cpf, rg, crm,data_nasc, sexo, especialidades,  rua,cep,numero,complemento, bairro, contato) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//COM O PREPAREDsTATEMENT QUE É UM RECURSO USADO PARA EXECUTAR AS MESMAS INSTRUÇOES DO BANCO DE DADOS E NELA É COLOCADA A CONEXÇÃO E DPS A QUERY QUE CONTEM O COMANDO SQL
			   PreparedStatement stmt = (PreparedStatement) conexao1.prepareStatement(Query);
			   // AQUI SÃO OS CAMPOS EXISTENTES NO DESIGN E OS NUMEROS ESTÃO NA ORDEM DOS ? DE CIMA OUSEJA ELES VÃO INSERIR EXATAMENTE NO NUEMERO DO SEU PARAMETRO
			          stmt.setString(1,nomemed.getText());
			          stmt.setString(2,cpfmed.getText()); 
			            stmt.setString(3,rgmed.getText());
			            stmt.setString(4,crmmed.getText()); 
			            stmt.setString(5,datamed.getText());
			            stmt.setString(6,comboBox.getSelectedItem().toString());    
			            stmt.setString(7,especialidadesmed.getText()); 
			            stmt.setString(8,ruamed.getText()); 
			            stmt.setString(9,cepmed.getText());
			            stmt.setString(10,numeromed.getText());
			            stmt.setString(11,complementomed.getText()); 
			            stmt.setString(12,bairromed.getText());
			            stmt.setString(13,contatomed.getText());
		       //SE O CADASTRO FOI UM SUCESSO APARECE UM MENSAGEM DE DADOS INSERIDOS COM SUCESSO
	JOptionPane.showMessageDialog(null," dados inseridos com sucesso");
           	// SÃO FECHADA AS FUNÇOES ABERTAS
			    stmt.executeUpdate();
			    stmt.close();
			    conexao1.close();
			              //CASO DE EERRO NA INSERCÇÃO DO BANCO DE DADOS IRA APARECER UMA MENSAGEM DE ERRO MAIS OQ NO SQL ESTA ERRADO
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "erro" + ex.toString());
// ISSO TUDO DE CIMA SÓ ACONTECEU SE O CPF FOI CORRETO, SE NÃO ELE CONTORNA TUDO ISSO E VAI AQUI PRA BAIXO ONDE APARECERA UMA MENSAGEM DE CPF INVALIDO,NÃO FAZENDO O CADASTRO
				}}else{
		        	JOptionPane.showMessageDialog(null, "CPF inválido!");
					}
					
					
				try {
					conexao1 = conexao.getConnnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				sql = "select * from medicos";
				
				//aqui comeca a parte de pupular tabela dentro do botão castrara onde ao clicar em cadatrar
				//primeiro ocorrerá o cadastro e logo a pos a tabela sera preenchida
				try {
					ps = (PreparedStatement) conexao1.prepareStatement(sql);
				rs = ps.executeQuery(sql);
				
				//o defaultTaleModel serve para digamos fazer a ponto da tabela ao dados 
				DefaultTableModel modelo = (DefaultTableModel)table.getModel();
				modelo.setNumRows(0);
					
	while(rs.next())	{
		
		modelo.addRow(new Object[]{
				
		            // pegando valores do bd para colocar na tabela.
	                 rs.getString("idmedicos"), rs.getString("nome"), rs.getString("data_nasc"),rs.getString("cpf"), rs.getString("rg"), rs.getString("crm"), rs.getString("sexo") 
		               });	
	
		
		
		        
			
				
				
				
				
		
		}
	
	          	
			
	
			
			} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						//fechando todas as funçoes abertas.
						conexao1.close();
						ps.close();
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCadastrar.setBackground(new Color(102, 204, 153));
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnCadastrar.setForeground(new Color(0, 0, 0));
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\Sem T\u00EDtulo-2.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				cadastro obj = new cadastro();
			     obj.setVisible(true);
			     dispose();
			}
		});
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\gggg.png"));
		btnFechar.setForeground(Color.GRAY);
		btnFechar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
					 System.exit(0);
					 }
		});
		
		JLabel lblSexo = new JLabel("Sexo: ");
		
		datamed = new JTextField();
		datamed.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//limpando taela colocando seu valor como vazio
				nomemed.setText("");
				cpfmed.setText("");
				rgmed.setText("");
				crmmed.setText("");
				datamed.setText("");
				especialidadesmed.setText("");
				ruamed.setText("");
				cepmed.setText("");
				numeromed.setText("");
				complementomed.setText("");
				bairromed.setText("");
				contatomed.setText("");
			
			
				//tfdtelefonepessoalmed.setText("");
				//tfdtelefonecomercialmed.setText("");
			
			}
		});
		
		Connection con = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		JPanel panel1 = new JPanel();
		panel1.setBackground(SystemColor.textHighlight);
		
	
		
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	
		
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		
	
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblrua = new JLabel("Rua:");
		
		JLabel lblcep = new JLabel("CEP:");
		
		JLabel lblnumero = new JLabel("N\u00FAmero:");
		
		JLabel lblcomplemento = new JLabel("Complemento:");
		
		ruamed = new JTextField();
		ruamed.setColumns(10);
		
		cepmed = new JTextField();
		cepmed.setColumns(10);
		
		numeromed = new JTextField();
		numeromed.setColumns(10);
		
		complementomed = new JTextField();
		complementomed.setColumns(10);
		
		JLabel lblbairro = new JLabel("Bairro:");
		
		bairromed = new JTextField();
		bairromed.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
	
	cpfdel = new JTextField();
	cpfdel.setColumns(10);
	
	JLabel lblDigiteOId = new JLabel("Digite CPF:");
	
	JButton btnAtualizar = new JButton("Atualizar");
	btnAtualizar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			
			
			
// AQUI COMEÇA A FUNÇÃO PARA PUPULAR TABELA DO CADASTRO MÉDICO
			try {    // É FEITA A CONEXÃO
				conexao1 = conexao.getConnnection();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}// UMA VARIAVEL PARA CONTER O COMANDO SQL É CRIADA
			sql = "select * from medicos";
		try { // A VARIAVEL ENTÃO CHAMADA PS IRA CONTER A CONEXÃO E O COMANDO OU SEJA, TODO OS DADOS DA TABELA DO MEDICO
				ps = (PreparedStatement) conexao1.prepareStatement(sql);
				// MANDEI ELE EXECUTAR O O COMANDO QUERY NO SQL
			rsmed = ps.executeQuery(sql);
			// UMA VARIAVEL JA CRIADA LÁ EM CIMA É CRIADA DO TIPO DEFAULT TABLE MODEL , TABLEMODEL É A INTERFACE QUE REPRESENTA O MODEL DA JTable.
			 model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
				
while(rsmed.next())	{
	
	model.addRow(new Object[]{
 // AQUI COM A VARIAVEL RSMED CRIADA ALI EM CIMA COM A FUNÇÃO SQL, AQUI ELA ATUA PARA CHAMAR EXATAMENTE OS CAMPOS QUE ESTÃO EM "" DA TABELA. E COLOCAR NA TABEL EXATAMENTE NA ORDEM
                 rsmed.getString("idmedicos"), rsmed.getString("nome"), rsmed.getString("data_nasc"),rsmed.getString("cpf"), rsmed.getString("rg"), rsmed.getString("crm"), rsmed.getString("sexo") 
                 ,rsmed.getString("fk_endereco_med"),rsmed.getString("fk_contatos_med")  });	
}	// adiconando coluna
	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {// AS FUNÇOES SÃO FECHADAS
					conexao1.close();
					ps.close();
					rsmed.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
				
				
			}
		});
			
			JButton btnNewButton_2 = new JButton("EXCLUIR");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
			}
		});
		
		especialidadesmed = new JTextField();
		especialidadesmed.setColumns(10);
		
		contatomed = new JTextField();
		contatomed.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(204, 0, 102));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//AQUI COMECA A PARTE PARA DELETAR DADOS DA TABELA PELO BOTÃO ESXCLUIR ATRAVES DO CPF	
				try {// INICIANDO VARIAVEIS PARA CONEXÃO
					 conexao paciente = new conexao();
						paciente.getConnection();
							Connection conexao1;
							//COM A VAIRIAVEL CONEXÃO UM É O DIRETORIO DA MINHA BASE DE DADOS
						conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
	
						//COM A STRIG QUERY QUE CONTERA A O COMANDODE DELETAR DADO DADOS X DA TABELA MEDICO ATRAVES DO CPF PELO PARAMETRO QUE SERA DIGITIO NO TEXTFIELD CPFDEL
				   String Query = " DELETE FROM medicos where cpf=?";
					
				   //COM O PREPAREDsTATEMENT QUE SERVA PARA EXECUTAR FUNÇIE DO SQL É FEITA A CONEÇÃO COM A VARIAVEL CONEXÃO1 E LOGO DPS O COMANDO SQL ATRAVES DA VARIAVEL QUERY 
				   PreparedStatement stmt = (PreparedStatement) conexao1.prepareStatement(Query);
				   // ALI EM CIMA TEM NO CPF UM ? ESSE ? SERA O TEXTFIELD CPFMED QUE SERAMLIDO AQUI EM BAIXO E LOGO EXLUIDO O DADO DA TABELA SE TIVER UM CPF IGUAL O DIGITADO 
				          stmt.setString(1,cpfdel.getText());
				             
				          
				            
				      
				       
				            //SE O DELETE DER CERTO UM MENSAGEM DE DADOS DELETADOS COM SUCESSO
				
				JOptionPane.showMessageDialog(null," dados deletados com sucesso");
				    stmt.executeUpdate();
				    stmt.close();
				    conexao1.close();
				    //CASO O DELETE DE ERRADO UMA MESNAGEM DE ERRO MAIS OQ DE ERRADO NO SQL ESTÃ ACONTECENDO 
					}catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "erro" + ex.toString());
					}
					try {
						conexao1 = conexao.getConnnection();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					sql = "select * from medicos";
					
					//aqui comeca a parte de pupular tabela dentro do botão castrara onde ao clicar em cadatrar
					//primeiro ocorrerá o cadastro e logo a pos a tabela sera preenchida
					try {
						ps = (PreparedStatement) conexao1.prepareStatement(sql);
					rsdel = ps.executeQuery(sql);
					
					//o defaultTaleModel serve para digamos fazer a ponto da tabela ao dados 
					DefaultTableModel modelo = (DefaultTableModel)table.getModel();
					modelo.setNumRows(0);
						
		while(rsdel.next())	{
			
			modelo.addRow(new Object[]{
					
			            // pegando valores do bd para colocar na tabela.
		                 rsdel.getString("idmedicos"), rsdel.getString("nome"), rsdel.getString("data_nasc"),rsdel.getString("cpf"), rsdel.getString("rg"), rsdel.getString("crm"), rsdel.getString("sexo") 
			               });	
}
		} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						try {
							//fechando todas as funçoes abertas.
							conexao1.close();
							ps.close();
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
}
		});
		
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
							.addGap(10))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(58, Short.MAX_VALUE)
							.addComponent(lblDigiteOId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpfdel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(31)
							.addComponent(btnFechar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCpf)
												.addComponent(lblNome)
												.addComponent(lblRg)
												.addComponent(lblCrm)
												.addComponent(lblSituao)
												.addComponent(lblSexo))
											.addGap(23)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cpfmed, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
												.addComponent(rgmed, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
												.addComponent(nomemed, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
												.addComponent(crmmed, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
												.addComponent(datamed, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblEspecialidades)
												.addComponent(lblrua)
												.addComponent(lblcep)
												.addComponent(lblnumero)
												.addComponent(lblcomplemento)
												.addComponent(lblbairro)
												.addComponent(lblTipodeContato)))
										.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(especialidadesmed)
											.addComponent(ruamed, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
										.addComponent(cepmed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(numeromed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(complementomed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(bairromed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnAtualizar)
												.addComponent(contatomed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
											.addComponent(btnLimpar)))))))
					.addGap(49))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nomemed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome)
								.addComponent(lblEspecialidades)
								.addComponent(especialidadesmed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cpfmed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(ruamed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblrua))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(rgmed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cepmed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblcep)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCpf)
									.addGap(18)
									.addComponent(lblRg)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(numeromed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblnumero))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(complementomed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblcomplemento))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(bairromed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblbairro)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(crmmed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCrm))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(datamed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSituao))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSexo)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipodeContato)
								.addComponent(contatomed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(6))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAtualizar)
							.addComponent(btnLimpar)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDigiteOId)
						.addComponent(cpfdel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir)
						.addComponent(btnFechar)
						.addComponent(btnNewButton))
					.addGap(29))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Data de Nascimento", "CPF", "RG", "CRM", "Sexo", "Endere\u00E7o", "Contatos"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\logopanel.png"));
		panel.add(label);
		contentPane.setLayout(gl_contentPane);
	}
}
