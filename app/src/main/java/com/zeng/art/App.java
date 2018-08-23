package com.zeng.art;

import com.zeng.art.baselibrary.ArtApp;
import com.zeng.art.di.dagger.DaggerAModuleComponent;


public class App extends ArtApp {
    @Override
    protected void injectApp() {

        DaggerAModuleComponent.builder().application(this).build().inject(this);

    }
}
