package com.lorialawrence.armu.service;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGPT {

    public static void chatGPT (String text) throws IOException, JSONException {
        String url = "https://api.openai.com/v1/engines/davinci/completions";
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + System.getenv("ALURA_SERIES_CHATGPT_API_KEY"));

        JSONObject data = new JSONObject();
        data.put("model", "davinci");
        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 0.7);

        conn.setDoOutput(true);
        conn.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(conn.getInputStream())).lines().reduce((a, b) -> a + b).get();

        System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
    }
}
