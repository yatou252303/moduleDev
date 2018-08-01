package com.component.dbdao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.component.model.db.CategoryEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "tbl_category".
*/
public class CategoryEntityDao extends AbstractDao<CategoryEntity, Long> {

    public static final String TABLENAME = "tbl_category";

    /**
     * Properties of entity CategoryEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Uid = new Property(1, String.class, "uid", false, "UID");
        public final static Property CId = new Property(2, int.class, "cId", false, "C_ID");
        public final static Property RId = new Property(3, int.class, "rId", false, "R_ID");
        public final static Property LocalData = new Property(4, int.class, "localData", false, "LOCAL_DATA");
        public final static Property CName = new Property(5, String.class, "cName", false, "C_NAME");
        public final static Property RName = new Property(6, String.class, "rName", false, "R_NAME");
        public final static Property AId = new Property(7, String.class, "aId", false, "A_ID");
        public final static Property CType = new Property(8, int.class, "cType", false, "C_TYPE");
        public final static Property Color = new Property(9, String.class, "color", false, "COLOR");
        public final static Property Icon = new Property(10, String.class, "icon", false, "ICON");
    }


    public CategoryEntityDao(DaoConfig config) {
        super(config);
    }
    
    public CategoryEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"tbl_category\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"UID\" TEXT," + // 1: uid
                "\"C_ID\" INTEGER NOT NULL ," + // 2: cId
                "\"R_ID\" INTEGER NOT NULL UNIQUE ," + // 3: rId
                "\"LOCAL_DATA\" INTEGER NOT NULL ," + // 4: localData
                "\"C_NAME\" TEXT," + // 5: cName
                "\"R_NAME\" TEXT," + // 6: rName
                "\"A_ID\" TEXT," + // 7: aId
                "\"C_TYPE\" INTEGER NOT NULL ," + // 8: cType
                "\"COLOR\" TEXT," + // 9: color
                "\"ICON\" TEXT);"); // 10: icon
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"tbl_category\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CategoryEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(2, uid);
        }
        stmt.bindLong(3, entity.getCId());
        stmt.bindLong(4, entity.getRId());
        stmt.bindLong(5, entity.getLocalData());
 
        String cName = entity.getCName();
        if (cName != null) {
            stmt.bindString(6, cName);
        }
 
        String rName = entity.getRName();
        if (rName != null) {
            stmt.bindString(7, rName);
        }
 
        String aId = entity.getAId();
        if (aId != null) {
            stmt.bindString(8, aId);
        }
        stmt.bindLong(9, entity.getCType());
 
        String color = entity.getColor();
        if (color != null) {
            stmt.bindString(10, color);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(11, icon);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CategoryEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(2, uid);
        }
        stmt.bindLong(3, entity.getCId());
        stmt.bindLong(4, entity.getRId());
        stmt.bindLong(5, entity.getLocalData());
 
        String cName = entity.getCName();
        if (cName != null) {
            stmt.bindString(6, cName);
        }
 
        String rName = entity.getRName();
        if (rName != null) {
            stmt.bindString(7, rName);
        }
 
        String aId = entity.getAId();
        if (aId != null) {
            stmt.bindString(8, aId);
        }
        stmt.bindLong(9, entity.getCType());
 
        String color = entity.getColor();
        if (color != null) {
            stmt.bindString(10, color);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(11, icon);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CategoryEntity readEntity(Cursor cursor, int offset) {
        CategoryEntity entity = new CategoryEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // uid
            cursor.getInt(offset + 2), // cId
            cursor.getInt(offset + 3), // rId
            cursor.getInt(offset + 4), // localData
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // cName
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // rName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // aId
            cursor.getInt(offset + 8), // cType
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // color
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // icon
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CategoryEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCId(cursor.getInt(offset + 2));
        entity.setRId(cursor.getInt(offset + 3));
        entity.setLocalData(cursor.getInt(offset + 4));
        entity.setCName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setAId(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCType(cursor.getInt(offset + 8));
        entity.setColor(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setIcon(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CategoryEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CategoryEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CategoryEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
