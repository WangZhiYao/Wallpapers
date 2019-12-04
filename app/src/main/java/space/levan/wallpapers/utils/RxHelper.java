package space.levan.wallpapers.utils;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class RxHelper {

    public static <T> SingleTransformer<T, T> rxSchedulerHelper() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
