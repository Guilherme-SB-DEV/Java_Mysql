
package mysql;
import java.util.Scanner;

public class Mysql {
     // jdbc:mysql://localhost:3306/mydb
    public static void main(String[] args) throws ClassNotFoundException {
        
        
        Pessoa p1 = new Pessoa();
        
        
        
        Scanner input = new Scanner(System.in);
        /*
        System.out.println("nome: ");
        String nome_insert = input.nextLine();
        p1.setNome(nome_insert);
        System.out.println("email: ");
        String email_insert  = input.nextLine();
        p1.setEmail(email_insert);
        System.out.println("peso: ");
        Double peso = input.nextDouble();
        System.out.println("altura: ");
        Double altura = input.nextDouble();
        System.out.println("id q vc quer deletar: ");
        int id_del = input.nextInt();
        */

        try{
            Class.forName(dri);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement sentenca = conexao.createStatement();
            /* 
            PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_insert);
            preparedStatement.setString(1, nome_insert);
            preparedStatement.setString(2, email_insert);
            preparedStatement.setDouble(3, p1.calcImc(peso, altura));
            preparedStatement.executeUpdate();
            */
            ResultSet rs = sentenca.executeQuery(instrucao);
            /*  
            while(rs.next()){
                int id = rs.getInt("idpessoa");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Double getimc = rs.getDouble("imc");
                System.out.println("id: "+id + " -nome: "+ nome +" -email: "+ email+" -imc: "+getimc);
            }
            
            System.out.println("conexao realizada com sucesso");
            
            PreparedStatement deleta = conexao.prepareStatement(instrucao_delete);
            deleta.setInt(1, id_del);
            deleta.execute();
            */
            System.out.println("update");
            System.out.println("id: ");
            int id_update = input.nextInt();
            
            System.out.println("nome: ");
            String nome_update = input.next();
            
            System.out.println("email: ");
            String email_update = input.next();
            System.out.println("peso: ");
            Double peso_update = input.nextDouble();
            System.out.println("altura: ");
            Double altura_update = input.nextDouble();
            Double imc_update = p1.calcImc(peso_update, altura_update);
            
            
            PreparedStatement update = conexao.prepareStatement(instrucao_update);
            update.setInt(4, id_update);
            update.setString(1, nome_update);
            update.setString(2, email_update);
            update.setDouble(3, imc_update);
            update.executeUpdate();
            
            
            while(rs.next()){
                int id = rs.getInt("idpessoa");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Double getimc = rs.getDouble("imc");
                System.out.println("id: "+id + " -nome: "+ nome +" -email: "+ email+" -imc: "+getimc);
            }
            
        }catch(SQLException| ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
