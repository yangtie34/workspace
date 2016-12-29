package com.chengyi.android.util;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chengyi.android.angular.R;

/**通用的样式类
 * Created by administrator on 2016-12-19.
 */

public class CSS {
    /**
     * 样式
     */
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

    /**
     * 效果
     */
    public static class effect{
        /**
         * 动画
         */
        public static class Animation{
            public static int byAlpha(){
                return R.style.animByAlpha;
            }
            public static int formBottom(){
                return R.style.animFormBottom;
            }
            public static int formTop(){
                return R.style.animFormTop;
            }

        }

    }

}
