/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

public class PessoaDao extends Dao{
    String instrucao_insert = "INSERT INTO pessoa(nome, email, imc) VALUES (?,?,?)";
    String instrucao_delete = "DELETE FROM pessoa WHERE idpessoa = ?";
    String instrucao_update = "UPDATE pessoa SET nome = ?, email = ?, imc = ? WHERE idpessoa = ?";
    
    
}
