package com.example.customdialog_bhk_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnFilter;
    private TextView txtFilterMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListener();

    }
    private void initViews()
    {
        btnFilter = findViewById(R.id.btnFilter);
        txtFilterMessage =findViewById(R.id.txtFilterMessage);
    }


    private  void initListener()
    {
        btnFilter.setOnClickListener(new btnFilterClickListener());
    }
    private class btnFilterClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
        FilterDialog filterDialog = new FilterDialog(MainActivity.this);
        filterDialog.setOnFilterlistener(new FilterActions());
        filterDialog.show();
        }
    }
    private  class FilterActions implements FilterDialog.onFilterlistener
    {

        @Override
        public void onSucess() {
          txtFilterMessage.setText(" Empty Section");
        }
    }
}