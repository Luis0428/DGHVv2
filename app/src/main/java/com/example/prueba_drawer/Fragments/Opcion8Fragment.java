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
import com.google.android.material.snackbar.Snackbar;

public class Opcion8Fragment extends Fragment {

    protected EditText Radio ;
    protected TextView Area,Perimetro;
    protected Button BtnResolver,BtnLimpiar;
    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.opcion8,container,false);
        Radio = view.findViewById(R.id.editText21);
        Area = view.findViewById(R.id.textView32);
        Perimetro = view.findViewById(R.id.textView56);
        BtnResolver = view.findViewById(R.id.button11);
        BtnLimpiar = view.findViewById(R.id.button12);

        BtnResolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String R = Radio.getText().toString();
                if(!R.isEmpty()){
                    float RadioCirculo = Float.parseFloat(R);
                    float AreaCirculo = (float)(3.1415*Math.pow(RadioCirculo,2));
                    float PerimetroCirculo = (float) (2*3.1415*RadioCirculo);
                    Area.setText(String.valueOf(AreaCirculo));
                    Perimetro.setText(String.valueOf(PerimetroCirculo));
                }else if(R.isEmpty()){
                    Snackbar.make(getView(),"Falta colocar el radio del circulo",Snackbar.LENGTH_LONG).show();
                }
            }
        });

        BtnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Radio.setText("");
                Area.setText("");
                Perimetro.setText("");
            }
        });
        return view;
    }
}
