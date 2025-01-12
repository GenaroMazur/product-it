package com.genaro.productosIt.service;

import com.genaro.productosIt.entity.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.client.RestTemplate;

public class UserService {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = userService.getRandomUser();
        System.out.println(user);
    }

    public User getRandomUser() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://randomuser.me/api", String.class);


        assert response != null;
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonObject userObject = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject();

        User user = new User();

        user.setName(userObject.getAsJsonObject("name").get("first").getAsString());
        user.setLastName(userObject.getAsJsonObject("name").get("last").getAsString());
        user.setEmail(userObject.get("email").getAsString());

        return user;
    }
}
