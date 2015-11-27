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
        //Database helper being initalised
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

        Add();
        select();
        Update();
        Delete();
    }

    //Update class to change users info
    public void Update() {
        //Listener that updates data in the db
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    //On Click, update the info required to be updated
                    @Override
                    public void onClick(View v) {
                        boolean Update = myDb.updateData(editMemNo.getText().toString(),
                                editName.getText().toString(),
                                editDate.getText().toString(),
                                editGrade.getText().toString(),
                                editScore.getText().toString()

                        );
                        //If successful display a toast to say data was updated
                        if (Update == true)
                            Toast.makeText(MainActivity2.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity2.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    //Class to add new values to the database
    public void Add() {
        //Listener that adds data in the db
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean Insert = myDb.insertData(editMemNo.getText().toString(),
                                editName.getText().toString(),
                                editDate.getText().toString(),
                                editGrade.getText().toString(),
                                editScore.getText().toString());
                        if (Insert == true)
                            Toast.makeText(MainActivity2.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity2.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    //Class to delete values to the database
    public void Delete() {
        //Listener that deletes data in the db
        btnviewDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer delete = myDb.deleteData(editMemNo.getText().toString());
                        if (delete > 0)
                            Toast.makeText(MainActivity2.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity2.this, "Data not deleted", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    //Select data from the db
    public void select() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //provides r-w access to the set returned by the query
                        Cursor res = myDb.getAllData();
                        if (res.getColumnCount() == 0) {
                            //show message if nothing there
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        //Accepts any type of data (boolean, char, int, long, Strings)
                        //While loop to get each piece of data it will go to each
                        //attribute in the table as specified below
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Membership No: " + res.getString(0) + "\n");
                            buffer.append("Name: " + res.getString(1) + "\n");
                            buffer.append("Date: " + res.getString(2) + "\n");
                            buffer.append("Grade: " + res.getString(3) + "\n");
                            buffer.append("Score: " + res.getString(4) + "\n");
                            buffer.append("------------------------------------------------------------");
                        }

                        //Display the below message
                        showMessage("Grading Database", buffer.toString());
                    }
                }
        );
    }

    //Function which contains a dialog box for a title and list
    public void showMessage(String title, String Message) {
        //Make the dialog box
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        //Set title
        builder.setTitle(title);
        //Set list
        builder.setMessage(Message);
        //Show the list
        builder.show();
    }

}

