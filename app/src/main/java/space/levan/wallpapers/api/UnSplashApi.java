package space.levan.wallpapers.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import space.levan.wallpapers.api.response.Photo;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public interface UnSplashApi {

    String BASE_URL = "https://api.unsplash.com/";

    /**
     * Get a single page from the list of all photos.
     *
     * @param page    Page number to retrieve. (Optional; default: 1)
     * @param perPage Number of items per page. (Optional; default: 10)
     * @param orderBy How to sort the photos. Optional. (Valid values: latest, oldest, popular; default: latest)
     * @return
     */
    @GET("photos")
    Single<List<Photo>> getPhotos(@Query("page") int page,
                                  @Query("per_page") int perPage,
                                  @Query("order_by") String orderBy);

    /**
     * Retrieve a single photo.
     *
     * @param id The photo’s ID. Required.
     * @return
     */
    @GET("photo/{id}")
    Single<Photo> getPhotoById(@Path("id") String id);

    /**
     * Retrieve a single random photo, given optional filters.
     *
     * @param username    Limit selection to a single user.
     * @param query       Limit selection to photos matching a search term.
     * @param orientation Filter search results by photo orientation. Valid values are landscape, portrait, and squarish.
     * @param collections Public collection ID(‘s) to filter selection. If multiple, comma-separated
     * @param featured    Limit selection to featured photos.
     * @param count       The number of photos to return. (Default: 1; max: 30)
     * @return
     */
    @GET("photos/random")
    Single<Photo> getRandomPhoto(@Query("username") String username,
                                 @Query("query") String query,
                                 @Query("orientation") String orientation,
                                 @Query("collections") String collections,
                                 @Query("featured") String featured,
                                 @Query("count") int count);

}
