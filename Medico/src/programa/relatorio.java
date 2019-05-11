package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class relatorio extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	PreparedStatement ps = null;

	ResultSet rsrel  = null;
	ResultSet rs1 = null;
	String sql = null;
	Connection conexao1 = null;



	private DefaultTableModel model;
	String CPF;
	char[] sexo;

	private DefaultTableModel modelo;





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relatorio frame = new relatorio();
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
	public relatorio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\logoprog.png"));
		setTitle("Relat\u00F3rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 328);
		contentPane = new JPanel();
		contentPane.setToolTipText("Relat\u00F3rio");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				

				Connection conexao1 = null;
				try {    // É FEITA A CONEXÃO
					conexao1 = conexao.getConnnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}// UMA VARIAVEL PARA CONTER O COMANDO SQL É CRIADA
				String sql = "select * from consultas_historico";
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
					

			
				
				
				
			}});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\meu\\Desktop\\icones\\Sem T\u00EDtulo-2.png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastro obj = new cadastro();
			     obj.setVisible(true);
			     dispose();
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAtualizar)
							.addContainerGap())
						.addComponent(btnVoltar, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAtualizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnVoltar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paciente", "M\u00E9dico", "Hora", "Dia", "M\u00EAs", "Ano", "Local", "Descri\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(1).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setPreferredWidth(51);
		table.getColumnModel().getColumn(3).setPreferredWidth(35);
		table.getColumnModel().getColumn(4).setPreferredWidth(42);
		table.getColumnModel().getColumn(5).setPreferredWidth(42);
		table.getColumnModel().getColumn(7).setPreferredWidth(165);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
