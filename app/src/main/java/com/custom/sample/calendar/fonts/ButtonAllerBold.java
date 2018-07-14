package com.custom.sample.calendar.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonAllerBold extends Button {

    public ButtonAllerBold(Context context, AttributeSet attrs,
                           int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ButtonAllerBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonAllerBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Bd.ttf");
        setTypeface(tf);
    }

}