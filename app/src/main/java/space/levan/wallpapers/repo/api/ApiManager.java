package space.levan.wallpapers.repo.api;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import space.levan.wallpapers.App;
import space.levan.wallpapers.repo.api.interceptor.AuthInterceptor;
import space.levan.wallpapers.repo.api.interceptor.CacheInterceptor;
import space.levan.wallpapers.utils.FileUtils;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class ApiManager {

    private UnSplashApi mUnSplashApi;

    private static final long DEFAULT_CACHE_SIZE = 10 * 1024 * 1024;

    private static final long DEFAULT_CONNECT_TIMEOUT = 10;
    private static final long DEFAULT_READ_TIMEOUT = 10;
    private static final long DEFAULT_WRITE_TIMEOUT = 10;

    private ApiManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);

        Cache cache = new Cache(FileUtils.getPrivateCacheDir(App.getInstance()), DEFAULT_CACHE_SIZE);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(new AuthInterceptor())
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(new CacheInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UnSplashApi.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mUnSplashApi = retrofit.create(UnSplashApi.class);
    }

    private static class SingletonHolder {
        private static ApiManager mInstance = new ApiManager();
    }

    public static ApiManager getInstance() {
        return SingletonHolder.mInstance;
    }

    public UnSplashApi getUnSplashApi() {
        return mUnSplashApi;
    }
}
