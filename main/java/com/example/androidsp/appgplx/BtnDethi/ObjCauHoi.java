package com.example.androidsp.appgplx.BtnDethi;

/**
 * Created by Androidsp on 22/12/2016.
 */

public class ObjCauHoi {
    public String noidung, dapAn1, dapAn2, dapAn3, dapAn4, tenAnh;
    public int idCauhoi, dapandung, idLoaicauhoi;
    private boolean kiemtra= false;

    public ObjCauHoi() {
    }

    public ObjCauHoi(String dapAn1, String dapAn2, String dapAn3, String dapAn4, int dapandung, int idCauhoi, int idLoaicauhoi, String noidung, String tenAnh) {
        this.dapAn1 = dapAn1;
        this.dapAn2 = dapAn2;
        this.dapAn3 = dapAn3;
        this.dapAn4 = dapAn4;
        this.dapandung = dapandung;
        this.idCauhoi = idCauhoi;
        this.idLoaicauhoi = idLoaicauhoi;
        this.noidung = noidung;
        this.tenAnh = tenAnh;
    }

    public boolean isKiemtra() {
        return kiemtra;
    }

    public void setKiemtra(boolean kiemtra) {
        this.kiemtra = kiemtra;
    }

    public String getDapAn1() {
        return dapAn1;
    }

    public void setDapAn1(String dapAn1) {
        this.dapAn1 = dapAn1;
    }

    public String getDapAn2() {
        return dapAn2;
    }

    public void setDapAn2(String dapAn2) {
        this.dapAn2 = dapAn2;
    }

    public String getDapAn3() {
        return dapAn3;
    }

    public void setDapAn3(String dapAn3) {
        this.dapAn3 = dapAn3;
    }

    public String getDapAn4() {
        return dapAn4;
    }

    public void setDapAn4(String dapAn4) {
        this.dapAn4 = dapAn4;
    }

    public int getDapandung() {
        return dapandung;
    }

    public void setDapandung(int dapandung) {
        this.dapandung = dapandung;
    }

    public int getIdCauhoi() {
        return idCauhoi;
    }

    public void setIdCauhoi(int idCauhoi) {
        this.idCauhoi = idCauhoi;
    }

    public int getIdLoaicauhoi() {
        return idLoaicauhoi;
    }

    public void setIdLoaicauhoi(int idLoaicauhoi) {
        this.idLoaicauhoi = idLoaicauhoi;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    @Override
    public String toString() {
        return "ObjCauHoi{" +
                "dapAn1='" + dapAn1 + '\'' +
                ", noidung='" + noidung + '\'' +
                ", dapAn2='" + dapAn2 + '\'' +
                ", dapAn3='" + dapAn3 + '\'' +
                ", dapAn4='" + dapAn4 + '\'' +
                ", tenAnh='" + tenAnh + '\'' +
                ", idCauhoi=" + idCauhoi +
                ", dapandung=" + dapandung +
                ", idLoaicauhoi=" + idLoaicauhoi +
                ", kiemtra=" + kiemtra +
                '}';
    }
}
