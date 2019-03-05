package com.xuyao.rewrite;

import com.xuyao.utils.DataSourceUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRountingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceUtils.getDataSource();
    }
}
