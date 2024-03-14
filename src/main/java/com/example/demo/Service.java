package com.example.demo;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

@org.springframework.stereotype.Service
public class Service {


    public List<Course> whenSetDefaultHeader_thenCorrect()
            throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(
                        new DefaultContentTypeInterceptor("application/json"))
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8080/courses")
                .build();

        Call call = client.newCall(request);
        //Response response = call.execute();

        ObjectMapper objectMapper = new ObjectMapper();
        //ResponseBody responseBody = client.newCall(request).execute().body();
        ResponseBody responseBody = call.execute().body();
        //SimpleEntity entity = objectMapper.readValue(responseBody.string(), SimpleEntity.class);
        //List<Course> entityArray = objectMapper.readValue(responseBody.string(), objectMapper.getTypeFactory().constructCollectionType(List.class, Course.class));
        List<Course> asList = objectMapper.readValue(
                responseBody.string(), new TypeReference<List<Course>>() { });




        System.out.println("response>>>>>>>>>>");
        System.out.println(asList);

        responseBody.close();
        return asList;

    }
}
