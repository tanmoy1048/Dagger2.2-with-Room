package com.datagene.daggerroomapplication.di;

import android.app.Application;

import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.datagene.daggerroomapplication.R;
import com.datagene.daggerroomapplication.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, "database-name").build();
    }

}
