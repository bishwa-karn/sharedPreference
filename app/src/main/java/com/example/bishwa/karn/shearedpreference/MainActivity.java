package com.example.bishwa.karn.shearedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText address;
    EditText phone;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.et_name);
        address = (EditText) findViewById(R.id.et_address);
        phone = (EditText) findViewById(R.id.et_phone);

        sharedPreferences = getSharedPreferences(ShearedPreferenceActivity.USER_PROFILE,MODE_PRIVATE);

        name.setText("Name : "+sharedPreferences.getString("NAME",""));
        address.setText("Name : "+sharedPreferences.getString("ADDRESS",""));
        phone.setText("Name : "+sharedPreferences.getString("PHONE",""));



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_item_list:
                Intent intent = new Intent(MainActivity.this,ShearedPreferenceActivity.class);
                startActivityForResult(intent,101);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("request code", requestCode +"");
        Log.e("Result code",resultCode+"");
        if(resultCode == RESULT_OK && requestCode == 101){
            String name = data.getStringExtra("name");
            String address = data.getStringExtra("address");
            String phone = data.getStringExtra("phone");

            this.name.setText("Name : "+name);
            this.address.setText("Address : "+address);
            this.phone.setText("Phone : "+phone);

        }
    }
}
