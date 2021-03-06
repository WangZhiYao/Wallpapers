package space.levan.wallpapers.ui.home;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import space.levan.wallpapers.repo.api.entity.Photo;

/**
 * @author WangZhiYao
 * @date 2019/12/6
 */
class HomeDataSourceFactory extends PageKeyedDataSource.Factory<Integer, Photo> {

    private int mPage;
    private String mOrderBy;

    HomeDataSourceFactory(int page, String orderBy) {
        mPage = page;
        mOrderBy = orderBy;
    }

    @NonNull
    @Override
    public DataSource<Integer, Photo> create() {
        return new HomeDataSource(mPage, mOrderBy);
    }
}
