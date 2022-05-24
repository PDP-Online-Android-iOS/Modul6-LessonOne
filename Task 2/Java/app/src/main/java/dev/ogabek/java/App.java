package dev.ogabek.java;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import timber.log.Timber;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree(){
            @Override
            protected void log(int priority, @Nullable String tag, @NonNull String message, @Nullable Throwable t) {
                super.log(priority, "GLOBAL_TAB -:- " + tag, message, t);
            }

            @Nullable
            @Override
            protected String createStackElementTag(@NonNull StackTraceElement element) {
                return String.format(
                        "FileName : %s\tMethodName : %s\tLineNumber : %s",
                        element.getFileName(),
                        element.getMethodName(),
                        element.getLineNumber(),
                        super.createStackElementTag(element)
                );
            }
        });

    }
}
