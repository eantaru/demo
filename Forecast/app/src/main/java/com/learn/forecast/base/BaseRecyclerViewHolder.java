package com.learn.forecast.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseRecyclerViewHolder(@NonNull Context context, @NonNull  int resource,
        @NonNull ViewGroup parent) {
        this(context, LayoutInflater.from(context).inflate(resource, parent, false));
    }

    public BaseRecyclerViewHolder(@NonNull Context context, @NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(T data);
}
