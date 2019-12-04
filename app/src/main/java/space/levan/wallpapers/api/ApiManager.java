package space.levan.wallpapers.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class ApiManager {

    private UnSplashApi mUnSplashApi;

    private static final long DEFAULT_CONNECT_TIMEOUT = 10;
    private static final long DEFAULT_READ_TIMEOUT = 10;
    private static final long DEFAULT_WRITE_TIMEOUT = 10;

    private ApiManager() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(new AuthInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UnSplashApi.BASE_URL)
                .client(httpClient)
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
