package com.erkuai.workview;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Administrator on 2019/10/16.
 */

public class Utils {
    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
