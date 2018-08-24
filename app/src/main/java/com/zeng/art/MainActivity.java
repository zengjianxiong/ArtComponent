package com.zeng.art;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zeng.art.baselibrary.base.simple.SimpleActivity;
import com.zeng.art.baselibrary.core.RouterHub;

import butterknife.BindView;

@Route(path = RouterHub.APP_MAINACTIVITY)
public class MainActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setSimple(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setUp() {

        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(RouterHub.GANK_GANKACTIVITY).navigation();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
