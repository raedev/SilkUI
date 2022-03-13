package com.silk.dialog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * 默认对话框
 * @author RAE
 * @date 2021/10/19
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public abstract class SilkDialogFragment extends AppCompatDialogFragment {

    public SilkDialogFragment() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            setArguments(arguments);
        }
    }

}
