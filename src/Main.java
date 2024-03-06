import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.CabecalhoRecord;
import entities.Titulo;
import exceptions.TamanhoAnoInvalidoException;
import services.Gerenciador;
import services.Requisicao;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String nomeFilme = "";

        while (!nomeFilme.equalsIgnoreCase("sair")){
            System.out.print("Informe o filme requerido: ");
            nomeFilme = sc.nextLine();

            if(nomeFilme.equalsIgnoreCase("sair")){
                break;
            }

            try {
                String json = Requisicao.reqFilme(nomeFilme);
                Gerenciador.instanciaFilme(json);

            } catch (TamanhoAnoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(Gerenciador.getListTitulos());
        Gerenciador.gerarArquivo();

    }

}