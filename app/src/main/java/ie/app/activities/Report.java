package ie.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ie.app.R;

public class Report extends AppCompatActivity
{
    ListView listView;

    static final String[] numbers = new String[] {
            "100, PayPal",
            "10,     Direct",
            "100,    PayPal",
            "1000,   PayPal",
            "10,     Direct",
            "5000,   PayPal"};

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        listView = (ListView) findViewById(R.id.reportList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(adapter);
    }
}