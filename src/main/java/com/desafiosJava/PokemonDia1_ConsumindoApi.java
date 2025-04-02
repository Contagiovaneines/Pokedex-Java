//Dia 1 - Consumindo a API
package com.desafiosJava;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PokemonDia1_ConsumindoApi {
    public static void main(String[] args) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon?limit=700"; // Pegando os primeiros 150 Pokémon
        List<Pokemon> pokemons = new ArrayList<>();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("❌ Erro ao acessar a API!");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray results = jsonObject.getAsJsonArray("results");

            for (int i = 0; i < results.size(); i++) {
                String name = results.get(i).getAsJsonObject().get("name").getAsString();
                Pokemon pokemon = buscarDetalhesPokemon(name);
                if (pokemon != null) {
                    pokemons.add(pokemon);
                }
            }

            gerarHtml(pokemons);
            System.out.println("✅ Pokédex gerada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao acessar API: " + e.getMessage());
        }
    }

    public static Pokemon buscarDetalhesPokemon(String nome) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + nome;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            int id = jsonObject.get("id").getAsInt();
            String type = jsonObject.getAsJsonArray("types").get(0).getAsJsonObject().get("type").getAsJsonObject().get("name").getAsString();

            // Obtendo o GIF animado quando disponível
            String sprite = jsonObject.getAsJsonObject("sprites").has("versions") ?
                    jsonObject.getAsJsonObject("sprites").getAsJsonObject("versions").getAsJsonObject("generation-v").getAsJsonObject("black-white").getAsJsonObject("animated").get("front_default").getAsString() :
                    jsonObject.getAsJsonObject("sprites").get("front_default").getAsString();

            return new Pokemon(nome, id, type, sprite);
        } catch (Exception e) {
            return null;
        }
    }

    public static void gerarHtml(List<Pokemon> pokemons) {
        try (FileWriter file = new FileWriter("pokedex.html", StandardCharsets.UTF_8)) {
            file.write("<html><head><title>Pokedex</title>");
            file.write("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            file.write("<style>");
            file.write("body { text-align: center; background-color: #f8f9fa; }");
            file.write(".pokemon-container { display: flex; flex-wrap: wrap; justify-content: center; }");
            file.write(".pokemon-item { background: white; padding: 15px; margin: 10px; border-radius: 15px; width: 220px; box-shadow: 3px 3px 10px rgba(0,0,0,0.2); transition: transform 0.2s; }");
            file.write(".pokemon-item:hover { transform: scale(1.05); }");
            file.write(".pokemon-item img { width: 120px; height: 120px; display: block; margin: 0 auto; }");
            file.write("</style>");
            file.write("</head><body>");
            file.write("<div class='container'><h1 class='mt-4'>Pokedex</h1>");
            file.write("<input type='text' id='search' class='form-control' onkeyup='searchPokemon()' placeholder='Pesquisar por nome ou ID...'>");
            file.write("<div class='pokemon-container mt-4' id='pokemon-list'>");

            for (Pokemon pokemon : pokemons) {
                file.write("<div class='pokemon-item card' data-name='" + pokemon.getName() + "' data-id='" + pokemon.getId() + "'>");
                file.write("<h5 class='card-title'>" + pokemon.getName() + "</h5>");
                file.write("<p class='card-text'>ID: " + pokemon.getId() + "</p>");
                file.write("<p class='card-text'>Tipo: " + pokemon.getType() + "</p>");
                file.write("<img class='card-img-top' src='" + pokemon.getSprite() + "' alt='Sprite'>");
                file.write("</div>");
            }

            file.write("</div></div>");
            file.write("</body></html>");
        } catch (Exception e) {
            System.out.println("Erro ao gerar HTML: " + e.getMessage());
        }
    }
}