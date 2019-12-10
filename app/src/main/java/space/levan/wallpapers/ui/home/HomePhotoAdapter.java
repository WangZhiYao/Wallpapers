package space.levan.wallpapers.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import space.levan.wallpapers.R;
import space.levan.wallpapers.repo.api.entity.Photo;

/**
 * @author WangZhiYao
 * @date 2019/12/9
 */
class HomePhotoAdapter extends PagedListAdapter<Photo, RecyclerView.ViewHolder> {

    private static DiffUtil.ItemCallback<Photo> PHOTOS_DIFF_CALLBACK = new DiffUtil.ItemCallback<Photo>() {
        @Override
        public boolean areItemsTheSame(@NonNull Photo oldItem, @NonNull Photo newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Photo oldItem, @NonNull Photo newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    };

    HomePhotoAdapter() {
        super(PHOTOS_DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomePhotoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Photo photo = getItem(position);
        if (photo != null) {
            ((HomePhotoViewHolder) holder).bind(photo);
        }
    }
}
