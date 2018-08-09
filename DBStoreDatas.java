import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBStoreDatas extends SQLiteOpenHelper {

    private static final String DBNAME = "agendadb.s3db";
    private SQLiteDatabase db;
    private Context _context;

    public DBStoreDatas(Context context) {
        super(context, DBNAME, null, 1);
        this._context = context;
    }

    public DBStoreDatas(
            Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea la tabla una sola vez.
        db.execSQL("CREATE TABLE IF NOT EXISTS Agenda (id INTEGER PRIMARY KEY NOT NULL, "
            + "username TEXT NOT NULL, telephone TEXT NOT NULL, email TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No usado.
    }

    public ArrayList<Users> getList() {
        try {
            ArrayList<Users> data = new ArrayList<Users>();
            DBStoreDatas admin = new DBStoreDatas(_context, DBNAME, null, 1);
            db = admin.getReadableDatabase();
            String query = "SELECT * FROM Agenda ORDER By id ASC;";
            Cursor c = db.rawQuery(query, null);
            data.clear();
            if(c!=null || db!= null) {
                while(c.moveToNext()) {
                    data.add(
                        new Users(
                            c.getInt(0),
                            c.getString(1).trim(),
                            c.getString(2).trim(),
                            c.getString(3).trim()
                        )
                    );
                }
            }
            db.close();
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Users> getItem(int id) {
        try {
            ArrayList<Users> data = new ArrayList<Users>();
            DBStoreDatas admin = new DBStoreDatas(_context, DBNAME, null, 1);
            db = admin.getReadableDatabase();
            String query = String.format("SELECT * FROM Agenda WHERE id = %s;", id);
            Cursor c = db.rawQuery(query, null);
            data.clear();
            if(c!=null || db!= null) {
                while (c.moveToNext()) {
                    data.add(
                        new Users(
                            c.getInt(0),
                            c.getString(1).trim(),
                            c.getString(2).trim(),
                            c.getString(3).trim()
                        )
                    );
                }
            }
            db.close();
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    public long add(Users entityclassdata) {
        try {
            long retStatus = 0;
            DBStoreDatas ld = new DBStoreDatas(_context, DBNAME, null, 1);
            db = ld.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("username", entityclassdata.getUsername().trim());
            reg.put("telephone", entityclassdata.getTelephone().trim());
            reg.put("email", entityclassdata.getEmail().trim());
            retStatus = db.insert("Agenda", null,  reg);
            db.close();
            return retStatus;
        } catch (Exception ex) {
            return 0;
        }
    }

    public long delete(Users entityclassdata) {
        try {
            long retStatus = 0;
            DBStoreDatas ld = new DBStoreDatas(_context, DBNAME, null, 1);
            db = ld.getWritableDatabase();
            String[] args = { String.valueOf(entityclassdata.getId()) };
            retStatus = db.delete("Agenda", "id=?", args);
            db.close();
            return retStatus;
        } catch (Exception ex) {
            return 0;
        }
    }

    public long update(Users entityclassdata) {
        try {
            long retStatus = 0;
            DBStoreDatas ld = new DBStoreDatas(_context, DBNAME, null, 1);
            db = ld.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("username", entityclassdata.getUsername().trim());
            reg.put("telephone", entityclassdata.getTelephone().trim());
            reg.put("email", entityclassdata.getEmail().trim());
            String[] args = { String.valueOf(entityclassdata.getId()) };
            retStatus = db.update("Agenda", reg, "id=?", args);
            db.close();
            return retStatus;
        } catch (Exception ex) {
            return 0;
        }
    }
}
