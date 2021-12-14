import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class serverApp {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, Exception {
        String n_identificacao;
        
        Scanner read = new Scanner(System.in);
        
        System.out.println("Insira o numero de identificacao: ");
        
        n_identificacao = read.nextLine();
        
        System.out.println("Numero de identificacao" + n_identificacao);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(n_identificacao.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            System.out.println("Hash: " + hashtext);
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
        presencesServer ligarServidor = new presencesServer();
        ligarServidor.presencesServer();
    }
}