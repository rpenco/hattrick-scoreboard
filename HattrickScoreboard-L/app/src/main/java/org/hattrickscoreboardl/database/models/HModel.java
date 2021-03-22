package org.hattrickscoreboardl.database.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HModel extends SugarRecord<HModel> {

    public static <T extends SugarRecord<?>> T findOne(Class<T> cls, String whereClause, String... args){
        List<T> list = find(cls, whereClause, args);
        return (list.size() == 0)? null : list.get(0);
    }
}

