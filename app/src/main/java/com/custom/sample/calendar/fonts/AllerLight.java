package com.custom.sample.calendar.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class AllerLight extends TextView {

    public AllerLight(Context context, AttributeSet attrs,
                      int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AllerLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AllerLight(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Lt.ttf");
        setTypeface(tf);
    }

}