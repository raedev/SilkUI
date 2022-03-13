package com.silk.ui;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;

import com.silk.dialog.SilkLoadingDialogFragment;

import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * 全局使用的组件
 * @author RAE
 * @date 2021/10/18
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public final class SilkCompat {

    private static Application sApplication;
    @Nullable
    private static WeakReference<SilkLoadingDialogFragment> sWeakReference;

    private SilkCompat() {
    }

    public static void attach(Application application) {
        sApplication = application;
    }

    @NonNull
    public static Context getContext() {
        return Objects.requireNonNull(sApplication, "全局使用，请先初始化SilkCompat.attach()中的Application！");
    }

    public static void showToast(@StringRes int resId) {
        showToast(getContext().getString(resId));
    }

    public static void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static SilkLoadingDialogFragment showLoading(FragmentActivity activity, String message) {
        // 判断是否需要创建
        SilkLoadingDialogFragment fragment;
        if (sWeakReference == null || sWeakReference.get() == null) {
            fragment = SilkLoadingDialogFragment.newInstance(message);
            sWeakReference = new WeakReference<>(fragment);
        } else {
            fragment = sWeakReference.get();
            fragment.setMessage(message);
        }
        if (fragment.getDialog() == null || !fragment.getDialog().isShowing()) {
            fragment.show(activity.getSupportFragmentManager(), "SilkLoadingDialog");
        }
        return fragment;
    }

    public static void dismissLoading() {
        if (sWeakReference != null && sWeakReference.get() != null) {
            sWeakReference.get().dismiss();
            sWeakReference.clear();
            sWeakReference = null;
        }
    }
}
