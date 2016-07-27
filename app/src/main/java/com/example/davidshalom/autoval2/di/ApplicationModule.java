package com.example.davidshalom.autoval2.di;

import android.app.Application;

import com.example.davidshalom.autoval2.SeasonPresenter;
import com.example.davidshalom.autoval2.SeasonPresenterImpl;
import com.example.davidshalom.autoval2.network.FootballService;
import com.example.davidshalom.autoval2.network.FootballServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    FootballService provideFootballService(Retrofit retrofit) {
        return new FootballServiceImpl(retrofit);
    }

    @Provides
    SeasonPresenter provideSeasonPresenter(FootballService footballService) {
        return new SeasonPresenterImpl(footballService);
    }

}
