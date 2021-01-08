package com.esiea.testsocket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        getSupportActionBar().hide();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},10);
        EditText editText = findViewById(R.id.editText6);
        EditText AdresseIp = findViewById(R.id.AdresseIp);
        EditText port = findViewById(R.id.port);
        findViewById(R.id.btnvalider2)
                .setOnClickListener(v -> {

                    if(!AdresseIp.getText().toString().isEmpty() && !port.getText().toString().isEmpty()){
                        Intent intent = new Intent(this, ChatActivity.class);
                        intent.putExtra("name", editText.getText().toString());
                        intent.putExtra("AdresseIp",AdresseIp.getText().toString());
                        intent.putExtra("Port",port.getText().toString());

                        startActivity(intent);
                    }else
                        Toast.makeText(LauncherActivity.this,"Adrrese Ip ou port obligatoire",Toast.LENGTH_LONG).show();



                });
    }
}
