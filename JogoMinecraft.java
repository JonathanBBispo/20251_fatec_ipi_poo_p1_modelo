import java.util.Random;
public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var personagem1 = new JogadorMinecraft("Dennis");
        var gerador = new Random();
        while(true){
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
            System.out.println(personagem1);
            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}
