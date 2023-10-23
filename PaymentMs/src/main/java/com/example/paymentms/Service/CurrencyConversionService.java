package com.example.paymentms.Service;





import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyConversionService {

    private static final String API_KEY = "d80ee14c3f280ae67989026ce18f656c";
    private static final String API_URL = "https://open.er-api.com/v6/latest/TND";

    public double convertTNDtoUSD(double amountInTND) {
        RestTemplate restTemplate = new RestTemplate();
        ConversionResponse response = restTemplate.getForObject(API_URL, ConversionResponse.class);

        if (response != null && response.getRates() != null) {
            Double usdRate = response.getRates().get("USD");
            if (usdRate != null) {
                return amountInTND * usdRate;
            }
        }
        throw new RuntimeException("Failed to fetch conversion rate");
    }

    public static class ConversionResponse {
        private Map<String, Double> rates;

        public Map<String, Double> getRates() {
            return rates;
        }

        public void setRates(Map<String, Double> rates) {
            this.rates = rates;
        }
    }
}
