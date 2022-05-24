package com.github.dmitrKuznetsov.dto;

public enum Gender {
    undefined("Н/О"),
    male("Мужчина"),
    female("Женщина");

    private String alias;

    Gender(String alias) {
        this.alias = alias;
    }

    public String alias() {
        return alias;
    }
}
