package srv;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import entities.Bitacora;
import entities.PlantaVO;

/**
 * Created by ddelacruz on 20/10/2016.
 */

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "/sdcard/oleana.db";
    public static final int VERSION = 1;

    public DataBase(Context context) {
        super(context, DataBase.DATABASE_NAME, null, DataBase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder estados = new StringBuilder();
        estados.append("CREATE TABLE estados (")
                .append("ID INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append("ESTADO TEXT NOT NULL)");


        StringBuilder bitacora = new StringBuilder();
        bitacora.append("CREATE TABLE bitacora(")
                .append("   ID INTEGER PRIMARY KEY AUTOINCREMENT,")
                .append("   FECHA DATE NOT NULL,")
                .append("   DESCRIPCION TEXT NOT NULL,")
                .append("   ESTADO TEXT NOT NULL)");

        db.execSQL(estados.toString());
        db.execSQL(bitacora.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS estados");
        db.execSQL("DROP TABLE IF EXISTS bitacora");
        onCreate(db);
    }

    public boolean insertarBitacora(Bitacora bitacora) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("fecha", String.valueOf(bitacora.getFecha()));
        contentValues.put("descripcion", bitacora.getDescripcion());
        contentValues.put("estado", bitacora.getEstado());

        db.insertOrThrow("bitacora", null, contentValues);
        return true;
    }
}
