package mysql;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Dao {
    Connection conexao;
    PreparedStatement prepared;
    ResultSet rs;
    CallableStatement call;
    
    
    public void open() throws Exception{
        String usuario = "#####";
        String senha = "#####";
        String url = "jdbc:mysql://localhost:3306/sla";
        String dri = "com.mysql.jdbc.Driver";
        try{
            Class.forName(dri);
            conexao = DriverManager.getConnection(url, usuario, senha);
        }catch(Exception ex){
            ex.printStackTrace(); 
        }
    }
    public void close() throws Exception{
        conexao.close();
    }
    

}
