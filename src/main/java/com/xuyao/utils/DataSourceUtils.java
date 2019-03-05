package com.xuyao.utils;

public class DataSourceUtils {

    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    public static void setDataSource(String dataSource) {
        dataSources.set(dataSource);
    }

    public static String getDataSource() {
        return dataSources.get();
    }

}