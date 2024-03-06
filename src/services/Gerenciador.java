package services;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.CabecalhoRecord;
import entities.Titulo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private static List<Titulo> listTitulos = new ArrayList<>();
    private static Gson gson = new GsonBuilder().
            setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
    public static void instanciaFilme(String json){
        CabecalhoRecord cabecalho = gson.fromJson(json, CabecalhoRecord.class);
        Titulo titulo = new Titulo(cabecalho);
        listTitulos.add(titulo);
        System.out.println(titulo);

    }
    public static void gerarArquivo() throws IOException {
        FileWriter arquivo = new FileWriter("filmes.json");
        arquivo.write(gson.toJson(listTitulos));
        arquivo.close();
    }
    public static List<Titulo> getListTitulos() {
        return listTitulos;
    }

}
