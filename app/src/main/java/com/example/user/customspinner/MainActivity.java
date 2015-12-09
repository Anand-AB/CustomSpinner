package com.example.user.customspinner;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends Activity {
    String[] spinnerValues = { "Blur", "NFS", "Burnout","GTA IV", "Racing", };
    String[] spinnerSubs = { "Ultimate Game", "Need for Speed", "Ulimate Racing", "Rockstar Games", "Thunder Bolt" };
    int total_images[] = { R.drawable.china, R.drawable.india, R.drawable.ireland, R.drawable.japan, R.drawable.china, R.drawable.india };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner_show);
        mySpinner.setAdapter(new MyAdapter(this, R.layout.spinner_layout, spinnerValues));
    }
    public class MyAdapter extends ArrayAdapter<String> {
        public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {
            super(ctx, txtViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }
        public View getCustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner = inflater.inflate(R.layout.spinner_layout, parent, false);
            TextView main_text = (TextView) mySpinner .findViewById(R.id.text_main_seen);
            main_text.setText(spinnerValues[position]);
            TextView subSpinner = (TextView) mySpinner .findViewById(R.id.sub_text_seen);
            subSpinner.setText(spinnerSubs[position]);
            ImageView left_icon = (ImageView) mySpinner .findViewById(R.id.left_pic);
            left_icon.setImageResource(total_images[position]); return mySpinner;
        }
    }
}

