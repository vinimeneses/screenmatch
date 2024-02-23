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
