package space.levan.wallpapers.repo.api;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.IOException;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;
import space.levan.wallpapers.repo.api.exception.ApiException;
import space.levan.wallpapers.repo.api.exception.ErrorResponse;

/**
 * @author WangZhiYao
 * @date 2019/12/6
 */
public abstract class ApiSubscriber<T> implements SingleObserver<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            Response response = ((HttpException) e).response();
            if (response != null) {
                ResponseBody errorBody = response.errorBody();
                if (errorBody != null) {
                    try {
                        ErrorResponse errorResponse = new Gson().fromJson(errorBody.string(), ErrorResponse.class);
                        if (errorResponse.getErrors() != null && !errorResponse.getErrors().isEmpty()) {
                            onError(new ApiException(response.code(), errorResponse.getErrors().get(0)));
                        }
                    } catch (IOException ex) {
                        onError(new ApiException(response.code(), ex.getMessage()));
                    }
                } else {
                    onError(new ApiException(response.code(), response.message()));
                }
            } else {
                onError(new ApiException.NoResponse());
            }
        } else if (e instanceof JsonParseException) {
            onError(new ApiException.ParseError());
        } else {
            onError(new ApiException.UnknowError());
        }
    }

    public abstract void onError(ApiException ex);
}
