package com.example.androidsp.appgplx.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.androidsp.appgplx.BtnBienBao.BtnBienBaoActivity;
import com.example.androidsp.appgplx.BtnDethi.Giaodien_Dethi_Activity;
import com.example.androidsp.appgplx.BtnDethi.ObjCauHoi;
import com.example.androidsp.appgplx.BtnOntap_Lythuyet.Ontap_Lythuyet_Activity;
import com.example.androidsp.appgplx.Btn_MeoGhiNho.Btn_MeoGhiNho_Activity;
import com.example.androidsp.appgplx.R;
import com.example.androidsp.appgplx.data.MyData;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDeThi, btnOntap_LyThuyet,btnOnTap_BienBao, btnMeoGhiNho;
    Intent intent;
    Random rd = new Random();
    private ArrayList<ObjCauHoi> mangcauhoi = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       MyData.getData();

        btnDeThi = (Button) findViewById(R.id.btnDeThi);
        btnOntap_LyThuyet = (Button) findViewById(R.id.btnOntap_LyThuyet);
        btnOnTap_BienBao = (Button) findViewById(R.id.btnOnTap_BienBao);
        btnMeoGhiNho = (Button) findViewById(R.id.btnMeoGhiNho);


        btnDeThi.setOnClickListener(this);
        btnOntap_LyThuyet.setOnClickListener(this);
        btnOnTap_BienBao.setOnClickListener(this);
        btnMeoGhiNho.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnDeThi:

                intent = new Intent(this, Giaodien_Dethi_Activity.class);
                startActivity(intent);
                break;
            case R.id.btnOntap_LyThuyet:
                intent = new Intent(this, Ontap_Lythuyet_Activity.class);
                startActivity(intent);
                break;
            case R.id.btnOnTap_BienBao:
                intent = new Intent(this, BtnBienBaoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMeoGhiNho:
                intent = new Intent(this, Btn_MeoGhiNho_Activity.class);
                startActivity(intent);
                break;
        }
    }
}
