package cadastroaluno;

import java.sql.*;

public class Conexao {
    String driver = "com.mysql.jdbk.Driver"; //Driver para conexão com o Banco
    String banco = "CadAluno"; //Nome do banco de dados
    String host = "localhost"; //Servidor do banco de dados
    String stringDeConexao = "jdbc:mysql://" + host + ":3306/" + banco + "?serverTimezone=UTC"; //String de conexão com o Banco
    String usuario = "root"; //Usuario do Banco de Dados
    String senha = "123456";
    
    public Connection conexao;
    
    public Conexao(){}
    
    public Connection getConexao()
    {
        try
        {
            Class.forName(driver); //carrega o driver
            return DriverManager.getConnection(this.stringDeConexao,usuario,senha);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return conexao;
        }
    }
    
    public ResultSet getResultSet(String sentenca)
    {
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            ResultSet rs = stm.executeQuery(sentenca);
            return rs;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String atualizarBanco(String sentenca)
    {
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            stm.executeUpdate(sentenca);
            return "1";
        }
        catch(SQLException e)
        {
            return e.getMessage();
        }
        catch(Exception ex)
        {
            return ex.getMessage();
        }
    }
}
