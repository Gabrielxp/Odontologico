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
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					System.in));

			String usuario = login.getText();

			String senhax = new String(senha.getPassword());

			if ((mapaUsuario.containsKey(usuario))
					&& (mapaUsuario.get(usuario).getSenha().equals(senhax))) {

				if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo()
								.equals("dentista"))) {

					Menus m = new Menus();
					m.menuDentista();

				} else if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo()
								.equals("secretario"))) {
					Menus m = new Menus();
					m.menuSecretario();

				} else if ((mapaUsuario.containsKey(usuario))
						&& (mapaUsuario.get(usuario).getTipo().equals("admin"))) {

					Menus m = new Menus();
					m.menuAdmin();

				}

			} else {
				System.out.println("Usuario e/ou senha invalido(s)!");
				System.out.println("");
				JOptionPane.showMessageDialog(logar,
						"Usuario e/ou senha invalido(s)!");
				Programa.main(null);

			}

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
		}
	}
}
