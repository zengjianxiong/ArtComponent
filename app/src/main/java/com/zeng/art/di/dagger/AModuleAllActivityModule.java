package com.zeng.art.di.dagger;


import com.zeng.art.baselibrary.di.component.ArtActivityComponent;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {
        ArtActivityComponent.class
})
public abstract class AModuleAllActivityModule {


}
