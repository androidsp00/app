package com.example.androidsp.appgplx.BtnOntap_Lythuyet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.bumptech.glide.Glide;
import com.example.androidsp.appgplx.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Ontap_Lythuyet_Activity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontap_lythuyet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ontaplythuyet, menu);
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


    public static class PlaceholderFragment extends Fragment {

        private CauhoilythuyetObj obj = new CauhoilythuyetObj();
        private ArrayList<CauhoiBienbaoObj> listCauhoiBienbao;
        private LinearLayout ll_hinhanh;
        private ImageView img_hinhanh;
        TextView textViewCauhoi;
        CheckBox checkBoxDa1, checkBoxDa2, checkBoxDa3, checkBoxDa4;

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
            View rootView = inflater.inflate(R.layout.fragment_ontap_lythuyet, container, false);
            textViewCauhoi = (TextView) rootView.findViewById(R.id.txtv_DbCauHoi);
            checkBoxDa1 = (CheckBox) rootView.findViewById(R.id.chk_DapAn1);
            checkBoxDa2 = (CheckBox) rootView.findViewById(R.id.chk_DapAn2);
            checkBoxDa3 = (CheckBox) rootView.findViewById(R.id.chk_DapAn3);
            checkBoxDa4 = (CheckBox) rootView.findViewById(R.id.chk_DapAn4);

            ll_hinhanh = (LinearLayout) rootView.findViewById(R.id.ll_hinhanh);
            img_hinhanh = (ImageView) rootView.findViewById(R.id.img_hinhanh);

            setupData();



            return rootView;
        }

        private void setupData() {

            setupDapan();


            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference mData = firebaseDatabase.getReference("tbCauhoi");

            mData.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                        obj.setIdCauhoi(dataSnapshot.child(String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER))+"/idCauhoi").getValue(Integer.class));
                        obj.setIdLoaicauhoi(dataSnapshot.child(String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER))+"/idLoaiCauhoi").getValue(Long.class));
                        obj.setNoidung(dataSnapshot.child(String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)) + "/Cauhoi").getValue(String.class));
                        obj.setDapAn1(dataSnapshot.child(String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)) + "/DapAn1").getValue(String.class));
                        obj.setDapAn2(dataSnapshot.child(String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)) + "/DapAn2").getValue(String.class));
                        obj.setDapAn3(dataSnapshot.child(String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)) + "/DapAn3").getValue(String.class));
                        obj.setDapAn4(dataSnapshot.child(String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)) + "/DapAn4").getValue(String.class));
                        obj.setTenAnh(dataSnapshot.child(String.valueOf(getArguments().get(ARG_SECTION_NUMBER)) + "/TenAnh").getValue(String.class));
                        obj.setDapandung(dataSnapshot.child(String.valueOf(getArguments().get(ARG_SECTION_NUMBER)) + "/DapAnDung").getValue(Long.class));

                    }
                    //int sosanh = cauhoi.getDapandung();
                    //int dapan1 = sosanh/10;
                    //int dapan2 = sosanh%10;


                    //Xét đáp án đúng
                    String[] dapan = String.valueOf(obj.getDapandung()).split("");
                    //Toast.makeText(getActivity(), dapan[1]+"", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < dapan.length; i++) {
                        if(!dapan[i].isEmpty())
                            switch (Integer.parseInt(dapan[i])){
                                case 1:
                                    checkBoxDa1.setTypeface(Typeface.DEFAULT_BOLD);
                                    checkBoxDa1.setChecked(true);
                                    break;
                                case 2:
                                    checkBoxDa2.setTypeface(Typeface.DEFAULT_BOLD);
                                    checkBoxDa2.setChecked(true);
                                    break;
                                case 3:
                                    checkBoxDa3.setTypeface(Typeface.DEFAULT_BOLD);
                                    checkBoxDa3.setChecked(true);
                                    break;
                                case 4:
                                    checkBoxDa4.setTypeface(Typeface.DEFAULT_BOLD);
                                    checkBoxDa4.setChecked(true);
                                    break;
                            }
                    }


                    textViewCauhoi.setText(obj.getNoidung());
                    checkBoxDa1.setText(obj.getDapAn1());
                    checkBoxDa2.setText(obj.getDapAn2());
                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                        checkBoxDa3.setVisibility(View.GONE);
                        checkBoxDa4.setVisibility(View.GONE);

                        if(obj.getDapAn3().trim().length()!=0){
                            checkBoxDa3.setText(obj.getDapAn3());
                            checkBoxDa3.setVisibility(View.VISIBLE);
                        }
                        if(obj.getDapAn4().trim().length()!=0){
                            checkBoxDa4.setText(obj.getDapAn4());
                            checkBoxDa4.setVisibility(View.VISIBLE);
                        }
                    }

                    String idLoaicauhoi = String.valueOf(obj.getIdLoaicauhoi());
                    if (!idLoaicauhoi.isEmpty()){
                        switch (Integer.parseInt(idLoaicauhoi)){
                            case 1:
                                ll_hinhanh.setVisibility(View.GONE);
                                break;
                            case 2:
                                ll_hinhanh.setVisibility(View.VISIBLE);
                                img_hinhanh.setVisibility(View.VISIBLE);
                                Glide.
                                        with(getActivity())
                                        .load("file:///android_asset/imagesques/" + obj.getTenAnh() + ".jpg")
                                        .into(img_hinhanh);
                                break;
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }


        private void setupDapan() {
            checkBoxDa1.setChecked(false);
            checkBoxDa2.setChecked(false);
            checkBoxDa3.setChecked(false);
            checkBoxDa4.setChecked(false);

            checkBoxDa1.setEnabled(false);
            checkBoxDa2.setEnabled(false);
            checkBoxDa3.setEnabled(false);
            checkBoxDa4.setEnabled(false);
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 20;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return "Câu " + String.valueOf(position+1);
        }
    }
}
