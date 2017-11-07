package com.dbcandan.taboodb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GameResultActivity extends AppCompatActivity {

    TextView txt_result_desc1, txt_result_desc2, txt_result_desc3, txt_result_desc4, txt_result_group_1_1, txt_result_group_1_2, txt_result_group_1_3,
            txt_result_group_2_1, txt_result_group_2_2, txt_result_group_2_3, txt_result_group_3_1, txt_result_group_3_2, txt_result_group_3_3,
            txt_result_group_4_1, txt_result_group_4_2, txt_result_group_4_3, txt_result_group_5_1, txt_result_group_5_2, txt_result_group_5_3;
    ConstraintLayout cLayout_result_tab1, cLayout_result_tab2, cLayout_result_tab3, cLayout_result_tab4, cLayout_result_tab5, cLayout_result_tab6;
    String v_group_name;
    int v_true_count = 0, v_false_count = 0, v_group_point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        v_group_name = getIntent().getStringExtra("groupName");
        v_true_count = Integer.parseInt(getIntent().getStringExtra("trueCount"));
        v_false_count = Integer.parseInt(getIntent().getStringExtra("falseCount"));
        v_group_point = Integer.parseInt(getIntent().getStringExtra("groupPoint"));

        PrepareScreenSettings();
        PrepareGroupPoint();
        SetScreenGroupPoint();
    }

    private void PrepareScreenSettings() {
        Typeface txt_type = Typeface.createFromAsset(getAssets(), "Phenomena-Bold.otf");

        txt_result_desc1 = (TextView) findViewById(R.id.id_txt_result_desc1);
        txt_result_desc2 = (TextView) findViewById(R.id.id_txt_result_desc2);
        txt_result_desc3 = (TextView) findViewById(R.id.id_txt_result_desc3);
        txt_result_desc4 = (TextView) findViewById(R.id.id_txt_result_desc4);
        txt_result_group_1_1 = (TextView) findViewById(R.id.id_txt_result_group_1_1);
        txt_result_group_1_2 = (TextView) findViewById(R.id.id_txt_result_group_1_2);
        txt_result_group_1_3 = (TextView) findViewById(R.id.id_txt_result_group_1_3);
        txt_result_group_2_1 = (TextView) findViewById(R.id.id_txt_result_group_2_1);
        txt_result_group_2_2 = (TextView) findViewById(R.id.id_txt_result_group_2_2);
        txt_result_group_2_3 = (TextView) findViewById(R.id.id_txt_result_group_2_3);
        txt_result_group_3_1 = (TextView) findViewById(R.id.id_txt_result_group_3_1);
        txt_result_group_3_2 = (TextView) findViewById(R.id.id_txt_result_group_3_2);
        txt_result_group_3_3 = (TextView) findViewById(R.id.id_txt_result_group_3_3);
        txt_result_group_4_1 = (TextView) findViewById(R.id.id_txt_result_group_4_1);
        txt_result_group_4_2 = (TextView) findViewById(R.id.id_txt_result_group_4_2);
        txt_result_group_4_3 = (TextView) findViewById(R.id.id_txt_result_group_4_3);
        txt_result_group_5_1 = (TextView) findViewById(R.id.id_txt_result_group_5_1);
        txt_result_group_5_2 = (TextView) findViewById(R.id.id_txt_result_group_5_2);
        txt_result_group_5_3 = (TextView) findViewById(R.id.id_txt_result_group_5_3);

        cLayout_result_tab1 = (ConstraintLayout) findViewById(R.id.id_constraintLayout_result1_tab1);
        cLayout_result_tab2 = (ConstraintLayout) findViewById(R.id.id_constraintLayout_result1_tab2);
        cLayout_result_tab3 = (ConstraintLayout) findViewById(R.id.id_constraintLayout_result1_tab3);
        cLayout_result_tab4 = (ConstraintLayout) findViewById(R.id.id_constraintLayout_result1_tab4);
        cLayout_result_tab5 = (ConstraintLayout) findViewById(R.id.id_constraintLayout_result1_tab5);
        cLayout_result_tab6 = (ConstraintLayout) findViewById(R.id.id_constraintLayout_result1_tab6);

        txt_result_desc1.setTypeface(txt_type);
        txt_result_desc2.setTypeface(txt_type);
        txt_result_desc3.setTypeface(txt_type);
        txt_result_desc4.setTypeface(txt_type);
        txt_result_group_1_1.setTypeface(txt_type);
        txt_result_group_1_2.setTypeface(txt_type);
        txt_result_group_1_3.setTypeface(txt_type);
        txt_result_group_2_1.setTypeface(txt_type);
        txt_result_group_2_2.setTypeface(txt_type);
        txt_result_group_2_3.setTypeface(txt_type);
        txt_result_group_3_1.setTypeface(txt_type);
        txt_result_group_3_2.setTypeface(txt_type);
        txt_result_group_3_3.setTypeface(txt_type);
        txt_result_group_4_1.setTypeface(txt_type);
        txt_result_group_4_2.setTypeface(txt_type);
        txt_result_group_4_3.setTypeface(txt_type);
        txt_result_group_5_1.setTypeface(txt_type);
        txt_result_group_5_2.setTypeface(txt_type);
        txt_result_group_5_3.setTypeface(txt_type);

        txt_result_group_1_1.setText("1");
        txt_result_group_2_1.setText("2");
        txt_result_group_3_1.setText("3");
        txt_result_group_4_1.setText("4");
        txt_result_group_5_1.setText("5");

        switch (GeneralAttributes.val_GroupCount) {
            case 2:
                cLayout_result_tab4.setVisibility(View.GONE);
            case 3:
                cLayout_result_tab5.setVisibility(View.GONE);
            case 4:
                cLayout_result_tab6.setVisibility(View.GONE);
        }
    }

    private void PrepareGroupPoint() {
        SharedPreferences sPref = getApplicationContext().getSharedPreferences("groupWriter", Context.MODE_PRIVATE);
        SharedPreferences.Editor sEditor = sPref.edit();

        if (v_group_name.equals(GeneralAttributes.val_Group1_Name)) {
            cLayout_result_tab2.setBackgroundResource(R.drawable.style_txt_blue_settings);
            sEditor.putString(GeneralAttributes.val_Group1_Name, v_group_name);
            sEditor.putInt(GeneralAttributes.val_Group1_Name + "_TrueCount", v_true_count);
            sEditor.putInt(GeneralAttributes.val_Group1_Name + "_FalseCount", v_false_count);
            sEditor.putInt(GeneralAttributes.val_Group1_Name + "_GroupPoint", v_group_point);
        }
        if (v_group_name.equals(GeneralAttributes.val_Group2_Name)) {
            cLayout_result_tab3.setBackgroundResource(R.drawable.style_txt_blue_settings);
            sEditor.putString(GeneralAttributes.val_Group2_Name, GeneralAttributes.val_Group1_Name);
            sEditor.putInt(GeneralAttributes.val_Group2_Name + "_TrueCount", v_true_count);
            sEditor.putInt(GeneralAttributes.val_Group2_Name + "_FalseCount", v_false_count);
            sEditor.putInt(GeneralAttributes.val_Group2_Name + "_GroupPoint", v_group_point);
        }
        if (v_group_name.equals(GeneralAttributes.val_Group3_Name)) {
            cLayout_result_tab4.setBackgroundResource(R.drawable.style_txt_blue_settings);
            sEditor.putString(GeneralAttributes.val_Group3_Name, GeneralAttributes.val_Group1_Name);
            sEditor.putInt(GeneralAttributes.val_Group3_Name + "_TrueCount", v_true_count);
            sEditor.putInt(GeneralAttributes.val_Group3_Name + "_FalseCount", v_false_count);
            sEditor.putInt(GeneralAttributes.val_Group3_Name + "_GroupPoint", v_group_point);
        }
        if (v_group_name.equals(GeneralAttributes.val_Group4_Name)) {
            cLayout_result_tab5.setBackgroundResource(R.drawable.style_txt_blue_settings);
            sEditor.putString(GeneralAttributes.val_Group4_Name, GeneralAttributes.val_Group1_Name);
            sEditor.putInt(GeneralAttributes.val_Group4_Name + "_TrueCount", v_true_count);
            sEditor.putInt(GeneralAttributes.val_Group4_Name + "_FalseCount", v_false_count);
            sEditor.putInt(GeneralAttributes.val_Group4_Name + "_GroupPoint", v_group_point);
        }
        if (v_group_name.equals(GeneralAttributes.val_Group5_Name)) {
            cLayout_result_tab6.setBackgroundResource(R.drawable.style_txt_blue_settings);
            sEditor.putString(GeneralAttributes.val_Group5_Name, GeneralAttributes.val_Group1_Name);
            sEditor.putInt(GeneralAttributes.val_Group5_Name + "_TrueCount", v_true_count);
            sEditor.putInt(GeneralAttributes.val_Group5_Name + "_FalseCount", v_false_count);
            sEditor.putInt(GeneralAttributes.val_Group5_Name + "_GroupPoint", v_group_point);
        }
        sEditor.commit();
    }

    private void SetScreenGroupPoint() {
        SharedPreferences sPref = getApplicationContext().getSharedPreferences("groupWriter", Context.MODE_PRIVATE);
        int v_g1_point = sPref.getInt(GeneralAttributes.val_Group1_Name + "_GroupPoint", 0);
        int v_g1_true = sPref.getInt(GeneralAttributes.val_Group1_Name + "_TrueCount", 0);
        int v_g1_false = sPref.getInt(GeneralAttributes.val_Group1_Name + "_FalseCount", 0);

        int v_g2_point = sPref.getInt(GeneralAttributes.val_Group2_Name + "_GroupPoint", 0);
        int v_g2_true = sPref.getInt(GeneralAttributes.val_Group2_Name + "_TrueCount", 0);
        int v_g2_false = sPref.getInt(GeneralAttributes.val_Group2_Name + "_FalseCount", 0);

        int v_g3_point = sPref.getInt(GeneralAttributes.val_Group3_Name + "_GroupPoint", 0);
        int v_g3_true = sPref.getInt(GeneralAttributes.val_Group3_Name + "_TrueCount", 0);
        int v_g3_false = sPref.getInt(GeneralAttributes.val_Group3_Name + "_FalseCount", 0);

        int v_g4_point = sPref.getInt(GeneralAttributes.val_Group4_Name + "_GroupPoint", 0);
        int v_g4_true = sPref.getInt(GeneralAttributes.val_Group4_Name + "_TrueCount", 0);
        int v_g4_false = sPref.getInt(GeneralAttributes.val_Group4_Name + "_FalseCount", 0);

        int v_g5_point = sPref.getInt(GeneralAttributes.val_Group5_Name + "_GroupPoint", 0);
        int v_g5_true = sPref.getInt(GeneralAttributes.val_Group5_Name + "_TrueCount", 0);
        int v_g5_false = sPref.getInt(GeneralAttributes.val_Group5_Name + "_FalseCount", 0);

        txt_result_group_1_2.setText(GeneralAttributes.val_Group1_Name);
        txt_result_group_1_3.setText(v_g1_point + " / " + GeneralAttributes.val_FinishPoint + " (" + v_g1_true + " / " + v_g1_false + ")");

        txt_result_group_2_2.setText(GeneralAttributes.val_Group2_Name);
        txt_result_group_2_3.setText(v_g2_point + " / " + GeneralAttributes.val_FinishPoint + " (" + v_g2_true + " / " + v_g2_false + ")");

        txt_result_group_3_2.setText(GeneralAttributes.val_Group3_Name);
        txt_result_group_3_3.setText(v_g3_point + " / " + GeneralAttributes.val_FinishPoint + " (" + v_g3_true + " / " + v_g3_false + ")");

        txt_result_group_4_2.setText(GeneralAttributes.val_Group4_Name);
        txt_result_group_4_3.setText(v_g4_point + " / " + GeneralAttributes.val_FinishPoint + " (" + v_g4_true + " / " + v_g4_false + ")");

        txt_result_group_5_2.setText(GeneralAttributes.val_Group5_Name);
        txt_result_group_5_3.setText(v_g5_point + " / " + GeneralAttributes.val_FinishPoint + " (" + v_g5_true + " / " + v_g5_false + ")");

        if (v_g1_point > v_g2_point && v_g1_point > v_g3_point && v_g1_point > v_g4_point && v_g1_point > v_g5_point)
            cLayout_result_tab2.setBackgroundResource(R.drawable.style_txt_red_settings);
        if (v_g2_point > v_g1_point && v_g2_point > v_g3_point && v_g2_point > v_g4_point && v_g2_point > v_g5_point)
            cLayout_result_tab3.setBackgroundResource(R.drawable.style_txt_red_settings);
        if (v_g3_point > v_g2_point && v_g3_point > v_g1_point && v_g3_point > v_g4_point && v_g3_point > v_g5_point)
            cLayout_result_tab4.setBackgroundResource(R.drawable.style_txt_red_settings);
        if (v_g4_point > v_g2_point && v_g4_point > v_g3_point && v_g4_point > v_g1_point && v_g4_point > v_g5_point)
            cLayout_result_tab5.setBackgroundResource(R.drawable.style_txt_red_settings);
        if (v_g5_point > v_g2_point && v_g5_point > v_g3_point && v_g5_point > v_g4_point && v_g5_point > v_g1_point)
            cLayout_result_tab6.setBackgroundResource(R.drawable.style_txt_red_settings);
    }

    public void OnClick_RestartGame(View w) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
