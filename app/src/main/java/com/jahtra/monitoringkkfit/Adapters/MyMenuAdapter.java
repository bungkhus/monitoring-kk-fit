package com.jahtra.monitoringkkfit.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jahtra.monitoringkkfit.R;

/**
 * Created by bungkhus on 1/14/17.
 */

public class MyMenuAdapter extends BaseAdapter {

    Context context;
    String[] data;
    int minHeight;

    private static LayoutInflater inflater = null;

    public MyMenuAdapter(Context context, String[] data, int minHeight) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        this.minHeight = minHeight;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.menu_row, null);
        vi.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, minHeight));
        if (position == 1) {
            vi.setBackgroundColor(Color.parseColor("#927C78"));
        }
        else if (position == 2) {
            vi.setBackgroundColor(Color.parseColor("#a0009688"));
        }
        else if (position == 3) {
            vi.setBackgroundColor(Color.parseColor("#444444"));
        }
        else {
            vi.setBackgroundColor(Color.parseColor("#673AB7"));
        }
        TextView text = (TextView) vi.findViewById(R.id.menuTitle);
        text.setText(data[position]);
        return vi;
    }
}
