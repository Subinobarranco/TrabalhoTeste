/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javax.swing.JOptionPane;
import persistencia.Conexao;

/**
 *
 * @author Administrador
 */
public class Eventodao {
    
    public boolean inserir(String dataString,int nume,int tipo) {
        String sql = "INSERT INTO categoria(nome) VALUES (?)";//define instrução SQL
        PreparedStatement ps;
        DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        java.sql.Date datas = new java.sql.Date(long fmt.parse(dataString));
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução SQ
            ps.setDate(1, datas);// primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.setInt(2, nume);
            ps.setInt(3, tipo);
            ps.execute(); //executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Eventodao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        //crie um objeto da classe 
        Eventodao dao = new Eventodao();
        //chame o método inserir desse objeto
        boolean result = dao.inserir("2000/05/13", 100, 5);
        if (result) {
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas com a inserção!");
        }
    }

}