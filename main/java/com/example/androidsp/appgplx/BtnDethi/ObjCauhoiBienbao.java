package com.example.androidsp.appgplx.BtnDethi;

import java.io.Serializable;

/**
 * Created by Cheng Lee on 10/27/2016.
 */

public class ObjCauhoiBienbao implements Serializable{
    public int idCauhoi, viTri;
    public String tenBienbao;

    public ObjCauhoiBienbao() {
    }

    public ObjCauhoiBienbao(int idCauhoi, int viTri, String tenBienbao) {
        this.idCauhoi = idCauhoi;
        this.viTri = viTri;
        this.tenBienbao = tenBienbao;
    }

    public int getIdCauhoi() {
        return idCauhoi;
    }

    public void setIdCauhoi(int idCauhoi) {
        this.idCauhoi = idCauhoi;
    }

    public int getViTri() {
        return viTri;
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    public String getTenBienbao() {
        return tenBienbao;
    }

    public void setTenBienbao(String tenBienbao) {
        this.tenBienbao = tenBienbao;
    }

}
