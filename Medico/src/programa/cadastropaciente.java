package programa;

import java.awt.BorderLayout;
import java.util.Date;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import ValidacaoDeDados.ValidaCPF;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class cadastropaciente extends JFrame {

	private JPanel cidade;
	private JTextField nomepac;
	private JTextField cpfpac;
	private JTextField rgpac;
	private JTextField estadocivilpac;
	private JTextField religiaopac;
	private JTextField telpessoalpac;
	private JTextField bairropac;
	private JTable table_1;
	private JTextField datapac;
	private JTable table;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ResultSet rspac = null;
	String sql = null;
	Connection conexao1 = null;
	Connection conexao2=null;
	private DefaultTableModel modelo;
	String CPF;
	char[] sexo;
	private JTextField ceppac;
	private JTextField telcomercialpac;
	protected JTextField jsexomed;
	JComboBox cid ;
	private JTextField cpfpesquisa;
	private JTextField ruapac;
	private JTextField numeropac;
	private JTextField complementopac;
	JComboBox sexopac = new JComboBox();
	private JTextField cidadepac;
	private JTextField resp;
	JComboBox calss = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastropaciente frame = new cadastropaciente();
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
	public cadastropaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\logoprog.png"));
		setTitle("Cadastro Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 723);
		cidade = new JPanel();
		cidade.setBackground(SystemColor.window);
		cidade.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cidade);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 16, 912, 79);
		panel.setBackground(new Color(100, 149, 237));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 101, 912, 10);
		panel_1.setBackground(new Color(65, 105, 225));
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(23, 137, 66, 14);
		
		nomepac = new JTextField();
		nomepac.setBounds(154, 134, 129, 20);
		nomepac.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(20, 163, 69, 14);
		
		cpfpac = new JTextField();
		cpfpac.setBounds(154, 160, 129, 20);
		cpfpac.setColumns(10);
		
		JLabel lblRg = new JLabel("RG :");
		lblRg.setBounds(20, 189, 69, 14);
		
		rgpac = new JTextField();
		rgpac.setBounds(154, 186, 129, 20);
		rgpac.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil :");
		lblEstadoCivil.setBounds(397, 189, 88, 14);
		
		estadocivilpac = new JTextField();
		estadocivilpac.setBounds(550, 186, 136, 20);
		estadocivilpac.setColumns(10);
		
		JLabel lblReligio = new JLabel("Religi\u00E3o :");
		lblReligio.setBounds(397, 163, 88, 14);
		
		religiaopac = new JTextField();
		religiaopac.setBounds(548, 160, 102, 20);
		religiaopac.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 0, 0);
		
		JLabel lblTelefonePessoal = new JLabel("Telefone Pessoal :");
		lblTelefonePessoal.setBounds(397, 242, 113, 14);
		
		telpessoalpac = new JTextField();
		telpessoalpac.setBounds(550, 239, 90, 20);
		telpessoalpac.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Bairro :");
		lblEndereo.setBounds(20, 272, 69, 14);
		
		bairropac = new JTextField();
		bairropac.setBounds(154, 269, 129, 20);
		bairropac.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(23, 396, 129, 36);
		btnCadastrar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\lolo.png"));
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			private JComboBox sexomed;
		

			public void actionPerformed(ActionEvent e) {
		   
		   
				
				

				CPF =cpfpac.getText();
				
				//ate aqui
				// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
					if (ValidaCPF.isCPF(CPF) == true){	
					
				//CADASTRAR
//a conexão é feita  com a ajuda do drivermaneger que faz a ponte entre bd e o programa
				try {
				 conexao paciente = new conexao();
					paciente.getConnection();
						Connection conexao1;
					conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
					
					
//aqui são seleciondos os campos existentes na tabela medico onde quero cadastrar
			   String Query = " INSERT INTO pacientes(nome,data_nasc, cpf, rg,bairro, sexo,religião,estado_civil,"
			   		+ " tel_pessoal, tel_comercial, cep,numero,complemento,cidade,classificação,responsavel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			           
//os campos de texto existetntes na tabela são chamados e pegadas seus valores digitados para incluir no bd   
			   PreparedStatement stmt = (PreparedStatement) conexao1.prepareStatement(Query);
			   
			            stmt.setString(1,nomepac.getText());
			            stmt.setString(2,datapac.getText()); 
			            stmt.setString(3,cpfpac.getText());
			            stmt.setString(4,rgpac.getText()); 
			            stmt.setString(5,bairropac.getText());
			            stmt.setString(6,sexopac.getSelectedItem().toString());    
			            stmt.setString(7,religiaopac.getText());    
			            stmt.setString(8,estadocivilpac.getText());    
			            stmt.setString(9,telpessoalpac.getText());    
			            stmt.setString(10,telcomercialpac.getText());    
			            stmt.setString(11,ceppac.getText());  
			            stmt.setString(12,numeropac.getText());  
			            stmt.setString(13,complementopac.getText());  
			            stmt.setString(14,cidadepac.getText());
			            stmt.setString(15,calss.getSelectedItem().toString());
			            stmt.setString(16,resp.getText());
			            
			            
			            
			            
			            //ao dar tud certo uma mensagem de notificação aparece
			
			JOptionPane.showMessageDialog(null," dados inseridos com sucesso");
			    stmt.executeUpdate();
			    stmt.close();
			    conexao1.close();
			    //caso de erro na inserção do bd aparecera o erro do sql.
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "erro" + ex.toString());
				}}else{
		        	JOptionPane.showMessageDialog(null, "CPF inválido!");
					}
				try {
					conexao1 = conexao.getConnnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				sql = "select * from pacientes";
				
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
	                 rs.getString("idpaciente"), rs.getString("nome"), rs.getString("data_nasc"),rs.getString("cpf"), rs.getString("rg"), rs.getString("sexo"), rs.getString("religião"),rs.getString("cep"),rs.getString("tel_pessoal")   
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
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(550, 644, 100, 29);
		btnVoltar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				new cadastro().show(); 
				dispose();  
			
			    
			}
		});
		btnVoltar.setForeground(new Color(105, 105, 105));
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\Sem T\u00EDtulo-2.png"));
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
		JButton btnFechar = new JButton("fechar");
		btnFechar.setBounds(660, 644, 113, 29);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 System.exit(0);
			}
		});
		btnFechar.setForeground(new Color(112, 128, 144));
		btnFechar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\gggg.png"));
		btnFechar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
		JList list = new JList();
		list.setBounds(511, 222, 1, 1);
		
		JList list_1 = new JList();
		list_1.setBounds(678, 293, 1, 1);
		
		JList list_2 = new JList();
		list_2.setBounds(768, 300, 1, 1);
		cidade.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(-10008, -10031, 137, 28);
		addPopup(cidade, popupMenu);
		
		table_1 = new JTable();
		table_1.setBounds(596, 374, 1, 1);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(728, 402, 95, 25);
		btnLimpar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//LIMPAR
				
				nomepac.setText("");
				cpfpac.setText("");
				rgpac.setText("");
				estadocivilpac.setText("");
				religiaopac.setText("");
				complementopac.setText("");
				ceppac.setText("");
				telpessoalpac.setText("");
				ruapac.setText("");
				cidadepac.setText("");
				bairropac.setText("");
				telcomercialpac.setText("");
				bairropac.setText("");
				resp.setText("");
				numeropac.setText("");
				datapac.setText("");
			}
		});
		
		datapac = new JTextField();
		datapac.setBounds(154, 295, 86, 20);
		datapac.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(20, 298, 129, 14);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(397, 137, 88, 14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 438, 800, 190);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.setBounds(175, 639, 86, 23);
		btnNewButton_1.setBackground(new Color(204, 0, 102));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//a conexão é feita  com a ajuda do drivermaneger que faz a ponte entre bd e o programa
				try {
				 conexao paciente = new conexao();
					paciente.getConnection();
						Connection conexao1;
					conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
					
					
					//aqui são seleciondos os campos existentes na tabela medico onde quero cadastrar
			   String Query = " DELETE FROM pacientes where cpf=?";
				
			   //os campos de texto existetntes na tabela são chamados e pegadas seus valores digitados para incluir no bd   
			   PreparedStatement stmt = (PreparedStatement) conexao1.prepareStatement(Query);
			          stmt.setString(1,cpfpesquisa.getText());
			             
			          
			            
			      
			       
			            //ao dar tud certo uma mensagem de notificação aparece
			
			JOptionPane.showMessageDialog(null," dados deletados com sucesso");
			    stmt.executeUpdate();
			    stmt.close();
			    conexao1.close();
			    //caso de erro na inserção do bd aparecera o erro do sql.
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "erro" + ex.toString());
				}
				try {
					conexao1 = conexao.getConnnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				sql = "select * from pacientes";
				
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
                 rs.getString("idpaciente"), rs.getString("nome"), rs.getString("data_nasc"),rs.getString("cpf"), rs.getString("rg"), rs.getString("sexo"), rs.getString("religião"),rs.getString("cep"),rs.getString("tel_pessoal")   
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
				
		
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(20, 242, 69, 14);
		
		ceppac = new JTextField();
		ceppac.setBounds(548, 214, 86, 20);
		ceppac.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(397, 217, 88, 14);
		
		telcomercialpac = new JTextField();
		telcomercialpac.setBounds(550, 269, 136, 20);
		telcomercialpac.setColumns(10);
		
		cpfpesquisa = new JTextField();
		cpfpesquisa.setBounds(64, 640, 86, 20);
		cpfpesquisa.setColumns(10);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setBounds(23, 643, 31, 14);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(623, 404, 84, 23);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
				try {
					conexao1 = conexao.getConnnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				sql = "select * from pacientes";
				
				
				try {
					ps = (PreparedStatement) conexao1.prepareStatement(sql);
				rspac = ps.executeQuery(sql);
				
				 modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
					
	while(rspac.next())	{
		
		modelo.addRow(new Object[]{
		            // pegando valores do bd para colocar na tabela.
	                 rspac.getString("idpaciente"), rspac.getString("nome"), rspac.getString("data_nasc"),rspac.getString("cpf"), rspac.getString("rg"), rspac.getString("sexo"), rspac.getString("religião") 
	                 ,rspac.getString("cep"),rspac.getString("tel_pessoal")  });	
  }
	// adiconando coluna

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						conexao1.close();
						ps.close();
						rspac.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		ruapac = new JTextField();
		ruapac.setBounds(154, 217, 86, 20);
		ruapac.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Rua:");
		lblNewLabel.setBounds(20, 217, 69, 14);
		
		numeropac = new JTextField();
		numeropac.setBounds(550, 295, 86, 20);
		numeropac.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Complemento:");
		lblNewLabel_2.setBounds(20, 326, 113, 14);
		
		complementopac = new JTextField();
		complementopac.setBounds(154, 323, 86, 20);
		complementopac.setColumns(10);
		sexopac.setBounds(550, 134, 44, 20);
		
		
		sexopac.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		
		cidadepac = new JTextField();
		cidadepac.setBounds(154, 243, 86, 20);
		cidadepac.setColumns(10);
		
		JLabel lblTelComercial = new JLabel("Tel Comercial:");
		lblTelComercial.setBounds(397, 272, 102, 14);
		
		JLabel lblNumResidencial = new JLabel("Num Residencial:");
		lblNumResidencial.setBounds(397, 298, 102, 14);
		calss.setBounds(397, 323, 71, 20);
		calss.setModel(new DefaultComboBoxModel(new String[] {"De Maior", "De Menor"}));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Data de Nascimento", "CPF", "RG", "Sexo", "Religi\u00E3o", "Endere\u00E7os", "Contatos"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(5).setPreferredWidth(46);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\logopanel.png"));
		panel.add(label_2);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		resp = new JTextField();
		resp.setBounds(550, 351, 100, 20);
		resp.setColumns(10);
		
		JLabel lblResponsvelParaMenor = new JLabel("Respons\u00E1vel para menor:");
		lblResponsvelParaMenor.setBounds(395, 354, 155, 14);
		cidade.add(panel_1);
		cidade.add(panel);
		cidade.add(btnNewButton_1);
		cidade.add(lblCpf_1);
		cidade.add(cpfpesquisa);
		cidade.add(btnVoltar);
		cidade.add(btnFechar);
		cidade.add(scrollPane);
		cidade.add(lblNome);
		cidade.add(label);
		cidade.add(lblCpf);
		cidade.add(lblRg);
		cidade.add(lblNewLabel);
		cidade.add(lblCidade);
		cidade.add(lblEndereo);
		cidade.add(lblDataDeNascimento);
		cidade.add(lblNewLabel_2);
		cidade.add(calss);
		cidade.add(table_1);
		cidade.add(datapac);
		cidade.add(cidadepac);
		cidade.add(ruapac);
		cidade.add(cpfpac);
		cidade.add(rgpac);
		cidade.add(nomepac);
		cidade.add(bairropac);
		cidade.add(lblSexo);
		cidade.add(lblReligio);
		cidade.add(lblEstadoCivil);
		cidade.add(lblTelefonePessoal);
		cidade.add(lblCep);
		cidade.add(lblTelComercial);
		cidade.add(lblNumResidencial);
		cidade.add(list_1);
		cidade.add(list);
		cidade.add(sexopac);
		cidade.add(religiaopac);
		cidade.add(estadocivilpac);
		cidade.add(ceppac);
		cidade.add(telpessoalpac);
		cidade.add(telcomercialpac);
		cidade.add(numeropac);
		cidade.add(btnLimpar);
		cidade.add(list_2);
		cidade.add(btnAtualizar);
		cidade.add(btnCadastrar);
		cidade.add(complementopac);
		cidade.add(resp);
		cidade.add(lblResponsvelParaMenor);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void setId(String string) {
		// TODO Auto-generated method stub
		
	}
}
