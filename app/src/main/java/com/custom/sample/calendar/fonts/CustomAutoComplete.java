package com.custom.sample.calendar.fonts;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;


public class CustomAutoComplete extends AutoCompleteTextView {

    Context context;



    public CustomAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }



    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_1 :
                //
                break;
            case KeyEvent.KEYCODE_2 :
                //
                break;
            case KeyEvent.KEYCODE_3 :
                //
                break;
        }
        return true;
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Lt.ttf");
        setTypeface(tf);
    }

}