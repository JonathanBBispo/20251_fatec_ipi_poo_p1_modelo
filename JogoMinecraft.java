import java.util.Random;
public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var personagem1 = new JogadorMinecraft("Dennis");
        var gerador = new Random();
        while(true){
            var oQueFazer = 1 + gerador.nextInt(3);
            var sofrerDanos = gerador.nextDouble();
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
            if(!personagem1.estaVivo()){
                System.out.println("GAME OVER");
                return;
            }
            System.out.println(personagem1);
            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}
