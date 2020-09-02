package com.ucx.training.dbdemo.util;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TupleHelper {
    public static List<Map<String, Object>> toList(List<Tuple> results) {
        List<Map<String, Object>> data = new ArrayList<>();

        if (results != null && results.size() > 0) {
            for (Tuple tuple : results) {
                data.add(toMap(tuple));
            }
        }
        return data;
    }

    public static Map<String, Object> toMap(Tuple tuple) {
        Map<String, Object> item = new HashMap<>();
        List<TupleElement<?>> columns = tuple.getElements();
        for (TupleElement column : columns) item.put(column.getAlias(), tuple.get(column.getAlias()));
        return item;
    }
}
