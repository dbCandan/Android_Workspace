package com.dbcandan.taboodb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

public class warning_Snack {
    Snackbar mSnack;

    public warning_Snack(@NonNull Context v_context, @NonNull View v_view, @NonNull String v_message, boolean snackDuration) {
        this.mSnack = Snackbar.make(v_view, (CharSequence) v_message, -1);
        this.mSnack.getView().setBackgroundColor(ContextCompat.getColor(v_context, R.color.colorGray));
        this.mSnack.setActionTextColor(ContextCompat.getColor(v_context, R.color.colorWhite));
        if (snackDuration) {
            this.mSnack.setDuration(-2);
        }
        this.mSnack.show();
    }
}
