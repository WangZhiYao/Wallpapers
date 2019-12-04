package space.levan.wallpapers.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class User {

    private String id;
    @SerializedName("updated_at")
    private Date updatedAt;
    private String username;
    private String name;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("twitter_username")
    private String twitterUsername;
    @SerializedName("portfolio_url")
    private String portfolioUrl;
    private String bio;
    private String location;
    private UserLinks links;
    @SerializedName("profile_image")
    private ProfileImage profileImage;
    @SerializedName("instagram_username")
    private String instagramUsername;
    @SerializedName("total_collections")
    private int totalCollections;
    @SerializedName("total_likes")
    private int totalLikes;
    @SerializedName("total_photos")
    private int totalPhotos;
    @SerializedName("accepted_tos")
    private boolean acceptedTos;

    public String getId() {
        return id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public UserLinks getLinks() {
        return links;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public int getTotalCollections() {
        return totalCollections;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getTotalPhotos() {
        return totalPhotos;
    }

    public boolean isAcceptedTos() {
        return acceptedTos;
    }
}
