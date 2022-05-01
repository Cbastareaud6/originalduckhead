package com.cathybastareaud.originalduckhead.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.cathybastareaud.originalduckhead.entity.Weather;
import io.reactivex.rxjava3.core.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface WeatherDao {





    @Insert
    Single<Long> insert(Weather weather);

    @Insert
    Single<List<Long>> insert(Weather... weathers);

    @Insert
    Single<List<Long>> insert(Collection<Weather> weathers);

    @Update
    Single<Integer> update(Weather weather);

    @Update
    Single<Integer> update(Weather... weathers);

    @Update
    Single<Integer> update(Collection<Weather> weathers);

    @Delete
    Single<Integer> delete(Weather weather);

    @Delete
    Single<Integer> delete(Weather... weathers);

    @Delete
    Single<Integer> delete(Collection<Weather> weathers);

    @Query("SELECT * FROM weather WHERE `weather-id` = :id")
    LiveData<Weather> select(long id);

    @Query("SELECT * FROM weather ORDER BY created ASC")
    LiveData<List<Weather>> select();

    @Query("SELECT * FROM weather WHERE `weather-id` = :userId ORDER BY created DESC")
    LiveData<List<Weather>> selectByUser(long userId);

  }



