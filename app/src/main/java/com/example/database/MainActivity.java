package com.example.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    database d1;
    EditText name, father, semes, sec, mark, ph,id;
    Button sub, ret,up,count;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d1 = new database(this);
        id=(EditText) findViewById(R.id.textview);
        name = (EditText) findViewById(R.id.textView2);
        father = (EditText) findViewById(R.id.textView3);
        semes = (EditText) findViewById(R.id.textView4);
        sec = (EditText) findViewById(R.id.textView5);
        mark = (EditText) findViewById(R.id.textView6);
        ph = (EditText) findViewById(R.id.textView7);
        sub = (Button) findViewById(R.id.button);
        ret = (Button) findViewById(R.id.button2);
        up=(Button) findViewById(R.id.button5);
        count=(Button) findViewById(R.id.button6);
        AddData();
        viewAll();
        update();
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Total Rows entered are "+ c, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void AddData()
    {
        sub.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       boolean isinserted = d1.insertdata(id.getText().toString(),name.getText().toString(), father.getText().toString(), semes.getText().toString(), sec.getText().toString(), mark.getText().toString(), ph.getText().toString());

                                       if (isinserted == true) {
                                           Toast.makeText(MainActivity.this, "Entry Added", Toast.LENGTH_SHORT).show();
                                            c+=1;
                                       } else
                                           Toast.makeText(MainActivity.this, "Entry not added ", Toast.LENGTH_SHORT).show();
                                   }
                               }
        );
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void update()
    {
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdate=d1.update(id.getText().toString(),name.getText().toString(), father.getText().toString(), semes.getText().toString(), sec.getText().toString(), mark.getText().toString(), ph.getText().toString());
                if (isupdate == true) {
                    Toast.makeText(MainActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "Entry not Updated ", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void viewAll() {
        ret.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),Listview.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Button CLicked", Toast.LENGTH_SHORT).show();
                       /* Cursor res = d1.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Alert", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append("Father Name :"+ res.getString(2)+"\n");
                            buffer.append("Semester :"+ res.getString(3)+"\n");
                            buffer.append("Section :"+ res.getString(4)+"\n");
                            buffer.append("Marks :"+ res.getString(5)+"\n");
                            buffer.append("Phone Num :"+ res.getString(6)+"\n\n");
                            Intent intent=new Intent(getApplicationContext(),Listview.class);
                            startActivity(intent);

                        // Show all data
                        showMessage("Data",buffer.toString());

                    }*/

                    }
                });
    }



}


