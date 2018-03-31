package org.learning.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "app_timestamp")
public class AppTimestamp {
  
  @Id
  @SequenceGenerator(name = "app_timestamp_id_gen", initialValue = 1)
  @GeneratedValue(generator = "app_timestamp_id_gen", strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;
  
  @Column(name = "app_timestamp")
  private Date appTimestamp;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public Date getAppTimestamp() {
    return appTimestamp;
  }
  
  public void setAppTimestamp(Date appTimestamp) {
    this.appTimestamp = appTimestamp;
  }
  
  @Override
  public String toString() {
    return "AppTimestamp{" +
      "id=" + id +
      ", appTimestamp=" + appTimestamp +
      '}';
  }
}
