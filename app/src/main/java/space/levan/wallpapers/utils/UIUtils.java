package space.levan.wallpapers.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * @author WangZhiYao
 * @date 2019/12/9
 */
public class UIUtils {

    private UIUtils() {

    }

    public static int getScreenWidth(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        if (wm != null) {
            wm.getDefaultDisplay().getMetrics(dm);
        }

        return dm.widthPixels;
    }

    public static int getScreenHeight(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        if (wm != null) {
            wm.getDefaultDisplay().getMetrics(dm);
        }

        return dm.heightPixels;
    }

    public static int dp2px(Context context, int dpVal) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics()));
    }
}
