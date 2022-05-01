package com.cathybastareaud.originalduckhead.service;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.cathybastareaud.originalduckhead.dao.WeatherDao;
import com.cathybastareaud.originalduckhead.entity.Weather;
import com.cathybastareaud.originalduckhead.service.OriginalDuckHeadDatabase.Converters;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Date;

@Database(
    entities = {Weather.class},
    version = 1
)
@TypeConverters({Converters.class})
public abstract class OriginalDuckHeadDatabase extends RoomDatabase {


  private static final String DB_NAME = "originalduckhead-db";

  private static Application context;

  /**
   * Sets the context of the database.
   *
   * @param context
   */
  public static void setContext(Application context) {
    OriginalDuckHeadDatabase.context = context;
  }

  /**
   * Retrieves an instance of the {@link OriginalDuckHeadDatabase}
   *
   * @return
   */
  public static OriginalDuckHeadDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Retrieves the {@link WeatherDao}
   *
   * @return
   */
  public abstract WeatherDao getWeatherDao();


  private static class InstanceHolder {

    private static final OriginalDuckHeadDatabase INSTANCE = Room
        .databaseBuilder(context, OriginalDuckHeadDatabase.class, DB_NAME)
        .addCallback(new OriginalDuckHeadDatabase.Callback())
        .build();
  }

  private static class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      Weather weather = new Weather();
      weather.setCity("Test city");
      getInstance()
          .getWeatherDao()
          .insert(weather)
          .subscribeOn(Schedulers.io())
          .subscribe();
    }

  }

  /**
   * Date and time converters
   */
  public static class Converters {

    @TypeConverter
    public static Long toLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date toDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }
}





