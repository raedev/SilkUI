package com.silk.dialog;

import android.os.Bundle;

/**
 * 弹出对话框
 * @author RAE
 * @date 2021/10/19
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public class SilkLoadingDialogFragment extends SilkDialogFragment {

    public static SilkLoadingDialogFragment newInstance(String message) {
        Bundle args = new Bundle();
        args.putString("message", message);
        SilkLoadingDialogFragment fragment = new SilkLoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private SilkLoadingDialogFragment() {
    }

    public void setMessage(String message) {
        Bundle arguments = requireArguments();
        arguments.putString("message", message);
    }
}
