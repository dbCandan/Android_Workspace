package com.dbcandan.taboodb;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dbcandan.taboodb.TabooDB_Model.TabooDB_Group;
import com.dbcandan.taboodb.TabooDB_Model.TabooDB_Player;
import com.dbcandan.taboodb.TabooDB_Model.TabooDB_Question;
import com.dbcandan.taboodb.TabooDB_Model.TabooDB_QuestionList;

import java.util.Random;
import java.util.Stack;

public class GameScreenActivity extends AppCompatActivity {
    final String BackgrounTask_OperationName_TimePicker = "TimePicker";

    TextView txt_groupName, txt_groupPoint, txt_groupTime, txt_question, txt_forbidden1, txt_forbidden2, txt_forbidden3, txt_forbidden4, txt_forbidden5;
    Button btn_pas, btn_true, btn_tabu, btn_mola;
    ProgressBar pBar_groupTime;
    //AdView mAdView;
    TabooDB_Group group1, group2, group3, group4, group5;
    TabooDB_Group racingGroup;
    TabooDB_Player racingPlayer;
    TabooDB_Question racingQuestion;
    int groupIndex, racingPasIndex;
    boolean newPlayerIndex, racingPlayerIndex;
    BackgroundTaskOperator bck_operator1;
    MediaPlayer sEffect_finish, sEffect_tick, sEffect_false_answer, sEffect_true_answer, sEffect_pass;
    Stack<TabooDB_Question> all_question_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        bck_operator1 = new BackgroundTaskOperator(BackgrounTask_OperationName_TimePicker);
        bck_operator1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        groupIndex = 1;
        racingPasIndex = 0;
        newPlayerIndex = true;
        racingPlayerIndex = false;
        all_question_list = new TabooDB_QuestionList().getQuestionStack();

        PrepareScreenAttributes();
        PreparePlayerGroups();
        PrepareGameActions();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bck_operator1.cancel(true);
    }

    private void PrepareScreenAttributes() {
        Typeface txt_style = Typeface.createFromAsset(getAssets(), "Phenomena-ExtraBold.otf");

        pBar_groupTime = (ProgressBar) findViewById(R.id.id_pBar_groupTime);

        //mAdView = (AdView) findViewById(R.id.id_adView2);

        btn_pas = (Button) findViewById(R.id.id_btn_pas);
        btn_tabu = (Button) findViewById(R.id.id_btn_tabu);
        btn_true = (Button) findViewById(R.id.id_btn_true);
        btn_mola = (Button) findViewById(R.id.id_btn_mola);

        txt_groupName = (TextView) findViewById(R.id.id_txt_group_name);
        txt_groupPoint = (TextView) findViewById(R.id.id_txt_group_point);
        txt_groupTime = (TextView) findViewById(R.id.id_txt_group_time);
        txt_question = (TextView) findViewById(R.id.id_txt_group_question);
        txt_forbidden1 = (TextView) findViewById(R.id.id_txt_group_question_forbidden1);
        txt_forbidden2 = (TextView) findViewById(R.id.id_txt_group_question_forbidden2);
        txt_forbidden3 = (TextView) findViewById(R.id.id_txt_group_question_forbidden3);
        txt_forbidden4 = (TextView) findViewById(R.id.id_txt_group_question_forbidden4);
        txt_forbidden5 = (TextView) findViewById(R.id.id_txt_group_question_forbidden5);

        txt_groupName.setTypeface(txt_style);
        txt_groupPoint.setTypeface(txt_style);
        txt_groupTime.setTypeface(txt_style);
        txt_question.setTypeface(txt_style);
        txt_forbidden1.setTypeface(txt_style);
        txt_forbidden2.setTypeface(txt_style);
        txt_forbidden3.setTypeface(txt_style);
        txt_forbidden4.setTypeface(txt_style);
        txt_forbidden5.setTypeface(txt_style);

        btn_true.setTypeface(txt_style);
        btn_tabu.setTypeface(txt_style);
        btn_pas.setTypeface(txt_style);
        btn_mola.setTypeface(txt_style);

        pBar_groupTime.setMax(GeneralAttributes.val_FinishTime);
        btn_pas.setText("Pas (" + Integer.parseInt(GeneralAttributes.val_PasCount - racingPasIndex + "") + ")");
        //mAdView.loadAd(new AdRequest.Builder().build());

        sEffect_finish = MediaPlayer.create(this, R.raw.sound_effect_finish);
        sEffect_tick = MediaPlayer.create(this, R.raw.sound_effect_tick);
        sEffect_false_answer = MediaPlayer.create(this, R.raw.sound_effect_false_answer);
        sEffect_true_answer = MediaPlayer.create(this, R.raw.sound_effect_true_answer);
        sEffect_pass = MediaPlayer.create(this, R.raw.sound_effect_pass);
    }

    private void PreparePlayerGroups() {
        switch (GeneralAttributes.val_GroupCount) {
            case 5:
                group5 = new TabooDB_Group(GeneralAttributes.val_Group5_Name);
                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 10:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player10_Name));
                    case 9:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player9_Name));
                    case 8:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player8_Name));
                    case 7:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player7_Name));
                    case 6:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player6_Name));
                    case 5:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player5_Name));
                    case 4:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player4_Name));
                    case 3:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player3_Name));
                    case 2:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player2_Name));
                    case 1:
                        group5.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group5_Player1_Name));
                }
            case 4:
                group4 = new TabooDB_Group(GeneralAttributes.val_Group4_Name);
                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 10:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player10_Name));
                    case 9:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player9_Name));
                    case 8:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player8_Name));
                    case 7:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player7_Name));
                    case 6:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player6_Name));
                    case 5:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player5_Name));
                    case 4:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player4_Name));
                    case 3:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player3_Name));
                    case 2:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player2_Name));
                    case 1:
                        group4.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group4_Player1_Name));
                }
            case 3:
                group3 = new TabooDB_Group(GeneralAttributes.val_Group3_Name);
                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 10:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player10_Name));
                    case 9:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player9_Name));
                    case 8:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player8_Name));
                    case 7:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player7_Name));
                    case 6:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player6_Name));
                    case 5:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player5_Name));
                    case 4:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player4_Name));
                    case 3:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player3_Name));
                    case 2:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player2_Name));
                    case 1:
                        group3.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group3_Player1_Name));
                }
            case 2:
                group1 = new TabooDB_Group(GeneralAttributes.val_Group1_Name);
                group2 = new TabooDB_Group(GeneralAttributes.val_Group2_Name);

                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 10:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player10_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player10_Name));
                    case 9:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player9_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player9_Name));
                    case 8:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player8_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player8_Name));
                    case 7:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player7_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player7_Name));
                    case 6:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player6_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player6_Name));
                    case 5:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player5_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player5_Name));
                    case 4:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player4_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player4_Name));
                    case 3:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player3_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player3_Name));
                    case 2:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player2_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player2_Name));
                    case 1:
                        group1.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group1_Player1_Name));
                        group2.getAllPlayer().add(new TabooDB_Player(GeneralAttributes.val_Group2_Player1_Name));
                }
        }
    }

    private void PrepareGameActions() {
        if (groupIndex <= GeneralAttributes.val_GroupCount) {
            if (groupIndex == 1)
                racingGroup = group1;
            if (groupIndex == 2)
                racingGroup = group2;
            if (groupIndex == 3)
                racingGroup = group3;
            if (groupIndex == 4)
                racingGroup = group4;
            if (groupIndex == 5)
                racingGroup = group5;

            if (racingGroup.getGroupPoint() >= GeneralAttributes.val_FinishPoint) {
                bck_operator1.cancel(true);

                Intent intent_GameResult = new Intent(GameScreenActivity.this, GameResultActivity.class);
                intent_GameResult.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent_GameResult.putExtra("groupName", racingGroup.getGroupName());
                intent_GameResult.putExtra("groupPoint", racingGroup.getGroupPoint() + "");
                intent_GameResult.putExtra("trueCount", racingGroup.getGroupTrueCount() + "");
                intent_GameResult.putExtra("falseCount", racingGroup.getGroupFalseCount() + "");
                startActivityForResult(intent_GameResult, 2);
            } else {
                if (newPlayerIndex) {
                    if (racingGroup.getAllPlayer().size() > racingGroup.getRacingPlayer().size())
                        racingPlayerIndex = true;
                    if (racingGroup.getAllPlayer().size() < racingGroup.getRacingPlayer().size())
                        racingPlayerIndex = false;

                    if (racingPlayerIndex) {
                        racingPlayer = racingGroup.getAllPlayer().pop();
                        racingGroup.getRacingPlayer().add(racingPlayer);
                    } else {
                        racingPlayer = racingGroup.getRacingPlayer().pop();
                        racingGroup.getAllPlayer().add(racingPlayer);
                    }
                }

                int racingQuestionIndex = new Random().nextInt(all_question_list.size());
                racingQuestion = all_question_list.get(racingQuestionIndex);
                all_question_list.remove(racingQuestion);

                txt_groupName.setText(racingGroup.getGroupName() + " - " + racingPlayer.getPlayerName());
                txt_groupPoint.setText(racingGroup.getGroupPoint() + "/" + GeneralAttributes.val_FinishPoint);
                txt_question.setText(racingQuestion.getQuestionText());
                if (racingPasIndex <= GeneralAttributes.val_PasCount)
                    btn_pas.setText("Pas (" + Integer.parseInt(GeneralAttributes.val_PasCount - racingPasIndex + "") + ")");
                txt_forbidden1.setText(racingQuestion.getForbiddenText1());
                txt_forbidden2.setText(racingQuestion.getForbiddenText2());
                txt_forbidden3.setText(racingQuestion.getForbiddenText3());
                txt_forbidden4.setText(racingQuestion.getForbiddenText4());
                txt_forbidden5.setText(racingQuestion.getForbiddenText5());

                newPlayerIndex = false;
            }
        }
        Log.i("dCandanLOG", "Grup: " + racingGroup + " Kalan Soru: " + all_question_list.size());
    }

    public void OnClick_PasActions(View w) {
        racingPasIndex++;
        if (racingPasIndex <= GeneralAttributes.val_PasCount) {
            sEffect_pass.start();
            btn_pas.setText("Pas (" + Integer.parseInt(GeneralAttributes.val_PasCount - racingPasIndex + "") + ")");
            PrepareGameActions();
        } else
            new warning_Snack(GameScreenActivity.this, findViewById(R.id.id_game_screen_activity), "Pas Hakkı Tamamlandı", false);
    }

    public void OnClick_TrueActions(View w) {
        sEffect_true_answer.start();
        racingGroup.setGroupPoint(racingGroup.getGroupPoint() + 1);
        racingGroup.setGroupTrueCount(racingGroup.getGroupTrueCount() + 1);

        racingPlayer.setPlayerPoint(racingPlayer.getPlayerPoint() + 1);
        racingPlayer.setPlayerTrueCount(racingPlayer.getPlayerTrueCount() + 1);

        PrepareGameActions();
    }

    public void OnClick_MolaActions(View w) {
        if ((GeneralAttributes.val_FinishTime - pBar_groupTime.getProgress()) > 1) {
            bck_operator1.isOperationWait = true;
            btn_pas.setClickable(false);
            btn_tabu.setClickable(false);
            btn_true.setClickable(false);
            btn_mola.setClickable(false);

            Snackbar mSnack = Snackbar.make(findViewById(R.id.id_game_screen_activity), "MOLA VERDİN", Snackbar.LENGTH_SHORT);
            mSnack.setDuration(Snackbar.LENGTH_INDEFINITE);
            mSnack.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorGray));
            mSnack.setActionTextColor(ContextCompat.getColor(this, R.color.colorWhite));
            mSnack.setAction("Devam Et", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bck_operator1.isOperationWait = false;
                    btn_pas.setClickable(true);
                    btn_tabu.setClickable(true);
                    btn_true.setClickable(true);
                    btn_mola.setClickable(true);
                }
            });
            mSnack.show();
        }
    }

    public void OnClick_FalseActions(View w) {
        sEffect_false_answer.start();
        racingGroup.setGroupPoint(racingGroup.getGroupPoint() - 1);
        racingGroup.setGroupFalseCount(racingGroup.getGroupFalseCount() + 1);

        racingPlayer.setPlayerPoint(racingPlayer.getPlayerPoint() - 1);
        racingPlayer.setPlayerFalseCount(racingPlayer.getPlayerFalseCount() + 1);

        PrepareGameActions();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (groupIndex == GeneralAttributes.val_GroupCount)
                groupIndex = 1;
            else
                groupIndex++;

            newPlayerIndex = true;
            racingPasIndex = 0;
            PrepareGameActions();

            bck_operator1 = new BackgroundTaskOperator(BackgrounTask_OperationName_TimePicker);
            bck_operator1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        if (requestCode == 2)
            finish();
    }

    class BackgroundTaskOperator extends android.os.AsyncTask {
        String operationName;
        boolean isOperationOK, isOperationWait;

        public BackgroundTaskOperator(String v_operation_name) {
            operationName = v_operation_name;
            isOperationOK = false;
            isOperationWait = false;
        }

        @Nullable
        @Override
        protected Object doInBackground(Object[] params) {
            if (operationName.equals(BackgrounTask_OperationName_TimePicker))
                Operation_TimePicker();
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
            if (operationName.equals(BackgrounTask_OperationName_TimePicker))
                Operation_TimePickerGui((int) values[0]);
        }

        private void Operation_TimePicker() {
            int i = 0;
            for (; i <= GeneralAttributes.val_FinishTime; i++) {
                if (!isOperationWait)
                    publishProgress(i);
                else
                    i--;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isOperationOK = true;
            publishProgress(GeneralAttributes.val_FinishTime);
        }

        private void Operation_TimePickerGui(int val) {
            if ((GeneralAttributes.val_FinishTime - val) > 0 && val > 0)
                sEffect_tick.start();
            pBar_groupTime.setProgress(val);
            txt_groupTime.setText(GeneralAttributes.val_FinishTime - val + " sn");

            if ((GeneralAttributes.val_FinishTime - val) == 2)
                sEffect_finish.start();

            if (isOperationOK) {    //  Süre Bittiyse
                Intent intent_GameResult = new Intent(GameScreenActivity.this, GameResultActivity.class);
                intent_GameResult.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent_GameResult.putExtra("groupName", racingGroup.getGroupName());
                intent_GameResult.putExtra("groupPoint", racingGroup.getGroupPoint() + "");
                intent_GameResult.putExtra("trueCount", racingGroup.getGroupTrueCount() + "");
                intent_GameResult.putExtra("falseCount", racingGroup.getGroupFalseCount() + "");
                startActivityForResult(intent_GameResult, 1);
            }
        }
    }
}
