package br.p2;
import java.util.*;
import lombok.*;

@Getter
@Setter
public class JogadorMinecraft {
    private String nome;
    private int vida;
    private int blocosColetados;
    private List<String> inventario;
    private int vitorias;
    private int derrotas;
    

    public JogadorMinecraft(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.blocosColetados = 0;
        this.inventario = new ArrayList<>();
    }

    public void minerar() {
        System.out.println(nome + " está minerando...");
        blocosColetados++;
        inventario.add("Pedra");
    }

    public void coletarMadeira() {
        System.out.println(nome + " coletou madeira.");
        inventario.add("Madeira");
    }

    public void construir() {
        if (inventario.size() >= 2) {
            System.out.println(nome + " construiu algo com seus recursos!");
            inventario.remove(0);
            inventario.remove(0);
        } else {
            System.out.println(nome + " não tem blocos suficientes para construir.");
        }
    }

    public void levarDano() {
        if(estaVivo()){
            vida--;
            System.out.println(nome + " levou dano! Vida atual: " + vida);
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void ataque(JogadorMinecraft personagem){
                System.out.print(nome + " atacou! ");
                personagem.levarDano();
    }

    @Override
    public String toString() {
        return String.format(
            "%s - Vida: %d, Blocos: %d, Inventário: %s",
            nome, vida, blocosColetados, inventario
        );
    }
}
