package com.dbcandan.taboodb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameScreenSettingsActivity extends AppCompatActivity {

    EditText eTxt_g1_p1, eTxt_g1_p2, eTxt_g1_p3, eTxt_g1_p4, eTxt_g1_p5, eTxt_g1_p6, eTxt_g1_p7, eTxt_g1_p8, eTxt_g1_p9, eTxt_g1_p10,
            eTxt_g2_p1, eTxt_g2_p2, eTxt_g2_p3, eTxt_g2_p4, eTxt_g2_p5, eTxt_g2_p6, eTxt_g2_p7, eTxt_g2_p8, eTxt_g2_p9, eTxt_g2_p10,
            eTxt_g3_p1, eTxt_g3_p2, eTxt_g3_p3, eTxt_g3_p4, eTxt_g3_p5, eTxt_g3_p6, eTxt_g3_p7, eTxt_g3_p8, eTxt_g3_p9, eTxt_g3_p10,
            eTxt_g4_p1, eTxt_g4_p2, eTxt_g4_p3, eTxt_g4_p4, eTxt_g4_p5, eTxt_g4_p6, eTxt_g4_p7, eTxt_g4_p8, eTxt_g4_p9, eTxt_g4_p10,
            eTxt_g5_p1, eTxt_g5_p2, eTxt_g5_p3, eTxt_g5_p4, eTxt_g5_p5, eTxt_g5_p6, eTxt_g5_p7, eTxt_g5_p8, eTxt_g5_p9, eTxt_g5_p10;
    TextView txt_g1, txt_g2, txt_g3, txt_g4, txt_g5;
    NestedScrollView nestedView_Group1, nestedView_Group2, nestedView_Group3, nestedView_Group4, nestedView_Group5;
    Button btn_start_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_settings);

        PrepareGameScreenSettings();
        PrepareGameSettings();
    }

    public void OnClick_StartGame(View w) {
        PreparePlayerName();
        startActivity(new Intent(this, GameScreenActivity.class));
    }

    private void PrepareGameSettings() {
        SharedPreferences sPref = getApplicationContext().getSharedPreferences("groupWriter", Context.MODE_PRIVATE);
        SharedPreferences.Editor sEdit = sPref.edit();

        sEdit.remove(GeneralAttributes.val_Group1_Name);
        sEdit.remove(GeneralAttributes.val_Group2_Name);
        sEdit.remove(GeneralAttributes.val_Group3_Name);
        sEdit.remove(GeneralAttributes.val_Group4_Name);
        sEdit.remove(GeneralAttributes.val_Group5_Name);

        sEdit.remove(GeneralAttributes.val_Group1_Name + "_TrueCount");
        sEdit.remove(GeneralAttributes.val_Group2_Name + "_TrueCount");
        sEdit.remove(GeneralAttributes.val_Group3_Name + "_TrueCount");
        sEdit.remove(GeneralAttributes.val_Group4_Name + "_TrueCount");
        sEdit.remove(GeneralAttributes.val_Group5_Name + "_TrueCount");

        sEdit.remove(GeneralAttributes.val_Group1_Name + "_FalseCount");
        sEdit.remove(GeneralAttributes.val_Group2_Name + "_FalseCount");
        sEdit.remove(GeneralAttributes.val_Group3_Name + "_FalseCount");
        sEdit.remove(GeneralAttributes.val_Group4_Name + "_FalseCount");
        sEdit.remove(GeneralAttributes.val_Group5_Name + "_FalseCount");

        sEdit.remove(GeneralAttributes.val_Group1_Name + "_GroupPoint");
        sEdit.remove(GeneralAttributes.val_Group2_Name + "_GroupPoint");
        sEdit.remove(GeneralAttributes.val_Group3_Name + "_GroupPoint");
        sEdit.remove(GeneralAttributes.val_Group4_Name + "_GroupPoint");
        sEdit.remove(GeneralAttributes.val_Group5_Name + "_GroupPoint");

        sEdit.commit();
    }

    private void PreparePlayerName() {
        if (!eTxt_g1_p1.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player1_Name = eTxt_g1_p1.getText().toString();
        if (!eTxt_g1_p2.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player2_Name = eTxt_g1_p2.getText().toString();
        if (!eTxt_g1_p3.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player3_Name = eTxt_g1_p3.getText().toString();
        if (!eTxt_g1_p4.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player4_Name = eTxt_g1_p4.getText().toString();
        if (!eTxt_g1_p5.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player5_Name = eTxt_g1_p5.getText().toString();
        if (!eTxt_g1_p6.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player6_Name = eTxt_g1_p6.getText().toString();
        if (!eTxt_g1_p7.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player7_Name = eTxt_g1_p7.getText().toString();
        if (!eTxt_g1_p8.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player8_Name = eTxt_g1_p8.getText().toString();
        if (!eTxt_g1_p9.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player9_Name = eTxt_g1_p9.getText().toString();
        if (!eTxt_g1_p10.getText().toString().equals(""))
            GeneralAttributes.val_Group1_Player10_Name = eTxt_g1_p10.getText().toString();

        if (!eTxt_g2_p1.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player1_Name = eTxt_g2_p1.getText().toString();
        if (!eTxt_g2_p2.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player2_Name = eTxt_g2_p2.getText().toString();
        if (!eTxt_g2_p3.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player3_Name = eTxt_g2_p3.getText().toString();
        if (!eTxt_g2_p4.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player4_Name = eTxt_g2_p4.getText().toString();
        if (!eTxt_g2_p5.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player5_Name = eTxt_g2_p5.getText().toString();
        if (!eTxt_g2_p6.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player6_Name = eTxt_g2_p6.getText().toString();
        if (!eTxt_g2_p7.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player7_Name = eTxt_g2_p7.getText().toString();
        if (!eTxt_g2_p8.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player8_Name = eTxt_g2_p8.getText().toString();
        if (!eTxt_g2_p9.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player9_Name = eTxt_g2_p9.getText().toString();
        if (!eTxt_g2_p10.getText().toString().equals(""))
            GeneralAttributes.val_Group2_Player10_Name = eTxt_g2_p10.getText().toString();

        if (!eTxt_g3_p1.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player1_Name = eTxt_g3_p1.getText().toString();
        if (!eTxt_g3_p2.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player2_Name = eTxt_g3_p2.getText().toString();
        if (!eTxt_g3_p3.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player3_Name = eTxt_g3_p3.getText().toString();
        if (!eTxt_g3_p4.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player4_Name = eTxt_g3_p4.getText().toString();
        if (!eTxt_g3_p5.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player5_Name = eTxt_g3_p5.getText().toString();
        if (!eTxt_g3_p6.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player6_Name = eTxt_g3_p6.getText().toString();
        if (!eTxt_g3_p7.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player7_Name = eTxt_g3_p7.getText().toString();
        if (!eTxt_g3_p8.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player8_Name = eTxt_g3_p8.getText().toString();
        if (!eTxt_g3_p9.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player9_Name = eTxt_g3_p9.getText().toString();
        if (!eTxt_g3_p10.getText().toString().equals(""))
            GeneralAttributes.val_Group3_Player10_Name = eTxt_g3_p10.getText().toString();

        if (!eTxt_g4_p1.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player1_Name = eTxt_g4_p1.getText().toString();
        if (!eTxt_g4_p2.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player2_Name = eTxt_g4_p2.getText().toString();
        if (!eTxt_g4_p3.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player3_Name = eTxt_g4_p3.getText().toString();
        if (!eTxt_g4_p4.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player4_Name = eTxt_g4_p4.getText().toString();
        if (!eTxt_g4_p5.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player5_Name = eTxt_g4_p5.getText().toString();
        if (!eTxt_g4_p6.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player6_Name = eTxt_g4_p6.getText().toString();
        if (!eTxt_g4_p7.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player7_Name = eTxt_g4_p7.getText().toString();
        if (!eTxt_g4_p8.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player8_Name = eTxt_g4_p8.getText().toString();
        if (!eTxt_g4_p9.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player9_Name = eTxt_g4_p9.getText().toString();
        if (!eTxt_g4_p10.getText().toString().equals(""))
            GeneralAttributes.val_Group4_Player10_Name = eTxt_g4_p10.getText().toString();

        if (!eTxt_g5_p1.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player1_Name = eTxt_g5_p1.getText().toString();
        if (!eTxt_g5_p2.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player2_Name = eTxt_g5_p2.getText().toString();
        if (!eTxt_g5_p3.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player3_Name = eTxt_g5_p3.getText().toString();
        if (!eTxt_g5_p4.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player4_Name = eTxt_g5_p4.getText().toString();
        if (!eTxt_g5_p5.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player5_Name = eTxt_g5_p5.getText().toString();
        if (!eTxt_g5_p6.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player6_Name = eTxt_g5_p6.getText().toString();
        if (!eTxt_g5_p7.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player7_Name = eTxt_g5_p7.getText().toString();
        if (!eTxt_g5_p8.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player8_Name = eTxt_g5_p8.getText().toString();
        if (!eTxt_g5_p9.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player9_Name = eTxt_g5_p9.getText().toString();
        if (!eTxt_g5_p10.getText().toString().equals(""))
            GeneralAttributes.val_Group5_Player10_Name = eTxt_g5_p10.getText().toString();

    }

    private void PrepareGameScreenSettings() {
        Typeface facedeType = Typeface.createFromAsset(getAssets(), "Phenomena-Bold.otf");

        nestedView_Group1 = (NestedScrollView) findViewById(R.id.id_nested_group1);
        nestedView_Group2 = (NestedScrollView) findViewById(R.id.id_nested_group2);
        nestedView_Group3 = (NestedScrollView) findViewById(R.id.id_nested_group3);
        nestedView_Group4 = (NestedScrollView) findViewById(R.id.id_nested_group4);
        nestedView_Group5 = (NestedScrollView) findViewById(R.id.id_nested_group5);

        txt_g1 = (TextView) findViewById(R.id.id_txt_group_desc1);
        txt_g2 = (TextView) findViewById(R.id.id_txt_group_desc2);
        txt_g3 = (TextView) findViewById(R.id.id_txt_group_desc3);
        txt_g4 = (TextView) findViewById(R.id.id_txt_group_desc4);
        txt_g5 = (TextView) findViewById(R.id.id_txt_group_desc5);

        btn_start_game = (Button) findViewById(R.id.id_btn_start_game);

        eTxt_g1_p1 = (EditText) findViewById(R.id.id_edit_txt_g1_player1_name);
        eTxt_g1_p2 = (EditText) findViewById(R.id.id_edit_txt_g1_player2_name);
        eTxt_g1_p3 = (EditText) findViewById(R.id.id_edit_txt_g1_player3_name);
        eTxt_g1_p4 = (EditText) findViewById(R.id.id_edit_txt_g1_player4_name);
        eTxt_g1_p5 = (EditText) findViewById(R.id.id_edit_txt_g1_player5_name);
        eTxt_g1_p6 = (EditText) findViewById(R.id.id_edit_txt_g1_player6_name);
        eTxt_g1_p7 = (EditText) findViewById(R.id.id_edit_txt_g1_player7_name);
        eTxt_g1_p8 = (EditText) findViewById(R.id.id_edit_txt_g1_player8_name);
        eTxt_g1_p9 = (EditText) findViewById(R.id.id_edit_txt_g1_player9_name);
        eTxt_g1_p10 = (EditText) findViewById(R.id.id_edit_txt_g1_player10_name);

        eTxt_g2_p1 = (EditText) findViewById(R.id.id_edit_txt_g2_player1_name);
        eTxt_g2_p2 = (EditText) findViewById(R.id.id_edit_txt_g2_player2_name);
        eTxt_g2_p3 = (EditText) findViewById(R.id.id_edit_txt_g2_player3_name);
        eTxt_g2_p4 = (EditText) findViewById(R.id.id_edit_txt_g2_player4_name);
        eTxt_g2_p5 = (EditText) findViewById(R.id.id_edit_txt_g2_player5_name);
        eTxt_g2_p6 = (EditText) findViewById(R.id.id_edit_txt_g2_player6_name);
        eTxt_g2_p7 = (EditText) findViewById(R.id.id_edit_txt_g2_player7_name);
        eTxt_g2_p8 = (EditText) findViewById(R.id.id_edit_txt_g2_player8_name);
        eTxt_g2_p9 = (EditText) findViewById(R.id.id_edit_txt_g2_player9_name);
        eTxt_g2_p10 = (EditText) findViewById(R.id.id_edit_txt_g2_player10_name);

        eTxt_g3_p1 = (EditText) findViewById(R.id.id_edit_txt_g3_player1_name);
        eTxt_g3_p2 = (EditText) findViewById(R.id.id_edit_txt_g3_player2_name);
        eTxt_g3_p3 = (EditText) findViewById(R.id.id_edit_txt_g3_player3_name);
        eTxt_g3_p4 = (EditText) findViewById(R.id.id_edit_txt_g3_player4_name);
        eTxt_g3_p5 = (EditText) findViewById(R.id.id_edit_txt_g3_player5_name);
        eTxt_g3_p6 = (EditText) findViewById(R.id.id_edit_txt_g3_player6_name);
        eTxt_g3_p7 = (EditText) findViewById(R.id.id_edit_txt_g3_player7_name);
        eTxt_g3_p8 = (EditText) findViewById(R.id.id_edit_txt_g3_player8_name);
        eTxt_g3_p9 = (EditText) findViewById(R.id.id_edit_txt_g3_player9_name);
        eTxt_g3_p10 = (EditText) findViewById(R.id.id_edit_txt_g3_player10_name);

        eTxt_g4_p1 = (EditText) findViewById(R.id.id_edit_txt_g4_player1_name);
        eTxt_g4_p2 = (EditText) findViewById(R.id.id_edit_txt_g4_player2_name);
        eTxt_g4_p3 = (EditText) findViewById(R.id.id_edit_txt_g4_player3_name);
        eTxt_g4_p4 = (EditText) findViewById(R.id.id_edit_txt_g4_player4_name);
        eTxt_g4_p5 = (EditText) findViewById(R.id.id_edit_txt_g4_player5_name);
        eTxt_g4_p6 = (EditText) findViewById(R.id.id_edit_txt_g4_player6_name);
        eTxt_g4_p7 = (EditText) findViewById(R.id.id_edit_txt_g4_player7_name);
        eTxt_g4_p8 = (EditText) findViewById(R.id.id_edit_txt_g4_player8_name);
        eTxt_g4_p9 = (EditText) findViewById(R.id.id_edit_txt_g4_player9_name);
        eTxt_g4_p10 = (EditText) findViewById(R.id.id_edit_txt_g4_player10_name);

        eTxt_g5_p1 = (EditText) findViewById(R.id.id_edit_txt_g5_player1_name);
        eTxt_g5_p2 = (EditText) findViewById(R.id.id_edit_txt_g5_player2_name);
        eTxt_g5_p3 = (EditText) findViewById(R.id.id_edit_txt_g5_player3_name);
        eTxt_g5_p4 = (EditText) findViewById(R.id.id_edit_txt_g5_player4_name);
        eTxt_g5_p5 = (EditText) findViewById(R.id.id_edit_txt_g5_player5_name);
        eTxt_g5_p6 = (EditText) findViewById(R.id.id_edit_txt_g5_player6_name);
        eTxt_g5_p7 = (EditText) findViewById(R.id.id_edit_txt_g5_player7_name);
        eTxt_g5_p8 = (EditText) findViewById(R.id.id_edit_txt_g5_player8_name);
        eTxt_g5_p9 = (EditText) findViewById(R.id.id_edit_txt_g5_player9_name);
        eTxt_g5_p10 = (EditText) findViewById(R.id.id_edit_txt_g5_player10_name);

        btn_start_game.setTypeface(facedeType);

        txt_g1.setTypeface(facedeType);
        txt_g2.setTypeface(facedeType);
        txt_g3.setTypeface(facedeType);
        txt_g4.setTypeface(facedeType);
        txt_g5.setTypeface(facedeType);

        eTxt_g1_p1.setTypeface(facedeType);
        eTxt_g1_p2.setTypeface(facedeType);
        eTxt_g1_p3.setTypeface(facedeType);
        eTxt_g1_p4.setTypeface(facedeType);
        eTxt_g1_p5.setTypeface(facedeType);
        eTxt_g1_p6.setTypeface(facedeType);
        eTxt_g1_p7.setTypeface(facedeType);
        eTxt_g1_p8.setTypeface(facedeType);
        eTxt_g1_p9.setTypeface(facedeType);
        eTxt_g1_p10.setTypeface(facedeType);

        eTxt_g2_p1.setTypeface(facedeType);
        eTxt_g2_p2.setTypeface(facedeType);
        eTxt_g2_p3.setTypeface(facedeType);
        eTxt_g2_p4.setTypeface(facedeType);
        eTxt_g2_p5.setTypeface(facedeType);
        eTxt_g2_p6.setTypeface(facedeType);
        eTxt_g2_p7.setTypeface(facedeType);
        eTxt_g2_p8.setTypeface(facedeType);
        eTxt_g2_p9.setTypeface(facedeType);
        eTxt_g2_p10.setTypeface(facedeType);

        eTxt_g3_p1.setTypeface(facedeType);
        eTxt_g3_p2.setTypeface(facedeType);
        eTxt_g3_p3.setTypeface(facedeType);
        eTxt_g3_p4.setTypeface(facedeType);
        eTxt_g3_p5.setTypeface(facedeType);
        eTxt_g3_p6.setTypeface(facedeType);
        eTxt_g3_p7.setTypeface(facedeType);
        eTxt_g3_p8.setTypeface(facedeType);
        eTxt_g3_p9.setTypeface(facedeType);
        eTxt_g3_p10.setTypeface(facedeType);

        eTxt_g4_p1.setTypeface(facedeType);
        eTxt_g4_p2.setTypeface(facedeType);
        eTxt_g4_p3.setTypeface(facedeType);
        eTxt_g4_p4.setTypeface(facedeType);
        eTxt_g4_p5.setTypeface(facedeType);
        eTxt_g4_p6.setTypeface(facedeType);
        eTxt_g4_p7.setTypeface(facedeType);
        eTxt_g4_p8.setTypeface(facedeType);
        eTxt_g4_p9.setTypeface(facedeType);
        eTxt_g4_p10.setTypeface(facedeType);

        eTxt_g5_p1.setTypeface(facedeType);
        eTxt_g5_p2.setTypeface(facedeType);
        eTxt_g5_p3.setTypeface(facedeType);
        eTxt_g5_p4.setTypeface(facedeType);
        eTxt_g5_p5.setTypeface(facedeType);
        eTxt_g5_p6.setTypeface(facedeType);
        eTxt_g5_p7.setTypeface(facedeType);
        eTxt_g5_p8.setTypeface(facedeType);
        eTxt_g5_p9.setTypeface(facedeType);
        eTxt_g5_p10.setTypeface(facedeType);

        switch (GeneralAttributes.val_GroupCount) {
            case 2:
                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 1:
                        eTxt_g1_p2.setVisibility(View.GONE);
                        eTxt_g2_p2.setVisibility(View.GONE);
                    case 2:
                        eTxt_g1_p3.setVisibility(View.GONE);
                        eTxt_g2_p3.setVisibility(View.GONE);
                    case 3:
                        eTxt_g1_p4.setVisibility(View.GONE);
                        eTxt_g2_p4.setVisibility(View.GONE);
                    case 4:
                        eTxt_g1_p5.setVisibility(View.GONE);
                        eTxt_g2_p5.setVisibility(View.GONE);
                    case 5:
                        eTxt_g1_p6.setVisibility(View.GONE);
                        eTxt_g2_p6.setVisibility(View.GONE);
                    case 6:
                        eTxt_g1_p7.setVisibility(View.GONE);
                        eTxt_g2_p7.setVisibility(View.GONE);
                    case 7:
                        eTxt_g1_p8.setVisibility(View.GONE);
                        eTxt_g2_p8.setVisibility(View.GONE);
                    case 8:
                        eTxt_g1_p9.setVisibility(View.GONE);
                        eTxt_g2_p9.setVisibility(View.GONE);
                    case 9:
                        eTxt_g1_p10.setVisibility(View.GONE);
                        eTxt_g2_p10.setVisibility(View.GONE);
                    default:
                        nestedView_Group3.setVisibility(View.GONE);
                        nestedView_Group4.setVisibility(View.GONE);
                        nestedView_Group5.setVisibility(View.GONE);
                        break;
                }
                break;
            case 3:
                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 1:
                        eTxt_g1_p2.setVisibility(View.GONE);
                        eTxt_g2_p2.setVisibility(View.GONE);
                        eTxt_g3_p2.setVisibility(View.GONE);
                    case 2:
                        eTxt_g1_p3.setVisibility(View.GONE);
                        eTxt_g2_p3.setVisibility(View.GONE);
                        eTxt_g3_p3.setVisibility(View.GONE);
                    case 3:
                        eTxt_g1_p4.setVisibility(View.GONE);
                        eTxt_g2_p4.setVisibility(View.GONE);
                        eTxt_g3_p4.setVisibility(View.GONE);
                    case 4:
                        eTxt_g1_p5.setVisibility(View.GONE);
                        eTxt_g2_p5.setVisibility(View.GONE);
                        eTxt_g3_p5.setVisibility(View.GONE);
                    case 5:
                        eTxt_g1_p6.setVisibility(View.GONE);
                        eTxt_g2_p6.setVisibility(View.GONE);
                        eTxt_g3_p6.setVisibility(View.GONE);
                    case 6:
                        eTxt_g1_p7.setVisibility(View.GONE);
                        eTxt_g2_p7.setVisibility(View.GONE);
                        eTxt_g3_p7.setVisibility(View.GONE);
                    case 7:
                        eTxt_g1_p8.setVisibility(View.GONE);
                        eTxt_g2_p8.setVisibility(View.GONE);
                        eTxt_g3_p8.setVisibility(View.GONE);
                    case 8:
                        eTxt_g1_p9.setVisibility(View.GONE);
                        eTxt_g2_p9.setVisibility(View.GONE);
                        eTxt_g3_p9.setVisibility(View.GONE);
                    case 9:
                        eTxt_g1_p10.setVisibility(View.GONE);
                        eTxt_g2_p10.setVisibility(View.GONE);
                        eTxt_g3_p10.setVisibility(View.GONE);
                    default:
                        nestedView_Group4.setVisibility(View.GONE);
                        nestedView_Group5.setVisibility(View.GONE);
                        break;
                }
                break;
            case 4:
                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 1:
                        eTxt_g1_p2.setVisibility(View.GONE);
                        eTxt_g2_p2.setVisibility(View.GONE);
                        eTxt_g3_p2.setVisibility(View.GONE);
                        eTxt_g4_p2.setVisibility(View.GONE);
                    case 2:
                        eTxt_g1_p3.setVisibility(View.GONE);
                        eTxt_g2_p3.setVisibility(View.GONE);
                        eTxt_g3_p3.setVisibility(View.GONE);
                        eTxt_g4_p3.setVisibility(View.GONE);
                    case 3:
                        eTxt_g1_p4.setVisibility(View.GONE);
                        eTxt_g2_p4.setVisibility(View.GONE);
                        eTxt_g3_p4.setVisibility(View.GONE);
                        eTxt_g4_p4.setVisibility(View.GONE);
                    case 4:
                        eTxt_g1_p5.setVisibility(View.GONE);
                        eTxt_g2_p5.setVisibility(View.GONE);
                        eTxt_g3_p5.setVisibility(View.GONE);
                        eTxt_g4_p5.setVisibility(View.GONE);
                    case 5:
                        eTxt_g1_p6.setVisibility(View.GONE);
                        eTxt_g2_p6.setVisibility(View.GONE);
                        eTxt_g3_p6.setVisibility(View.GONE);
                        eTxt_g4_p6.setVisibility(View.GONE);
                    case 6:
                        eTxt_g1_p7.setVisibility(View.GONE);
                        eTxt_g2_p7.setVisibility(View.GONE);
                        eTxt_g3_p7.setVisibility(View.GONE);
                        eTxt_g4_p7.setVisibility(View.GONE);
                    case 7:
                        eTxt_g1_p8.setVisibility(View.GONE);
                        eTxt_g2_p8.setVisibility(View.GONE);
                        eTxt_g3_p8.setVisibility(View.GONE);
                        eTxt_g4_p8.setVisibility(View.GONE);
                    case 8:
                        eTxt_g1_p9.setVisibility(View.GONE);
                        eTxt_g2_p9.setVisibility(View.GONE);
                        eTxt_g3_p9.setVisibility(View.GONE);
                        eTxt_g4_p9.setVisibility(View.GONE);
                    case 9:
                        eTxt_g1_p10.setVisibility(View.GONE);
                        eTxt_g2_p10.setVisibility(View.GONE);
                        eTxt_g3_p10.setVisibility(View.GONE);
                        eTxt_g4_p10.setVisibility(View.GONE);
                    default:
                        nestedView_Group5.setVisibility(View.GONE);
                        break;
                }
                break;
            case 5:
                switch (GeneralAttributes.val_PlayerCount / GeneralAttributes.val_GroupCount) {
                    case 1:
                        eTxt_g1_p2.setVisibility(View.GONE);
                        eTxt_g2_p2.setVisibility(View.GONE);
                        eTxt_g3_p2.setVisibility(View.GONE);
                        eTxt_g4_p2.setVisibility(View.GONE);
                        eTxt_g5_p2.setVisibility(View.GONE);
                    case 2:
                        eTxt_g1_p3.setVisibility(View.GONE);
                        eTxt_g2_p3.setVisibility(View.GONE);
                        eTxt_g3_p3.setVisibility(View.GONE);
                        eTxt_g4_p3.setVisibility(View.GONE);
                        eTxt_g5_p3.setVisibility(View.GONE);
                    case 3:
                        eTxt_g1_p4.setVisibility(View.GONE);
                        eTxt_g2_p4.setVisibility(View.GONE);
                        eTxt_g3_p4.setVisibility(View.GONE);
                        eTxt_g4_p4.setVisibility(View.GONE);
                        eTxt_g5_p4.setVisibility(View.GONE);
                    case 4:
                        eTxt_g1_p5.setVisibility(View.GONE);
                        eTxt_g2_p5.setVisibility(View.GONE);
                        eTxt_g3_p5.setVisibility(View.GONE);
                        eTxt_g4_p5.setVisibility(View.GONE);
                        eTxt_g5_p5.setVisibility(View.GONE);
                    case 5:
                        eTxt_g1_p6.setVisibility(View.GONE);
                        eTxt_g2_p6.setVisibility(View.GONE);
                        eTxt_g3_p6.setVisibility(View.GONE);
                        eTxt_g4_p6.setVisibility(View.GONE);
                        eTxt_g5_p6.setVisibility(View.GONE);
                    case 6:
                        eTxt_g1_p7.setVisibility(View.GONE);
                        eTxt_g2_p7.setVisibility(View.GONE);
                        eTxt_g3_p7.setVisibility(View.GONE);
                        eTxt_g4_p7.setVisibility(View.GONE);
                        eTxt_g5_p7.setVisibility(View.GONE);
                    case 7:
                        eTxt_g1_p8.setVisibility(View.GONE);
                        eTxt_g2_p8.setVisibility(View.GONE);
                        eTxt_g3_p8.setVisibility(View.GONE);
                        eTxt_g4_p8.setVisibility(View.GONE);
                        eTxt_g5_p8.setVisibility(View.GONE);
                    case 8:
                        eTxt_g1_p9.setVisibility(View.GONE);
                        eTxt_g2_p9.setVisibility(View.GONE);
                        eTxt_g3_p9.setVisibility(View.GONE);
                        eTxt_g4_p9.setVisibility(View.GONE);
                        eTxt_g5_p9.setVisibility(View.GONE);
                    case 9:
                        eTxt_g1_p10.setVisibility(View.GONE);
                        eTxt_g2_p10.setVisibility(View.GONE);
                        eTxt_g3_p10.setVisibility(View.GONE);
                        eTxt_g4_p10.setVisibility(View.GONE);
                        eTxt_g5_p10.setVisibility(View.GONE);
                        break;
                }
                break;
        }
    }
}
