package com.example.androidsp.appgplx.BtnBienBao;

/**
 * Created by Androidsp on 23/12/2016.
 */

public class ObjBienbao {
    public String tenBienbao, moTa;
    public int linkanh;


    public ObjBienbao() {
    }

    public ObjBienbao(int linkanh, String tenBienbao,String moTa ) {
        this.linkanh = linkanh;
        this.tenBienbao = tenBienbao;
        this.moTa = moTa;

    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenBienbao() {
        return tenBienbao;
    }

    public void setTenBienbao(String tenBienbao) {
        this.tenBienbao = tenBienbao;
    }

    public int getLinkanh() {
        return linkanh;
    }

    public void setLinkanh(int linkanh) {
        this.linkanh = linkanh;
    }
}
