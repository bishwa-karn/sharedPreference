package com.example.bishwa.karn.shearedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShearedPreferenceActivity extends AppCompatActivity {

    private EditText name;
    private EditText address;
    private EditText phone;
    private Button save;
    SharedPreferences sharedPreferences;
    public static final  String USER_PROFILE = "profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheared_preference);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.et_name);
        address = (EditText) findViewById(R.id.et_address);
        phone = (EditText) findViewById(R.id.et_phone);
        save = (Button) findViewById(R.id.btn_save);


        sharedPreferences= getSharedPreferences(USER_PROFILE,MODE_PRIVATE);

    }


    public void saveData(View view) {
        if(isFormValid()){
            saveUserInfo();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean isFormValid(){
        if(TextUtils.isEmpty(name.getText().toString())){
            name.setError("name can't be empty");
            return false;
        }if(TextUtils.isEmpty(phone.getText().toString())){
            phone.setError("name can't be empty");
            return false;
        }if(TextUtils.isEmpty(address.getText().toString())){
            address.setError("name can't be empty");
            return false;
        }
        return true;
    }

    private void saveUserInfo(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",name.getText().toString());
        editor.putString("ADDRESS",address.getText().toString());
        editor.putString("PHONE",phone.getText().toString());
        editor.commit();
        Toast.makeText(this,"Profile Sucessfully saved",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("address",address.getText().toString());
        intent.putExtra("phone",phone.getText().toString());

        setResult(RESULT_OK,intent);
        finish();
    }
}
