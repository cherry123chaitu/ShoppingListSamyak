package com.example.shoppinglist;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.example.shoppinglist.App.Channel1;

public class DataInsertion extends AppCompatActivity {
    EditText name,quantity;
    private NotificationManagerCompat notificationManagerCompat;
    private FirebaseFirestore db;
    Button b1,b2;
    String Name,ammount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insertion);
        notificationManagerCompat=NotificationManagerCompat.from(this);

        b1=findViewById(R.id.button);
        b2=findViewById(R.id.retrival);

        db=FirebaseFirestore.getInstance();
        name=(EditText)findViewById(R.id.Itemname);
        quantity=(EditText)findViewById(R.id.Quantity);


    }
    public void Add(View v){
        Name=name.getText().toString();
        ammount=quantity.getText().toString();
        Notification notification=new NotificationCompat.Builder(this,App.Channel1).setSmallIcon(R.drawable.ic_one).setContentTitle("Shopping List").setContentText("Added"+" "+name+" "+"To Your list").setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        CollectionReference database=db.collection("Shopping_List");
        Shopping_List s=new Shopping_List(Name, Integer.parseInt(ammount));
        database.add(s).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(DataInsertion.this,"Sucessful",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(DataInsertion.this,Notifications.class);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DataInsertion.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Retrive(View view)
    {
        Intent intent=new Intent(DataInsertion.this,Retrival.class);
        startActivity(intent);
    }

}
