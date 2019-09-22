package com.equifax.service;

import com.equifax.model.GreetingModel;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@Service
@Profile("dev")
public class InsecureGreetingServiceImpl implements GreetingService {

    private static Map<String, String> repo = new HashMap<>();

    static {
        repo.put("AU", "Gud'day");
        repo.put("GB", "Hello");
        repo.put("US", "Hello");
        repo.put("ES", "Hola");
        repo.put("FR", "Bonjour");
        repo.put("IND", "Namaste");
        repo.put("PH", "Kumusta");
        repo.put("ITA", "Ciao");
        repo.put("CHI", "Ni hao");
        repo.put("KOR", "Yeoboseyo");
    }


    @Override
    public ResponseEntity<String> greet(String country, String firstName) {
        GreetingModel model = new GreetingModel();
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            model.setCountry(country);
            model.setMessage(repo.get(country) + " - " + inetAddress.getHostAddress());
            model.setFirstName(firstName);
        } catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(model.toString());
    }
}
