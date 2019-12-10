package space.levan.wallpapers.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import space.levan.wallpapers.repo.api.entity.Photo;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";

    private PagedList.Config mPhotoListConfig = new PagedList.Config.Builder()
            .setInitialLoadSizeHint(20)
            .setPageSize(20)
            .setPrefetchDistance(8)
            .setEnablePlaceholders(false)
            .build();

    LiveData<PagedList<Photo>> getPhotoList(int page, String orderBy) {
        return new LivePagedListBuilder<>(new HomeDataSourceFactory(page, orderBy), mPhotoListConfig)
                .setInitialLoadKey(page)
                .build();
    }
}