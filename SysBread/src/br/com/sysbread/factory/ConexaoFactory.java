package br.com.sysbread.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO="postgres";
	private static final String SENHA="postgres";
	private static final String URL="jdbc:postgresql://localhost:5432/sysbread";
	
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	
	public static void main(String[] args) {
		try{
		Connection conexao = ConexaoFactory.conectar();
		System.out.println("Conexão realizada com sucesso!");
		}catch (SQLException ex){
		ex.printStackTrace();
		System.out.println("Não foi possível realizar a conexão!");
		}
	}
}