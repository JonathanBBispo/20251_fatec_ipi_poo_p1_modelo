import java.util.Random;
public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var personagem1 = new JogadorMinecraft("Dennis");
        var personagem2 = new JogadorMinecraft("Steve Construtor");
        var gerador = new Random();
        
        while(true){
            var sofrerDanos = gerador.nextDouble();
            var quemAtaca = 1 + gerador.nextInt(2);
            
            if(personagem1.estaVivo() && personagem2.estaVivo()){
                switch (quemAtaca) {
                    case 1: 
                        personagem1.ataque(personagem2);
                        break;
        
                    case 2:
                        personagem2.ataque(personagem1);
                        break;
                }
            }

            if(personagem1.estaVivo()) {
                var oQueFazer = 1 + gerador.nextInt(3);
                switch (oQueFazer) {
                    case 1:
                    personagem1.minerar();
                    break;        
                    case 2:
                    personagem1.coletarMadeira();
                    break;
                    case 3:
                    personagem1.construir();
                    break;
                }
                if(sofrerDanos <= 0.25) personagem1.levarDano();
            }
            if(personagem2.estaVivo()){
                var oQueFazer = 1 + gerador.nextInt(10);
                switch (oQueFazer) {
                    case 1, 2, 3, 4, 5, 6:
                    personagem2.construir();
                    break;
                    case 7, 8, 9:
                    personagem2.coletarMadeira();
                    break;
                    case 10:
                    personagem2.minerar();
                    break;
                }
                sofrerDanos = gerador.nextDouble();
                if(sofrerDanos <= 0.25) personagem2.levarDano();
            }

            if(personagem1.estaVivo() && !personagem2.estaVivo()) System.out.println(personagem1.getNome() + " é o vencedor!");
            else if(!personagem1.estaVivo() && personagem2.estaVivo()) System.out.println(personagem2.getNome() + " é o vencedor!");
            else if(!personagem1.estaVivo() && !personagem2.estaVivo()){
                System.out.println("GAME OVER");
                return;
            }

            if(personagem1.estaVivo()) System.out.println(personagem1);
            if(personagem2.estaVivo()) System.out.println(personagem2);
            System.out.println("============");

            Thread.sleep(5000);
        }
    }
}
