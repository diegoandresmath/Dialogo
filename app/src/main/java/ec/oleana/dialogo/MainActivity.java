package ec.oleana.dialogo;

import android.app.Dialog;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import srv.DataBase;

public class MainActivity extends AppCompatActivity {
    private DataBase dataBase;
    private Button btnDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dataBase = new DataBase(this);

        btnLanzarDialogo();
    }

    public void btnLanzarDialogo() {
        Log.d("DLC", "MainActivity.btnLanzarDialogo");
        btnDialogo = (Button) findViewById(R.id.btnDialogo);
        btnDialogo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("DLC", "MainActivity.btnLanzarDialogo.onClick");
                        srv.Dialog dialog = new srv.Dialog();
                        dialog.show(getSupportFragmentManager(),"DLC: MainActivity.btnLanzarDialogo");
                    }
                }
        );
    }
}
