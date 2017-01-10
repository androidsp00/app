package com.example.androidsp.appgplx.data;

import android.util.Log;

import com.example.androidsp.appgplx.BtnDethi.ObjCauHoi;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Androidsp on 10/01/2017.
 */

public class MyData {
    static  FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    static  DatabaseReference mData = firebaseDatabase.getReference("tbCauhoi");
    static  int dem=0;
    static ArrayList<ObjCauHoi> listCauhoi;
    public  static  void getData(){
        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listCauhoi=new ArrayList<ObjCauHoi>();
                dem = (int) dataSnapshot.getChildrenCount();

                for (DataSnapshot  snapshot: dataSnapshot.getChildren()) {

                    //TODO: Load dữ liệu từ Firebase
                    ObjCauHoi objCauHoi = new ObjCauHoi();
                    objCauHoi=snapshot.getValue(ObjCauHoi.class);
                    listCauhoi.add(objCauHoi);
                }

                //TODO: Random câu hỏi
                Collections.shuffle(listCauhoi);

                Log.e("Dataa", listCauhoi.toString());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
}
