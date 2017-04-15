package com.yiyun.chengyi.eyun_db_lib.util;

/**
 * Created by administrator on 2016-11-4.
 */
public interface DataListener<T> {

    public void hasChange(T t);
}
