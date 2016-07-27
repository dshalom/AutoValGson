package com.example.davidshalom.autoval2.network;


import com.example.davidshalom.autoval2.model.Season;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FootballServiceImpl implements FootballService {

    private FootballApiService footballApiService;

    public FootballServiceImpl(Retrofit retrofit) {
        this.footballApiService = retrofit.create(FootballApiService.class);
    }

    @Override
    public void getSeasons(GetSeasonListener getSeasonListener) {

        footballApiService.getSeasons().subscribeOn(Schedulers.io())
                .flatMap((List<Season> seasons) -> Observable.from(seasons)
                        .filter(season -> season.id() == 424)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()))
                .subscribe(getSeasonListener::onSeasonsLoaded);

    }
}
