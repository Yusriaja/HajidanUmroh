package com.d4it_b.hajidanumroh.utils;

import android.app.Activity;
import android.content.Intent;

import com.d4it_b.hajidanumroh.R;

/**
 * Created by fahrul on 3/27/18.
 */

public class ThemeUtils

{

    private static int cTheme=2;



    public final static int DARK_GREEN = 0;
    public final static int SOFT_DARK = 1;
    public final static int AN_NUR = 2;



    public static void changeToTheme(Activity activity, int theme)

    {

        cTheme = theme;


        activity.finish();



        activity.startActivity(new Intent(activity, activity.getClass()));


    }

    public static void onActivityCreateSetTheme(Activity activity)

    {

        switch (cTheme)

        {

            default:

            case DARK_GREEN:

                activity.setTheme(R.style.ThemeWA);

                break;

            case SOFT_DARK:

                activity.setTheme(R.style.ThemeDarkAnNur);

                break;

            case AN_NUR:

                activity.setTheme(R.style.ThemeAnNur);

                break;

        }

    }

}
