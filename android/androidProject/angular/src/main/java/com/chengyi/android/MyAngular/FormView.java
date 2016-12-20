package com.chengyi.android.MyAngular;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chengyi.android.angular.DataListener;
import com.chengyi.android.angular.R;
import com.chengyi.android.angular.ViewData;
import com.chengyi.android.angular.ViewParent;
import com.chengyi.android.angular.scope;

import java.util.List;
import java.util.Map;

/**
 * 表单元件
 * Data:[{
 *     name:'',
 *     code:'',
 *     type:'',//'checkBox',''
 *     data:object
 * },...]
 * params:"title-change"||"title-view"  修改模式||查看模式
 * Return:[{
 *     code:'',
 *     value:MapObject
 * }...]
 */

public class FormView extends ViewParent {
    //key值
    public static String name="name";
    public static String code="code";
    public static String type="type";
    public static String data="data";
    //key值
    private List<Map<String,Object>> list;
    public FormView(String Data, String params, String Return){
        super();
        setData(Data);
        setParams(params);
        setReturn(Return);
        init();
    }
    public FormView(Context context, AttributeSet attr) {
        super(context, attr);
        init();
    }

    @Override
    protected void init() {
        scope.watch(this.getData(), new DataListener<List<Map<String,Object>>>() {
            @Override
            public void hasChange(List<Map<String,Object>> items) {
                FormView.this.list=items;
               createViews();
            }
        });
        final ViewData textData=new ViewData();
        switch (FormView.this.getParams()){
            case "checkBox":
                final CheckBox checkBox=new CheckBox(scope.activity);
                checkBox.setClickable(false);
                FormView.this.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkBox.setChecked(!checkBox.isChecked());
                        FormView.this.setReturn(checkBox.isChecked());
                    }
                });
                FormView.this.addView(checkBox);
                TextView textView=new TextView(scope.activity);
                scope.bind(textView,textData);
                FormView.this.addView(textView);
                break;
            case "checkButton":
                Button button= new Button(scope.activity);

                scope.bind(button,textData);

                FormView.this.addView(button);
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textData.setCheck(!textData.isCheck());
                        FormView.this.setReturn(textData.isCheck());
                        if(textData.isCheck()){
                            v.setBackground(scope.activity.getResources().getDrawable(R.drawable.sharp_boder));
                        }else{
                            v.setBackground(scope.activity.getResources().getDrawable(R.drawable.none_bg));
                        }
                    }
                });
                break;
        }
        //FormView.this.addView(textView);
        scope.watch(this.getData(), new DataListener<String>() {
            @Override
            public void hasChange(String text ) {
                textData.setText(text);
            }
        });
    }
    protected void createViews(){

        for(int i=0;i<list.size();i++){

        }
        //this.addView();
    }

}
