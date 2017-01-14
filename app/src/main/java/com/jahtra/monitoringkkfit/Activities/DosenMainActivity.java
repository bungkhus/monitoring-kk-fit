package com.jahtra.monitoringkkfit.Activities;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jahtra.monitoringkkfit.Adapters.MyMenuAdapter;
import com.jahtra.monitoringkkfit.Base.BaseActivity;
import com.jahtra.monitoringkkfit.R;

public class DosenMainActivity extends BaseActivity {

    ListView listView ;
    Rect rectangle;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_main);

        listView = (ListView) findViewById(R.id.listView);
        rectangle = new Rect();
        window = getWindow();

        final String[] values = new String[] {
                "PROFILE",
                "RINCIAN",
                "STATISTIK",
                "KEMAJUAN",
                "UNGGAH PROPOSAL"
        };

        listView.setAdapter(new MyMenuAdapter(this, values, (getHeightScreen()-getStatusBarHeight())/values.length));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition     = position;
                String  itemValue    = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
