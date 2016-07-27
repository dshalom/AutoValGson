package com.example.davidshalom.autoval2;

import com.example.davidshalom.autoval2.model.Season;
import com.example.davidshalom.autoval2.network.FootballService;
import com.example.davidshalom.autoval2.network.GetSeasonListener;

public class SeasonPresenterImpl implements SeasonPresenter {

    private FootballService footballService;
    private SeasonView seasonView;

    public SeasonPresenterImpl(FootballService footballService) {
        this.footballService = footballService;
    }

    @Override
    public void setView(SeasonView view) {
        seasonView = view;
    }

    @Override
    public void getSeasons() {
        seasonView.showProgress();
        footballService.getSeasons(season -> {
            seasonView.showSeason(season);
        });
    }

//    public void movieGenresLoaded(List<MovieGenre> movieGenres) {
//        seasonView.hideProgress();
//    }

    public void movieGenresFailed() {
        seasonView.hideProgress();
        seasonView.displayError();
    }
}
