package fr.oukilson.app.entity;

import java.util.UUID;

public class Game {

    private String name;
    private UUID UUID;

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUUID() {
        return UUID;
    }

    public void setUUID(UUID UUID) {
        this.UUID = UUID;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                '}';
    }
}
