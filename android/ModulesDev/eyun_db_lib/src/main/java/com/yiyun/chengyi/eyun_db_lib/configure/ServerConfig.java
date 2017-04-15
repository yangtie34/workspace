package com.yiyun.chengyi.eyun_db_lib.configure;

/**
 * Created by Administrator on 2017/2/20.
 */

public final class ServerConfig {


    //---------数据源相关驱动------------
    public static class JDBC {
        public static final String driverName = "net.sourceforge.jtds.jdbc.Driver";//"com.microsoft.sqlserver.jdbc.SQLServerDriver";//"oracle.jdbc.driver.OracleDriver";
        public static  String ipAndPort="192.168.56.248:1533";
        public static  String orcl="JYun_Bang_Storage_Test";
        public static  String url = "jdbc:jtds:sqlserver://"+ipAndPort+"/"+orcl;//"jdbc:sqlserver://192.168.56.248:1533;DatabaseName=HuaChi_Test";//"jdbc:oracle:thin:@ 202.196.0.180:1521:DM";
        public static  String user = "jyun_bang_storage";
        public static  String password = "jyun_bang_storage_20170215";
        //验证数据库连接是否健康
        public static final String validationQuery = "select getdate()";//"select sysdate from dual";
        //最小连接数
        public static final int minPool = 1;
        //单次增加连接数的数量
        public static final int upPool = 5;
        //最大连接数
        public static final int maxPool = 100;
    }
    //---------数据源相关驱动------------
}
