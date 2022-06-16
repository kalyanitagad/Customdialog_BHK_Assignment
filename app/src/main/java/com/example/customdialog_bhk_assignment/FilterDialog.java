package com.example.customdialog_bhk_assignment;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class FilterDialog extends Dialog {

    private TextView txtPriceRange;
    private CheckBox checkOneBhk,checkTwoBhk,checkThreeBhk;
    private Button btnOk;
    private SeekBar seekbarPrice;

    public interface onFilterlistener
    {
        void onSucess();
    }

    private onFilterlistener onFilterlistener;
    public void setOnFilterlistener(onFilterlistener onFilterlistener)
    {
        this.onFilterlistener = onFilterlistener;
    }

    public FilterDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_layout);
        initViews();
        initListener();

        seekbarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                txtPriceRange.setText(""+String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void initViews()
    {
        txtPriceRange = findViewById(R.id.txtPricerange);
        checkOneBhk = findViewById(R.id.checkOneBhk);
        checkTwoBhk = findViewById(R.id.checktwoBhk);
        checkThreeBhk = findViewById(R.id.checkthreeBhk);
        seekbarPrice = findViewById(R.id.seekbarprice);
        btnOk = findViewById(R.id.btnOk);
    }
    private void initListener()
    {
        btnOk.setOnClickListener(new btnOkListener());
    }
    private class btnOkListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            onFilterlistener.onSucess();
            dismiss();

        }
    }
}
