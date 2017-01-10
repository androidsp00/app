package com.example.androidsp.appgplx.BtnDethi;

/**
 * Created by Androidsp on 23/12/2016.
 */

public class ObjDapAnChon {
    private int idCauhoi;
    private String DapAn;

    public ObjDapAnChon() {
    }

    public ObjDapAnChon(int idCauhoi, String dapAn) {
        this.idCauhoi = idCauhoi;
        DapAn = dapAn;
    }

    public int getIdCauhoi() {
        return idCauhoi;
    }

    public void setIdCauhoi(int idCauhoi) {
        this.idCauhoi = idCauhoi;
    }

    public String getDapAn() {
        return DapAn;
    }

    public void setDapAn(String dapAn) {
        DapAn = dapAn;
    }
}
