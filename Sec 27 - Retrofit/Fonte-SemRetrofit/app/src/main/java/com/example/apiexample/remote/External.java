package com.example.apiexample.remote;

import com.example.apiexample.entity.APIResponseEntity;
import com.example.apiexample.entity.ParameterEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

public class External {

    /**
     * Executa chamada a API
     */
    public APIResponseEntity execute(ParameterEntity param) {

        APIResponseEntity response;

        InputStream inputStream;
        HttpURLConnection conn;

        try {
            URL url;

            if (param.getMethod().equals("GET"))
                url = new URL(param.getUrl() + getQuery(param.getParameters(), param.getMethod()));
            else
                url = new URL(param.getUrl());

            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(100000);
            conn.setConnectTimeout(150000);
            conn.setRequestMethod(param.getMethod());
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);

            // Faz tratamento para headers
            if (param.getHeaderParameters() != null) {
                Iterator it = param.getHeaderParameters().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    conn.setRequestProperty(pair.getKey().toString(), pair.getValue().toString());
                    it.remove();
                }
            }

            // Tratamento para os verbos que mandam dados no corpo
            if (!param.getMethod().equals("GET")) {

                String query = getQuery(param.getParameters(), param.getMethod());
                byte[] postDataBytes = query.getBytes(StandardCharsets.UTF_8);
                int postDataLength = postDataBytes.length;

                // Faz tratamento para parâmetros de body
                conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));

                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);
            }

            // Starts the query
            conn.connect();

            // Caso seja erro 404, não existe input strem fazendo com que caia sempre na exception
            if (conn.getResponseCode() != 200) {
                // Lê conteúdo de erro
                inputStream = conn.getErrorStream();
            } else {
                // Lê conteúdo de sucesso
                inputStream = conn.getInputStream();
            }
            // Monta a classe de resposta da API
            response = new APIResponseEntity(getStringFromInputStream(inputStream), conn.getResponseCode());

            inputStream.close();
            conn.disconnect();

        } catch (Exception e) {
            response = new APIResponseEntity("", 404);
        }

        // Retorna entidade preenchida
        return response;
    }

    /**
     * Faz a conversão do retorno do webservice para string
     */
    private String getStringFromInputStream(InputStream is) {

        if (is == null)
            return "";

        BufferedReader br;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (IOException e) {
            return "";
        }

        return sb.toString();
    }

    /**
     * Monta a query string
     */
    private String getQuery(AbstractMap<String, String> params, String method) throws UnsupportedEncodingException {

        if (params == null)
            return "";

        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, String> e : params.entrySet()) {
            if (first) {
                if (method.equals("GET")) {
                    result.append("?");
                }
                first = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(e.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(e.getValue(), "UTF-8"));
        }

        return result.toString();
    }

}
