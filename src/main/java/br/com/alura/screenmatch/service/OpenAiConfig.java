package br.com.alura.screenmatch.service;

public class OpenAiConfig {

    private static final String API_KEY = "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";

    public static String getApiKey() {
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalStateException("Chave da API da OpenAI não configurada. Configure a variável de ambiente OPENAI_API_KEY.");
        }
        return API_KEY;
    }
}