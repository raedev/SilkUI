package com.silk.utils;

import android.util.Log;

import com.silk.ui.BuildConfig;

/**
 * 日志记录
 * @author RAE
 * @date 2021/10/20
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public final class SilkLog {

    public final static boolean DEBUG = BuildConfig.DEBUG;
    private final static String TAG = "Silk";

    private static String newTag(String tag) {
        return TAG.concat(".").concat(tag);
    }

    public static void e(String tag, String msg, Throwable e) {
        Log.e(newTag(tag), msg, e);
    }

    public static void e(String tag, String msg) {
        e(tag, msg, null);
    }

    public static void e(String msg, Throwable e) {
        e(TAG, msg, null);
    }

    public static void e(String msg) {
        e(msg, (Throwable) null);
    }

    public static void w(String msg) {
        Log.w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable e) {
        Log.w(tag, msg, e);
    }

    public static void d(String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(newTag(tag), msg);
        }
    }

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(TAG.concat(".").concat(tag), msg);
        }
    }
}
