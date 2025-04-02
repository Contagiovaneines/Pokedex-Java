package com.desafiosJava;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PokemonDia4_GerandoHTML {
    public static void gerarHtml(List<Pokemon> pokemons) {
        try (FileWriter file = new FileWriter("pokedex.html", StandardCharsets.UTF_8)) {
            file.write("<html><head><meta charset='UTF-8'><title>Pokédex</title>");
            file.write("<meta charset='UTF-8'>");
            file.write("<style>");
            file.write("body { font-family: Arial, sans-serif; text-align: center; }");
            file.write("input { margin: 20px; padding: 10px; font-size: 16px; }");
            file.write(".pokemon-card { border: 1px solid #ccc; padding: 10px; margin: 10px; display: inline-block; }");
            file.write("</style>");
            file.write("<script>");
            file.write("function filtrarPokemon() {");
            file.write("var filtro = document.getElementById('search').value.toLowerCase();");
            file.write("var pokemons = document.getElementsByClassName('pokemon-card');");
            file.write("for (var i = 0; i < pokemons.length; i++) {");
            file.write("var nome = pokemons[i].getElementsByTagName('h2')[0].innerText.toLowerCase();");
            file.write("pokemons[i].style.display = nome.includes(filtro) ? 'inline-block' : 'none';");
            file.write("}}");
            file.write("</script>");
            file.write("</head><body>");
            file.write("<div class='container'><h1 class='mt-4'>Pokédex</h1>");
            file.write("<input type='text' id='search' onkeyup='filtrarPokemon()' placeholder='Pesquisar Pokémon...'>");

            for (Pokemon pokemon : pokemons) {
                file.write("<div class='pokemon-card'>");
                file.write("<h2>" + pokemon.getName() + "</h2>");
                file.write("<p>ID: " + pokemon.getId() + "</p>");
                file.write("<p>Tipo: " + pokemon.getType() + "</p>");
                file.write("<img src='" + pokemon.getSprite() + "' alt='Sprite'>");
                file.write("</div>");
            }

            file.write("</body></html>");
        } catch (IOException e) {
            System.out.println("Erro ao gerar HTML: " + e.getMessage());
        }
    }
}