package com.learn.forecast.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<VH extends BaseRecyclerViewHolder<T>,T> extends
    RecyclerView.Adapter<VH> {

    private List<T> items;

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return null;
//    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, int index) {
        viewHolder.bindData(getItem(index));
    }

    @Override
    public int getItemCount() {
        return  getItemSize();
    }

    public void appendItems(List<T> newItems) {
        if (newItems == null) {
            return;
        }

        this.items = newItems;
        notifyDataSetChanged();
    }

    public T getItem(int index) {
        if (index < getItemSize()) {
            return items.get(index);
        }
        return null;
    }

    private int getItemSize() {
        if (null == items) {
            return 0;
        }
        return items.size();
    }
}
