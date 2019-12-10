package space.levan.wallpapers.repo.api.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class Category {

    private int id;
    private String title;
    @SerializedName("published_at")
    private String publishedAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("cover_photo")
    private Photo coverPhoto;
    private User user;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Photo getCoverPhoto() {
        return coverPhoto;
    }

    public User getUser() {
        return user;
    }
}
