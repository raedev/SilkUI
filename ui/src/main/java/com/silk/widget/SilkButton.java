package com.silk.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.silk.ui.R;

/**
 * 按钮
 * @author RAE
 * @date 2021/10/18
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public class SilkButton extends MaterialButton {
    public SilkButton(@NonNull Context context) {
        this(context, null);
    }

    public SilkButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.materialButtonStyle);
    }

    public SilkButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
