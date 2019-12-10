package space.levan.wallpapers.repo.api.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class Photo {

    private String id;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;
    @SerializedName("promoted_at")
    private Date promotedAt;
    private int width;
    private int height;
    private String color;
    private String description;
    @SerializedName("alt_description")
    private String altDescription;
    private Exif exif;
    private Location location;
    private List<Tag> tags;
    private PhotoUrls urls;
    private PhotoLinks links;
    private List<Category> categories;
    private int likes;
    @SerializedName("liked_by_user")
    private boolean likedByUser;
    @SerializedName("current_user_collections")
    private List<Category> currentUserCollections;
    private User user;

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getPromotedAt() {
        return promotedAt;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public Exif getExif() {
        return exif;
    }

    public Location getLocation() {
        return location;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public PhotoUrls getUrls() {
        return urls;
    }

    public PhotoLinks getLinks() {
        return links;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public int getLikes() {
        return likes;
    }

    public boolean isLikedByUser() {
        return likedByUser;
    }

    public List<Category> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public User getUser() {
        return user;
    }
}
