package com.dannik.docker_master;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FiboService {


    FiboRepository fiboRepository;
    ProjectProperties projectProperties;

    @Autowired
    private FiboService(FiboRepository fiboRepository, ProjectProperties projectProperties){
        this.fiboRepository = fiboRepository;
        this.projectProperties = projectProperties;
    }


    public Fibo getLastFibo(){
        return fiboRepository.findTop1ByOrderByIdDesc();
    }


    public void calculateNewFibo(){

        OkHttpClient client = new OkHttpClient();
        RequestBody emptyBody = RequestBody.create(null, new byte[0]);
        Request request = new Request.Builder()
                    .url("http://" + projectProperties.getWorkerHost() + "/calculate")
                    .put(emptyBody)
                    .build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFibo(){
        fiboRepository.deleteAll();
        fiboRepository.save(new Fibo(0, 1));
    }


}
