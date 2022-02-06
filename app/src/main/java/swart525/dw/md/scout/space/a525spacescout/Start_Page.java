package swart525.dw.md.scout.space.a525spacescout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);
        //WARNING: Anything above this line do not edit

        //Below to dotted line defines the needed button and are used to bring you to data collection start page
        Button Start_Collection_Open = (Button) findViewById(R.id.Start_Collection_Open_B); //Defines button for later use
        Start_Collection_Open.setOnClickListener(new View.OnClickListener() { //Makes onclick listener for button
            @Override
            public void onClick(View v) {
                Data_Collection_Page_1.StartLocation1 = "False";
                Data_Collection_Page_1.StartLocation2 = "False";
                Data_Collection_Page_1.StartLocation3 = "False";
                Data_Collection_Page_1.StartLocation4 = "False";
                Data_Collection_Page_1.StartUnknown = "False";
                data_Collection_sandstorm.Taxi_Yes = "False";
                data_Collection_sandstorm.Taxi_No = "False";
                data_Collection_sandstorm.HumanPlayerScore = "False";
                data_Collection_sandstorm.HumanPlayerMiss = "False";
                data_Collection_sandstorm.HumanPlayerMultiple = "False";
                data_Collection_sandstorm.HumanPlayerNone = "False";
                data_Collection_sandstorm.AutoUpperhubScore = "0";
                data_Collection_sandstorm.AutoUpperhubMiss = "0";
                data_Collection_sandstorm.AutoLowerhubScore = "0";
                data_Collection_sandstorm.AutoLowerhubMiss = "0";
                data_collection_TeleOP.RobotDefense = "False";
                data_collection_TeleOP.DefenseFouls = "False";
                data_collection_TeleOP.NoDefense = "False";
                data_collection_TeleOP.CargoDefense = "False";
                data_collection_TeleOP.CargoWrongColor = "False";
                data_collection_TeleOP.TeleUpperhubScore = "0";
                data_collection_TeleOP.TeleUpperhubMiss = "0";
                data_collection_TeleOP.TeleLowerhubScore = "0";
                data_collection_TeleOP.TeleLowerhubMiss = "0";
                data_collection_end_game.HangTraversal = "False";
                data_collection_end_game.HangHigh = "False";
                data_collection_end_game.HangMid = "False";
                data_collection_end_game.HangLow = "False";
                data_collection_end_game.AttemptedHang = "False";
                data_collection_end_game.NoAttempt = "False";
                data_collection_end_game.FellOffRung = "False";
                data_collection_end_game.Robot_Tipped = "False";
                data_collection_end_game.Robot_Stalled = "False";
                Intent startintent = new Intent(getApplicationContext(), Data_Collection_Page_1.class);
                startActivity(startintent);
            }
        });
        //----------------------------------------------------------------------------------------------------------------

        /*
        //Below to dotted line defines the needed button and are used to bring you to the instruction page
        Button Instruct_Button = (Button) findViewById(R.id.Instructions);
        Instruct_Button.setOnClickListener(new View.OnClickListener()
        { //Makes onclick listener for button
            @Override
            public void onClick(View v) {
                Intent startintent = new Intent(getApplicationContext(), Instructions_Page.class);
                startActivity(startintent);
            }
        });
        //----------------------------------------------------------------------------------------------------------------
    */
    }
}