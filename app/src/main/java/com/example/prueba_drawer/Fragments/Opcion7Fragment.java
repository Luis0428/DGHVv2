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

public class Opcion7Fragment extends Fragment {
    protected EditText Diagonal1,Diagonal2;
    protected TextView Area,Perimetro;
    protected Button BtnResolver,BtnLimpiar;
    protected View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.opcion7,container,false);

        Diagonal1 = view.findViewById(R.id.editText3);
        Diagonal2 = view.findViewById(R.id.editText21);
        Area = view.findViewById(R.id.textView32);
        Perimetro = view.findViewById(R.id.textView56);
        BtnResolver = view.findViewById(R.id.button11);
        BtnLimpiar = view.findViewById(R.id.button12);

        BtnResolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String D1 = Diagonal1.getText().toString();
                String D2 = Diagonal2.getText().toString();
                if(!D1.isEmpty() && !D2.isEmpty()){
                    float Diagonal1R = Float.parseFloat(D1);
                    float Diagonal2R = Float.parseFloat(D2);
                    float AreaRombo= (Diagonal1R*Diagonal2R)/2;
                    float LadoRombo = (float) Math.sqrt(((Diagonal1R/2)*(Diagonal1R/2)) + ((Diagonal2R/2)*(Diagonal2R/2)));
                    float PerimetroRombo = LadoRombo*4;
                    Area.setText(String.valueOf(AreaRombo));
                    Perimetro.setText(String.valueOf(PerimetroRombo));
                }else if(D1.isEmpty() && !D2.isEmpty()){
                    Snackbar.make(getView(),"Hace falta introducir la diagonal 1", Snackbar.LENGTH_LONG).show();
                }else if(!D1.isEmpty() && D2.isEmpty()){
                    Snackbar.make(getView(),"Hace falta introducir la diagonal 2", Snackbar.LENGTH_LONG).show();
                }else if(D1.isEmpty() && D2.isEmpty()){
                    Snackbar.make(getView(),"Hace falta introducir la diagonal 1 y 2", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        BtnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Diagonal1.setText("");
                Diagonal2.setText("");
                Area.setText("");
                Perimetro.setText("");
            }
        });

        return view;
    }
}
