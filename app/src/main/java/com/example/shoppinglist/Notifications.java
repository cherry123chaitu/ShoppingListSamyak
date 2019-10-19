package com.example.shoppinglist;
import android.app.Application;
import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


public class Notifications extends Application {
    public NotificationManagerCompat notificationManagerCompat;
    @Override
    public void onCreate() {
        notificationManagerCompat=NotificationManagerCompat.from(this);
        super.onCreate();
        Notification notification=new NotificationCompat.Builder(this,App.Channel1).setSmallIcon(R.drawable.ic_one).setContentTitle("Shopping List").setContentText("Added"+" "+"To Your list").setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
        notificationManagerCompat.notify(2,notification);
    }


}
