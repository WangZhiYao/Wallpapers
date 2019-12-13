package space.levan.wallpapers.ui.widgets;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * @author WangZhiYao
 * @date 2019/12/13
 */
public class StaggeredGridItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpanCount;
    private int mSpacing;

    public StaggeredGridItemDecoration(int spanCount, int spacing) {
        mSpanCount = spanCount;
        mSpacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();

        if (params.getSpanIndex() % mSpanCount == 0) {
            outRect.left = mSpacing;
            outRect.right = mSpacing / 2;
        } else if (params.getSpanIndex() % mSpanCount == mSpanCount - 1) {
            outRect.left = mSpacing / 2;
            outRect.right = mSpacing;
        } else {
            outRect.left = mSpacing / 2;
            outRect.right = mSpacing / 2;
        }

        outRect.bottom = mSpacing;

        if (parent.getChildLayoutPosition(view) < mSpanCount) {
            outRect.top = mSpacing;
        }
    }
}
