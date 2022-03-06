package com.uti.catatan.helper;

import android.content.Context;
import android.widget.Toast;

import com.uti.catatan.model.ModelKegiatan;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;


public class RealmHelper {

    private Context context;
    private Realm realm;
    private RealmResults<ModelKegiatan> realmResults;

    //logt
    private static final String TAG = "RealmHelper";

    public RealmHelper(Context context) {
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void inputDataAwal() {
        ModelKegiatan catatan = new ModelKegiatan();
        catatan.setId(1);
        catatan.setNama("Meeting");
        catatan.setAlamat("Meeting Kantor");

        realm.beginTransaction();
        realm.copyToRealm(catatan);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil ditambah", Toast.LENGTH_LONG).show();
    }

    public ArrayList<ModelKegiatan> tampilDataKegiatan() {
        ArrayList<ModelKegiatan> data = new ArrayList<>();
        realmResults = realm.where(ModelKegiatan.class).findAll();
        realmResults.sort("id", Sort.ASCENDING);

        if (realmResults.size() > 0) {

            for (int i = 0; i < realmResults.size(); i++) {
                ModelKegiatan catatan = new ModelKegiatan();
                catatan.setId(realmResults.get(i).getId());
                catatan.setNama(realmResults.get(i).getNama());
                catatan.setAlamat(realmResults.get(i).getAlamat());
                data.add(catatan);
            }
        }
        return data;
    }

    public void tambahCatatan(String nama, String kegiatan) {
        ModelKegiatan catatan = new ModelKegiatan();
        catatan.setId((int) (System.currentTimeMillis() / 1000));
        catatan.setNama(nama);
        catatan.setAlamat(kegiatan);

        realm.beginTransaction();
        realm.copyToRealm(catatan);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil ditambah", Toast.LENGTH_LONG).show();
    }

    public void updateCatatan(int id, String nama, String kegiatan) {
        realm.beginTransaction();
        ModelKegiatan catatan = realm.where(ModelKegiatan.class).equalTo("id", id).findFirst();
        catatan.setNama(nama);
        catatan.setAlamat(kegiatan);
        realm.copyToRealm(catatan);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil diupdate", Toast.LENGTH_LONG).show();
    }

    public void deleteCatatan(int id) {
        realm.beginTransaction();
        RealmResults<ModelKegiatan> catatan = realm.where(ModelKegiatan.class).equalTo("id", id).findAll();
        catatan.deleteAllFromRealm();
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_LONG).show();
    }

}
