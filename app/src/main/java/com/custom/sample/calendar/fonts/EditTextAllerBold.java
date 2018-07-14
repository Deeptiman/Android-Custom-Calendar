package com.custom.sample.calendar.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextAllerBold extends EditText {

    public EditTextAllerBold(Context context, AttributeSet attrs,
                             int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditTextAllerBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextAllerBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Bd.ttf");
        setTypeface(tf);
    }

}