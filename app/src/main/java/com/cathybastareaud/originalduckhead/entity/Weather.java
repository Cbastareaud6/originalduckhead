package com.cathybastareaud.originalduckhead.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "weather")
public class Weather {

  @PrimaryKey
  @ColumnInfo(name = "weather-id")
  private long id;

  private String city = "";

  private int temp;

  private int humidity;

  private boolean rain;

  private boolean snow;

  private long longitude;

  private long latitude;

  private Date created;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getTemp() {
    return temp;
  }

  public void setTemp(int temp) {
    this.temp = temp;
  }

  public int getHumidity() {
    return humidity;
  }

  public void setHumidity(int humidity) {
    this.humidity = humidity;
  }

  public boolean isRain() {
    return rain;
  }

  public void setRain(boolean rain) {
    this.rain = rain;
  }

  public boolean isSnow() {
    return snow;
  }

  public void setSnow(boolean snow) {
    this.snow = snow;
  }

  public long getLongitude() {
    return longitude;
  }

  public void setLongitude(long longitude) {
    this.longitude = longitude;
  }

  public long getLatitude() {
    return latitude;
  }

  public void setLatitude(long latitude) {
    this.latitude = latitude;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }
}
