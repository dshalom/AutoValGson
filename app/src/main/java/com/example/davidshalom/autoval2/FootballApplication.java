package com.example.davidshalom.autoval2;


import android.app.Application;

import com.example.davidshalom.autoval2.di.ApplicationComponent;
import com.example.davidshalom.autoval2.di.ApplicationModule;
import com.example.davidshalom.autoval2.di.DaggerApplicationComponent;
import com.example.davidshalom.autoval2.di.NetModule;

import timber.log.Timber;

public class FootballApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule("http://api.football-data.org/v1/"))
                .build();

        Timber.plant(new Timber.DebugTree());
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
