package com.example.androidsp.appgplx.BtnBienBao;

import java.io.Serializable;

/**
 * Created by Androidsp on 23/12/2016.
 */

public class ObjLoaibienbao implements Serializable {
    public int idLoaibienbao;
    public String tenLoaibienbao;

    public ObjLoaibienbao() {
    }

    public ObjLoaibienbao(int idLoaibienbao, String tenLoaibienbao) {
        this.idLoaibienbao = idLoaibienbao;
        this.tenLoaibienbao = tenLoaibienbao;
    }

    public int getIdLoaibienbao() {
        return idLoaibienbao;
    }

    public void setIdLoaibienbao(int idLoaibienbao) {
        this.idLoaibienbao = idLoaibienbao;
    }

    public String getTenLoaibienbao() {
        return tenLoaibienbao;
    }

    public void setTenLoaibienbao(String tenLoaibienbao) {
        this.tenLoaibienbao = tenLoaibienbao;
    }
}
