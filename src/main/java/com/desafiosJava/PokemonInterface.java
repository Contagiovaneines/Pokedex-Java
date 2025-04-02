// Dia 6 - Tornando o Código Genérico com Interfaces
package com.desafiosJava;

interface PokemonInterface {
    Pokemon buscar(String nome);
}

class PokemonServico implements PokemonInterface {
    @Override
    public Pokemon buscar(String nome) {
        return PokemonDia5_Servico.buscarPokemon(nome);
    }
}