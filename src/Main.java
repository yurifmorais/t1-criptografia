////criar uma funcao para criptografar. vai receber o texto e N como parametros;
////criar uma funcao para descriptografar. vai receber o texto criptografado e N como parametros;
//
////tenho que fazer o tratamento para quando o texto tiver uma LETRA 'z" por ex. ai devo contar do inicio do alfabeto, pois nao tem nada dps do Z
////resolvi o problema acima adicionando o alfabeto novamente na string. mas deve ter um metodo melhor;
////prox passo é descriptografar
import java.util.Scanner;

public class Main {

    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

    public static void criptografa(String texto, int k) {
        texto = trataTextoEntrada(texto);
        StringBuilder textoCriptografado = new StringBuilder();
        for (char letra : texto.toCharArray()) {
            int posicao = ALFABETO.indexOf(letra);
            if (posicao != -1) {
                char letraCriptografada = ALFABETO.charAt(posicao + k);
                textoCriptografado.append(letraCriptografada);
            } else {
                textoCriptografado.append(letra);
            }
        }
        System.out.println("Texto criptografado: " + textoCriptografado.toString());
    }

    public static void descriptografa(String texto) {
        texto = trataTextoEntrada(texto);
        StringBuilder textoDescriptografado = new StringBuilder();
        for (int k = 0; k < 26; k++) {
            for (char letra : texto.toCharArray()) {
                int posicao = ALFABETO.indexOf(letra);
                if (posicao != -1) {
                    char letraDescriptografada = ALFABETO.charAt(posicao - k + 25);
                    textoDescriptografado.append(letraDescriptografada);
                } else {
                    textoDescriptografado.append(letra);
                }
            }
            System.out.println("Possivel texto com K = " + k + ": " + textoDescriptografado.toString());
            textoDescriptografado.setLength(0);
        }
    }

    public static String trataTextoEntrada(String texto) {
        texto = texto.toLowerCase().replaceAll("\\s", "");
        return texto;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o texto: ");
        String texto = sc.nextLine();
        System.out.println("Deseja criptografar ou descriptografar? (C/D)");
        String escolha = sc.nextLine();
        switch (escolha.toUpperCase()) {
            case "C":
                System.out.println("Informe o valor de K: ");
                int kCriptografia = sc.nextInt();
                criptografa(texto, kCriptografia);
                break;
            case "D":
                descriptografa(texto);
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }
    }
}
