package com.example.MicroservicesApplication.repository;

import com.example.MicroservicesApplication.dto.Plant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface PlantRetrofitRepository {

    @GET("/perl/mobile/viewplantsjsonarray.pl")
    Call<List<Plant>> getPlants(@Query("Combined_Name") String combinedName);
}
