package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StatementImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class agendaconsultas extends JFrame  {

	private static JPanel mescon;
	private JTextField horario;
	private JTable table;
	private JTextField descri;
	String datacon;
	int dia;
	int mes;
	int ano;
	JComboBox cbdia = new JComboBox();
	JComboBox mesbox = new JComboBox();
	private JTextField cpfpacdel;
	JComboBox diabox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
			public void preencheBox() {
			Object cursor;
	//	combobox.setCursor(cursor.getPredefinedcursor(cursor.HAND_CURSOR));
			
			
			}
			
			public void criarListener() {
				
			}
			
			public void modificaBox() {
				
			}
			
			public void mes() {
				
			}
			
			public void dia() {
				
			}
			public void run() {
				
			
				try {
					agendaconsultas frame = new agendaconsultas();
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
	public agendaconsultas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\logoprog.png"));
		setTitle("Agenda Consultas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 475);
		mescon = new JPanel();
		mescon.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mescon);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 105, 225));
		
		JComboBox boxpac1 = new JComboBox();
		JComboBox boxpac = new JComboBox();
		JComboBox box = new JComboBox();
		JComboBox boxloc = new JComboBox();
		JComboBox<String> anobox = new JComboBox();
		anobox.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021"}));
		
		
		//C O M B O     B O X 
		
		// DECLARAÇÃO DE VARIAS PARA USAR NOS COMBOBOX
		Connection con = null;
		java.sql.Statement st = null;
		java.sql.Statement st2 = null;
		java.sql.Statement st3 = null;
		ResultSet rs = null; 
		ResultSet rss = null; 
		ResultSet rss2 = null; 
		JPanel panel1 = new JPanel();
		panel1.setBackground(SystemColor.textHighlight);
		
	
		
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	

	
	//AQUI COMEÇA A INSERÇÃO DE DADOS NO COMBO BOX DO MÉDICO
	
	try {
		//CRIEI UMA VARIAVEL CHAMADA CON ONDE ELA VAI CONTER A CONEXÃO COM O BANCO DE DADOS, QUE ALI NO CASO TEM O DIRETÓRIO DO BANCO
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
	// DEPOIS COM UMA VARIAVEL QUE EU DACLEREI LÁ EM CIMA ANTES DA FUNÇÃO DO COMBOBOX DE MÉDICO
		// ELA É DO TIPO Statement QUE É  UMA INTERFACE UTILIZADA PARA EXECUTAR UNSTRUÇOES SQL
		st = con.createStatement();
	//AQUI NO CRIREI UMA VARIAVEL LOCA COM O NOME DE QUERY QUE CONTERA A FUNÇÃO EM MYSQ QUE DPS SERÁ MANDADO PARA O BANCO
	           String Query = " select nome from medicos;";
    //AQUI  DISSE QUE A VARIAVEL (RS) QUE É DO TIPO RESULTSET QUE SERVE PARA PARA GUARDAR DADOS VINDO DO BANCO
	           // MANDEI ELE EXECUTAR O O COMANDO QUERY NO SQL
		   rs = st.executeQuery(Query);
      while(rs.next())
{
		        	//POPULANDO O COMBOBOX COM O RS QUE TEM VALOR DA INSTRUÇÃO MANDADA AO BANCO
		        	// OU SEJA, OS DADOS QUE QUEREMOS: NOME MEDICO
		        	box.addItem(rs.getString(1));
	}
		        // COMO EU ABRI UM TRY É OBRIGATÓRIO UM CATCH, COMO UM IF E ELSE, NO CASO O MEU CATCH SERA PARA CASO DE ERRO EM ALGUMA PARTE
		        //ELE APARECERA UMA MENSAGEM DE ERRO
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"ERRO");
}finally {
	try {
	//PARA FECHAR AS FUNÇÕES QUE ABRI
			st.close();
			rs.close();
	//CASO DE ERRO AO FECHAR AS FUNÇOES A CIMA APARECERA UMA MENSAGEM NOTIFICANDO "ERRO AO FECHAR"	
		}catch(Exception e ){
   JOptionPane.showMessageDialog(null,"ERRO AO FECHAR");
			
	
	}
		panel1.add(box);
		this.getContentPane().add(panel);
		this.setVisible(true);

		
	}
	
	
	
	
	
	//AQUI COMEÇA O DÓDIGO DO COMB BOX PARA OS PACIENTES
	
	
	
	
	try {
		//CRIEI UMA VARIAVEL CHAMADA CON ONDE ELA VAI CONTER A CONEXÃO COM O BANCO DE DADOS, QUE ALI NO CASO TEM O DIRETÓRIO DO BANCO
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
		
		// DEPOIS COM UMA VARIAVEL QUE EU DACLEREI LÁ EM CIMA ANTES DA FUNÇÃO DO COMBOBOX DE MÉDICO
		// ELA É DO TIPO Statement QUE É  UMA INTERFACE UTILIZADA PARA EXECUTAR UNSTRUÇOES SQL
		st = con.createStatement();
		//AQUI NO CRIREI UMA VARIAVEL LOCA COM O NOME DE QUERY2(PQ JA EXISTE O 1)  QUE CONTERA A FUNÇÃO EM MYSQ QUE DPS SERÁ MANDADO PARA O BANCO
		
		   String Query2 = " select cpf from pacientes;";
           //AQUI  DISSE QUE A VARIAVEL (RSS) QUE É DO TIPO RESULTSET QUE SERVE PARA PARA GUARDAR DADOS VINDO DO BANCO
           // MANDEI ELE EXECUTAR O O COMANDO QUERY NO SQL
		 
		   rss = st.executeQuery(Query2);
		   
		        while(rss.next())
		        	
	{
		        	//POPULANDO O COMBOBOX COM O RS QUE TEM VALOR DA INSTRUÇÃO MANDADA AO BANCO
		        	// OU SEJA, OS DADOS QUE QUEREMOS: NOME MEDICO
		        	boxpac1.addItem(rss.getString(1));
	}
		   // COMO EU ABRI UM TRY É OBRIGATÓRIO UM CATCH, COMO UM IF E ELSE, NO CASO O MEU CATCH SERA PARA CASO DE ERRO EM ALGUMA PARTE
		        //ELE APARECERA UMA MENSAGEM DE ERRO
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"ERRO");
		
	}finally {
	
		try {
			//FECHANDO AS FUNÇOES QUE ABRI, RECONDAÇÃO DE PROFESSORES.
		
	rss.close();
		
			
	//CASO DE ERRO AO FECHAR AS FUNÇOES A CIMA APARECERA UMA MENSAGEM NOTIFICANDO "ERRO AO FECHAR"
		}catch(Exception e ){
   JOptionPane.showMessageDialog(null,"ERRO AO FECHAR");
			
	
	}
		
		try {
			//CRIEI UMA VARIAVEL CHAMADA CON ONDE ELA VAI CONTER A CONEXÃO COM O BANCO DE DADOS, QUE ALI NO CASO TEM O DIRETÓRIO DO BANCO
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
			
			// DEPOIS COM UMA VARIAVEL QUE EU DACLEREI LÁ EM CIMA ANTES DA FUNÇÃO DO COMBOBOX DE MÉDICO
			// ELA É DO TIPO Statement QUE É  UMA INTERFACE UTILIZADA PARA EXECUTAR UNSTRUÇOES SQL
			st3 = con.createStatement();
			
			//AQUI NO CRIREI UMA VARIAVEL LOCA COM O NOME DE QUERY QUE CONTERA A FUNÇÃO EM MYSQ QUE DPS SERÁ MANDADO PARA O BANCO
		           String Query3 = " select nome_clinica from clinica;";

		           //AQUI  DISSE QUE A VARIAVEL (RS) QUE É DO TIPO RESULTSET QUE SERVE PARA PARA GUARDAR DADOS VINDO DO BANCO
		           // MANDEI ELE EXECUTAR O O COMANDO QUERY NO SQL
			   rss2 = st3.executeQuery(Query3);

			   
			        while(rss2.next())
			        	
		{
			        	
						//POPULANDO O COMBOBOX COM O RS QUE TEM VALOR DA INSTRUÇÃO MANDADA AO BANCO
			        	// OU SEJA, OS DADOS QUE QUEREMOS: NOME MEDICO
			        	boxloc.addItem(rss2.getString(1));
		}
			        // COMO EU ABRI UM TRY É OBRIGATÓRIO UM CATCH, COMO UM IF E ELSE, NO CASO O MEU CATCH SERA PARA CASO DE ERRO EM ALGUMA PARTE
			        //ELE APARECERA UMA MENSAGEM DE ERRO
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ERRO");
			
		}finally {
		
			try {
				
				//PARA FECHAR AS FUNÇÕES QUE ABRI
				st3.close();
				rss2.close();
				con.close();
			
				
		//CASO DE ERRO AO FECHAR AS FUNÇOES A CIMA APARECERA UMA MENSAGEM NOTIFICANDO "ERRO AO FECHAR"	
			}catch(Exception e ){
	   JOptionPane.showMessageDialog(null,"ERRO AO FECHAR");
				
		
		}
			panel1.add(box);
			this.getContentPane().add(panel);
			this.setVisible(true);

			
		}
		
		
	

		
	}
			
		 
			

		
		JLabel lblMdico = new JLabel("M\u00E9dico:");
		
		JLabel lblPaciente = new JLabel("Paciente:");
		

		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		
		horario = new JTextField();
		horario.setColumns(10);
		
		JLabel Data = new JLabel("Data:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\lolo.png"));
		btnSalvar.setBackground(new Color(102, 205, 170));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			
				
				try {
					
				
					
					//inicia a conexão
					 conexao paciente = new conexao();
					 // chama conexão da classe conexao
						paciente.getConnection();
							Connection conexao1;
						conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
						
						
	//aqui são seleciondos os campos existentes na tabela medico onde quero cadastrar
				   String Query = " INSERT INTO consultas(dia_consul,mes_consul,ano_consul,hora_con, descricao,medico,pacienterg, local) VALUES (?,?,?,?,?,?,?,?)";
				           
	//os campos de texto existetntes na tabela são chamados e pegadas seus valores digitados para incluir no bd   
				   PreparedStatement stmt = (PreparedStatement) conexao1.prepareStatement(Query);
				   stmt.setString(1,diabox.getSelectedItem().toString());    
				          stmt.setString(2,mesbox.getSelectedItem().toString());
				          stmt.setString(3,anobox.getSelectedItem().toString());
				          stmt.setString(4,horario.getText());
		                   stmt.setString(5,descri.getText());
		                   stmt.setString(6,box.getSelectedItem().toString());
		                   stmt.setString(7,boxpac1.getSelectedItem().toString());
		                   stmt.setString(8,boxloc.getSelectedItem().toString());
				          
				          
				          
				          
				            
				      
				       
				            //ao dar tudo certo uma mensagem de notificação aparece
				
				JOptionPane.showMessageDialog(null," dados inseridos com sucesso");
				    stmt.executeUpdate();
				    stmt.close();
				    conexao1.close();
				    //caso de erro na inserção do bd aparecera o erro do sql.
					}catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "erro" + ex.toString());
					}
				
				
				
				//cadastro no historico
				
				
				try {
					
				
					
					//inicia a conexão
					 conexao paciente1 = new conexao();
					 // chama conexão da classe conexao
						paciente1.getConnection();
							Connection conexao11;
						conexao11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
						
						
	//aqui são seleciondos os campos existentes na tabela medico onde quero cadastrar
				   String Query1 = " INSERT INTO consultas_historico(dia_consul,mes_consul,ano_consul,hora_con, descricao,medico,pacienterg, local) VALUES (?,?,?,?,?,?,?,?)";
				           
	//os campos de texto existetntes na tabela são chamados e pegadas seus valores digitados para incluir no bd   
				   PreparedStatement stmt1= (PreparedStatement) conexao11.prepareStatement(Query1);
				   stmt1.setString(1,diabox.getSelectedItem().toString());    
				          stmt1.setString(2,mesbox.getSelectedItem().toString());
				          stmt1.setString(3,anobox.getSelectedItem().toString());
				          stmt1.setString(4,horario.getText());
		                   stmt1.setString(5,descri.getText());
		                   stmt1.setString(6,box.getSelectedItem().toString());
		                   stmt1.setString(7,boxpac1.getSelectedItem().toString());
		                   stmt1.setString(8,boxloc.getSelectedItem().toString());
				          
				          
				          
				          
				            
				      
				       
				            //ao dar tudo certo uma mensagem de notificação aparece
				
				JOptionPane.showMessageDialog(null," dados inseridos com sucesso");
				    stmt1.executeUpdate();
				    stmt1.close();
				    conexao11.close();
				    //caso de erro na inserção do bd aparecera o erro do sql.
					}catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "erro" + ex.toString());
					}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				Connection conexao1 = null;
				try {    // É FEITA A CONEXÃO
					conexao1 = conexao.getConnnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}// UMA VARIAVEL PARA CONTER O COMANDO SQL É CRIADA
				String sql = "select * from consultas";
			PreparedStatement ps = null;
			ResultSet rsmed = null;
			try { // A VARIAVEL ENTÃO CHAMADA PS IRA CONTER A CONEXÃO E O COMANDO OU SEJA, TODO OS DADOS DA TABELA DO MEDICO
					ps = (PreparedStatement) conexao1.prepareStatement(sql);
					// MANDEI ELE EXECUTAR O O COMANDO QUERY NO SQL
				rsmed = ps.executeQuery(sql);
				// UMA VARIAVEL JA CRIADA LÁ EM CIMA É CRIADA DO TIPO DEFAULT TABLE MODEL , TABLEMODEL É A INTERFACE QUE REPRESENTA O MODEL DA JTable.
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
					
	while(rsmed.next())	{
		
		model.addRow(new Object[]{
	 // AQUI COM A VARIAVEL RSMED CRIADA ALI EM CIMA COM A FUNÇÃO SQL, AQUI ELA ATUA PARA CHAMAR EXATAMENTE OS CAMPOS QUE ESTÃO EM "" DA TABELA. E COLOCAR NA TABEL EXATAMENTE NA ORDEM
	                 rsmed.getString("pacienterg"), rsmed.getString("medico"), rsmed.getString("hora_con"),rsmed.getString("dia_consul"), rsmed.getString("mes_consul"), rsmed.getString("ano_consul"), rsmed.getString("local") 
	                 ,rsmed.getString("descricao")  });	
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
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(204, 0, 102));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {// INICIANDO VARIAVEIS PARA CONEXÃO
					 conexao paciente = new conexao();
						paciente.getConnection();
							Connection conexao1;
							//COM A VAIRIAVEL CONEXÃO UM É O DIRETORIO DA MINHA BASE DE DADOS
						conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
	
						//COM A STRIG QUERY QUE CONTERA A O COMANDODE DELETAR DADO DADOS X DA TABELA MEDICO ATRAVES DO CPF PELO PARAMETRO QUE SERA DIGITIO NO TEXTFIELD CPFDEL
				   String Query = " DELETE FROM consultas where pacienterg=?";
					
				   //COM O PREPAREDsTATEMENT QUE SERVA PARA EXECUTAR FUNÇIE DO SQL É FEITA A CONEÇÃO COM A VARIAVEL CONEXÃO1 E LOGO DPS O COMANDO SQL ATRAVES DA VARIAVEL QUERY 
				   PreparedStatement stmt = (PreparedStatement) conexao1.prepareStatement(Query);
				   // ALI EM CIMA TEM NO CPF UM ? ESSE ? SERA O TEXTFIELD CPFMED QUE SERAMLIDO AQUI EM BAIXO E LOGO EXLUIDO O DADO DA TABELA SE TIVER UM CPF IGUAL O DIGITADO 
				          stmt.setString(1,cpfpacdel.getText());
				             
				          
				            
				      
				       
				            //SE O DELETE DER CERTO UM MENSAGEM DE DADOS DELETADOS COM SUCESSO
				
				JOptionPane.showMessageDialog(null," dados deletados com sucesso");
				    stmt.executeUpdate();
				    stmt.close();
				    conexao1.close();
				    //CASO O DELETE DE ERRADO UMA MESNAGEM DE ERRO MAIS OQ DE ERRADO NO SQL ESTÃ ACONTECENDO 
					}catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "erro" + ex.toString());
					}
					Connection conexao1 = null;
					try {
						conexao1 = conexao.getConnnection();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String sql = "select * from consultas";
					
					StatementImpl ps = null;
					//aqui comeca a parte de pupular tabela dentro do botão castrara onde ao clicar em cadatrar
					//primeiro ocorrerá o cadastro e logo a pos a tabela sera preenchida
					try {
						ps = (PreparedStatement) conexao1.prepareStatement(sql);
					Object rsdel = ps.executeQuery(sql);
					
					//o defaultTaleModel serve para digamos fazer a ponto da tabela ao dados 
					DefaultTableModel modelo = (DefaultTableModel)table.getModel();
					modelo.setNumRows(0);
						
		while(((ResultSet) rsdel).next())	{
			
			modelo.addRow(new Object[]{
					
			            // pegando valores do bd para colocar na tabela.
		                 ((ResultSet) rsdel).getString("pacienterg"), ((ResultSet) rsdel).getString("medico"),((ResultSet) rsdel).getString("hora_con"), ((ResultSet) rsdel).getString("dia_consul") 
		                 , ((ResultSet) rsdel).getString("mes_consul"), ((ResultSet) rsdel).getString("ano_consul"), ((ResultSet) rsdel).getString("local"), ((ResultSet) rsdel).getString("descricao")});	
}
		} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						try {
							//fechando todas as funçoes abertas.
							conexao1.close();
							ps.close();
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
							
				
				
				
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\Sem T\u00EDtulo-2.png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastro obj = new cadastro();
			     obj.setVisible(true);
			     dispose();
			}
			
			
		});
		
		
		
		JLabel lblLocal = new JLabel("Local:");
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		
		descri = new JTextField();
		descri.setColumns(10);
		
		JLabel label = new JLabel("/");
		
		JLabel label_1 = new JLabel("/");
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 System.exit(0);
			}
		});
		btnFechar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\gggg.png"));
		
	
		mesbox.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		
			
				
				
			
					
		;
		
		JButton Atualizar = new JButton("Atualizar");
		Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				Connection conexao1 = null;
				try {    // É FEITA A CONEXÃO
					conexao1 = conexao.getConnnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}// UMA VARIAVEL PARA CONTER O COMANDO SQL É CRIADA
				String sql = "select * from consultas";
			PreparedStatement ps = null;
			ResultSet rsmed = null;
			try { // A VARIAVEL ENTÃO CHAMADA PS IRA CONTER A CONEXÃO E O COMANDO OU SEJA, TODO OS DADOS DA TABELA DO MEDICO
					ps = (PreparedStatement) conexao1.prepareStatement(sql);
					// MANDEI ELE EXECUTAR O O COMANDO QUERY NO SQL
				rsmed = ps.executeQuery(sql);
				// UMA VARIAVEL JA CRIADA LÁ EM CIMA É CRIADA DO TIPO DEFAULT TABLE MODEL , TABLEMODEL É A INTERFACE QUE REPRESENTA O MODEL DA JTable.
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
					
	while(rsmed.next())	{
		
		model.addRow(new Object[]{
	 // AQUI COM A VARIAVEL RSMED CRIADA ALI EM CIMA COM A FUNÇÃO SQL, AQUI ELA ATUA PARA CHAMAR EXATAMENTE OS CAMPOS QUE ESTÃO EM "" DA TABELA. E COLOCAR NA TABEL EXATAMENTE NA ORDEM
	                 rsmed.getString("pacienterg"), rsmed.getString("medico"), rsmed.getString("hora_con"),rsmed.getString("dia_consul"), rsmed.getString("mes_consul"), rsmed.getString("ano_consul"), rsmed.getString("local") 
	                 ,rsmed.getString("descricao")  });	
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
		
		JLabel lblDigiteOCpf = new JLabel("CPF paciente:");
		
		cpfpacdel = new JTextField();
		cpfpacdel.setColumns(10);
		
		
		diabox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	
				
		GroupLayout gl_mescon = new GroupLayout(mescon);
		gl_mescon.setHorizontalGroup(
			gl_mescon.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
				.addGroup(gl_mescon.createSequentialGroup()
					.addGroup(gl_mescon.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mescon.createSequentialGroup()
							.addGap(13)
							.addComponent(lblDescrio))
						.addGroup(gl_mescon.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLocal))
						.addGroup(gl_mescon.createSequentialGroup()
							.addContainerGap()
							.addComponent(Data))
						.addGroup(gl_mescon.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHorrio))
						.addGroup(gl_mescon.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPaciente))
						.addGroup(gl_mescon.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMdico)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_mescon.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_mescon.createSequentialGroup()
							.addComponent(btnVoltar)
							.addPreferredGap(ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
							.addComponent(btnFechar))
						.addGroup(gl_mescon.createSequentialGroup()
							.addGroup(gl_mescon.createParallelGroup(Alignment.LEADING)
								.addComponent(boxpac1, 0, 175, Short.MAX_VALUE)
								.addComponent(boxloc, 0, 175, Short.MAX_VALUE)
								.addComponent(box, 0, 175, Short.MAX_VALUE)
								.addGroup(gl_mescon.createSequentialGroup()
									.addComponent(diabox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(mesbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(anobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(horario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_mescon.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnSalvar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(descri, Alignment.LEADING, 111, 111, Short.MAX_VALUE)))
							.addGap(34)
							.addGroup(gl_mescon.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_mescon.createSequentialGroup()
									.addComponent(lblDigiteOCpf)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cpfpacdel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExcluir)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(Atualizar))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_mescon.setVerticalGroup(
			gl_mescon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mescon.createSequentialGroup()
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_mescon.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mescon.createSequentialGroup()
							.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
								.addComponent(box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMdico))
							.addGap(18)
							.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
								.addComponent(boxpac1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPaciente))
							.addGap(18)
							.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
								.addComponent(horario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHorrio))
							.addGap(18)
							.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
								.addComponent(Data)
								.addComponent(diabox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(mesbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(anobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLocal)
								.addComponent(boxloc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescrio)
								.addComponent(descri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_mescon.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDigiteOCpf)
								.addComponent(cpfpacdel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExcluir)
								.addComponent(Atualizar))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_mescon.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnVoltar))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\logopanel.png"));
		panel1.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paciente", "M\u00E9dico", "Hor\u00E1rio", "Dia", "M\u00EAs", "Ano", "Local", "Descri\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(41);
		scrollPane.setViewportView(table);
		mescon.setLayout(gl_mescon);
	}
}