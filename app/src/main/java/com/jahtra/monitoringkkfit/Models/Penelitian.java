package com.jahtra.monitoringkkfit.Models;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by bungkhus on 1/15/17.
 */

public class Penelitian {

    private String id;
    private String judul;
    private String tanggal;
    private Map<String, User> anggota;
    private float anggaran;
    private String lokasi;
    private String kodeDosen;
    private String ketuaKK;

    public Penelitian() {
    }

    public Penelitian(String id, String judul, String tanggal, Map<String, User> anggota, float anggaran, String lokasi, String kodeDosen, String ketuaKK) {
        this.id = id;
        this.judul = judul;
        this.tanggal = tanggal;
        this.anggota = anggota;
        this.anggaran = anggaran;
        this.lokasi = lokasi;
        this.kodeDosen = kodeDosen;
        this.ketuaKK = ketuaKK;
    }

    public Map<String, User> getAnggota() {
        return anggota;
    }

    public void setAnggota(Map<String, User> anggota) {
        this.anggota = anggota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public float getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(float anggaran) {
        this.anggaran = anggaran;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }

    public String getKetuaKK() {
        return ketuaKK;
    }

    public void setKetuaKK(String ketuaKK) {
        this.ketuaKK = ketuaKK;
    }
}
