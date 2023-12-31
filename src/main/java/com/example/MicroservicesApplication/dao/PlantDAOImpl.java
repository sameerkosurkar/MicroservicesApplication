package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Plant;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Repository
public class PlantDAOImpl implements PlantDAO {
    @Override
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        PlantRetrofitRepository plantRetrofitRepository = retrofitInstance.create(PlantRetrofitRepository.class);
        Call<List<Plant>> allPlants = plantRetrofitRepository.getPlants(combinedName);
        Response<List<Plant>> execute = allPlants.execute();
        List<Plant> plants = execute.body();
        return plants;
    }
}
