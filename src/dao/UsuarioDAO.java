package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
	private Connection conexao;
	private PreparedStatement preparar;
	private String sql;
	private ResultSet rs;
	private List<Usuario> lista;

	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		conexao = new Conexao().getConexao();
	}

	public void adicionar(Usuario usuario) throws SQLException {
		sql = "insert into usuario(email,nome,senha,perfil) values (?,?,?,?)";
		preparar = conexao.prepareStatement(sql);
		preparar.setString(1, usuario.getEmail());
		preparar.setString(2, usuario.getNome());
		preparar.setString(3, usuario.getSenha());
		preparar.setString(4, usuario.getPerfil());
		preparar.execute();
		preparar.close();
	}

	public void excluir(Usuario usuario) throws SQLException {
		sql = "delete from usuario where email=?";
		preparar = conexao.prepareStatement(sql);
		preparar.setString(1, usuario.getEmail());
		preparar.execute();
		preparar.close();
	}

	public List<Usuario> listarUsuario() throws SQLException {
		lista = new ArrayList<Usuario>();
		sql = "select * from usuario order by nome";
		preparar = conexao.prepareStatement(sql);
		rs = preparar.executeQuery();
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setEmail(rs.getString("email"));
			usuario.setNome(rs.getString("nome"));
			usuario.setPerfil(rs.getString("perfil"));
			// usuario.setSenha(rs.getString("senha"));
			lista.add(usuario);
		}
		return lista;
	}

	public List<Usuario> editarUsuario(String email) throws SQLException {
		lista = new ArrayList<Usuario>();
		sql = "select * from usuario where email='" + email + "'";
		preparar = conexao.prepareStatement(sql);
		rs = preparar.executeQuery();
		rs.next();
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNome(rs.getString("nome"));
		usuario.setPerfil(rs.getString("perfil"));
		usuario.setSenha(rs.getString("senha"));
		lista.add(usuario);

		return lista;
	}

	public void alterarUsuario(Usuario usuario) throws SQLException {
		sql = "update usuario set nome=?, perfil=?,senha=? where email=?";
		preparar = conexao.prepareStatement(sql);
		preparar.setString(1, usuario.getNome());
		preparar.setString(2, usuario.getPerfil());
		preparar.setString(3, usuario.getSenha());
		preparar.setString(4, usuario.getEmail());
		preparar.executeUpdate();
		preparar.close();
	}

}
