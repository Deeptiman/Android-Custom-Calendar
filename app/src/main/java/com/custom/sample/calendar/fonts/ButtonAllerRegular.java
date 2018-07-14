package com.custom.sample.calendar.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonAllerRegular extends Button {

    public ButtonAllerRegular(Context context, AttributeSet attrs,
                              int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ButtonAllerRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonAllerRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Rg.ttf");
        setTypeface(tf);
    }

}