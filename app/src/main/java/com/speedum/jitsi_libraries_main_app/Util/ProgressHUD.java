package com.speedum.jitsi_libraries_main_app.Util;


import android.app.Dialog;
import android.content.Context;


public class ProgressHUD extends Dialog {
    public ProgressHUD(Context context) {
        super(context);
    }

    public ProgressHUD(Context context, int theme) {
        super(context, theme);
    }

    public void onWindowFocusChanged(boolean hasFocus) {

//		ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
//		AnimationDrawable spinner = (AnimationDrawable) imageView
//				.getBackground();
//		spinner.start();
    }

/*
    @RequiresApi(api = Build.VERSION_CODES.P)
    public static ProgressHUD show(Context context, boolean indeterminate,
                                   boolean cancelable, OnCancelListener cancelListener, ColorConfigModel colorConfigModel) {
       ProgressHUD dialog = new ProgressHUD(context, R.style.ProgressHUD);
       */
/*  try {
            dialog = new ProgressHUD(context, R.style.ProgressHUD);
            dialog.setTitle("");
            dialog.setContentView(R.layout.progress_hud);
            MyLoader avLoadingIndicatorView=(MyLoader)dialog.findViewById(R.id.avloadingIndicatorView);
            avLoadingIndicatorView.setIndecatorColor(colorConfigModel.getAppDefaultColor());
            dialog.setCancelable(cancelable);
            dialog.setOnCancelListener(cancelListener);
            dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.dimAmount = 0.2f;
            dialog.getWindow().setAttributes(lp);
            // dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            dialog.show();
        } catch (Exception e) {

        }*//*

        return dialog;
    }
*/
/*
  public static ProgressHUD showSplash(Context context, boolean indeterminate,
                                   boolean cancelable, OnCancelListener cancelListener) {
        ProgressHUD dialog = new ProgressHUD(context, R.style.ProgressHUD);
        try {
            dialog = new ProgressHUD(context, R.style.ProgressHUD);
            dialog.setTitle("");
            dialog.setContentView(R.layout.progress_hud);
            LinearLayout LinearLayout_backcontainer=dialog.findViewById(R.id.LinearLayout_backcontainer);
            LinearLayout_backcontainer.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
            dialog.setCancelable(cancelable);
            dialog.setOnCancelListener(cancelListener);
            dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.dimAmount = 0.2f;
            dialog.getWindow().setAttributes(lp);
            // dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            dialog.show();
        } catch (Exception e) {

        }
        return dialog;
    }
*/
}
