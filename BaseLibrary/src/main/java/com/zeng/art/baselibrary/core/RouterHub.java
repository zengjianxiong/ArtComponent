
package com.zeng.art.baselibrary.core;


public interface RouterHub {
    /**
     * 组名
     */
    String APP = "/app";//宿主 App 组件
    String ZHIHU = "/zhihu";//知乎组件
    String GANK = "/gank";//干货集中营组件
    String GOLD = "/gold";//稀土掘金组件

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    String SERVICE = "/service";


    /**
     * 宿主 App 分组
     */
    String APP_SPLASHACTIVITY = APP + "/SplashActivity";
    String APP_MAINACTIVITY = APP + "/MainActivity";


    /**
     * 知乎分组
     */
    String ZHIHU_SERVICE_ZHIHUINFOSERVICE = ZHIHU + SERVICE + "/ZhihuInfoService";

    String ZHIHU_HOMEACTIVITY = ZHIHU + "/HomeActivity";
    String ZHIHU_DETAILACTIVITY = ZHIHU + "/DetailActivity";

    /**
     * 干货集中营分组
     */
    String GANK_SERVICE_GANKINFOSERVICE = GANK + SERVICE + "/GankInfoService";

    String GANK_GANKACTIVITY = GANK + "/GankActivity";

    /**
     * 稀土掘金分组
     */
    String GOLD_SERVICE_GOLDINFOSERVICE = GOLD + SERVICE + "/GoldInfoService";

    String GOLD_HOMEACTIVITY = GOLD + "/HomeActivity";
    String GOLD_DETAILACTIVITY = GOLD + "/DetailActivity";
}
