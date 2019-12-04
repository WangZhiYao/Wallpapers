package space.levan.wallpapers.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class PhotoLinks {

    private String self;
    private String html;
    private String download;
    @SerializedName("download_location")
    private String downloadLocation;

    public String getSelf() {
        return self;
    }

    public String getHtml() {
        return html;
    }

    public String getDownload() {
        return download;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }
}
