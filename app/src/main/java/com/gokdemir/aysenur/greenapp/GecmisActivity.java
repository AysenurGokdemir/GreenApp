package com.gokdemir.aysenur.greenapp;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Aysenur on 29.04.2017.
 */

public class GecmisActivity extends AppCompatActivity {
    ListView gecmisListe;
    ArrayList<String>arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gecmis);
        arrayList=new ArrayList<>();
        gecmisListe= (ListView) findViewById(R.id.listview);

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrayList);
        gecmisListe.setAdapter(adapter);

        DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference().child(config.android_id);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    dataSnapshot.getKey();
                    Model model=ds.getValue(Model.class);
                    Log.d("Kilo",model.getKilo());
                    Log.d("Boy",model.getBoy());
                    Log.d("Sonuc",model.getSonuc());
                    arrayList.add("Kilom:"+model.getKilo()+"Boyum:"+model.getBoy()+"Sonuc:"+model.getSonuc());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
