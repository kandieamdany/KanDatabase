package com.smartdevelopers.kandie.kandatabase;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private ListView obj;
    DBHelper mydb;
    TextView tv;

    private static final int RESULT_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllCotacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        obj = (ListView)findViewById(R.id.listView1);
        tv=(TextView)findViewById(R.id.empty);
        obj.setAdapter(arrayAdapter);
        obj.setVisibility((arrayAdapter.isEmpty()) ? View.GONE : View.VISIBLE);
        tv.setVisibility((arrayAdapter.isEmpty())?View.VISIBLE:View.GONE);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {
            case R.id.item1:Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);

                Intent intent = new Intent(getApplicationContext(),com.smartdevelopers.kandie.kandatabase.DisplayContact.class);
                intent.putExtras(dataBundle);

                startActivity(intent);
                return true;
            case R.id.item2:Bundle data_Bundle=new Bundle();
                data_Bundle.putInt("id", 1);

                Intent i = new Intent(getApplicationContext(),com.smartdevelopers.kandie.kandatabase.AllContacts.class);
                i.putExtras(data_Bundle);

                startActivity(i);
                return true;
            case R.id.item3:Bundle data_bund=new Bundle();
                data_bund.putInt("id", 2);
                Intent intent1=new Intent(getApplicationContext(),com.smartdevelopers.kandie.kandatabase.ActivitySharedPref.class);
                intent1.putExtras(data_bund);

                startActivity(intent1);
                return true;
            case R.id.menu_settings:Bundle bundle=new Bundle();
                bundle.putInt("id", 3);
                Intent intent2=new Intent(getApplicationContext(),com.smartdevelopers.kandie.kandatabase.UserSettingActivity.class);
                intent2.putExtras(bundle);

                startActivityForResult(intent2,RESULT_SETTINGS);
                return true;
            case R.id.display_user_settings:Bundle bundle1=new Bundle();
                bundle1.putInt("id",4);
                Intent intent3=new Intent(getApplicationContext(),com.smartdevelopers.kandie.kandatabase.DisplayUserSettings.class);
                intent3.putExtras(bundle1);

                startActivity(intent3);
                return true;
            case R.id.user_broadcast:Bundle bundle2=new Bundle();
                bundle2.putInt("id",5);
                Intent intent4=new Intent(getApplicationContext(),com.smartdevelopers.kandie.kandatabase.UserBroadcast.class);
                intent4.putExtras(bundle2);
                startActivity(intent4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keycode, event);
    }
}
