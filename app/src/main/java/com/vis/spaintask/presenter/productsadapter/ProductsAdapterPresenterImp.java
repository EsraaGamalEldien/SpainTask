package com.vis.spaintask.presenter.productsadapter;

import android.content.Intent;
import android.net.Uri;

import com.vis.spaintask.data.App;
import com.vis.spaintask.data.Constants;
import com.vis.spaintask.data.Preferences;
import com.vis.spaintask.presenter.base.BasePresenterImp;

/**
 * Created by Esraa on 7/10/2017.
 */

public class ProductsAdapterPresenterImp  implements ProductsAdapterPresenter {
    @Override
    public boolean isPostpaid() {
        if (Preferences.getUserDataObj().getUserType().equals(Constants.POSTPAID))
            return true;
        else
            return false;
    }

    @Override
    public void openUrlLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getAppContext().startActivity(intent);
    }
}
