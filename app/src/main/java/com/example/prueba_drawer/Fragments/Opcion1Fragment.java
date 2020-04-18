package com.example.prueba_drawer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.prueba_drawer.R;

public class Opcion1Fragment extends Fragment {

    protected EditText ed_a, ed_b, ed_c;
    protected TextView tv_x1, tv_x2;
    protected View vista;
    protected Button btnResolver, btnLimpiar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.opcion1,container,false);

        ed_a = vista.findViewById(R.id.editText);
        ed_b = vista.findViewById(R.id.editText2);
        ed_c = vista.findViewById(R.id.editText3);
        tv_x1 = vista.findViewById(R.id.textView13);
        tv_x2 = vista.findViewById(R.id.textView14);
        btnResolver = vista.findViewById(R.id.button);
        btnLimpiar = vista.findViewById(R.id.button2);

        btnResolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                float a = Float.parseFloat(ed_a.getText().toString());
                float b = Float.parseFloat(ed_b.getText().toString());
                float c = Float.parseFloat(ed_c.getText().toString());

                float sqrt, x1, x2, tmp;
                tmp = (b * b) - (4 * a * c);
                if(tmp > 0)
                {
                    sqrt = (float) Math.sqrt(tmp);
                    x1 = (float) ((-b + sqrt) / (2 * a));
                    x2 = (float) ((-b - sqrt) / (2 * a));

                    tv_x1.setText(String.valueOf(x1));
                    tv_x2.setText(String.valueOf(x2));
                }
                else
                {
                    sqrt = (float) Math.sqrt(-tmp);
                    sqrt = sqrt / (2 * a);
                    x1 = (-b) / 2 * a;
                    String real = (x1 == 0) ? "" : String.valueOf(x1);
                    String img1 = (sqrt == 1) ? "i" : " + " + String.valueOf(sqrt) + "i";
                    String img2 = (sqrt == 1) ? "-i" : " - " + String.valueOf(sqrt) + "i";

                    String m1 = real + img1;
                    String m2 = real + img2;
                    tv_x1.setText(m1);
                    tv_x2.setText(m2);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_a.setText("");
                ed_b.setText("");
                ed_c.setText("");
                tv_x1.setText("");
                tv_x2.setText("");
            }
        });

        return vista;
    }
    public void mResolver(View view)
    {
        float a = Float.parseFloat(ed_a.getText().toString());
        float b = Float.parseFloat(ed_b.getText().toString());
        float c = Float.parseFloat(ed_c.getText().toString());

        float sqrt, x1, x2, tmp;
        tmp = (b * b) - (4 * a * c);
        if(tmp < 0)
        {
            sqrt = (float) Math.sqrt(tmp);
            x1 = (float) ((-b + sqrt) / (2 * a));
            x2 = (float) ((-b - sqrt) / (2 * a));

            tv_x1.setText(String.valueOf(x1));
            tv_x2.setText(String.valueOf(x2));
        }
        else
        {
            sqrt = (float) Math.sqrt(-tmp);
            sqrt = sqrt / (2 * a);
            x1 = (-b) / 2 * a;
            String m1 = String.valueOf(x1) + " + " + String.valueOf(sqrt) + "i";
            String m2 = String.valueOf(x1) + " - " + String.valueOf(sqrt) + "i";
            tv_x1.setText(m1);
            tv_x2.setText(m2);
        }

    }
    public void mLimpiar(View view)
    {
        ed_a.setText("");
        ed_b.setText("");
        ed_c.setText("");
    }

}
