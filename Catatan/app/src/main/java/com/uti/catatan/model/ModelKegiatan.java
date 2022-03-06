package com.uti.catatan.model;

import io.realm.RealmObject;


public class ModelKegiatan extends RealmObject {
    private int id;
    private String nama;
    private String kegiatan;

    public ModelKegiatan(int id, String nama, String kegiatan) {
        this.id = id;
        this.nama = nama;
        this.kegiatan = kegiatan;
    }

    public ModelKegiatan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return kegiatan;
    }

    public void setAlamat(String alamat) {
        this.kegiatan = alamat;
    }
}
