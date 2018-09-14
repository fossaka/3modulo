package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AlunosJdbcDAO;
import controller.CordenadorJdbcDAO;
import controller.JdbUtil;
import model.Alunos;
import model.Cordenador;

public class AlterarAluno extends JFrame {
	
	JTextField txtId = new JTextField();
	JLabel id = new JLabel("ID: ");
	
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("BAIRRO: ");

	JTextField txtCep = new JTextField();
	JLabel cep = new JLabel("CEP:   ");
	
	JButton btnSalvar = new JButton("Alterar");
	public AlterarAluno(){
		super("Alterar Alunos");
		
		Container paine = this.getContentPane();
		

		
		paine.add(id);
		paine.add(txtId);	
		id.setBounds(10, 15, 45, 30);
		txtId.setBounds(90, 15, 225, 30);
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 50, 70, 30);
		txtNome.setBounds(90, 50, 225, 30);	
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 85, 70, 30);
		txtEnd.setBounds(90, 85, 225, 30);
		
		paine.add(bairro); 
		paine.add(txtBairro);
		bairro.setBounds(10, 120, 70, 30);
		txtBairro.setBounds(90, 120, 225, 30);
		
		paine.add(cep);
		paine.add(txtCep);	
		cep.setBounds(10, 155, 70, 30);
		txtCep.setBounds(90, 155, 225, 30);
		
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					
					
				Alunos alunos = new Alunos();
				alunos.setId(Integer.parseInt( txtId.getText() ));
				alunos.setNome(txtNome.getText());
				alunos.setEndereco(txtEnd.getText());
				alunos.setBairro(txtBairro.getText());
				alunos.setCep(Integer.parseInt(txtCep.getText()));
				Connection connection = JdbUtil.getConnection();
				
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
			alunosJdbcDao.alterar(alunos, alunos.getId());
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main( String[] args )
    {
    	AlterarAluno aa = new AlterarAluno();
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	