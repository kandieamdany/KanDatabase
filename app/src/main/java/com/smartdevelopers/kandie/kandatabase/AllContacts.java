package com.smartdevelopers.kandie.kandatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 4331 on 30/06/2015.
 */
public class AllContacts extends AppCompatActivity {
    private ListView obj;
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_contacts);

        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllCotacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

        obj = (ListView)findViewById(R.id.allcontacts);
        obj.setAdapter(arrayAdapter);
        obj.setVisibility((arrayAdapter.isEmpty()) ? View.GONE : View.VISIBLE);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(getApplicationContext(),com.smartdevelopers.kandie.kandatabase.DisplayContact.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });

    }

//    @Override
//    public void onContentChanged() {
//        super.onContentChanged();
//        View empty=findViewById(R.id.empty);
//        obj.setEmptyView(empty);
//
//    }
}
