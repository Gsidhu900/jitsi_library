package com.speedum.jitsi_libraries_main_app.Util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse.ColorConfigModel;
import com.speedum.jitsi_libraries_main_app.R;


public class CustomShapes {

    public static interface DrawableCallback {
        void setDrawable(Drawable drawable);
    }

    private static float mRadiusCalander = 15f;

    /*Return Text box outline*/
    public static GradientDrawable getTextBoxOutline(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.WHITE);
        shape.setCornerRadius(7);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppButtonColor()));
        return shape;
    }

   /*Return Text box outline*/
    public static GradientDrawable getTextBoxOutline(int color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.WHITE);
        shape.setCornerRadius(7);
        shape.setStroke(3, color);
        return shape;
    }

    /*Return Text box outline*/
    public static GradientDrawable getTextBoxOutline2(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(7);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppButtonColor()));
        return shape;
    }

   /*Return Text box outline*/
    public static GradientDrawable getTextBoxOutline2MoreRound(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(9);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppButtonColor()));
        return shape;
    }

    /*Return Text box outline*/
    public static GradientDrawable getImage_boarder(ColorConfigModel colorConfigModel,Context context) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(25);
        shape.setStroke(2, context.getResources().getColor(R.color.gray));
        return shape;
    }

    /*Return Text box outline*/
    public static GradientDrawable getBoxOutline(String color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(7);
        shape.setStroke(3, Color.parseColor(color));
        return shape;
    }


    /*Return Text box outline*/
    public static GradientDrawable getTextBoxOutline3(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(colorConfigModel.getAppDefaultColor()));
        shape.setCornerRadius(7);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppDefaultColor()));
        return shape;
    }
    /*Return Text box outline*/
    public static GradientDrawable getChatTextBoxOutline(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.WHITE);
        shape.setCornerRadius(50);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppButtonColor()));
        return shape;
    }

    /*Return Text box outline*/
    public static GradientDrawable searchEditBoxOutline(ColorConfigModel colorConfigModel, Context context) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(colorConfigModel.getAppIconColor()));
        shape.setCornerRadius(30);
        shape.setAlpha(70);
        shape.setStroke(1, Color.parseColor(colorConfigModel.getAppIconColor()));
        return shape;
    }
    /*return load more outline*/
    public static GradientDrawable getChatLoadMoreOutline(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(colorConfigModel.getAppMediumTheme()));
        shape.setCornerRadius(100);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppMediumTheme()));
        return shape;
    }

    /*return chat right outline*/
    public static GradientDrawable getChatRightLayOutline(ColorConfigModel colorConfigModel, Context context) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(context.getResources().getColor(R.color.profile_bg_color));
        shape.setCornerRadius(50);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppButtonColor()));
        return shape;
    }

    /*return chat left  outline*/
    public static GradientDrawable getChatLeftLayOutline(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.WHITE);
        shape.setCornerRadius(50);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppButtonColor()));
        return shape;
    }

    /*return load more outline*/
    public static GradientDrawable getChatDateOutline(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(colorConfigModel.getAppDarkThemeColor()));
        shape.setCornerRadius(100);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppDarkThemeColor()));
        return shape;
    }

    /*Return Negitive button*/
    public static GradientDrawable getNegitiveButton(ColorConfigModel colorConfigModel) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.WHITE);
        shape.setCornerRadius(7);
        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppNegativeButton()));
        return shape;
    }


    /*Return Text box outline*/
    public static void getHomeScreenButtons(String color, DrawableCallback callback) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(color));
        shape.setCornerRadius(14);
//        shape.setStroke(3, Color.parseColor(color));
        if (shape != null) {
            callback.setDrawable(shape);
        }
    }

    /*Return Text box outline*/
    public static void getToolBarBack(Context context, String color, DrawableCallback callback) {
        float mRadiusCalander = 30f;
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(color));
        shape.setCornerRadius(7);
        shape.setStroke(2,ContextCompat.getColor(context,R.color.gray));
        shape.setCornerRadii(new float[]{0, 0, 0, 0, mRadiusCalander, mRadiusCalander, mRadiusCalander, mRadiusCalander});
//        shape.setStroke(3,ContextCompat.getColor(context,R.color.gray));
        if (shape != null) {
            callback.setDrawable(shape);
        }
    }

    /*Return Text box outline*/
    public static void getBottomBarBack(Context context, String color, DrawableCallback callback) {
        float mRadiusCalander = 30f;
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(color));
        shape.setCornerRadius(7);
        shape.setStroke(2,ContextCompat.getColor(context,R.color.gray));
        shape.setCornerRadii(new float[]{mRadiusCalander, mRadiusCalander, mRadiusCalander, mRadiusCalander, 0, 0, 0, 0});
//        shape.setStroke(3,ContextCompat.getColor(context,R.color.gray));
        if (shape != null) {
            callback.setDrawable(shape);
        }
    }

    /*Return Text box outline*/
    public static GradientDrawable getCalendarTop(String color) {

        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.WHITE);
//        shape.setCornerRadius(7);
        shape.setCornerRadii(new float[]{mRadiusCalander, mRadiusCalander, mRadiusCalander, mRadiusCalander, 0, 0, 0, 0});
        shape.setStroke(3, Color.parseColor(color));
        return shape;
    }

    /*Return Text box outline*/
    public static GradientDrawable getCalendarBottom(String color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor(color));
//        shape.setCornerRadius(7);
        shape.setCornerRadii(new float[]{0, 0, 0, 0, mRadiusCalander, mRadiusCalander, mRadiusCalander, mRadiusCalander});
//        shape.s
//        shape.setStroke(3, Color.parseColor(colorConfigModel.getAppButtonColor()));
        return shape;
    }

    /*Return rounded solid button*/
    public static Drawable getDefaultButtonShape(Context context, ColorConfigModel colorConfigModel) {
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.press_button);
        ColorStateList colorStateListButton = new ColorStateList(
                new int[][]{{android.R.attr.state_selected},
                        {}},
                new int[]{Color.parseColor(colorConfigModel.getAppDarkThemeColor()), Color.parseColor(colorConfigModel.getAppButtonColor())});
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTintList(wrappedDrawable, colorStateListButton);
        return wrappedDrawable;
    }

   /*Return rounded solid button*/
    public static Drawable getDefaultButtonShapeMoreRound(Context context, ColorConfigModel colorConfigModel) {
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.press_button);
        ColorStateList colorStateListButton = new ColorStateList(
                new int[][]{{android.R.attr.state_selected},
                        {}},
                new int[]{Color.parseColor(colorConfigModel.getAppDarkThemeColor()), Color.parseColor(colorConfigModel.getAppButtonColor())});
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTintList(wrappedDrawable, colorStateListButton);
        return wrappedDrawable;
    }

   /*Return rounded solid button*/
        public static Drawable getDefaultButtonShape(Context context, String color) {
            if (color==null||color.length()<=0){
                color="#427fed";
            }
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.press_button);
        ColorStateList colorStateListButton = new ColorStateList(
                new int[][]{{android.R.attr.state_selected},
                        {}},
                new int[]{Color.parseColor(color), Color.parseColor(color)});
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTintList(wrappedDrawable, colorStateListButton);
        return wrappedDrawable;
    }


    /*Return rounded solid button dynamic color*/
    public static Drawable getCustomColorSolodButton(Context context, String color) {
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.press_button);
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, Color.parseColor(color));
        return wrappedDrawable;
    }

    /*Return input drawable with input color */
    public static Drawable getDrawableWithTint(Context context, int drawable, String color) {
        if (color==null||color.length()<=0){
            color="#0099cc";
        }
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, drawable);
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, Color.parseColor(color));
        if (wrappedDrawable == null) {
            wrappedDrawable = ContextCompat.getDrawable(context, drawable);
        }
        return wrappedDrawable;
    }

   /*Return input drawable with input color */
    public static Drawable getDrawableWithTint(Context context, Drawable drawable, String color) {
        Drawable unwrappedDrawable = drawable;
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, Color.parseColor(color));
        if (wrappedDrawable == null) {
            wrappedDrawable = drawable;
        }
        return wrappedDrawable;
    }

   /*Return input drawable with input color */
    public static Drawable getDrawableWithTint(Context context, int drawable, int color) {
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, drawable);

        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, color);
        if (wrappedDrawable == null) {
            wrappedDrawable = ContextCompat.getDrawable(context, drawable);
        }
        return wrappedDrawable;
    }

    /*Return Selector drawable will give color for select and un select view*/
    public static StateListDrawable getSelectorDrawable(String defaultColor, String onSelectedColor) {
        StateListDrawable res = new StateListDrawable();
        res.setExitFadeDuration(400);
        res.setAlpha(45);
        res.addState(new int[]{android.R.attr.state_checked}, new ColorDrawable(Color.parseColor(onSelectedColor)));
//        res.addState(new int[]{}, new ColorDrawable(Color.parseColor(defaultColor)));
        return res;
    }


    /*Return Selector drawable will give color for select and un select view*/
    public static ColorStateList getSelectorColorList(String defaultColor, String onSelectedColor) {
        ColorStateList textColorStates = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_selected},
                        new int[]{android.R.attr.state_active},
                        new int[]{-android.R.attr.state_active},
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        Color.parseColor(onSelectedColor),
                        Color.parseColor(onSelectedColor),
                        Color.parseColor(defaultColor),
                        Color.parseColor(defaultColor),
//                        Color.parseColor(defaultColor),
                        Color.parseColor(onSelectedColor)
                });

//        ColorStateList myList = new ColorStateList(states, colors);
        return textColorStates;
    }

    public static ColorStateList getSelectorColorList2() {
        int[] colors = new int[]{
                Color.BLACK,
                Color.BLACK,
                Color.GREEN,
        };

        int[][] states = new int[][]{
                new int[]{android.R.attr.state_hovered, android.R.attr.state_single},
                new int[]{android.R.attr.state_enabled, -android.R.attr.state_checked},
                new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}
        };

//        ColorStateList myList = new ColorStateList(states, colors);
        return new ColorStateList(states, colors);
    }

    public static StateListDrawable makeSelector(String color) {
        StateListDrawable res = new StateListDrawable();
        res.setExitFadeDuration(400);
        res.setAlpha(45);
        res.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.parseColor(color)));
        res.addState(new int[]{}, new ColorDrawable(Color.BLACK));
        return res;
    }


}
