/*
 * Copyright (c) 2018 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.douya.ui;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zhanghai.android.douya.R;
import me.zhanghai.android.douya.util.ViewUtils;

public class HorizontalUploadImageAdapter
        extends ClickableSimpleAdapter<Uri, HorizontalUploadImageAdapter.ViewHolder> {

    public HorizontalUploadImageAdapter() {
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        // Deliberately using plain hash code to identify only this instance.
        return getItem(position).hashCode();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ViewUtils.inflate(R.layout.horizontal_upload_image_item, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.uploadImageLayout.loadImage(getItem(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        public UploadImageLayout uploadImageLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
