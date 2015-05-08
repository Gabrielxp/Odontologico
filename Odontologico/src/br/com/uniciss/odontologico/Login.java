package br.com.uniciss.odontologico;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.uniciss.odontologico.BD.Gravar;
import br.com.uniciss.odontologico.BD.Scripts;
import br.com.uniciss.odontologico.funcionario.Funcionario;

public class Login extends JFrame implements ActionListener {
	/**
	 * Variavel login, utilizada para realização de login
	 */
	JTextField login;
	/**
	 * Variavel senha, utilizada para realização de login
	 */
	JPasswordField senha;
	/**
	 * Variavel logar, utilizada para criação de botão
	 */
	/**
	 * Variavel cancelar, utilizada para criação de botão
	 */
	JButton logar, cancelar;

	/**
	 * Método Login, utilizado na formação gráfica e no login do sistema
	 */
	public Login() {
		super("Atendimento Odontologico");

		logar = new JButton("Logar");
		logar.addActionListener(this);

		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);

		login = new JTextField();
		senha = new JPasswordField();

		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("   Login:"));
		c.add(login);
		c.add(new JLabel("   Senha:"));
		c.add(senha);
		c.add(logar);
		c.add(cancelar);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);

	}

	/**
	 * Método actionPerformed, utilizado para eventos
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logar) {
			setVisible(false);
		}
		if (e.getSource() == cancelar) {
			System.exit(0);
		}

		ArrayList<Funcionario> listaUsuario = new ArrayList<Funcionario>();
		Map<String, Funcionario> mapaUsuario = new HashMap<String, Funcionario>();

		Scanner s = new Scanner(System.in);

		Gravar g = new Gravar();
		g.leituraUsuario(mapaUsuario);
			
		BufferedReader entrada = new BufferedReader(new InputStreamReader(
					System.in));

			String usuario = login.getText();

			String senhax = new String(senha.getPassword());

			Menus m = new Menus();

			try{
				String pega = "SELECT nome_usuario FROM users where nome_usuario" + usuario + "'";
				String pegalogin = Scripts.selectNome(pega);

				String pegado = "SELECT senha FROM users where senha" + senhax + "'";
				String pegaSenha = Scripts.selectNome(pegado);

				String users = "SELECT tipo_users FROM users where nome_usuario ="+"'"+usuario+"'";

				if(pegalogin.equals(usuario) && pegaSenha.equals(senhax)){

					if (users.equals("admin")){
						m.menuAdmin();

					}else if(users.equals("dentista")){
						m.menuDentista();

					}else if(users.equals("secretario")){
						m.menuSecretario();
					}
				}
				m.menuDentista();

			} catch (InputMismatchException i) {

				s.nextLine();
				System.out.println("Você informou algum caracter inválido(s)! ");


			} catch (NullPointerException b) {

				System.out.println("Login inexistente!");

			} catch (IOException e1) {

				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}