package com.androidbelieve.drawerwithswipetabs;

import android.widget.CheckBox;

/**
 * Created by USER on 4/2/2016.
 */
public class favoriteObject {
    public static String name;
    public static boolean checkBox;

    public static boolean getChecked() {
        return checkBox;
    }
    public static void setChecked(boolean cb) {
        favoriteObject.checkBox=cb;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        favoriteObject.name = name;
    }


}
