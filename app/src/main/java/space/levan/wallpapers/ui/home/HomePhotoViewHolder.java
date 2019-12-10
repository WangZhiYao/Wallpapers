package space.levan.wallpapers.ui.home;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import space.levan.wallpapers.R;
import space.levan.wallpapers.repo.api.entity.Photo;
import space.levan.wallpapers.repo.api.entity.PhotoUrls;
import space.levan.wallpapers.utils.UIUtils;
import space.levan.wallpapers.utils.glide.GlideApp;

/**
 * @author WangZhiYao
 * @date 2019/12/9
 */
class HomePhotoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cv_home_photo)
    CardView mCvPhoto;
    @BindView(R.id.iv_home_photo)
    ImageView mIvPhoto;

    HomePhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(@NonNull Photo photo) {
        ViewGroup.LayoutParams cardViewParams = mCvPhoto.getLayoutParams();
        ViewGroup.LayoutParams imageViewParams = mIvPhoto.getLayoutParams();

        int widgetWidth = UIUtils.getScreenWidth(itemView.getContext()) / 2;
        cardViewParams.width = widgetWidth;
        imageViewParams.width = widgetWidth;

        int photoWidth = photo.getWidth();
        float scale = (float) widgetWidth / photoWidth;
        int widthHeight = (int) (scale * photo.getHeight());

        cardViewParams.height = widthHeight;
        imageViewParams.height = widthHeight;

        mCvPhoto.setLayoutParams(cardViewParams);
        mIvPhoto.setLayoutParams(imageViewParams);

        PhotoUrls urls = photo.getUrls();

        if (urls != null) {
            GlideApp.with(itemView.getContext())
                    .load(urls.getSmall())
                    .apply(new RequestOptions()
                            .override(widgetWidth, widthHeight)
                            .centerCrop())
                    .transition(new DrawableTransitionOptions().crossFade())
                    .thumbnail(0.1f)
                    .into(mIvPhoto);
        }
    }
}
