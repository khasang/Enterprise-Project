package io.khasang.enterprise.webservice.exchangerates;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.DoubleNode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CurrencyService {

    private static ObjectMapper mapper = new ObjectMapper();
    private static JsonNode rootNode = getRootNode();

    public String getCurrency(String code) {
        DoubleNode result = (DoubleNode) rootNode.get("Valute").get(code).get("Value");
        return result.asText();
    }

    public String getCurrentDay() {
        String date = rootNode.get("Date").asText().substring(0,10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.getDayOfMonth() + "-" + localDate.getMonth() + "-" + localDate.getYear();
    }

    private static JsonNode getRootNode() {
        try {
            rootNode = mapper.readTree(new URL("https://www.cbr-xml-daily.ru/daily_json.js"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rootNode;
    }
}
