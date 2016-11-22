package com.example.administrator.uupt_helpsend;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chengyi.Android.content.Scope;
import com.chengyi.Android.content.SysMethed;
import com.chengyi.Android.content.mvc.ViewContainer;
import com.chengyi.Android.content.mvc.data.CheckButtonData;
import com.chengyi.Android.content.mvc.data.CurWheelData;
import com.chengyi.Android.content.mvc.data.DataModle;
import com.chengyi.Android.content.mvc.data.ListCheckButtonData;
import com.chengyi.Android.content.mvc.data.ViewData;
import com.chengyi.Android.content.mvc.view.CurWheelView;
import com.chengyi.Android.content.mvc.view.ViewParent;
import com.chengyi.Android.libraryUI.WindowPop;
import com.chengyi.Android.util.PubInterface;
import com.chengyi.Android.util.entity.TreeEntity;
import com.example.administrator.uupt_helpsend.util.GetView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.example.administrator.uupt_helpsend.R.id.choose_incubator;
import static com.example.administrator.uupt_helpsend.R.id.safe_money;


public class HelpSendActivity extends Activity {
    private ViewData fhd= new ViewData();
    private ViewData shd= new ViewData();
    private ViewData fhr= new ViewData();
    private ViewData shr= new ViewData();
    private ViewData safe_moneyCheck= new ViewData();
    private ViewData safe_moneyText= new ViewData();
    private ViewData choose_incubatorCheck= new ViewData();
    private ViewData daikuan= new ViewData();
    private ViewData telData;
    private WindowPop windowPop;
    private String popTitle=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpsend);
        Scope.init(this);
        Scope.bind(R.id.fhd,fhd);
        Scope.bind(R.id.shd,shd);
        Scope.bind(R.id.fhr,fhr);
        Scope.bind(R.id.shr,shr);
        Scope.bind(R.id.safe_moneyCheck,safe_moneyCheck);
        Scope.bind(R.id.safe_moneyText,safe_moneyText);
        Scope.bind(R.id.choose_incubatorCheck,choose_incubatorCheck);
        Scope.bind(R.id.daikuanshow,daikuan);
        daikuan.setShow(false);
    }
    //点击EditText文本框之外任何地方隐藏键盘的解决办法
    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        return SysMethed.dispatchTouchEvent(ev,new PubInterface(){
            @Override
            public Object run(){
                return HelpSendActivity.super.dispatchTouchEvent(ev);
            }
        });
    }

    public void showPop(Class<?> clazz,View.OnClickListener listener) {

         windowPop= new WindowPop(R.layout.take_photo_pop);
        ((ViewContainer)windowPop.getContentView().findViewById(R.id.vc01))
                .bind(clazz,"vc01");
        windowPop.getContentView().findViewById(R.id.sure).setOnClickListener(listener);
        ViewData viewTitle=new ViewData();
        Scope.bind(windowPop.getContentView().findViewById(R.id.timezone_title),viewTitle);
        viewTitle.setText(this.popTitle);
    }
    public void popCancel(View v){
        windowPop.cancelClick();
    }

    public void thisClick(View view) {
        PubInterface run;
        switch (view.getId()) {
            case R.id.returnAction:
                new AlertDialog.Builder(this)
                        .setTitle("无其他action")
                        .setMessage("无其他action")
                        .setPositiveButton("是", null)
                        .setNegativeButton("否", null)
                        .show();
                break;
            case R.id.fhd:
                fhd.setText("无信息");

            case R.id.shd:
                shd.setText("无信息");
                new AlertDialog.Builder(this)
                        .setTitle("请调用地图")
                        .setMessage("无信息")
                        .setPositiveButton("是", null)
                        .setNegativeButton("否", null)
                        .show();
                break;
            case R.id.fhr:
                telData=fhr;
                opentxl(view);
                break;
            case R.id.shr:
                telData=shr;
                opentxl(view);
                break;
            case R.id.wplx:this.popTitle="物品类型";
                List<CheckButtonData> list=new ArrayList<CheckButtonData>();
                String[] wplxs={"普通","其他","美食","文件","易碎","洗衣","手机","蛋糕","鲜花","贵重物品","跨城订单","钥匙"};
                for (int i = 0; i < wplxs.length; i++) {
                    CheckButtonData checkButtonData= new CheckButtonData(false,wplxs[i]);
                    list.add(checkButtonData);
                }
                Scope.put("vc01",  new ListCheckButtonData(list));
                showPop(ViewParent.class,new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),((DataModle)Scope.get("vc01")).getReturnData().size()+"--",Toast.LENGTH_SHORT).show();
                        popCancel(null);
                    }
                });
                break;
            case R.id.daikuan:
                view.setSelected(!view.isSelected());
               daikuan.setShow(!daikuan.getShow());
                break;
            case safe_money:
                this.popTitle="选择保价";
                TreeEntity tree=new TreeEntity();
                tree.setLevel(0);
                Map<String,String> map=new LinkedHashMap<String, String>();
                map.put("不保价","若商品出现损坏，最高可获得30元优惠券赔付");
                map.put("投保3元","添加保价3元，最高可赔付300");
                map.put("投保5元","添加保价5元，最高可赔付500");
                int id=0;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    TreeEntity treeEntity1=new TreeEntity();
                    treeEntity1.setLevel(1);
                    treeEntity1.setId(id+"");id++;
                    treeEntity1.setName(entry.getKey());
                    LinearLayout layout=SysMethed.getWrapLinearLayout();
                    TextView textView1=GetView.getTextView(entry.getKey());
                    TextView textView2=GetView.getTextView(entry.getValue());;
                   layout.addView(textView1);  layout.addView(textView2);
                    treeEntity1.setContent(layout);
                    tree.addChildren(treeEntity1);
                }

                Scope.put("vc01",  new CurWheelData(tree,5));
                showPop(CurWheelView.class,new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),((TreeEntity)((DataModle)Scope.get("vc01")).getReturnData().get(0)).getId(),Toast.LENGTH_SHORT).show();
                      TreeEntity treeEntity=(TreeEntity)((DataModle)Scope.get("vc01")).getReturnData().get(0);
                       if(treeEntity.getId().equalsIgnoreCase("0")){
                           safe_moneyCheck.setCheck(false);
                           safe_moneyText.setText("保价");
                       }else{
                           safe_moneyCheck.setCheck(true);
                           safe_moneyText.setText(treeEntity.getName());
                       }
                        popCancel(null);
                    }
                });
                break;
            case choose_incubator:
                view.setSelected(!view.isSelected());
                break;
            case R.id.ljfh:this.popTitle="选择发货时间";
                TreeEntity treeEntity=new TreeEntity();
                int level=0;
                treeEntity.setLevel(level);
                String[] day={"今天","明天"};
                String[] hour={"立即发货"};
                String[] min={};
                for (int i = 0; i < day.length; i++) {
                    TreeEntity treeEntity1=new TreeEntity();
                    treeEntity1.setLevel(level+1);
                    String string=i+"_level1";
                    treeEntity1.setName(string);
                    treeEntity1.setId(string);
                    treeEntity1.setContent(GetView.getTextView(day[i]));
                    int mHour=0;int ehour=19;
                    if(i==0){
                        long time=System.currentTimeMillis();
                    final Calendar mCalendar=Calendar.getInstance();
                    mCalendar.setTimeInMillis(time);
                        mHour=mCalendar.get(Calendar.HOUR_OF_DAY)+1;
                        ehour=24;
                    }
                    int jj=0;
                    for (int j = mHour; j < ehour; j++) {
                        TreeEntity treeEntity2=new TreeEntity();
                        treeEntity2.setLevel(level+2);
                        string=j+"点";
                        if(i==0&&jj==0){
                            string="立即发货";
                            j--;
                        }
                        treeEntity2.setName(string);
                        treeEntity2.setId(string);
                        treeEntity2.setContent(GetView.getTextView(string));
                        if(jj+i==0){
                            TreeEntity treeEntity3=new TreeEntity();
                            treeEntity3.setLevel(level+3);
                            treeEntity3.setContent(GetView.getTextView(""));
                            treeEntity2.addChildren(treeEntity3);
                            jj++;
                        } else for (int k = 5; k <= 55; k+=5) {
                                TreeEntity treeEntity3=new TreeEntity();
                                treeEntity3.setLevel(level+3);
                                string=k+"分";
                                treeEntity3.setName(string);
                                treeEntity3.setId(string);
                                treeEntity3.setContent(GetView.getTextView(string));
                                treeEntity2.addChildren(treeEntity3);

                            }

                        treeEntity1.addChildren(treeEntity2);

                    }
                    treeEntity.addChildren(treeEntity1);
                }
                Scope.put("vc01",  new CurWheelData(treeEntity,10));

                showPop(CurWheelView.class,new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),((TreeEntity)((DataModle)Scope.get("vc01")).getReturnData().get(0)).getName()+"--",Toast.LENGTH_SHORT).show();
                        popCancel(null);
                    }
                });
                break;
            case R.id.intent_action:

                break;
        }
    }

    public void opentxl(View v){
        startActivityForResult(new Intent(
                Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String username,usernumber;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            ContentResolver reContentResolverol = getContentResolver();
            Uri contactData = data.getData();
            @SuppressWarnings("deprecation")
            Cursor cursor = managedQuery(contactData, null, null, null, null);
            cursor.moveToFirst();
            username = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = reContentResolverol.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                    null,
                    null);
            while (phone.moveToNext()) {
                usernumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                telData.setText(usernumber+" ("+username+")");
            }

        }
    }

}
