package com.example.loginapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd,btnDel,btnDone;
//    public Context context;

    RVAdapter adapter=new RVAdapter(this);
    DBHelper dbHelper=new DBHelper(this);

//    public HomeActivity(Context context) {
//        this.context=context;
//    }

    EditText etUsername,etPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnAdd = findViewById(R.id.btnAdd);
        btnDel = findViewById(R.id.btnDel);
        btnDone = findViewById(R.id.btnDone);
        recyclerView = findViewById(R.id.recyleViewer);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        etUsername=findViewById(R.id.etUserName);
        etPass=findViewById(R.id.etPassword);
        //To get the data
        Cursor cursor = dbHelper.getAllData();
        while (cursor.moveToNext()) {
            Language language = new Language(cursor.getInt(0),cursor.getString(3), cursor.getString(4), cursor.getString(1),
                    cursor.getString(2), cursor.getString(7), cursor.getString(5), cursor.getString(6),
                    cursor.getString(8), cursor.getString(10), cursor.getString(9), cursor.getString(11), cursor.getString(12));
            adapter.languageList.add(language);
        }
//        adapter.languageList.add(new Language("English","English Language","This is the excellent"));
//        adapter.languageList.add(new Language("Urdu","Urdu Language","This is the excellent"));
//        adapter.languageList.add(new Language("Dutch","Dutch Language","This is the excellent"));
        recyclerView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PrepareDetailActivity.class);
                startActivityForResult(intent, 345);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.context_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
            HomeActivity.this.finish();
            etUsername.setText("");
            etPass.setText("");
                break;
            case R.id.profile:
                break;
            case R.id.setting:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==345){
               Log.i("English","This request code is  : "+requestCode);
            if(resultCode!=RESULT_CANCELED){
                String stdName=data.getStringExtra("Student Name");
                String fatherName=data.getStringExtra("Father Name");
                String rollNo=data.getStringExtra("Roll No");
                String department=data.getStringExtra("Department");
                String language=data.getStringExtra("Language");
                String date=data.getStringExtra("Date");
                String ContactNo=data.getStringExtra("Contact No");
                String regis=data.getStringExtra("Registration");
                String subj=data.getStringExtra("Subject");
                String hodRemarks=data.getStringExtra("Hod Remarks");
                  Log.i("English","The resultcode is  : "+resultCode);

                adapter.languageList.add(new Language(rollNo,language,subj,hodRemarks));
                recyclerView.scrollToPosition(adapter.languageList.size()-1);
                Log.i("English","The resultcode is  added: "+adapter.languageList.size()+1);
                adapter.notifyDataSetChanged();
            }
        }
    }
}