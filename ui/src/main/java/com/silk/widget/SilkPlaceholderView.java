package com.silk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.silk.ui.R;

/**
 * 占位布局
 * @author RAE
 * @date 2021/10/20
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public class SilkPlaceholderView extends FrameLayout {

    private View mEmptyLayout;
    private View mLoadingLayout;

    /**
     * 视图模式，默认是加载中
     */
    private ViewMode mViewMode = ViewMode.Loading;

    /**
     * 提示消息
     */
    private CharSequence mMessage;
    private TextView mEmptyMessageView;
    private TextView mLoadingMessageView;

    /**
     * 视图模式
     */
    public enum ViewMode {
        /**
         * 空视图
         */
        Empty,
        /**
         * 加载中
         */
        Loading
    }

    public SilkPlaceholderView(@NonNull Context context) {
        super(context);
        initView();
    }

    public SilkPlaceholderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.silk_view_placeholder, this);
        mEmptyLayout = findViewById(R.id.ll_empty);
        mLoadingLayout = findViewById(R.id.ll_loading);
        mEmptyMessageView = findViewById(R.id.tv_message);
        mLoadingMessageView = findViewById(R.id.tv_loading_message);
        showLoading();
    }

    /**
     * 设置当前的显示模式
     * @param viewMode 显示模式
     */
    public void setViewMode(ViewMode viewMode) {
        mViewMode = viewMode;
        onViewModeChanged();
    }

    protected void onViewModeChanged() {
        // 隐藏其他布局
        if (mViewMode == ViewMode.Loading) {
            mEmptyLayout.setVisibility(View.GONE);
            mLoadingLayout.setVisibility(View.VISIBLE);
            mLoadingMessageView.setText(mMessage);
        } else {
            mEmptyLayout.setVisibility(View.VISIBLE);
            mLoadingLayout.setVisibility(View.GONE);
            mEmptyMessageView.setText(mMessage);
        }
    }

    // region 快速设置方法

    public void showEmpty() {
        showEmpty(getContext().getString(R.string.silk_default_empty_message));
    }

    public void showEmpty(CharSequence message) {
        mMessage = message;
        setViewMode(ViewMode.Empty);
    }

    public void showLoading() {
        showLoading(getContext().getString(R.string.silk_default_loading_message));
    }

    public void showLoading(CharSequence message) {
        mMessage = message;
        setViewMode(ViewMode.Loading);
    }

    // endregion

    /**
     * 隐藏
     */
    public void dismiss() {
        setVisibility(View.GONE);
    }

}
