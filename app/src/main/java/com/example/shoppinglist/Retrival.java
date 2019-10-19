package com.example.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class Retrival extends AppCompatActivity {
    public ListView l;
    public ArrayList<String> a=new ArrayList<String>();
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrival);
        db=FirebaseFirestore.getInstance();
        l=findViewById(R.id.List);
        db.collection("Shopping_List").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                a.clear();
                assert queryDocumentSnapshots != null;
                for (DocumentSnapshot snapshot:queryDocumentSnapshots){
                    a.add(snapshot.getString("item_name"));
                }

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_selectable_list_item,a);
                adapter.notifyDataSetChanged();
                l.setAdapter(adapter);
            }
        });
    }

}
