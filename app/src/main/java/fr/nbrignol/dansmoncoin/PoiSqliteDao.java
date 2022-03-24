package fr.nbrignol.dansmoncoin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PoiSqliteDao extends SQLiteOpenHelper implements PoiDaoInterface {

    public PoiSqliteDao(Context context) {
        super(context, "poi0.db", null, 1);
        Log.d("DB", "Opening poi.db");
    }

    @Override
    public void init(PoiDaoListener listener) {
        fetchAll();
    }

    @Override
    public Poi getPoi(int index) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("DB", "Creating DB table...");
        String query = "CREATE TABLE Poi ( title TEXT, latitude REAL, longitude REAL )";
        db.execSQL(query);

        initBasePoiList(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("DB", "Upgrading DB table...");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        Log.d("DB", "Upgrading DB table...");
    }

    public void addPoi(SQLiteDatabase db, Poi poi) {
        ContentValues values = new ContentValues();
        values.put("title", poi.getTitle());
        values.put("latitude", poi.getLatitude());
        values.put("longitude", poi.getLongitude());

        db.insert("Poi", null, values);
    }

    protected void initBasePoiList(SQLiteDatabase db){
        Log.d("DB", "Populating DB table...");

        addPoi(db, new Poi("Le super portail de l'IUT"));
        addPoi(db, new Poi("La salle de classe"));
        addPoi(db, new Poi("Le resto U"));

    }

    protected void fetchAll(){
        String table = "Poi";

        String[] columns = new String[] {
                "title",
                "latitude",
                "longitude"
        };



        Cursor cursor = this.getReadableDatabase().query(
                table, columns,
                null, null, null, null, null);

        while(cursor.moveToNext()) {
            Log.d("DB", cursor.getString(0));
        }
    }
}
