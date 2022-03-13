package com.silk.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView
 * @author RAE
 * @date 2021/10/20
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public class SilkRecyclerView extends RecyclerView {
    public SilkRecyclerView(@NonNull Context context) {
        super(context);
    }

    public SilkRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SilkRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
