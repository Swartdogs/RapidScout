package swart525.dw.md.scout.space.a525spacescout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class data_Collection_sandstorm extends AppCompatActivity {

    //Defines variables for use
    public static String Taxi_Yes = "False";
    public static String Taxi_No = "False";
    public static String HumanPlayerScore = "False";
    public static String HumanPlayerMiss = "False";
    public static String HumanPlayerNone = "False";
    public static String HumanPlayerMultiple = "False";
    public static String AutoUpperhubScore = "0";
    public static String AutoUpperhubMiss = "0";
    public static String AutoLowerhubScore = "0";
    public static String AutoLowerhubMiss = "0";
    public static String Add_AutoUpperhubScore = "0";
    public static String Add_AutoUpperhubMiss = "0";
    public static String Add_AutoLowerhubScore = "0";
    public static String Add_AutoLowerhubMiss = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__collection_sandstorm);

        //Defines all checkboxes for positions
        final RadioButton TaxiYesRB = (RadioButton) findViewById(R.id.Auto_Taxi_Yes_RB);
        final RadioButton TaxiNoRB = (RadioButton) findViewById(R.id.Auto_Taxi_No_RB);
        final RadioButton HumanPlayerScoreRB = (RadioButton) findViewById(R.id.Auto_HumanPlayerScore_RB);
        final RadioButton HumanPlayerMissRB = (RadioButton) findViewById(R.id.Auto_HumanPlayerMiss_RB);
        final RadioButton HumanPlayerNoneRB = (RadioButton) findViewById(R.id.Auto_HumanPlayerNone_RB);

        final CheckBox HumanPlayerMultipleCB = (CheckBox) findViewById(R.id.Auto_HumanPlayerMultiple_CB);


        //Defines "Elegant" Number Blocks
        final ElegantNumberButton AutoUpperhubScoreEB = (ElegantNumberButton) findViewById(R.id.Auto_Upperhub_Score_EB);
        final ElegantNumberButton AutoUpperhubMissEB = (ElegantNumberButton) findViewById(R.id.Auto_Upperhub_Miss_EB);
        final ElegantNumberButton AutoLowerhubScoreEB = (ElegantNumberButton) findViewById(R.id.Auto_Lowerhub_Score_EB);
        final ElegantNumberButton AutoLowerMissEB = (ElegantNumberButton) findViewById(R.id.Auto_Lowerhub_Miss_EB);


        //Defines and implements Button to continue along with variable savings
        Button To_Teleop = (Button) findViewById(R.id.To_Teleop);
        To_Teleop.setOnClickListener(new View.OnClickListener()
        { //Makes onclick listener for button
            @Override
            public void onClick(View v) {

                AutoUpperhubScore = Integer.toString(Integer.parseInt(AutoUpperhubScoreEB.getNumber()) + Integer.parseInt(data_Collection_sandstorm.Add_AutoUpperhubScore));
                AutoUpperhubMiss = Integer.toString(Integer.parseInt(AutoUpperhubMissEB.getNumber()) + Integer.parseInt(data_Collection_sandstorm.Add_AutoUpperhubMiss));
                AutoLowerhubScore = Integer.toString(Integer.parseInt(AutoLowerhubScoreEB.getNumber()) + Integer.parseInt(data_Collection_sandstorm.Add_AutoLowerhubScore));
                AutoLowerhubMiss = Integer.toString(Integer.parseInt(AutoLowerMissEB.getNumber()) + Integer.parseInt(data_Collection_sandstorm.Add_AutoLowerhubMiss));

                /*add in data collection pieces from checkboxes*/
                if (TaxiYesRB.isChecked()) {
                    Taxi_Yes = "True";
                }
                if (TaxiNoRB.isChecked()) {
                    Taxi_No = "True";
                }
                if (HumanPlayerScoreRB.isChecked()) {
                    HumanPlayerScore = "True";
                }
                if (HumanPlayerMissRB.isChecked()) {
                    HumanPlayerMiss = "True";
                }
                if (HumanPlayerNoneRB.isChecked()) {
                    HumanPlayerNone = "True";
                }
                if (HumanPlayerMultipleCB.isChecked()) {
                    HumanPlayerMultiple = "True";
                }





                Intent startintent = new Intent(getApplicationContext(), data_collection_TeleOP.class);
                startActivity(startintent);
            }
        });

    }

}
