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

        dp.updateDate(2019, 5, 1);
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

                Context context = MainActivity.this;
                CharSequence text = "Name: " + name + "\nMobile Number: " + number + "\nNo. of Pax: " + pax + "\nDate: " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1 ) + "/" + dp.getYear() + "\nTime: " +  ( "Time is "+  tp.getCurrentHour() + ":" + tp.getCurrentMinute()) + "\nTable: " + cbMsg;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020, 5, 15);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

                nameInput.setText("");
                numInput.setText("");
                paxInput.setText("");
                cbEnabled.setChecked(!cbEnabled.isChecked());
            }
        });
    }
}
