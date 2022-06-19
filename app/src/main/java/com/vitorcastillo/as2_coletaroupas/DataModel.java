package com.vitorcastillo.as2_coletaroupas;

import java.util.ArrayList;

public class DataModel {
    private static DataModel instance = new DataModel();
    private DataModel(){
        locais.add(
                new Local(
                        "José e Malu Roupas",
                        "Compra e Venda",
                        "Rua Pará, 503 - Jardim dos Estados 2 - Piraquara/PR - CEP: 84051-610",
                        "(41)98571-7186")
        );
        locais.add(
                new Local(
                        "Henry Roupas",
                        "Compra e Venda",
                        "Rua Chopinzinho, 646 - Ronda - Curitiba/PR - CEP: 84051-610",
                        "(41)98571-7186")
        );
        locais.add(
                new Local(
                        "Alaya Modas",
                        "Compra e Venda",
                        "Rua Elpidio Merisio, 762 - São Braz - Curitiba/PR - CEP: 85603-866",
                        "(41)98430-0651")
        );
        locais.add(
                new Local(
                        "Isicia e Patricia",
                        "Doação e Descarte",
                        "Rua Rosana Cambaúva Cordeiro, 531 - Jardim Everest - Curitiba/PR - CEP: 87075-793",
                        "(41)99646-1936")
        );
        locais.add(
                new Local(
                        "Olivia de Oliveira",
                        "Doação",
                        "Rua Hostílio César de Souza, 339 - Aguas Claras - Piraquara/PR - CEP: 83308-202",
                        "(41)99125-9015")
        );
        locais.add(
                new Local(
                        "Bruno Amarozin",
                        "Doação",
                        "Praça Dom Geraldo Fernandes, 440 - Hauer - Curitiba/PR - CEP: 82568-158",
                        "(41)99562-6116")
        );

    }
    public static DataModel getInstance(){
        return instance;
    }
    public ArrayList<Local> locais = new ArrayList<Local>();
}
