package com.example.davidshalom.autoval2.network;


import com.example.davidshalom.autoval2.model.Season;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

interface FootballApiService {
    @GET("soccerseasons")
    Observable<List<Season>> getSeasons();
}
