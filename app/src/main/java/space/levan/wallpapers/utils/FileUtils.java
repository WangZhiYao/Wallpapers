package space.levan.wallpapers.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * @author WangZhiYao
 * @date 2019/12/10
 */
public class FileUtils {

    public static File getPrivateFileDir(Context context) {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                && context.getExternalFilesDir(null) != null
                ? context.getExternalFilesDir(null) : context.getFilesDir();
    }

    public static File getPrivateCacheDir(Context context) {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                && context.getExternalCacheDir() != null
                ? context.getExternalCacheDir() : context.getCacheDir();
    }
}
