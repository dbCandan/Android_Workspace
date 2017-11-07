package com.dbcandan.taboodb;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;

public class NotificationService extends IntentService {
    private static final String serviceName = "NotificationService";

    public NotificationService() {
        super(serviceName);
    }

    protected void onHandleIntent(@Nullable Intent intent) {
        while (true) {
            try {
                Thread.sleep(172800000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Builder mBuilder = new Builder(this).setSmallIcon(R.drawable.taboo).setContentTitle(getString(R.string.app_name)).setContentText("Haydi Tabuya...");
            mBuilder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0));
            ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(1, mBuilder.build());
        }
    }
}
