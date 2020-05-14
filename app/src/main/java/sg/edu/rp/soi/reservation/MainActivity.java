package sg.edu.rp.soi.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput, numInput, paxInput;
    DatePicker dp;
    TimePicker tp;
    CheckBox cbEnabled;
    Button btnSubmit, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.etname);
        numInput = findViewById(R.id.etnum);
        paxInput = findViewById(R.id.etpax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbEnabled = findViewById(R.id.checkBox);
        btnSubmit = findViewById(R.id.btnsubmit);
        btnReset = findViewById(R.id.btnreset);

        dp.updateDate(2020, 5, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String number = numInput.getText().toString();
                String pax = paxInput.getText().toString();
                String cbMsg;

                if(cbEnabled.isChecked()) {
                    cbMsg = "Smoking Area";
                } else {
                    cbMsg = "Non-smoking Area";
                }
                String hour = tp.getCurrentHour().toString();

                String min = tp.getCurrentMinute().toString();



                if (hour.length() == 1){

                    hour = "0" + hour;

                }



                if (min.length() == 1) {

                    min = "0" + min;

                }



                if (name.isEmpty() || numInput.length() != 8 || paxInput.length() == 0){



                    Toast.makeText(MainActivity.this, "One or more of the information is empty", Toast.LENGTH_LONG).show();



                }else{



                    String firstName = "Name: " + nameInput.getText();

                    String secondPhone = "Phone: " + numInput.getText();

                    String thirdGuest = "No. Of Guest: " + paxInput.getText();

                    String date = "Date: " + dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();

                    String time = "Time: " + hour + ":" + min;

                    String smoking = "Smoking: " + cbMsg;



                    Toast.makeText(MainActivity.this, name + "\n" + number + "\n" + pax + "\n" + date + "\n" + time + "\n" + smoking, Toast.LENGTH_LONG).show();



                }







            }

        });
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker v, int hourOfDay, int min) {
               if(!(hourOfDay>=8 && hourOfDay<=20)){
                   Toast.makeText(MainActivity.this,"Timimg from 8am to 8:59.",Toast.LENGTH_LONG).show();
                   updateTime(8,0);
               }

            }
        });
btnReset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       reset();
    }
});


    }

    private void updateTime(int hour, int min) {
        tp.setCurrentMinute(min);
        tp.setCurrentHour(hour);
    }

    private void reset() {
        updateTime(19,30);
        dp.updateDate(2020,5,1);
        nameInput.setText("");
        paxInput.setText("");
        numInput.setText("");
        cbEnabled.setEnabled(false);
    }

}