package com.example.androidsp.appgplx.BtnDethi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.bumptech.glide.Glide;
import com.example.androidsp.appgplx.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Giaodien_Dethi_Activity extends AppCompatActivity implements Runnable, View.OnClickListener {

    public static final int TIMER = 900;
    TextView txtvTimer ;
    private int mTimer;
    private Handler mHandler;
    private ImageView img_done;
    private ItemBoxAdapter boxAdapter;


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien_dethi);

        img_done = (ImageView) findViewById(R.id.img_done);
        img_done.setOnClickListener(this);



        mHandler = new Handler();
        setHamtinhthoigian();
        txtvTimer = (TextView)findViewById(R.id.txtvTimer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setPageTransformer(true, new RotateUpTransformer());

        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                page.setRotationY(position * -30);
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_done:
                showDialogFinish();
            break;
        }

    }

    private void finishTest() {
        Toast.makeText(this, "Kết thúc bài thi", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainOver_Activity.class);
//        intent.putExtra(Constants.LIST_TEST, arrCauhoi);
//        intent.putExtra(Constants.LIST_DAPANCHON, arrDapanchon);
//        intent.putExtra(Constants.LONG_TIME, TIMER - total);
//        intent.putExtra(Constants.CAUHOIBIENBAO, listCauhoiBienbao);
        startActivity(intent);
        finish();
    }

    private void showDialogFinish() {
        Dialog dialog;
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn kết thúc bài thi không?");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Có",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishTest();
                    }
                });

        builder.setNegativeButton(
                "Không",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        showDialogBack();
    }

    private void showDialogBack() {
        Dialog dialog;
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn thoát không?");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Có",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

        builder.setNegativeButton(
                "Không",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        dialog = builder.create();
        dialog.show();
    }

    //TODO: Tính thời gian
    private void setHamtinhthoigian() {
        mHandler.removeCallbacksAndMessages(null);
        mTimer = TIMER;
        int time = TIMER + 1;
        for (int index = 0; index < time; index++){
            mHandler.postDelayed(this, index * 1000);
        }
    }
    @Override
    public void run() {
        int phut = mTimer/60;
        int giay = mTimer - phut * 60;
        txtvTimer.setText(phut + ":" + giay);
        mTimer--;
        if (mTimer == -1){
            finishTest();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_giaodien_dethi, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case android.R.id.home:
                this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }




     // TODO: Xử lý Fragment

    public static class PlaceholderFragment extends Fragment implements CompoundButton.OnCheckedChangeListener{

        TextView txtv_NoidungCauhoi, tv_index_ques;
        CheckBox chkDapAn1,chkDapAn2,chkDapAn3,chkDapAn4;
        private ObjCauHoi objCauHoi;
        private LinearLayout ll_image;
        private ImageView img_image;
        private String[] dapan;
        private int Loaicauhoi;
        private int dapanchon = 0;
        private static int tongdapandung = 0;
        int idcauhoi;

        Random rd = new Random();
        int dem = 0 ;
        private ArrayList<ObjCauHoi> arrCauHoiRandom = new ArrayList<ObjCauHoi>();

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {

        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_giaodien_dethi, container, false);

            tv_index_ques = (TextView) rootView.findViewById(R.id.tv_index_ques);
            txtv_NoidungCauhoi = (TextView) rootView.findViewById(R.id.txtv_DbNoiDungCauHoi);

            chkDapAn1 = (CheckBox) rootView.findViewById(R.id.checkBox_DapAn1);
            chkDapAn2 = (CheckBox) rootView.findViewById(R.id.checkBox_DapAn2);
            chkDapAn3 = (CheckBox) rootView.findViewById(R.id.checkBox_DapAn3);
            chkDapAn4 = (CheckBox) rootView.findViewById(R.id.checkBox_DapAn4);

            chkDapAn1.setOnCheckedChangeListener(this);
            chkDapAn2.setOnCheckedChangeListener(this);
            chkDapAn3.setOnCheckedChangeListener(this);
            chkDapAn4.setOnCheckedChangeListener(this);

            ll_image = (LinearLayout) rootView.findViewById(R.id.ll_image);
            img_image = (ImageView) rootView.findViewById(R.id.img_image);

            if (savedInstanceState == null)
            {

            }else
            {
                idcauhoi = savedInstanceState.getInt("abc");
                txtv_NoidungCauhoi.setText(idcauhoi);
            }

            setupData();

            return rootView;
        }


        private void setupData() {

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            final DatabaseReference mData = firebaseDatabase.getReference("tbCauhoi");
            mData.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    dem = (int) dataSnapshot.getChildrenCount();

                    for (int i = 0; i < dem; i++) {

                        //TODO: Load dữ liệu từ Firebase
                        objCauHoi = new ObjCauHoi();
                        objCauHoi.setIdCauhoi(dataSnapshot.child(String.valueOf(i) + "/idCauhoi").getValue(Integer.class));
                        objCauHoi.setIdLoaicauhoi(dataSnapshot.child(String.valueOf(i) + "/idLoaiCauhoi").getValue(Integer.class));
                        objCauHoi.setNoidung(dataSnapshot.child(String.valueOf(i) + "/Cauhoi").getValue(String.class));
                        objCauHoi.setDapAn1(dataSnapshot.child(String.valueOf(i) + "/DapAn1").getValue(String.class));
                        objCauHoi.setDapAn2(dataSnapshot.child(String.valueOf(i) + "/DapAn2").getValue(String.class));
                        objCauHoi.setDapAn3(dataSnapshot.child(String.valueOf(i) + "/DapAn3").getValue(String.class));
                        objCauHoi.setDapAn4(dataSnapshot.child(String.valueOf(i) + "/DapAn4").getValue(String.class));
                        objCauHoi.setTenAnh(dataSnapshot.child(String.valueOf(i) + "/TenAnh").getValue(String.class));
                        objCauHoi.setDapandung(dataSnapshot.child(String.valueOf(i) + "/DapAnDung").getValue(Integer.class));

                        arrCauHoiRandom.add(objCauHoi);
                    }

                    //TODO: Random câu hỏi
                    Collections.shuffle(arrCauHoiRandom);
                    int i = getArguments().getInt(ARG_SECTION_NUMBER);
                    //int rdQues = rd.nextInt(arrCauHoiRandom.size());

//                    for(int i = 0; i < arrCauHoiRandom.size(); i++){
//                        int rdQues = rd.nextInt(arrCauHoiRandom.size());

                    // TODO: Load Nội dung câu hỏi - Đáp án 1 , 2
                    txtv_NoidungCauhoi.setText(arrCauHoiRandom.get(i).getNoidung());
                    chkDapAn1.setText(arrCauHoiRandom.get(i).getDapAn1());
                    chkDapAn2.setText(arrCauHoiRandom.get(i).getDapAn2());

                    // TODO: Load đáp án 3 - 4 ( Ẩn hiện nếu có )
                    chkDapAn3.setVisibility(View.GONE);
                    chkDapAn4.setVisibility(View.GONE);
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        if (arrCauHoiRandom.get(i).getDapAn3().trim().length() != 0) {
                            chkDapAn3.setText(arrCauHoiRandom.get(i).getDapAn3());
                            chkDapAn3.setVisibility(View.VISIBLE);
                        }
                        if (arrCauHoiRandom.get(i).getDapAn4().trim().length() != 0) {
                            chkDapAn4.setText(arrCauHoiRandom.get(i).getDapAn4());
                            chkDapAn4.setVisibility(View.VISIBLE);
                        }
                    }

                    // TODO: Load Ảnh
                    String idLoaicauhoi = String.valueOf(arrCauHoiRandom.get(i).getIdLoaicauhoi());
                    if (!idLoaicauhoi.isEmpty()) {
                        switch (Integer.parseInt(idLoaicauhoi)) {
                            case 1:
                                ll_image.setVisibility(View.GONE);
                                break;
                            case 2:
                                ll_image.setVisibility(View.VISIBLE);
                                img_image.setVisibility(View.VISIBLE);
                                Glide.
                                        with(getActivity())
                                        .load("file:///android_asset/imagesques/" + arrCauHoiRandom.get(i).getTenAnh() + ".jpg")
                                        .into(img_image);
                                break;
                        }
                    }
//                }
                    // TODO: --> Kết thúc vòng for random <--

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
        }


        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            idcauhoi = objCauHoi.getIdCauhoi();
            outState.putInt("abc", idcauhoi);
        }


        ArrayList<String> dsDapanchon = new ArrayList<>();
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            dapan = String.valueOf(objCauHoi.getDapandung()).split("");
            if (buttonView==chkDapAn1 && isChecked==true){
                if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;
                dsDapanchon.add("1");
                dapanchon++;

            }else if(buttonView==chkDapAn1 && isChecked==false){ dapanchon--;dsDapanchon.remove("1");if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;}

            if(buttonView==chkDapAn2 && isChecked==true){
                if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;
                dsDapanchon.add("2");
                dapanchon++;
            }else if(buttonView==chkDapAn2 && isChecked==false){ dapanchon--;dsDapanchon.remove("2");if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;}

            if (buttonView==chkDapAn3 && isChecked==true){
                if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;
                dsDapanchon.add("3");
                dapanchon++;
            }else if(buttonView==chkDapAn3 && isChecked==false){ dapanchon--;dsDapanchon.remove("3");if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;}

            if (buttonView==chkDapAn4 && isChecked==true){
                if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;
                dsDapanchon.add("4");
                dapanchon++;
            }else if(buttonView==chkDapAn4&& isChecked==false){ dapanchon--;dsDapanchon.remove("4");if(tongdapandung!=0 && objCauHoi.isKiemtra()==true)tongdapandung--;}

            int demdapandung = 0;

            if(dapanchon==dapan.length-1){
                    for (int i = 1; i < dapan.length; i++) {
                        if(!dapan[i].isEmpty()){
                            for(int j = 0; j<dsDapanchon.size();j++){
                                if(Integer.parseInt(dapan[i])==Integer.parseInt(dsDapanchon.get(j))) {
                                    demdapandung++;
                                }
                            }
                        }
                    }
                //
                if(demdapandung==dapan.length-1){
                    objCauHoi.setKiemtra(true);
                    tongdapandung++;
                    Toast.makeText(getActivity(),"Đúng "+ tongdapandung + " Câu",Toast.LENGTH_SHORT).show();
                }else{
                    objCauHoi.setKiemtra(false);
                    Toast.makeText(getActivity(),"Sai "+ tongdapandung + " Câu",Toast.LENGTH_SHORT).show();
                }
            }else {
                objCauHoi.setKiemtra(false);
                Toast.makeText(getActivity(),"Sai "+ tongdapandung + " Câu",Toast.LENGTH_SHORT).show();
            }
        }

    }


    // TODO: Xử lý Adapter

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public CharSequence getPageTitle(int position) {
           return "Câu " + String.valueOf(position+1);
        }
    }
}
