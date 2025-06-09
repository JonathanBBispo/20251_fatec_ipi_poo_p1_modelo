package br.p2;

import java.sql.*;
import java.util.*;

public class JogadorMinecraftDAO {
    public ArrayList<JogadorMinecraft> listar() throws Exception {
        var personagens = new ArrayList<JogadorMinecraft>();
        var sql = "SELECT * FROM tb_personagem";
        try(
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
            var codigo = rs.getInt("cod_personagem");
            var nome = rs.getString("nome");
            var vitorias = rs.getInt("n_vitorias");
            var derrotas = rs.getInt("n_derrotas");
            var probConstruir = rs.getDouble("prob_construir");
            var probColetar = rs.getDouble("prob_coletar");
            var probMinerar = rs.getDouble("prob_minerar");
            var personagem = new JogadorMinecraft(codigo, nome, vitorias, derrotas, probConstruir, probColetar, probMinerar);
            personagens.add(personagem);
            }
            return personagens;
        }
    }
    public void atualizar(JogadorMinecraft personagem) throws Exception{
        var sql = "UPDATE tb_personagem SET n_vitorias = ?, n_derrotas = ? WHERE cod_personagem = ?";

        try(var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);){
                ps.setInt(1, personagem.getVitorias());
                ps.setInt(2, personagem.getDerrotas());
                ps.setInt(3, personagem.getCodigo());
                ps.execute();
            }
    }
}