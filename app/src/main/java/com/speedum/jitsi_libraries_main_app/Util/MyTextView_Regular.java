package com.speedum.jitsi_libraries_main_app.Util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView_Regular extends TextView {

	Context mcontext ;
	public MyTextView_Regular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mcontext =context;
        init();
    }

    public MyTextView_Regular(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext =context;
        init();
    }

    public MyTextView_Regular(Context context) {
        super(context);
        mcontext =context;
        init();
    }

    private void init() {
    	   Typeface custom_font4 = Util.getfontStyle(mcontext, Util.Fontstyle.FONT_REGULAR);//Typeface.createFromAsset(mcontext.getAssets(), "font/HelveticaLTStdCond.otf");
      //  Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"font/HelveticaLTStdCond.otf");
        setTypeface(custom_font4);
       
    }

}
