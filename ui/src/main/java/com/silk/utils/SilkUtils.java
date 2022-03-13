package com.silk.utils;

import android.content.Context;
import android.os.Build;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 工具类
 * @author RAE
 * @date 2021/10/20
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@SuppressWarnings({"SpellCheckingInspection"})
public final class SilkUtils {

    private static final String BRAND = Build.BRAND.toLowerCase();

    private SilkUtils() {
    }

    // region 资源相关


    // endregion

    // region IO操作

    public static void closeStream(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // endregion

    // region 设备相关

    /**
     * 是否为小米手机
     */
    public static boolean isXiaomi() {
        return Build.MANUFACTURER.toLowerCase().equals("xiaomi");
    }

    public static boolean isVivo() {
        return BRAND.contains("vivo") || BRAND.contains("bbk");
    }

    public static boolean isOppo() {
        return BRAND.contains("oppo");
    }

    public static boolean isHuawei() {
        return BRAND.contains("huawei") || BRAND.contains("honor");
    }

    public static boolean isEssentialPhone() {
        return BRAND.contains("essential");
    }

    // endregion

    // region UI相关

    /**
     * 获取状态栏导读
     */
    public static int getStatusBarHeight(Context context) {
        if (isXiaomi()) {
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                return context.getResources().getDimensionPixelSize(resourceId);
            }
            return 0;
        }
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            if (x > 0) {
                return context.getResources().getDimensionPixelSize(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // endregion
}
