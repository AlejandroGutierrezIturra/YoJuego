package cl.ejemplo.yojuego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Mostrar extends AppCompatActivity {

    RecyclerView recyclerViewPersona;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        recyclerViewPersona =(RecyclerView)findViewById(R.id.recycler);
        recyclerViewPersona.setLayoutManager(new LinearLayoutManager(this));

        //TODO: realizar metodo mostrar para llenar la lista de personas
        customAdapter = new CustomAdapter(mostrar());
        recyclerViewPersona.setAdapter(customAdapter);

    }

    private List<Jugador> mostrar() {
        List<Jugador> lista = new ArrayList<>();
        AdminSqLiteOpenHelper bd =
                new AdminSqLiteOpenHelper(this, "adm", null, 1);
        SQLiteDatabase ldb = bd.getReadableDatabase();

        Cursor fila= ldb.rawQuery("select rut, nombre, edad from persona", null);
        while (fila.moveToNext()){
            lista.add(new Jugador(fila.getString(0),
                    fila.getString(1),
                    fila.getInt(2)));
        }
        ldb.close();
        return lista;
    }


}





