/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.Conexao;

/**
 *
 * @author Administrador
 */
public class Funcionariodao {
    public boolean inserir(String cod,String nom,String tel) {
        String sql = "INSERT INTO categoria(descricao) VALUES (?)";//define instrução SQL
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução SQL
            ps.setString(1, cod);
            ps.setString(2, nom);// primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.setString(3, tel);
            ps.execute(); //executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Eventodao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        //crie um objeto da classe 
        Funcionariodao dao = new Funcionariodao();
        //chame o método inserir desse objeto
        boolean result = dao.inserir("01","jose","2456423");
        if (result) {
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas com a inserção!");
        }
    }
}
