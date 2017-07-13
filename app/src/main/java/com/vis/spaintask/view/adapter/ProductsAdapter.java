package com.vis.spaintask.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.vis.spaintask.R;
import com.vis.spaintask.data.Constants;
import com.vis.spaintask.data.Preferences;
import com.vis.spaintask.model.Items;
import com.vis.spaintask.presenter.productsadapter.ProductsAdapterPresenter;
import com.vis.spaintask.presenter.productsadapter.ProductsAdapterPresenterImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Esraa on 7/8/2017.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Items> itemsList;
    private Context context;
    private ProductsAdapterPresenter productsAdapterPresenter;

    public ProductsAdapter(List<Items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
        productsAdapterPresenter = new ProductsAdapterPresenterImp();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Items item = itemsList.get(position);
        if (item == null) return;
        if (item.getLabel() != null) holder.tv_tv_title.setText(item.getLabel());
        if (productsAdapterPresenter.isPostpaid()) {
            holder.tv_tv_subtitle.setVisibility(View.VISIBLE);
            holder.tv_tv_subtitle.setText(item.getSubtitle());
        }
        if (item.getIcon() != null)
            Glide.with(context).load(item.getIcon()).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    holder.progress_loadingImg.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    holder.progress_loadingImg.setVisibility(View.GONE);
                    return false;
                }
            })
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imgv_icon);

        holder.cardView_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productsAdapterPresenter.openUrlLink(item.getUrl());
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgv_icon)
        ImageView imgv_icon;
        @BindView(R.id.tv_tv_title)
        TextView tv_tv_title;
        @BindView(R.id.tv_tv_subtitle)
        TextView tv_tv_subtitle;
        @BindView(R.id.progress_loadingImg)
        ProgressBar progress_loadingImg;
        @BindView(R.id.cardView_products)
        CardView cardView_products;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
