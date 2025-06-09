package br.p2;
import java.util.Random;
import java.util.ArrayList;
public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var personagens = new ArrayList<JogadorMinecraft>();
        try{
            personagens = new JogadorMinecraftDAO().listar();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Sistema indisponível");
            return;
        }

        var gerador = new Random();
        var rounds = 1;
        
        while(true){
            var quemAtaca = 1 + gerador.nextInt(2);
            System.out.printf("Round %d\n", rounds);
            if(personagens.get(0).estaVivo() && personagens.get(1).estaVivo()){
                switch (quemAtaca) {
                    case 1: 
                        personagens.get(0).ataque(personagens.get(1));
                        break;
        
                    case 2:
                        personagens.get(1).ataque(personagens.get(0));
                        break;
                }
            }
            for(int i=0; i < personagens.size(); i++){
                if(personagens.get(i).estaVivo()){
                    var oQueFazer = gerador.nextDouble();
                    if(oQueFazer <= personagens.get(i).getProbColetar()) personagens.get(i).coletarMadeira();
                    else if(oQueFazer <= (personagens.get(i).getProbColetar() + personagens.get(i).getProbMinerar())) personagens.get(i).minerar();
                    else personagens.get(i).construir();

                    var sofrerDanos = gerador.nextDouble();
                    if(sofrerDanos <= 0.25) personagens.get(i).levarDano();
                }
            }


            if(personagens.get(0).estaVivo() && !personagens.get(1).estaVivo()) System.out.println(personagens.get(0).getNome() + " é o vencedor!");
            else if(!personagens.get(0).estaVivo() && personagens.get(1).estaVivo()) System.out.println(personagens.get(1).getNome() + " é o vencedor!");
            else if(!personagens.get(0).estaVivo() && !personagens.get(1).estaVivo()){
                System.out.println("GAME OVER");
                return;
            }

            for(int i =0; i < personagens.size(); i++)
                if(personagens.get(i).estaVivo())
                    System.out.println(personagens.get(i));
            System.out.println("============");

            rounds++;
            Thread.sleep(5000);
        }
    }
}
