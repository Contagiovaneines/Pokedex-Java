// Dia 3 - Criando a Classe
package com.desafiosJava;

public class Pokemon {
    private String name;
    private int id;
    private String type;
    private String sprite;

    public Pokemon(String name, int id, String type, String sprite) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.sprite = sprite;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSprite() {
        return sprite;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}