package swart525.dw.md.scout.space.a525spacescout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Actual_Submit extends AppCompatActivity {

    //Names the file it will be saved to
    public String fileName = "Blue_3_Data.csv";
    public String filePath = "/ScoutData/";

    //Compiles string for CSV file
    public String Final_String = Data_Collection_Page_1.Team_Num + "," +
            Data_Collection_Page_1.Match_Num + "," +
            Data_Collection_Page_1.StartLocation1 + "," +
            Data_Collection_Page_1.StartLocation2 + "," +
            Data_Collection_Page_1.StartLocation3 + "," +
            Data_Collection_Page_1.StartLocation4 + "," +
            Data_Collection_Page_1.StartUnknown + "," +
            data_Collection_sandstorm.Taxi_No + "," +
            data_Collection_sandstorm.Taxi_Yes + "," +
            data_Collection_sandstorm.AutoUpperhubScore + "," +
            data_Collection_sandstorm.AutoUpperhubMiss + "," +
            data_Collection_sandstorm.AutoLowerhubScore + "," +
            data_Collection_sandstorm.AutoLowerhubMiss + "," +
            data_collection_TeleOP.CargoWrongColor + "," +
            data_collection_TeleOP.RobotDefense + "," +
            data_collection_TeleOP.CargoDefense + "," +
            data_collection_TeleOP.DefenseFouls + "," +
            data_collection_TeleOP.NoDefense + "," +
            data_collection_TeleOP.TeleUpperhubScore + "," +
            data_collection_TeleOP.TeleUpperhubMiss + "," +
            data_collection_TeleOP.TeleLowerhubScore + "," +
            data_collection_TeleOP.TeleLowerhubMiss + "," +
            data_collection_end_game.HangTraversal + "," +
            data_collection_end_game.HangHigh + "," +
            data_collection_end_game.HangMid + "," +
            data_collection_end_game.HangLow + "," +
            data_collection_end_game.AttemptedHang + "," +
            data_collection_end_game.NoAttempt + "," +
            data_collection_end_game.FellOffRung + "," +
            data_collection_end_game.Robot_Tipped + "," +
            data_collection_end_game.Robot_Stalled + "," +
            Save_Page.comment + "," +
            Data_Collection_Page_1.Initials;

    File externalStorageDir = Environment.getExternalStorageDirectory();
    public File Scout_Data = new File(externalStorageDir , "/DCIM/" + fileName);

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual__submit);
        Button Press_Here = (Button) findViewById(R.id.Press_Here);
        Button Click_to_go_Back = (Button) findViewById(R.id.Backto);

        Click_to_go_Back.setOnClickListener(new View.OnClickListener(){//Makes onclick listener for button
            @Override
            public void onClick(View v) {
                Intent startintent = new Intent(getApplicationContext(), Start_Page.class);
                startActivity(startintent);
            }
        });
    } */


    //Checks for confirmation from external storage
        private boolean isExternalStorageWritable () {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                Log.i("State", "Yes, it is writable!");
                return true;
            } else {
                return false;
            }
        }

        public void Press_Here (View v){
            if (isExternalStorageWritable() && checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if(Scout_Data.exists() && Scout_Data.isFile() ){
                    try {
                        final Button Press_Here = (Button) findViewById(R.id.Press_Here_B);
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Scout_Data, true)));
                        out.println(Final_String);
                        out.close();
                        Toast.makeText(this, "File Saved", Toast.LENGTH_LONG).show();
                        Press_Here.setVisibility(View.GONE);
                        Intent startintent = new Intent(getApplicationContext(), Start_Page.class);
                        startActivity(startintent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    File textFile = new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM", fileName);
                    try {
                        final Button Press_Here = (Button) findViewById(R.id.Press_Here_B);
                        FileOutputStream fos = new FileOutputStream(textFile);
                        Final_String = Final_String + "\n";
                        fos.write(Final_String.getBytes());
                        fos.close();
                        Toast.makeText(this, "File Saved", Toast.LENGTH_LONG).show();
                        Press_Here.setVisibility(View.GONE);
                        Intent startintent = new Intent(getApplicationContext(), Start_Page.class);
                        startActivity(startintent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //write an else if - turn on permissions
            }
        }

    public boolean checkPermission (String permission) {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_actual__submit);
            final Button Press_Here = (Button) findViewById(R.id.Press_Here_B);
            Press_Here.setVisibility(View.VISIBLE);

    }
}










