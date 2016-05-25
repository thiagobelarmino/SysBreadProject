package br.com.sysbread.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sysbread.domain.Padaria;
import br.com.sysbread.factory.ConexaoFactory;

public class PadariaDAO {
	public void salvar (Padaria p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO padaria ");
		sql.append("(nome, endereco, bairro, cidade, estado, cnpj, telefone, email, senha) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getNome());
		comando.setString(2, p.getEndereco());
		comando.setString(3, p.getBairro());
		comando.setString(4, p.getCidade());
		comando.setString(5, p.getEstado());
		comando.setString(6, p.getCnpj());
		comando.setString(7, p.getTelefone());
		comando.setString(8, p.getEmail());
		comando.setString(9, p.getSenha());
		
		comando.executeUpdate();
}
	
	public static void main(String[] args) {
		Padaria p1 = new Padaria();
		p1.setNome("Sonnho de pão");
		p1.setEndereco("Av Domingos Olimpio 1535");
		p1.setBairro("Benfica");
		p1.setCidade("Fortaleza");
		p1.setEstado("CE");
		p1.setCnpj("00.000.000/0000-00");
		p1.setTelefone("(85)99999-9999");
		p1.setEmail("sonhodepaopanificadora@outlook.com");
		p1.setSenha("1234qwer");		
		
		PadariaDAO pdao = new PadariaDAO();
		
		try {
			pdao.salvar(p1);
			System.out.println("Padaria cadastrada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao cadastrar!");
			e.printStackTrace();
		}
		
	}
	
}
