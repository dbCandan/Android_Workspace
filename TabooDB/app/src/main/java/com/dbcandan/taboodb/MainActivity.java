package com.dbcandan.taboodb;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_start_game;
    MediaPlayer sEffect_tick;
    SeekBar seekBar_finishCount;
    SeekBar seekBar_finishTime;
    SeekBar seekBar_groupCount;
    SeekBar seekBar_pasCount;
    SeekBar seekBar_playerCount;
    TextView txt_desc1;
    TextView txt_desc2;
    TextView txt_desc3;
    TextView txt_desc4;
    TextView txt_desc5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, NotificationService.class));
        PrepareMainScreen();
        PrepareMainScreenRefresher();
    }

    private void PrepareMainScreen() {
        Typeface txt_type = Typeface.createFromAsset(getAssets(), "Phenomena-Bold.otf");
        this.txt_desc1 = (TextView) findViewById(R.id.id_txt_desc1);
        this.txt_desc2 = (TextView) findViewById(R.id.id_txt_desc2);
        this.txt_desc3 = (TextView) findViewById(R.id.id_txt_desc3);
        this.txt_desc4 = (TextView) findViewById(R.id.id_txt_desc4);
        this.txt_desc5 = (TextView) findViewById(R.id.id_txt_desc5);
        this.seekBar_playerCount = (SeekBar) findViewById(R.id.id_seekBar_playerCount);
        this.seekBar_groupCount = (SeekBar) findViewById(R.id.id_seekBar_groupCount);
        this.seekBar_finishCount = (SeekBar) findViewById(R.id.id_seekBar_finishPoint);
        this.seekBar_finishTime = (SeekBar) findViewById(R.id.id_seekBar_finishTime);
        this.seekBar_pasCount = (SeekBar) findViewById(R.id.id_seekBar_pasCount);
        this.btn_start_game = (Button) findViewById(R.id.id_btn_start);
        this.txt_desc1.setTypeface(txt_type);
        this.txt_desc2.setTypeface(txt_type);
        this.txt_desc3.setTypeface(txt_type);
        this.txt_desc4.setTypeface(txt_type);
        this.txt_desc5.setTypeface(txt_type);
        this.btn_start_game.setTypeface(txt_type);
        this.txt_desc1.setText("Oyuncu Sayısı (" + Integer.parseInt((this.seekBar_playerCount.getProgress() + 1) + "") + ")");
        this.txt_desc2.setText("Grup Sayısı (" + Integer.parseInt((this.seekBar_groupCount.getProgress() + 1) + "") + ")");
        this.txt_desc3.setText("Kazanma Puanı (" + Integer.parseInt((this.seekBar_finishCount.getProgress() + 10) + "") + ")");
        this.txt_desc4.setText("Süre (" + Integer.parseInt((this.seekBar_finishTime.getProgress() + 10) + "") + "sn)");
        this.txt_desc5.setText("Pas Hakkı (" + Integer.parseInt((this.seekBar_pasCount.getProgress() + 1) + "") + ")");
        this.seekBar_playerCount.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_mainScreen_txt), PorterDuff.Mode.SRC_IN);
        this.seekBar_groupCount.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_mainScreen_txt), PorterDuff.Mode.SRC_IN);
        this.seekBar_finishCount.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_mainScreen_txt), PorterDuff.Mode.SRC_IN);
        this.seekBar_finishTime.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_mainScreen_txt), PorterDuff.Mode.SRC_IN);
        this.seekBar_pasCount.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_mainScreen_txt), PorterDuff.Mode.SRC_IN);
        if (Build.VERSION.SDK_INT >= 16) {
            this.seekBar_playerCount.getThumb().setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
            this.seekBar_groupCount.getThumb().setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
            this.seekBar_finishCount.getThumb().setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
            this.seekBar_finishTime.getThumb().setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
            this.seekBar_pasCount.getThumb().setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
        }
        this.sEffect_tick = MediaPlayer.create(this, R.raw.sound_effect_tick);
    }

    private void PrepareMainScreenRefresher() {
        this.seekBar_playerCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgressVal;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.this.txt_desc1.setText("Oyuncu Sayısı (" + Integer.parseInt((MainActivity.this.seekBar_playerCount.getProgress() + 1) + "") + ")");
                MainActivity.this.sEffect_tick.start();
            }

            public void onStartTrackingTouch(@NonNull SeekBar seekBar) {
                this.lastProgressVal = seekBar.getProgress();
            }

            public void onStopTrackingTouch(@NonNull SeekBar seekBar) {
                if (MainActivity.this.seekBar_playerCount.getProgress() == 0) {
                    warning_Snack com_dbcandan_taboodb_warning_Snack = new warning_Snack(MainActivity.this, MainActivity.this.findViewById(R.id.id_main_activity), "Oyuncu Sayısı Minimum 2 Olmalıdır", false);
                    seekBar.setProgress(this.lastProgressVal);
                }
            }
        });

        this.seekBar_groupCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgressVal;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.this.txt_desc2.setText("Grup Sayısı (" + Integer.parseInt((MainActivity.this.seekBar_groupCount.getProgress() + 1) + "") + ")");
                MainActivity.this.sEffect_tick.start();
            }

            public void onStartTrackingTouch(@NonNull SeekBar seekBar) {
                this.lastProgressVal = seekBar.getProgress();
            }

            public void onStopTrackingTouch(@NonNull SeekBar seekBar) {
                if (MainActivity.this.seekBar_groupCount.getProgress() == 0) {
                    warning_Snack com_dbcandan_taboodb_warning_Snack = new warning_Snack(MainActivity.this, MainActivity.this.findViewById(R.id.id_main_activity), "Grup Sayısı Minimum 2 Olmalıdır", false);
                    seekBar.setProgress(this.lastProgressVal);
                }
            }
        });

        this.seekBar_finishCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.this.txt_desc3.setText("Kazanma Puanı (" + Integer.parseInt((MainActivity.this.seekBar_finishCount.getProgress() + 10) + "") + ")");
                MainActivity.this.sEffect_tick.start();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        this.seekBar_finishTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.this.txt_desc4.setText("Süre (" + Integer.parseInt((MainActivity.this.seekBar_finishTime.getProgress() + 10) + "") + " sn)");
                MainActivity.this.sEffect_tick.start();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(@NonNull SeekBar seekBar) {
                if (seekBar.getProgress() < 30) {
                    warning_Snack com_dbcandan_taboodb_warning_Snack = new warning_Snack(MainActivity.this, MainActivity.this.findViewById(R.id.id_main_activity), "Süreyi Çok Az Seçtiniz, Bilginize", false);
                }
            }
        });

        this.seekBar_pasCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.this.txt_desc5.setText("Pas Hakkı (" + Integer.parseInt((MainActivity.this.seekBar_pasCount.getProgress() + 1) + "") + ")");
                MainActivity.this.sEffect_tick.start();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        this.btn_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((MainActivity.this.seekBar_playerCount.getProgress() + 1) % (MainActivity.this.seekBar_groupCount.getProgress() + 1) != 0) {
                    warning_Snack com_dbcandan_taboodb_warning_Snack = new warning_Snack(MainActivity.this, MainActivity.this.findViewById(R.id.id_main_activity), "Oyuncu ve Grup Sayısı Uyumlu Olmalıdır", false);
                    return;
                }
                GeneralAttributes.val_GroupCount = MainActivity.this.seekBar_groupCount.getProgress() + 1;
                GeneralAttributes.val_PlayerCount = MainActivity.this.seekBar_playerCount.getProgress() + 1;
                GeneralAttributes.val_FinishTime = MainActivity.this.seekBar_finishTime.getProgress() + 10;
                GeneralAttributes.val_FinishPoint = MainActivity.this.seekBar_finishCount.getProgress() + 10;
                GeneralAttributes.val_PasCount = MainActivity.this.seekBar_pasCount.getProgress() + 1;
                MainActivity.this.startActivity(new Intent(MainActivity.this, GameScreenSettingsActivity.class));
            }
        });
    }
}
