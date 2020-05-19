package ie.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ie.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    private Button donateButton;
    private RadioGroup      paymentMethod;
    private ProgressBar     progressBar;
    private TextView money, total;

    private int             totalDonated = 0;
    int amount ;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        total = (TextView)findViewById(R.id.total);
        money = (TextView)findViewById(R.id.textMoney);
        money.setText("0");

        donateButton =(Button) findViewById(R.id.donateButton);
        if(donateButton != null){
            Log.v("Donate", "Really got the donate button");
        }

        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);

        progressBar.setMax(1000);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuReport : startActivity (new Intent(this, Report.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void donateButtonPressed (View view)
    {

        int radioId = paymentMethod.getCheckedRadioButtonId();
        String method = radioId == R.id.SberCassa ? "Сберкасса" : "Наличка";

        totalDonated = totalDonated + amount;
        progressBar.setProgress(totalDonated);

        total.setText("Total - [" + String.valueOf(totalDonated) + "]");
        Log.v("Donate", "₴ " + amount + ", method: " + method);
        Log.v("Donate", "Current total " + totalDonated);
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        money.setText(String.valueOf(seekBar.getProgress()));
        amount = seekBar.getProgress();
    }
}
