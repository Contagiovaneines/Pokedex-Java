package com.desafiosJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokemonDia7_Ordenando {
    public static void main(String[] args) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon?limit=700"; // Alterar limite se necessário
        List<Pokemon> pokemons = new ArrayList<>();

        // Consumir API e buscar Pokémon
        PokemonDia1_ConsumindoApi.main(null); // Isso executa a busca e gera o HTML diretamente.

        // Ordenar por ID
        Collections.sort(pokemons, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));

        // Gerar a Pokédex em HTML
        PokemonDia1_ConsumindoApi.gerarHtml(pokemons);

        System.out.println("✅ Pokédex gerada! Abra 'pokedex.html' no navegador.");
    }
}