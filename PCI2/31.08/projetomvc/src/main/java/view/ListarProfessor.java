package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CordenadorJdbcDAO;
import controller.JdbUtil;
import controller.ProfessorJdbcDAO;


public class ListarProfessor extends JFrame {
	JButton btnListar = new JButton("Listar");
	
	JLabel Mostrando = new JLabel("Mostrando Professores: ");
	JTextArea listando = new JTextArea();
	public ListarProfessor(){
		super("Listar Professores");
		
		Container paine = this.getContentPane();
		
		paine.add(Mostrando);
	
		Mostrando.setBounds(10, 15, 200, 30);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		paine.add(btnListar);
		btnListar.setBounds(20, 250, 130, 30);
		 btnListar.setBackground(Color.BLACK); // cOR DO FUNDO DO BOTÃO
		 btnListar.setForeground(Color.WHITE); //fONTE DO BOTÃO SALVAR  
		 paine.add(listando);
		 listando.setBounds(40, 40, 400, 180);

		btnListar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			try {
				Connection connection = JdbUtil.getConnection();
				ProfessorJdbcDAO listarprofessorJdbcDao = new ProfessorJdbcDAO(connection);
					
				listarprofessorJdbcDao.listar();
				
			}catch(Exception err) { 
				err.printStackTrace();
			}
	
			}
		});
		

	}
	public static void main(String args[]) {
		ListarProfessor lp = new ListarProfessor();
	}
}

