package com.zeng.art;

import com.zeng.art.baselibrary.ArtApp;
import com.zeng.art.di.component.DaggerAppComponent;


public class App extends ArtApp  {
    @Override
    protected void injectApp() {

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

    }
}
