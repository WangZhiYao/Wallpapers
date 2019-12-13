package space.levan.wallpapers;

import android.app.Application;

/**
 * @author WangZhiYao
 * @date 2019/12/13
 */
public class App extends Application {

    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }

    public static App getInstance() {
        return sInstance;
    }
}
