package com.jahtra.monitoringkkfit.Activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jahtra.monitoringkkfit.Adapters.MyMenuAdapter;
import com.jahtra.monitoringkkfit.Base.Base;
import com.jahtra.monitoringkkfit.Models.Penelitian;
import com.jahtra.monitoringkkfit.Models.User;
import com.jahtra.monitoringkkfit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DosenMainActivity extends AppCompatActivity {

    private ListView listView ;
    private Rect rectangle;
    private Window window;
    private Base base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_main);
        base = new Base(this);

        listView = (ListView) findViewById(R.id.listView);
        rectangle = new Rect();
        window = getWindow();

        final String[] menus = new String[] {
                "PROFILE",
                "RINCIAN",
                "STATISTIK",
                "KEMAJUAN",
                "UNGGAH PROPOSAL"
        };

        base.setActivityBackgroundColor(R.id.activity_dosen_main, base.getMenuColors()[menus.length-1]);

        listView.setAdapter(new MyMenuAdapter(this, menus, (base.getHeightScreen()-base.getStatusBarHeight())/menus.length));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String title = (String) listView.getItemAtPosition(position);
                Intent i = new Intent();
                switch (position) {
                    case 0: //profile
                        System.out.println(position + " " +title);
                        break;
                    case 1: //rincian
                        i = new Intent(DosenMainActivity.this, RincianActivity.class);
                        i.putExtra("position", position);
                        i.putExtra("title", title);
                        break;
                    case 2: //statistik
                        System.out.println(position + " " +title);
                        break;
                    case 3: //kemajuan
                        System.out.println(position + " " +title);
                        break;
                    case 4: //unggah file
                        System.out.println(position + " " +title);
                        break;
                }
                startActivity(i);
            }
        });
    }
}
