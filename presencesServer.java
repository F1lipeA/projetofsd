import java.net.*;
import java.io.*;

public class presencesServer{
    static int DEFAULT_PORT = 2000; 

    public void presencesServer() throws Exception{
        int port = DEFAULT_PORT; 
        Presences presences = new Presences();

        ServerSocket ligacao = new ServerSocket(port);

        System.out.println("Servidor à espera de ligações no porto " + port);

        while(true){
            try{
                Socket rececao = ligacao.accept();

                GetPresencesRequestHandler GPRH = new GetPresencesRequestHandler(rececao, presences);
                GPRH.start();
            }
            catch (IOException e){
                System.out.println("Erro na execução do servidor: " + e);
                System.exit(1);
            }
        }
    }
}