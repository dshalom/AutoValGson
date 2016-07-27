package com.example.davidshalom.autoval2.di;

import com.example.davidshalom.autoval2.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
