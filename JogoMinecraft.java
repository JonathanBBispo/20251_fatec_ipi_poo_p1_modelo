import java.util.Random;
public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var personagem1 = new JogadorMinecraft("Dennis");
        var personagem2 = new JogadorMinecraft("Steve Construtor");
        var gerador = new Random();
        while(true){
            var sofrerDanos = gerador.nextDouble();
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
            }
            if(sofrerDanos >= 0.25) personagem1.levarDano();
            sofrerDanos = gerador.nextDouble();
            if(sofrerDanos >= 0.25) personagem2.levarDano();
            if(!personagem1.estaVivo() && !personagem2.estaVivo()){
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
