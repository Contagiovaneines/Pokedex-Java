// Dia 5 - Encapsulando Código em Classes
package com.desafiosJava;

public class PokemonDia5_Servico {
    public static Pokemon buscarPokemon(String nome) {
        return new Pokemon(nome, 25, "Elétrico", "https://image.url");
    }
}

