import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfTurma;
	private JTextField tfAno;
	private JTable tbCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome");

		JLabel lblTurma = new JLabel("Turma");

		JLabel lblAno = new JLabel("Ano");

		tfNome = new JTextField();
		tfNome.setColumns(10);

		tfTurma = new JTextField();
		tfTurma.setColumns(10);

		tfAno = new JTextField();
		tfAno.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		//BOTÃO SALVAR
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 DefaultTableModel tabela = (DefaultTableModel)tbCadastro.getModel();
				
				 Object[] dados = {tfNome.getText(), tfTurma.getText(), tfAno.getText()};
				
				 tabela.addRow(dados);
				 
				 limpar();
				
				
			}

			private void limpar() {
				tfNome.setText("");
				 tfTurma.setText("");
				 tfAno.setText("");
				 tfNome.requestFocus(); //coloca o foco no primeiro componente
			}
		});
        // BOTÃO ALTERAR
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				System.out.println();
				
				if(tbCadastro.getSelectedRow() !=-1){
					
					//setar os valores selecionados
					tbCadastro.setValueAt(tfNome.getText(),
							tbCadastro.getSelectedRow(),0);
					tbCadastro.setValueAt(tfTurma.getText()
							,tbCadastro.getSelectedRow(),1);
					tbCadastro.setValueAt(tfAno.getText()
							,tbCadastro.getSelectedRow(),2);
					
				}
				
				
			}
		});
		
        // BOTÃO EXCLUIR
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//verifique se selecionou alguma linha
				
				if (tbCadastro.getSelectedRow() !=-1) {
					
					//criar modelo da tabela
					DefaultTableModel tabela= (DefaultTableModel)tbCadastro.getModel();
					
					tabela.removeRow(tbCadastro.getSelectedRow());
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(5)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNome)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAno).addComponent(lblTurma)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(tfAno, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfTurma, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(51)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnExcluir)
										.addComponent(btnAlterar).addComponent(btnSalvar))))
				.addContainerGap(30, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNome)
								.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSalvar))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTurma).addComponent(btnAlterar))
				.addGap(14)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAno).addComponent(btnExcluir)).addGap(14)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(13, Short.MAX_VALUE)));

		tbCadastro = new JTable();
		tbCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//verifique se foi selecionado alguma linha
				if (tbCadastro.getSelectedRow() != -1) {
					
					tfNome.setText(tbCadastro.getValueAt(tbCadastro.getSelectedRow(), 0).toString());
					
					tfTurma.setText(tbCadastro.getValueAt(tbCadastro.getSelectedRow(), 1).toString());
					
					tfAno.setText(tbCadastro.getValueAt(tbCadastro.getSelectedRow(), 2).toString());
					
				} else {
                    JOptionPane.showMessageDialog(null,"Selecione alguma linha");
				}
				
			}
		});
		tbCadastro.setModel(new DefaultTableModel(
				new Object[][] {
				},  // colunas da tabela
				new String[] { "Nome", "Turma", "Ano" }) {
			
			boolean[] columnEditables = new boolean[] { 
					false, false, false 
					};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbCadastro);
		contentPane.setLayout(gl_contentPane);
	}
}
