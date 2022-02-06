package swart525.dw.md.scout.space.a525spacescout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;


//After the first competition, we decided to only count the inner and outer
//goals as the top goal instead of separating them. When scouting, it was too
//hard to distinguish whether it hit the inner or outer.

//We also decided we did not need the cycle time data, so the Cycle Counter
//buttons were deleted. The same was true for the Crossing through the shield generator.

//The code for the above deleted was commented and not deleted.

public class data_collection_TeleOP extends AppCompatActivity {

    //Defines variables for data collection

    public static String CargoDefense = "False";
    public static String DefenseFouls = "False";
    public static String NoDefense = "False";
    public static String CargoWrongColor = "False";
    public static String RobotDefense = "False";
    public static String TeleUpperhubScore = "0";
    public static String TeleUpperhubMiss = "0";
    public static String TeleLowerhubScore = "0";
    public static String TeleLowerhubMiss = "0";
    public static String Add_TeleUpperhubScore = "0";
    public static String Add_TeleUpperhubMiss = "0";
    public static String Add_TeleLowerhubScore = "0";
    public static String Add_TeleLowerhubMiss = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection__tele_op);

        //Defines all checkboxes
        final CheckBox CargoWrongColorCB = (CheckBox) findViewById(R.id.Tele_CargoWrongColor_CB);
        final CheckBox CargoDefenseCB = (CheckBox) findViewById(R.id.Tele_CargoDefense_CB);
        final CheckBox RobotDefenseCB = (CheckBox) findViewById(R.id.Tele_RobotDefense_CB);
        final CheckBox NoDefenseCB = (CheckBox) findViewById(R.id.Tele_NoDefense_CB);
        final CheckBox DefenseFoulsCB = (CheckBox) findViewById(R.id.Tele_DefenseFouls_CB);
        //final RadioButton Cycle1PowerCell = (RadioButton) findViewById(R.id.PowerCellCycle1RadioButton);
        //final RadioButton Cycle2_3PowerCell = (RadioButton) findViewById(R.id.PowerCellCycle2_3RadioButton);
        //final RadioButton Cycle4_5PowerCell = (RadioButton) findViewById(R.id.CellCycle4_5RadioButton);

        //Defines "Elegant" Number Blocks
        final ElegantNumberButton TeleUpperhubScoreEB = (ElegantNumberButton) findViewById(R.id.Tele_Upperhub_Score_EB);
        final ElegantNumberButton TeleUpperhubMissEB = (ElegantNumberButton) findViewById(R.id.Tele_Upperhub_Miss_EB);
        final ElegantNumberButton TeleLowerhubScoreEB = (ElegantNumberButton) findViewById(R.id.Tele_Lowerhub_Score_EB);
        final ElegantNumberButton TeleLowerhubMissEB = (ElegantNumberButton) findViewById(R.id.Tele_Lowerhub_Miss_EB);


        //Below defines the button and commands for saving data and switching pages
        Button To_EndGame = (Button) findViewById(R.id.To_Endgame_B);
        To_EndGame.setOnClickListener(new View.OnClickListener()
        { //Makes onclick listener for button
            @Override
           public void onClick(View v) {

                TeleUpperhubScore = Integer.toString(Integer.parseInt(TeleUpperhubScoreEB.getNumber()) + Integer.parseInt(data_collection_TeleOP.Add_TeleUpperhubScore));
                TeleUpperhubMiss = Integer.toString(Integer.parseInt(TeleUpperhubMissEB.getNumber()) + Integer.parseInt(data_collection_TeleOP.Add_TeleUpperhubMiss));
                TeleLowerhubScore = Integer.toString(Integer.parseInt(TeleLowerhubScoreEB.getNumber()) + Integer.parseInt(data_collection_TeleOP.Add_TeleLowerhubScore));
                TeleLowerhubMiss= Integer.toString(Integer.parseInt(TeleLowerhubMissEB.getNumber()) + Integer.parseInt(data_collection_TeleOP.Add_TeleLowerhubMiss));




                if (CargoWrongColorCB.isChecked()) {
                    CargoWrongColor = "True";
                }
                if (CargoDefenseCB.isChecked()) {
                    CargoDefense = "True";
                }
                if (RobotDefenseCB.isChecked()) {
                    RobotDefense = "True";
                }
                if (NoDefenseCB.isChecked()) {
                    NoDefense = "True";
                }
                if (DefenseFoulsCB.isChecked()) {
                    DefenseFouls = "True";
                }


                    Intent startintent = new Intent(getApplicationContext(), data_collection_end_game.class);
                    startActivity(startintent);
                }

        });
    }
}
