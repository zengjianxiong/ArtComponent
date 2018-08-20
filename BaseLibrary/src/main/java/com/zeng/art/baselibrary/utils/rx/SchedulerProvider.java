

package com.zeng.art.baselibrary.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by amitshekhar on 07/07/17.
 */

public interface SchedulerProvider {


    Scheduler io();

    Scheduler newThread();

    Scheduler ui();
}
