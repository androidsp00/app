package com.example.androidsp.appgplx.BtnBienBao;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androidsp.appgplx.R;

import java.util.ArrayList;

public class BtnBienBaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_bienbao);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Setup spinner
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new MyAdapter( toolbar.getContext(),
                new String[]{
                        "Biển báo cấm",
                        "Biển báo nguy hiểm",
                        "Biển hiệu lệnh",
                        "Biển chỉ dẫn",
                        "Biển phụ",
                        "Vạch kẻ đường",
                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               getSupportFragmentManager().beginTransaction()
                       .replace(R.id.container, PlaceholderFragment.newInstance(position))
                       .commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_btn_bienbao, menu);
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


    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        public MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }



            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }

        @Override
        public void setDropDownViewTheme(Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }
    }


    public static class PlaceholderFragment extends Fragment {

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



        private ArrayList<ObjBienbao> mangBienbao;
        private AdapterBienBao adapter;
        private ListView listViewDSBienBao;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_btn_bienbao, container, false);
            ImageView imgBienBao = (ImageView) rootView.findViewById(R.id.ImageBienBao);
            TextView txtv_TenBienbao = (TextView) rootView.findViewById(R.id.txtv_TenBienbao);
            TextView txtv_Thongtin_Bienbao = (TextView) rootView.findViewById(R.id.txtv_Thongtin_Bienbao);
            listViewDSBienBao = (ListView) rootView.findViewById(R.id.lv_DsBienbao);

            mangBienbao = new ArrayList<ObjBienbao>();
            //ObjBienbao objBienbao = new ObjBienbao(R.drawable.bb130, "lol", "Biển báo 1");
            //mangBienbao.add(objBienbao);


            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 0:
                    txtv_TenBienbao.setText("Biển Cấm");
                    imgBienBao.setImageResource(R.drawable.bb130);
                    txtv_Thongtin_Bienbao.setText("Biển báo cấm để biểu thị các điều cấm. Người sử dụng đường phải chấp hành những điều cấm mà biển đã báo.");

                    mangBienbao.add(new ObjBienbao(R.drawable.bc101,"101","Đường cấm"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc102,"102","Cấm đi ngược chiều"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc103a,"103a","Cấm ôtô"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc103b,"103b","Cấm ôtô rẽ phải"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc103c,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc103c,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc104,"104","Cấm môtô"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc105,"105","Cấm ôtô và môtô"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc106,"106","Cấm ôtô tải"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc107,"107","Cấm ôtô khách và ôtô tải"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc108,"108","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc109,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc110,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc112,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc115,"115","Hạn chế trọng lượng xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc116,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc117,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc120,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc123,"123","Cấm rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc124,"124","Cấm quay xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc125,"125","Cấm vượt"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc126,"126","Cấm ôtô tải vượt"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc128,"128","Cấm bóp còi"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc130,"130","Cấm dừng xe và đỗ xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc131,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc132,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc133,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc134,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc135,"103c","Cấm ôtô rẽ trái"));

                    adapter = new AdapterBienBao(
                            getActivity(),
                            R.layout.item_bienbao,
                            mangBienbao);
                    listViewDSBienBao.setAdapter(adapter);


                    break;
                case 1:
                    imgBienBao.setImageResource(R.drawable.bb232);
                    txtv_Thongtin_Bienbao.setText("Biển báo nguy hiểm để cảnh báo các tình huống nguy hiểm có thể xảy ra được dùng để báo cho người sử dụng đường");
                    txtv_TenBienbao.setText("Biển báo nguy hiểm");
                    mangBienbao.add(new ObjBienbao(R.drawable.bc130,"130","Cấm dừng xe và đỗ xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc131,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc132,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc133,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc134,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc135,"103c","Cấm ôtô rẽ trái"));

                    adapter = new AdapterBienBao(
                            getActivity(),
                            R.layout.item_bienbao,
                            mangBienbao);
                    listViewDSBienBao.setAdapter(adapter);

                    break;
                case 2:
                    txtv_TenBienbao.setText("Biển hiệu lệnh");
                    imgBienBao.setImageResource(R.drawable.bb303);
                    txtv_Thongtin_Bienbao.setText("Biển báo cấm để biểu thị các điều cấm. Người sử dụng đường phải chấp hành những điều cấm mà biển đã báo.");
                    mangBienbao.add(new ObjBienbao(R.drawable.bc130,"130","Cấm dừng xe và đỗ xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc131,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc132,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc133,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc134,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc135,"103c","Cấm ôtô rẽ trái"));

                    adapter = new AdapterBienBao(
                            getActivity(),
                            R.layout.item_bienbao,
                            mangBienbao);
                    listViewDSBienBao.setAdapter(adapter);
                    break;
                case 3:
                    txtv_TenBienbao.setText("Biển chỉ dẫn");
                    imgBienBao.setImageResource(R.drawable.bb408a);
                    txtv_Thongtin_Bienbao.setText("Các biển chỉ dẫn để chỉ dẫn hướng đi hoặc các điều cần biết nhằm thông báo cho những người sử dụng đường biết những định hướng cần thiết");
                    mangBienbao.add(new ObjBienbao(R.drawable.bc130,"130","Cấm dừng xe và đỗ xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc131,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc132,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc133,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc134,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc135,"103c","Cấm ôtô rẽ trái"));

                    adapter = new AdapterBienBao(
                            getActivity(),
                            R.layout.item_bienbao,
                            mangBienbao);
                    listViewDSBienBao.setAdapter(adapter);

                    break;
                case 4:
                    txtv_TenBienbao.setText("Biển phụ");
                    imgBienBao.setImageResource(R.drawable.bb509);
                    txtv_Thongtin_Bienbao.setText("Biển phụ thường được đặt kết hợp với các biển báo nguy hiểm, biển báo cấm, biển hiệu lệnh và biển chỉ dẫn nhằm thuyết minh bổ sung để hiểu rõ hơn các biển đó");
                    mangBienbao.add(new ObjBienbao(R.drawable.bc130,"130","Cấm dừng xe và đỗ xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc131,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc132,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc133,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc134,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc135,"103c","Cấm ôtô rẽ trái"));

                    adapter = new AdapterBienBao(
                            getActivity(),
                            R.layout.item_bienbao,
                            mangBienbao);
                    listViewDSBienBao.setAdapter(adapter);

                    break;
                case 5:
                    txtv_TenBienbao.setText("Vạch kẻ đường");
                    imgBienBao.setImageResource(R.drawable.bb130);
                    txtv_Thongtin_Bienbao.setText("Vạch kẻ đường là một dạng báo hiệu để hướng dẫn, điều khiển giao thông nhằm nâng cao an toàn và khả năng thông xe. Vạch kẻ đường chia làm 2 loại: vạch nằm ngang và vạch nằm đứng.");
                    mangBienbao.add(new ObjBienbao(R.drawable.bc130,"130","Cấm dừng xe và đỗ xe"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc131,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc132,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc133,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc134,"103c","Cấm ôtô rẽ trái"));
                    mangBienbao.add(new ObjBienbao(R.drawable.bc135,"103c","Cấm ôtô rẽ trái"));

                    adapter = new AdapterBienBao(
                            getActivity(),
                            R.layout.item_bienbao,
                            mangBienbao);
                    listViewDSBienBao.setAdapter(adapter);

                    break;

            }
            return rootView;
        }

        public void getSystemService(String layoutInflaterService) {
        }
    }
}
