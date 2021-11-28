package com.pqt.phamquangthanh.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> array_base;
    private Spinner spinner1,spinner2;

    private EditText number;
    private TextView result;
    private Button btnConvert;
    public static int fromBase=0,toBase=0;
    public static final char CHAR_55 = 55;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView();
        array_base = new ArrayList<>();
        array_base.add(2);
        array_base.add(8);
        array_base.add(10);
        array_base.add(16);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, array_base);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);

        this.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                onItemSelectedHandler(parent, view, position, id);
                fromBase = array_base.get(position);
                result.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                fromBase = 10;
                result.setText("");
            }
        });

        this.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toBase = array_base.get(position);
                result.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                toBase = 10;
                result.setText("");
            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (fromBase == 10) {
                        result.setText(convertFrom10(Integer.parseInt(number.getText().toString().trim())));
                    }
                    if(toBase == 10){
                        result.setText(ConvertTo10Front(number.getText().toString().trim()));
                    }
                    if(fromBase != 10 && toBase != 10){
                        String middle = ConvertTo10Front(number.getText().toString().trim());
                        result.setText(convertFrom10(Integer.parseInt(middle)));
                    }
                }
            }
        });

    }
    public void mapView(){
        spinner1   = (Spinner) findViewById(R.id.spinner_base_from);
        spinner2   = (Spinner) findViewById(R.id.spinner_base_to);
        number     = (EditText) findViewById(R.id.number);
        btnConvert = (Button) findViewById(R.id.btnConvert);
        result     = (TextView) findViewById(R.id.result);
    }
    public static String convertFrom10(int nunber) {
        if (nunber < 0 || toBase < 2 || toBase > 16 ) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int m;
        int remainder = nunber;

        while (remainder > 0) {
            if (nunber > 10) {
                m = remainder % toBase;
                if (m >= 10) {
                    sb.append((char) (CHAR_55 + m));
                } else {
                    sb.append(m);
                }
            } else {
                sb.append(remainder % toBase);
            }
            remainder = remainder / toBase;
        }
        return sb.reverse().toString();
    }
    public static String ConvertTo10Front(String FromNumber)
    {
        String result = "";

        int numresult = 0;

        int n = FromNumber.length();

        for (int i = 0; i < n;i++ )
        {   String m = Character.toString(FromNumber.charAt(i));

            int x=0;
            if (fromBase == 16)
            {
                if (m.equals("A")) x = 10;
                if (m.equals("B")) x = 11;
                if (m.equals("C")) x = 12;
                if (m.equals("D")) x = 13;
                if (m.equals("E")) x = 14;
                if (m.equals("F")) x = 15;
            }
            if (FromNumber.charAt(i) >= '0' && FromNumber.charAt(i) <='9') x = Integer.parseInt(m);

                numresult = numresult +  x * LuyThua(fromBase, n - i - 1);

        }

        result = numresult+"";
        return result;

    }
    public static int LuyThua(int num, int somu)
    {
        int result = num;

        for (int i = 1; i < somu; i++)
        {
            result = result * num;
        }

        if (somu == 0) result = 1;

        return result;
    }

}