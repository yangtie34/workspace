package com.chengyi.Android.content.mvc.view;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.libraryUI.R;

import java.util.ArrayList;
import java.util.List;

import static com.chengyi.Android.content.CurrentActivity.activity;

/**
 * Created by Administrator on 2016/10/26.
 */

public class RepeatView extends ViewParent {
    private ScrollView scrollView;
    private LinearLayout linearLayout;
    private ViewGroup listView;
    private int orientation;
    private List<View> items=new ArrayList<>();
    private  AdapterView.OnItemClickListener onItemClickListener;
    public RepeatView(){
        repeatView(LinearLayout.HORIZONTAL);
    }
    /**
     * LinearLayout.VERTICAL,LinearLayout.HORIZONTAL
     * @param orientation
     */
    private void repeatView(int orientation){
        this.orientation=orientation;
        listView=new GridView(activity);
        int[] params={ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT};
        if(orientation==LinearLayout.VERTICAL){
            params[0]=ViewGroup.LayoutParams.MATCH_PARENT;
            params[1]=ViewGroup.LayoutParams.WRAP_CONTENT;
            listView=new ListView(activity);
        }
         scrollView = new ScrollView(activity);
        LinearLayout.LayoutParams relLayoutParams=new LinearLayout.LayoutParams
                (params[0],params[1],1);
        scrollView.setLayoutParams(relLayoutParams);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setHorizontalScrollBarEnabled(false);

        linearLayout= new LinearLayout(activity);
        linearLayout.setLayoutParams(relLayoutParams);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.setOrientation(orientation);


        listView.setBackground(CurrentActivity.activity.getResources().getDrawable(R.drawable.sharp_boder));
       /* relLayoutParams=new LinearLayout.LayoutParams
                (params[1],params[1],1);
        listView.setLayoutParams(relLayoutParams);*/
        this.linearLayout.addView(listView);
        this.scrollView.addView(linearLayout);
        this.getView().addView(scrollView);
    }
    public void itemClick(int index){
        onItemClickListener.onItemClick(null,null,index,0);
    }
    public void init(final List<View> items){
        if(items.size()==0)return;
        this.items=items;
        listView.setMinimumHeight(5);
        if(orientation==LinearLayout.VERTICAL){
            ((ListView)listView).setAdapter(new MyAdapter());
        }else{
            ((GridView)listView).setAdapter(new MyAdapter());
            ((GridView)listView).setNumColumns(5);
        }

        this.pushReturnData(0);

         onItemClickListener=new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                items.get((Integer) RepeatView.this.getDataModle().getReturnData().get(0)).setBackground(null);
                items.get(position).setBackground(CurrentActivity.activity.getResources().getDrawable(R.drawable.sharp_boder));
                RepeatView.this.clearReturnData();
                RepeatView.this.pushReturnData(position);
            }
        };
        if(orientation==LinearLayout.VERTICAL){
            ((ListView)listView).setOnItemClickListener(onItemClickListener);
        }else{
            ((GridView)listView).setOnItemClickListener(onItemClickListener);
        }
        onItemClickListener.onItemClick(null,null,0,0);
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return items.get(position);
        }

    }
}
