package sqldodemonio;

import java.sql.*;
import static sqldodemonio.Conexao.open;

public class DAO {
    public static String instrucao_select = "SELECT * FROM new_table;";
    public static String instrucao_insert = "INSERT INTO new_table(nome, idade) VALUES (?,?);";
    public static String instrucao_update = "UPDATE new_table SET nome=?, idade=? WHERE id =?;";
    public static String instrucao_delete = "DELETE FROM new_table WHERE id = ?;";
        public static void consulta(){
            
            try{
                Connection con = open();
                Statement sentenca = con.createStatement();
                ResultSet rs = sentenca.executeQuery(instrucao_select);
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    System.out.println("id: "+id+" nome: "+nome+" idade: "+idade);
                }
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        public static Boolean insert(String nome, int idade){
            try{
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_insert);
                stm.setString(1, nome);
                stm.setInt(2, idade);
                stm.execute();
            return true;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return false;
            }
        }
        public static Boolean update(int id, String new_nome, int new_idade){
            try {
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_update);
                stm.setString(1, new_nome);
                stm.setInt(2, new_idade);
                stm.setInt(3, id);
                stm.execute();
                
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            
        }
        public static Boolean delete(int id){
            try {
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_delete);
                stm.setInt(1, id);
                stm.execute();
                        
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

}
