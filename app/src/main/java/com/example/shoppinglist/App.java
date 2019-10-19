package com.example.shoppinglist;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App  extends Application {
    public static final String Channel1="ShoppingList";
    @Override
    public void onCreate() {
        super.onCreate();
        createNot();
    }
    private void createNot(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O ){
            NotificationChannel channel1=new NotificationChannel(Channel1,"Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("Shopping List App");
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }
}
