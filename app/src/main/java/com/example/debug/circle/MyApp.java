package com.example.debug.circle;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/24
 * description:
 */

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        mContext=this;
        super.onCreate();
    }
}
