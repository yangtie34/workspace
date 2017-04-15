package com.yiyun.chengyi.eyun_db_lib;


import org.json.JSONObject;
import com.uzmap.pkg.uzcore.UZWebView;
import com.uzmap.pkg.uzcore.uzmodule.UZModule;
import com.uzmap.pkg.uzcore.uzmodule.UZModuleContext;
import com.yiyun.chengyi.eyun_db_lib.configure.ServerConfig;
import com.yiyun.chengyi.eyun_db_lib.jdbcUtil.BaseDao;
import com.yiyun.chengyi.eyun_db_lib.jdbcUtil.DBManager;
import com.yiyun.chengyi.eyun_db_lib.util.PreferenceUtils;
import com.yiyun.chengyi.eyun_db_lib.util.Scope;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.Map;



/**
 * Created by Administrator on 2017/3/9.
 */

public class BaseDaoAPI extends UZModule {
    private Scope scope;
    public BaseDaoAPI(UZWebView webView) {
        super(webView);
        scope=new Scope();
        scope.activity=mContext;
    }
    public void jsmethod_query(final UZModuleContext moduleContext){
        final String sql = moduleContext.optString("sql");
                List<Map<String,Object>> list= BaseDao.getInstance().queryForList(sql);
                JSONObject ja = new JSONObject();
                try {
                    ja.put("list",list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                moduleContext.success(ja,true);
    }
    public void jsmethod_queryByParams(final UZModuleContext moduleContext){
        final String sql = moduleContext.optString("sql");
        JSONArray jparams = moduleContext.optJSONArray("params");
        final Object[] params=new Object[jparams.length()];
        for (int i=0;i<jparams.length();i++){
            try {
                params[i]=jparams.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
                List<Map<String,Object>> list= BaseDao.getInstance().queryForList(sql,params);
                JSONObject ja = new JSONObject();
                try {
                    ja.put("list",list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                moduleContext.success(ja,true);
    }
    public void jsmethod_excute(final UZModuleContext moduleContext){
        final String sql = moduleContext.optString("sql");
                boolean bool= BaseDao.getInstance().excute(sql);
                JSONObject ja = new JSONObject();
        try {
            ja.put("isTrue",bool);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        moduleContext.success(ja,true);
    }
    public  void  initUrl(){
        ServerConfig.JDBC.url = "jdbc:jtds:sqlserver://"+ServerConfig.JDBC.ipAndPort+"/"+ServerConfig.JDBC.orcl;
    };
    public  void jsmethod_initDBConfig(UZModuleContext moduleContext){
        ServerConfig.JDBC.ipAndPort= PreferenceUtils.getPrefString("db_ipAndPort", ServerConfig.JDBC.ipAndPort);
        ServerConfig.JDBC.orcl=PreferenceUtils.getPrefString("db_orcl", ServerConfig.JDBC.orcl);
        initUrl();
        ServerConfig.JDBC.user=PreferenceUtils.getPrefString("db_user", ServerConfig.JDBC.user);
        ServerConfig.JDBC.password=PreferenceUtils.getPrefString("db_password", ServerConfig.JDBC.password);
        DBManager.reStart();
    }
    public void jsmethod_checkDB(final UZModuleContext moduleContext){
        Boolean bool=DBManager.checkConnection();
                JSONObject ja = new JSONObject();
                try {
                    ja.put("isTrue",bool);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                moduleContext.success(ja,true);
    }
    public void jsmethod_configDB(final UZModuleContext moduleContext){
        String ipAndPort=moduleContext.optString("ipAndPort");
        String orcl=moduleContext.optString("orcl");
        String user=moduleContext.optString("user");
        String password=moduleContext.optString("password");
        ServerConfig.JDBC.ipAndPort=ipAndPort;
        ServerConfig.JDBC.orcl=orcl;
        initUrl();
        ServerConfig.JDBC.user=user;
        ServerConfig.JDBC.password=password;
        DBManager.reStart();
        JSONObject ja = new JSONObject();
        try {
            ja.put("isTrue",true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        moduleContext.success(ja,true);
    }
}
