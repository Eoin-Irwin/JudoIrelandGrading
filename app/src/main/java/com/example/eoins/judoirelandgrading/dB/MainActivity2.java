package com.example.eoins.judoirelandgrading.dB;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eoins.judoirelandgrading.R;


public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editMemNo, editDate, editGrade, editScore;

    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnviewDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);
        setContentView(R.layout.activity_mainn);

        editMemNo = (EditText) findViewById(R.id.mem_no);
        editName = (EditText) findViewById(R.id.name);
        editDate = (EditText) findViewById(R.id.date);
        editGrade = (EditText) findViewById(R.id.grade);
        editScore = (EditText) findViewById(R.id.score);

        btnAddData = (Button) findViewById(R.id.button_add);
        btnviewAll = (Button) findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button) findViewById(R.id.button_update);
        btnviewDelete = (Button) findViewById(R.id.button_delete);

        AddData();
        viewAll();
        Updatedata();
        DeleteData();
    }

    public void Updatedata() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editMemNo.getText().toString(),
                                editName.getText().toString(),
                                editDate.getText().toString(),
                                editGrade.getText().toString(),
                                editScore.getText().toString()

                        );
                        if (isUpdate == true)
                            Toast.makeText(MainActivity2.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity2.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editMemNo.getText().toString(),
                                editName.getText().toString(),
                                editDate.getText().toString(),
                                editGrade.getText().toString(),
                                editScore.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(MainActivity2.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity2.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void DeleteData() {
        btnviewDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editMemNo.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(MainActivity2.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity2.this, "Data not deleted", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getColumnCount() == 0) {
                            //show message if nothing there
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Membership No: " + res.getString(0) + "\n");
                            buffer.append("Name: " + res.getString(1) + "\n");
                            buffer.append("Date: " + res.getString(2) + "\n");
                            buffer.append("Grade: " + res.getString(3) + "\n");
                            buffer.append("Score: " + res.getString(4) + "\n");
                            buffer.append("------------------------------------------------------------");
                        }

                        showMessage("Grading Database", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}

