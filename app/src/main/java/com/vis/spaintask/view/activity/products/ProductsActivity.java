package com.vis.spaintask.view.activity.products;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.vis.spaintask.R;
import com.vis.spaintask.data.Constants;
import com.vis.spaintask.data.Preferences;
import com.vis.spaintask.model.Items;
import com.vis.spaintask.presenter.userproducts.UserProductsPresenter;
import com.vis.spaintask.presenter.userproducts.UserProductsPresenterImp;
import com.vis.spaintask.view.activity.base.BaseActivity;
import com.vis.spaintask.view.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends BaseActivity implements ProductsView {
    @BindView(R.id.recyclerView_products)
    RecyclerView recyclerView_products;
    private UserProductsPresenter userProductsPresenter;
    private List<Items> userItemsList;
    private ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);
        userItemsList = new ArrayList<Items>();

        productsAdapter = new ProductsAdapter(userItemsList, getApplicationContext());
        userProductsPresenter = new UserProductsPresenterImp(this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_products.setLayoutManager(mLayoutManager);
        recyclerView_products.setItemAnimator(new DefaultItemAnimator());
        recyclerView_products.setAdapter(productsAdapter);



        userProductsPresenter.getUserProducts(Preferences.getUserDataObj().getToken());
    }



    @Override
    public void onGetProductsSuccess(List<Items> items) {
        userItemsList.clear();
        userItemsList.addAll(items);
        productsAdapter.notifyDataSetChanged();
    }
}
