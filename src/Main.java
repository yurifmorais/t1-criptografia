//criar uma funcao para criptografar. vai receber o texto e N como parametros;
//criar uma funcao para descriptografar. vai receber o texto criptografado e N como parametros;

//tenho que fazer o tratamento para quando o texto tiver uma LETRA 'z" por ex. ai devo contar do inicio do alfabeto, pois nao tem nada dps do Z
//resolvi o problema acima adicionando o alfabeto novamente na string. mas deve ter um metodo melhor;
//prox passo é descriptografar
import java.util.Scanner;
public class Main {
    public static void criptografa(){
        Scanner sc = new Scanner(System.in);
        //recebe os dados para serem criptografados
        System.out.println("Informe o texto a ser criptografado: ");
        String texto = sc.nextLine();
        System.out.println("Informe o valor de K: ");
        int k = sc.nextInt();

        //tratando o texto de entrada
        texto = texto.toLowerCase();
        texto = texto.replaceAll("\\s", "");//retira os espacos
        System.out.println("TEXTO DE ENTRADA: " + texto);

        //GOL K = 4;
        //KSP
        //PEGO A POSICAO DO G+4

        //criptografando
        String alfabeto = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        int x = 0, posicao;
        char letra;
        String textoCriptografado = "";
        while (x < texto.length()){
            letra = texto.charAt(x);
            posicao = alfabeto.indexOf(letra);
            //System.out.println("alfabeto.charAt(letra): " + alfabeto.charAt(posicao));
            //System.out.println(alfabeto.charAt(posicao+k));
            textoCriptografado = textoCriptografado + alfabeto.charAt(posicao+k);
            x++;
        }
        System.out.println("Texto criptografado: " + textoCriptografado);
    }

    public static void descriptografa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o texto a ser descriptografado: ");
        String texto = sc.nextLine();

        //tratando o texto de entrada
        texto = texto.toLowerCase();
        texto = texto.replaceAll("\\s", "");//retira os espacos
        System.out.println("TEXTO DE ENTRADA: " + texto);

        //criptografando
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";//ihyevhs
        int x = 0, posicao;
        char letra;
        String textoCriptografado = "";
        int i = 1;
        while (i < 11){//ihyevhs
            while (x < texto.length()) {
                letra = texto.charAt(x);
                posicao = alfabeto.indexOf(letra);
                //as vezes funciona e as vezes nao
                if (posicao > i) textoCriptografado = textoCriptografado + alfabeto.charAt(posicao - i);
                else textoCriptografado = textoCriptografado + alfabeto.charAt(posicao%26 - posicao);
                x++;
            }
            System.out.println("Possivel texto com K = "+ i + ": " + textoCriptografado);
            i++;
            x=0;
            textoCriptografado = "";
        }
        //System.out.println("Texto criptografado: " + textoCriptografado);

    }
    public static void main(String[] args) {
        descriptografa();
    }
}