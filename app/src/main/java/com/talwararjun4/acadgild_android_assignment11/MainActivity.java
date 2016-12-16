package com.talwararjun4.acadgild_android_assignment11;

import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button ascending = null;
    Button descending= null;
    ListView listView = null;
    ArrayAdapter<String> arrayAdapter = null;
    List<String> stringList = null;

    String[] months = {"January", "February","March","April","May","June","July","August","September","October","November", "December"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ascending = (Button)findViewById(R.id.ascButton);
        descending= (Button)findViewById(R.id.descButton);
        listView =(ListView)findViewById(R.id.listView1);
        stringList = Arrays.asList(months);
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ascButton:
                Collections.sort(stringList);
                //arrayAdapter.clear();
                arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stringList);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();


                break;
            case R.id.descButton:
                Collections.sort(stringList);
                Collections.reverse(stringList);
                //arrayAdapter.clear();
                arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stringList);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();

                break;
            default:
                Toast.makeText(getApplicationContext(),"Not Possible Scenario!",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
