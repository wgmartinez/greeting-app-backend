package com.equifax.service;

import com.equifax.model.GreetingModel;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Profile("secure")
public class SecureGreetingServiceImpl implements GreetingService {

    private static Map<String, String> repo = new HashMap<>();

    static {
        repo.put("AU", "Secure Gud'day");
        repo.put("GB", "Secure Hello");
        repo.put("US", "Secure Hello");
        repo.put("ES", "Secure Hola");
        repo.put("FR", "Secure Bonjour");
        repo.put("IND", "Secure Namaste");
        repo.put("PH", "Secure Kumusta");
        repo.put("ITA", "Secure Ciao");
        repo.put("CHI", "Secure Ni hao");
        repo.put("KOR", "Secure Yeoboseyo");
    }


    @Override
    public ResponseEntity<String> greet(String country, String firstName) {
        GreetingModel model = new GreetingModel();
        model.setCountry(country);
        model.setMessage(repo.get(country));
        model.setFirstName(firstName);

        return ResponseEntity.ok(model.toString());
    }
}
