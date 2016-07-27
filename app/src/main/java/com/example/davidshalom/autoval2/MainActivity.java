package com.example.davidshalom.autoval2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.davidshalom.autoval2.databinding.ActivityMainBinding;
import com.example.davidshalom.autoval2.model.Season;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity  implements  SeasonView{

    @Inject
    SeasonPresenter seasonPresenter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ((FootballApplication) getApplication()).getComponent().inject(this);
        seasonPresenter.setView(this);
        seasonPresenter.getSeasons();
    }

    @Override
    public void displayError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showSeason(Season season) {

        binding.setVariable(BR.season, season);

    }
}
