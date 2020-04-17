package com.example.prueba_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.prueba_drawer.Fragments.Opcion1Fragment;
import com.example.prueba_drawer.Fragments.Opcion2Fragment;
import com.example.prueba_drawer.Fragments.Opcion3Fragment;
import com.example.prueba_drawer.Fragments.Opcion4Fragment;
import com.example.prueba_drawer.Fragments.Opcion5Fragment;
import com.example.prueba_drawer.Fragments.Opcion6Fragment;
import com.example.prueba_drawer.Fragments.Opcion7Fragment;
import com.example.prueba_drawer.Fragments.Opcion8Fragment;
import com.example.prueba_drawer.Fragments.PrincipalFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    protected DrawerLayout DL;
    protected ActionBarDrawerToggle ActionBDT;
    protected Toolbar toolbar;
    NavigationView navigationView;
    //Variables para cargar el fragment principal

    protected FragmentManager FM;
    protected FragmentTransaction FT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DL = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navegacionView);

        //establecer evento onclick al navigationView
        navigationView.setNavigationItemSelectedListener(this);

        ActionBDT = new ActionBarDrawerToggle(this,DL,toolbar, R.string.open, R.string.close);
        DL.addDrawerListener(ActionBDT);
        ActionBDT.setDrawerSlideAnimationEnabled(true);
        ActionBDT.syncState();

        //Cargar Fragment Principal
        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.add(R.id.contenido, new PrincipalFragment());
        FT.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.opciones, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        if(opcion_menu.getItemId() == R.id.info){
            Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        DL.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId() == R.id.Inicio){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new PrincipalFragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia1){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion1Fragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia2){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion2Fragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia3){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion3Fragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia4){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion4Fragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia5){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion5Fragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia6){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion6Fragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia7){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion7Fragment());
            FT.commit();
        }else if(menuItem.getItemId() == R.id.Materia8){
            FM = getSupportFragmentManager();
            FT = FM.beginTransaction();
            FT.replace(R.id.contenido, new Opcion8Fragment());
            FT.commit();
        }
        return false;
    }
}
