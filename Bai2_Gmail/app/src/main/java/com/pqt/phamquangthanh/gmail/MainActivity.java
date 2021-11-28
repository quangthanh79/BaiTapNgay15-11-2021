package com.pqt.phamquangthanh.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView listviewInbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        listviewInbox = (ListView) findViewById(R.id.listviewInbox);
        ArrayList<Inbox> data = new ArrayList<Inbox>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,10,28,12,34);
        Date date1 = calendar.getTime();

        calendar.set(2021,10,28,11,22);
        Date date2 = calendar.getTime();

        calendar.set(2021,10,28,11,14);
        Date date3 = calendar.getTime();

        calendar.set(2021,10,28,10,56);
        Date date4 = calendar.getTime();

        calendar.set(2021,10,28,10,22);
        Date date5 = calendar.getTime();
        data.add(new Inbox(date1,"$19 Only(First 10 spots) - Bestselling... Are you looking to Learn Web Designin...","Edurila.com"));
        data.add(new Inbox(date2,"Help make Campaign Monitor better Let us know your thoughts! No Images...","Chris Abad"));
        data.add(new Inbox(date3,"8h de formation gratuite et les nouvea... Photoshop,SEO,Blender,CSS,Wordpre","Tuto.com"));
        data.add(new Inbox(date4,"Societe Ovh: suivi de vos services-hp SAS OVH - http://www.ovh.com 2 rue K","support"));
        data.add(new Inbox(date5,"The New lonic Creator Is Here! Announcing the all-new Creator,building","Matt from lonic"));

        InboxAdapter adapter = new InboxAdapter(MainActivity.this,R.layout.custom_item,data);
        listviewInbox.setAdapter(adapter);
    }
}