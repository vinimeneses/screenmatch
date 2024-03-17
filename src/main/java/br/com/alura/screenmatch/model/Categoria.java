package br.com.alura.screenmatch.model;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.regex.Pattern;

public enum Categoria {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime"),
    ANIMATION("Animation", "Animação"),
    BIOGRAPHY("Biography", "Biografia"),
    ADVENTURE("Adventure", "Aventura");

    private String categoriaOmdb;
    private String categoriaPortugues;

    Categoria(String categoriaOmdb, String categoriaPortugues){
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }
    public static Categoria fromString(String text) {
        return Arrays.stream(values())
                .filter(categoria -> categoria.categoriaOmdb.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text));
    }

    public static Categoria fromPortugues(String text) {
        String normalizedText = normalizeText(text);
        return Arrays.stream(values())
                .filter(categoria -> normalizeText(categoria.categoriaPortugues).equals(normalizedText))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text));
    }

    private static String normalizeText(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizedText).replaceAll("").toLowerCase();
    }
}