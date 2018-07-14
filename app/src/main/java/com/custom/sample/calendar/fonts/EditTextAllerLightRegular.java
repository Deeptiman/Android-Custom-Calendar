package com.custom.sample.calendar.fonts;

public class EditTextAllerLightRegular extends android.widget.EditText {

    public EditTextAllerLightRegular(android.content.Context context, android.util.AttributeSet attrs,
                                     int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditTextAllerLightRegular(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextAllerLightRegular(android.content.Context context) {
        super(context);
        init();
    }

    private void init() {
        android.graphics.Typeface tf = android.graphics.Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Aller_Lt.ttf");
        setTypeface(tf);
    }

}