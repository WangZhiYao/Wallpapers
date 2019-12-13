package space.levan.wallpapers.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import space.levan.wallpapers.App;
import space.levan.wallpapers.R;
import space.levan.wallpapers.ui.BaseFragment;
import space.levan.wallpapers.ui.widgets.StaggeredGridItemDecoration;
import space.levan.wallpapers.utils.UIUtils;

public class HomeFragment extends BaseFragment {

    private static final String ORDER_BY_LATEST = "latest";
    private static final String ORDER_BY_OLDEST = "oldest";
    private static final String ORDER_BY_POPULAR = "popular";

    private static final int PHOTO_LIST_SPAN_COUNT = 2;
    private static final int PHOTO_LIST_INITIAL_PAGE = 1;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.recycler_view)
    RecyclerView mRvPhotoList;

    private HomeViewModel mHomeViewModel;
    private HomePhotoAdapter mHomePhotoAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);

        initView();
        initData();

        return root;
    }

    private void initView() {
        mSwipeRefresh.setEnabled(false);
        mRvPhotoList.setLayoutManager(new StaggeredGridLayoutManager(PHOTO_LIST_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL));
        mRvPhotoList.addItemDecoration(new StaggeredGridItemDecoration(PHOTO_LIST_SPAN_COUNT, UIUtils.dp2px(App.getInstance(), 6)));
    }

    private void initData() {
        mHomePhotoAdapter = new HomePhotoAdapter();
        mRvPhotoList.setAdapter(mHomePhotoAdapter);

        mHomeViewModel.getPhotoList(PHOTO_LIST_INITIAL_PAGE, ORDER_BY_LATEST)
                .observe(this, photos -> mHomePhotoAdapter.submitList(photos));
    }
}