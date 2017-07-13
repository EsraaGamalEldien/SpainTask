package com.vis.spaintask.view.activity.products;


import com.vis.spaintask.model.Items;
import com.vis.spaintask.view.activity.base.BaseView;

import java.util.List;

/**
 * Created by Esraa on 7/8/2017.
 */

public interface ProductsView extends BaseView {
    void onGetProductsSuccess(List<Items> items);
}
