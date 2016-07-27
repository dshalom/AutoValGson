package com.example.davidshalom.autoval2;

import com.example.davidshalom.autoval2.model.Season;

interface SeasonView {
    void displayError();
    void showProgress();
    void hideProgress();
    void showSeason(Season season);
}

