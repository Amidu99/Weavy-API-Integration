package lk.ijse.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.backend.dto.UserDTO;
import lk.ijse.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import okhttp3.RequestBody;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class User {
    private final UserService userService;
    private final ObjectMapper objectMapper;
    OkHttpClient client = new OkHttpClient();

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "User API Health is ok";
    }

    @PostMapping("/save")
    public String saveUser(@org.springframework.web.bind.annotation.RequestBody UserDTO user) throws IOException {
        String json = objectMapper.writeValueAsString(user);
        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url("https://132ba88fd9464cff845031fb40336690.weavy.io/api/users")
                .post(body)
                .header("Authorization", "Bearer wys_xihxG7BtGb2xaK2TcoFs4c2TqcXGOj4aQg8E")
                .build();

        Response response = client.newCall(request).execute();
        try {
            return response.body().string();
        } finally {
            response.close();
        }
    }
}