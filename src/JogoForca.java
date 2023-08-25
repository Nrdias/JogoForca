import java.util.Random;
import java.util.Scanner;

public class JogoForca {
    public static void executar () {
        System.out.println("===============");
        System.out.println(" Jogo da Forca ");
        System.out.println("===============");

        Scanner in = new Scanner(System.in);

        // Configurar jogo
        String[] bancoPalavras = {
                "ABACATE",
                "MANGA",
                "MELANCIA",
                "JABUTICABA",
                "BANANA",
                "PESSEGO",
        };
        Random random = new Random();

        int indicePalavraSorteada = random.nextInt(0,5);
        int chancesRestantes = 10;
        String palavraSorteada = bancoPalavras[indicePalavraSorteada];
        String resposta = "";
        int tamPalavraSorteada = palavraSorteada.length();
        char[] letrasEscondidas = palavraSorteada.toCharArray();
        char[] letrasReveladas = new char[tamPalavraSorteada];
        for (int i = 0; i < tamPalavraSorteada; i++) {
            letrasReveladas[i] = '?';
        }

        // Loop do jogo
        while (chancesRestantes > 0) {

            for(int i = 0; i < letrasReveladas.length; i++){
                if(letrasReveladas[i] == '?'){
                    resposta = "";
                    break;
                }else{
                    resposta += letrasReveladas[i];
                }
            }

            if(resposta.equals(palavraSorteada)){
                System.out.println("""
                    ====Você ganhou====
                            O
                           /|\\
                           / \\
                """);
                return;
            }
            System.out.println(letrasReveladas);
            System.out.println("\nChances restantes: " + chancesRestantes);

            // Mostra letras ja reveladas
            for (int i = 0; i < tamPalavraSorteada; i++) {
                System.out.print(letrasReveladas[i]);
            }
            System.out.println(); // quebra a linha

            // Solicita letra do usuario
            System.out.print("Letra: ");
            String strLetraDigitada = in.nextLine().toUpperCase();
            char letraDigitada = strLetraDigitada.charAt(0);

            // Revela letras, se existirem.
            boolean letraEncontrada = false;
            for (int i = 0; i < tamPalavraSorteada; i++) {
                if (letrasEscondidas[i] == letraDigitada) {
                    letraEncontrada = true;
                    letrasReveladas[i] = letrasEscondidas[i];
                }
            }

            // Reduz nro de chances se letra digitada nao existir.
            if (!letraEncontrada) {
                chancesRestantes--;
            }
        }

        System.out.println("""
                ====GAME OVER====
                    |-------|
                    O       |
                   /|\\      |
                   / \\      |
                         __dIb__
                """);

    }



}