package com.chengyi.android.util;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**通用的样式类
 * Created by administrator on 2016-12-19.
 */

public class CSS {
    public static class LayoutParams {
        public static RelativeLayout.LayoutParams wrapAll(){
            return new RelativeLayout.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        public static RelativeLayout.LayoutParams matchAll(){
            return new RelativeLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        public static RelativeLayout.LayoutParams wrapWidth(){
            return new RelativeLayout.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        public static RelativeLayout.LayoutParams wrapHeight(){
            return new RelativeLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }


}
