package swart525.dw.md.scout.space.a525spacescout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Data_Collection_Page_1 extends AppCompatActivity {

    //Defines Variables for Match/Team Number
    public static int Team_Num = 0;
    public static int Match_Num = 0;
    public static String Initials = "We got a runner";
    public static String StartLocation1 = "False";
    public static String StartLocation2 = "False";
    public static String StartLocation3 = "False";
    public static String StartLocation4 = "False";
    public static String StartUnknown = "False";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__collection__page_1);

        //Sets up comparison numbers
        final int Compare_Match_Num = 150; //Match must be less than 150
        final int Compare_Team_Num = 1; //Team must be greater than 1

        //Defines text boxes for Match/Team Number
        final EditText Match_Num_txt = (EditText) findViewById(R.id.Match_Num_Txt);
        final EditText Team_Num_txt = (EditText) findViewById(R.id.Team_Num_txt);
        final EditText Initials_txt = (EditText) findViewById(R.id.Init_Txt);

        //Defines all RadioButtons for positions
        final RadioButton StartLocation1RB = (RadioButton) findViewById(R.id.StartLocation1_RB);
        final RadioButton StartLocation2RB = (RadioButton) findViewById(R.id.StartLocation2_RB);
        final RadioButton StartLocation3RB = (RadioButton) findViewById(R.id.StartLocation3_RB);
        final RadioButton StartLocation4RB = (RadioButton) findViewById(R.id.StartLocation4_RB);
        final RadioButton StartUnknownRB = (RadioButton) findViewById(R.id.StartUnknown_RB);

        //Defines button needed and actions to cancel a data collection
        Button Cancel_Collection = (Button) findViewById(R.id.Cancel_Collection_B);
        Cancel_Collection.setOnClickListener(new View.OnClickListener() { //Makes onclick listener for button
            @Override
            public void onClick(View v) {
                Intent startintent = new Intent(getApplicationContext(), Start_Page.class);
                startActivity(startintent);
            }
        });
        //Defines Start button and takes to next page as well as recording data
        Button Start_Collection = (Button) findViewById(R.id.Start_Collection);
        Start_Collection.setOnClickListener(new View.OnClickListener() { //Makes onclick listener for button
            @Override
            public void onClick(View v) {
                if(Initials_txt.getText().toString().isEmpty() || Team_Num_txt.getText().toString().isEmpty() || Match_Num_txt.getText().toString().isEmpty()) {
                    Toast.makeText(Data_Collection_Page_1.this, "Cannot Continue. Please Enter ALL Information!", Toast.LENGTH_LONG).show();
                }else{
                    int Team_Num_Real = Integer.parseInt(Team_Num_txt.getText().toString());
                    int Match_Num_Real = Integer.parseInt(Match_Num_txt.getText().toString());
                    if(Compare_Match_Num > Match_Num_Real) {
                        if(Compare_Team_Num < Team_Num_Real){
                            Team_Num = Integer.parseInt(Team_Num_txt.getText().toString()); //Sets team num data to txt box information
                            Match_Num = Integer.parseInt(Match_Num_txt.getText().toString()); //Sets match num data to txt box information
                            Initials = Initials_txt.getText().toString();
                            Intent startintent = new Intent(getApplicationContext(), data_Collection_sandstorm.class);
                            startActivity(startintent);
                        }else{
                            Toast.makeText(Data_Collection_Page_1.this, "Did you make a mistake? Please make sure Team Number and Match Number aren't flipped.", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(Data_Collection_Page_1.this, "Did you make a mistake? Please make sure Team Number and Match Number aren't flipped.", Toast.LENGTH_LONG).show();
                    }

                }
                if (StartLocation1RB.isChecked()) {
                    StartLocation1 = "True";

                }
                if (StartLocation2RB.isChecked()) {
                    StartLocation2 = "True";
                }
                if (StartLocation3RB.isChecked()) {
                    StartLocation3 = "True";
                }
                if (StartLocation4RB.isChecked()) {
                    StartLocation4 = "True";
                }
                if (StartUnknownRB.isChecked()) {
                    StartUnknown = "True";
                }
            }
        });
    }
}
