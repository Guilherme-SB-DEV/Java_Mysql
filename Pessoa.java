package sql;
import java.sql.*;
public class Conexao {
    
    static Connection conexao;
    PreparedStatement prepared;
    ResultSet rs;
    CallableStatement call;
    
    public static Connection open() throws Exception{
        String usuario = "root";
        String senha = "Gui0205#";
        String url = "jdbc:mysql://localhost:3306/node_db";
        String dri = "com.mysql.jdbc.Driver";
        try{
            Class.forName(dri);
            conexao = DriverManager.getConnection(url, usuario, senha);
        }catch(Exception ex){
            ex.printStackTrace(); 
        }
       
        return conexao;
    }
    public void close() throws Exception{
        conexao.close();
    }
    

}
