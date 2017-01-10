package com.example.androidsp.appgplx.BtnOntap_Lythuyet;

import java.util.ArrayList;

/**
 * Created by Androidsp on 25/12/2016.
 */

public class CauhoilythuyetObj extends ArrayList<CauhoilythuyetObj> {
    public String noidung, dapAn1, dapAn2, dapAn3, dapAn4, tenAnh;
    public int idCauhoi;
    public long dapandung, idLoaicauhoi;

    public CauhoilythuyetObj() {
    }

    public CauhoilythuyetObj(String dapAn1, String dapAn2, String dapAn3, String dapAn4, long dapandung, int idCauhoi, long idLoaicauhoi, String noidung, String tenAnh) {
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

    public long getDapandung() {
        return dapandung;
    }

    public void setDapandung(long dapandung) {
        this.dapandung = dapandung;
    }

    public int getIdCauhoi() {
        return idCauhoi;
    }

    public void setIdCauhoi(int idCauhoi) {
        this.idCauhoi = idCauhoi;
    }

    public long getIdLoaicauhoi() {
        return idLoaicauhoi;
    }

    public void setIdLoaicauhoi(long idLoaicauhoi) {
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
}
