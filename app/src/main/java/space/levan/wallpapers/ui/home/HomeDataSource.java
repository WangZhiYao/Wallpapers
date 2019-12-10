package space.levan.wallpapers.ui.home;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.Collections;
import java.util.List;

import space.levan.wallpapers.repo.api.ApiManager;
import space.levan.wallpapers.repo.api.ApiSubscriber;
import space.levan.wallpapers.repo.api.entity.Photo;
import space.levan.wallpapers.repo.api.exception.ApiException;
import space.levan.wallpapers.utils.RxHelper;

/**
 * @author WangZhiYao
 * @date 2019/12/6
 */
class HomeDataSource extends PageKeyedDataSource<Integer, Photo> {

    private int mPage;
    private String mOrderBy;

    HomeDataSource(int page, String orderBy) {
        mPage = page;
        mOrderBy = orderBy;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Photo> callback) {
        ApiManager.getInstance().getUnSplashApi()
                .getPhotos(mPage, params.requestedLoadSize, mOrderBy)
                .compose(RxHelper.rxSchedulerHelper())
                .subscribe(new ApiSubscriber<List<Photo>>() {
                    @Override
                    public void onSuccess(List<Photo> photos) {
                        if (photos != null && !photos.isEmpty()) {
                            callback.onResult(photos, null, mPage + 1);
                        } else {
                            callback.onResult(Collections.emptyList(), null, null);
                        }
                    }

                    @Override
                    public void onError(ApiException ex) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Photo> callback) {
        if (params.key <= 1) {
            callback.onResult(Collections.emptyList(), null);
            return;
        }

        ApiManager.getInstance().getUnSplashApi()
                .getPhotos(params.key, params.requestedLoadSize, mOrderBy)
                .compose(RxHelper.rxSchedulerHelper())
                .subscribe(new ApiSubscriber<List<Photo>>() {
                    @Override
                    public void onSuccess(List<Photo> photos) {
                        if (photos != null && !photos.isEmpty()) {
                            callback.onResult(photos, params.key - 1);
                        } else {
                            callback.onResult(Collections.emptyList(), null);
                        }
                    }

                    @Override
                    public void onError(ApiException ex) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Photo> callback) {
        ApiManager.getInstance().getUnSplashApi()
                .getPhotos(params.key, params.requestedLoadSize, mOrderBy)
                .compose(RxHelper.rxSchedulerHelper())
                .subscribe(new ApiSubscriber<List<Photo>>() {
                    @Override
                    public void onSuccess(List<Photo> photos) {
                        if (photos != null && !photos.isEmpty()) {
                            callback.onResult(photos, params.key + 1);
                        } else {
                            callback.onResult(Collections.emptyList(), null);
                        }
                    }

                    @Override
                    public void onError(ApiException ex) {

                    }
                });
    }
}
