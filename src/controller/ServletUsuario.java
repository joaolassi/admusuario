package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletUsuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email, nome, senha, rsenha, perfil, opcao;

		opcao = request.getParameter("opcao");
		email = request.getParameter("email");

		if (opcao.equals("Adicionar")) {
			nome = request.getParameter("nome");
			senha = request.getParameter("senha");
			rsenha = request.getParameter("rsenha");
			perfil = request.getParameter("perfil");

			Usuario usuario = new Usuario(email, nome, senha, perfil);
			try {
				UsuarioDAO dao = new UsuarioDAO();
				dao.adicionar(usuario);
				response.getWriter().append("Gravado com sucesso").append(request.getContextPath());

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (opcao.equals("Excluir")) {

			Usuario usuario = new Usuario(email);
			usuario.setEmail(email);

			try {
				UsuarioDAO dao = new UsuarioDAO();
				dao.excluir(usuario);
				response.getWriter().append("Excluido com sucesso!").append(request.getContextPath());

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		} else if (opcao.equals("Editar")) {

			try {
				UsuarioDAO dao = new UsuarioDAO();
				List<Usuario> lista = new ArrayList<Usuario>();
				lista = dao.editarUsuario(email);
				// Zero pois, estamos mandando apenas 1 usuário
				String enome = lista.get(0).getNome();
				String eperfil = lista.get(0).getPerfil();
				String esenha = lista.get(0).getSenha();

				Usuario usuario = new Usuario(email, enome, esenha, eperfil);
				request.setAttribute("usuario", usuario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("view/editarusuario.jsp");
				dispatcher.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (opcao.equals("Atualizar")) {
			nome = request.getParameter("nome");
			senha = request.getParameter("senha");
			rsenha = request.getParameter("rsenha");
			perfil = request.getParameter("perfil");
			
			Usuario usuario = new Usuario(email, nome, senha, perfil);
			try {
				UsuarioDAO dao = new UsuarioDAO();
				dao.alterarUsuario(usuario);
				response.getWriter().append("Alterado com sucesso!!").append(request.getContextPath());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
