package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_uti_catatan_model_ModelKegiatanRealmProxy extends com.uti.catatan.model.ModelKegiatan
    implements RealmObjectProxy, com_uti_catatan_model_ModelKegiatanRealmProxyInterface {

    static final class ModelKegiatanColumnInfo extends ColumnInfo {
        long idIndex;
        long namaIndex;
        long kegiatanIndex;

        ModelKegiatanColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ModelKegiatan");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.namaIndex = addColumnDetails("nama", "nama", objectSchemaInfo);
            this.kegiatanIndex = addColumnDetails("kegiatan", "kegiatan", objectSchemaInfo);
        }

        ModelKegiatanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ModelKegiatanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ModelKegiatanColumnInfo src = (ModelKegiatanColumnInfo) rawSrc;
            final ModelKegiatanColumnInfo dst = (ModelKegiatanColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.namaIndex = src.namaIndex;
            dst.kegiatanIndex = src.kegiatanIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ModelKegiatanColumnInfo columnInfo;
    private ProxyState<com.uti.catatan.model.ModelKegiatan> proxyState;

    com_uti_catatan_model_ModelKegiatanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ModelKegiatanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.uti.catatan.model.ModelKegiatan>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nama() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.namaIndex);
    }

    @Override
    public void realmSet$nama(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.namaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.namaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.namaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.namaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$kegiatan() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.kegiatanIndex);
    }

    @Override
    public void realmSet$kegiatan(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.kegiatanIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.kegiatanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.kegiatanIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.kegiatanIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ModelKegiatan", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nama", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("kegiatan", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ModelKegiatanColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ModelKegiatanColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ModelKegiatan";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ModelKegiatan";
    }

    @SuppressWarnings("cast")
    public static com.uti.catatan.model.ModelKegiatan createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.uti.catatan.model.ModelKegiatan obj = realm.createObjectInternal(com.uti.catatan.model.ModelKegiatan.class, true, excludeFields);

        final com_uti_catatan_model_ModelKegiatanRealmProxyInterface objProxy = (com_uti_catatan_model_ModelKegiatanRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("nama")) {
            if (json.isNull("nama")) {
                objProxy.realmSet$nama(null);
            } else {
                objProxy.realmSet$nama((String) json.getString("nama"));
            }
        }
        if (json.has("kegiatan")) {
            if (json.isNull("kegiatan")) {
                objProxy.realmSet$kegiatan(null);
            } else {
                objProxy.realmSet$kegiatan((String) json.getString("kegiatan"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.uti.catatan.model.ModelKegiatan createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.uti.catatan.model.ModelKegiatan obj = new com.uti.catatan.model.ModelKegiatan();
        final com_uti_catatan_model_ModelKegiatanRealmProxyInterface objProxy = (com_uti_catatan_model_ModelKegiatanRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
            } else if (name.equals("nama")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nama((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nama(null);
                }
            } else if (name.equals("kegiatan")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$kegiatan((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$kegiatan(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.uti.catatan.model.ModelKegiatan copyOrUpdate(Realm realm, com.uti.catatan.model.ModelKegiatan object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.uti.catatan.model.ModelKegiatan) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.uti.catatan.model.ModelKegiatan copy(Realm realm, com.uti.catatan.model.ModelKegiatan newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.uti.catatan.model.ModelKegiatan) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.uti.catatan.model.ModelKegiatan realmObject = realm.createObjectInternal(com.uti.catatan.model.ModelKegiatan.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_uti_catatan_model_ModelKegiatanRealmProxyInterface realmObjectSource = (com_uti_catatan_model_ModelKegiatanRealmProxyInterface) newObject;
        com_uti_catatan_model_ModelKegiatanRealmProxyInterface realmObjectCopy = (com_uti_catatan_model_ModelKegiatanRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$nama(realmObjectSource.realmGet$nama());
        realmObjectCopy.realmSet$kegiatan(realmObjectSource.realmGet$kegiatan());
        return realmObject;
    }

    public static long insert(Realm realm, com.uti.catatan.model.ModelKegiatan object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.uti.catatan.model.ModelKegiatan.class);
        long tableNativePtr = table.getNativePtr();
        ModelKegiatanColumnInfo columnInfo = (ModelKegiatanColumnInfo) realm.getSchema().getColumnInfo(com.uti.catatan.model.ModelKegiatan.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$id(), false);
        String realmGet$nama = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$nama();
        if (realmGet$nama != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
        }
        String realmGet$kegiatan = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$kegiatan();
        if (realmGet$kegiatan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.kegiatanIndex, rowIndex, realmGet$kegiatan, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.uti.catatan.model.ModelKegiatan.class);
        long tableNativePtr = table.getNativePtr();
        ModelKegiatanColumnInfo columnInfo = (ModelKegiatanColumnInfo) realm.getSchema().getColumnInfo(com.uti.catatan.model.ModelKegiatan.class);
        com.uti.catatan.model.ModelKegiatan object = null;
        while (objects.hasNext()) {
            object = (com.uti.catatan.model.ModelKegiatan) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$id(), false);
            String realmGet$nama = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$nama();
            if (realmGet$nama != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
            }
            String realmGet$kegiatan = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$kegiatan();
            if (realmGet$kegiatan != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.kegiatanIndex, rowIndex, realmGet$kegiatan, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.uti.catatan.model.ModelKegiatan object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.uti.catatan.model.ModelKegiatan.class);
        long tableNativePtr = table.getNativePtr();
        ModelKegiatanColumnInfo columnInfo = (ModelKegiatanColumnInfo) realm.getSchema().getColumnInfo(com.uti.catatan.model.ModelKegiatan.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$id(), false);
        String realmGet$nama = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$nama();
        if (realmGet$nama != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.namaIndex, rowIndex, false);
        }
        String realmGet$kegiatan = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$kegiatan();
        if (realmGet$kegiatan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.kegiatanIndex, rowIndex, realmGet$kegiatan, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.kegiatanIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.uti.catatan.model.ModelKegiatan.class);
        long tableNativePtr = table.getNativePtr();
        ModelKegiatanColumnInfo columnInfo = (ModelKegiatanColumnInfo) realm.getSchema().getColumnInfo(com.uti.catatan.model.ModelKegiatan.class);
        com.uti.catatan.model.ModelKegiatan object = null;
        while (objects.hasNext()) {
            object = (com.uti.catatan.model.ModelKegiatan) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$id(), false);
            String realmGet$nama = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$nama();
            if (realmGet$nama != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.namaIndex, rowIndex, false);
            }
            String realmGet$kegiatan = ((com_uti_catatan_model_ModelKegiatanRealmProxyInterface) object).realmGet$kegiatan();
            if (realmGet$kegiatan != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.kegiatanIndex, rowIndex, realmGet$kegiatan, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.kegiatanIndex, rowIndex, false);
            }
        }
    }

    public static com.uti.catatan.model.ModelKegiatan createDetachedCopy(com.uti.catatan.model.ModelKegiatan realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.uti.catatan.model.ModelKegiatan unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.uti.catatan.model.ModelKegiatan();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.uti.catatan.model.ModelKegiatan) cachedObject.object;
            }
            unmanagedObject = (com.uti.catatan.model.ModelKegiatan) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_uti_catatan_model_ModelKegiatanRealmProxyInterface unmanagedCopy = (com_uti_catatan_model_ModelKegiatanRealmProxyInterface) unmanagedObject;
        com_uti_catatan_model_ModelKegiatanRealmProxyInterface realmSource = (com_uti_catatan_model_ModelKegiatanRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nama(realmSource.realmGet$nama());
        unmanagedCopy.realmSet$kegiatan(realmSource.realmGet$kegiatan());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ModelKegiatan = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nama:");
        stringBuilder.append(realmGet$nama() != null ? realmGet$nama() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{kegiatan:");
        stringBuilder.append(realmGet$kegiatan() != null ? realmGet$kegiatan() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_uti_catatan_model_ModelKegiatanRealmProxy aModelKegiatan = (com_uti_catatan_model_ModelKegiatanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aModelKegiatan.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aModelKegiatan.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aModelKegiatan.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
