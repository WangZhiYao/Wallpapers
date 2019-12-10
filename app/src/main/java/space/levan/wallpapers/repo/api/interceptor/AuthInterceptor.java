package space.levan.wallpapers.repo.api.interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * UnSplash Auth
 *
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class AuthInterceptor implements Interceptor {

    @Override
    @NonNull
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request.newBuilder()
                .addHeader("Authorization", "Client-ID 92f21cf22dc42674b79df8a207bb488cbb39f90ebeb7b95291b5cca6385548e6")
                .addHeader("Accept-Version", "v1")
                .build());
    }
}
