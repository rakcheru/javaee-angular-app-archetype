package org.learning.app.repository;

import org.learning.app.model.AppTimestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class AppTimestampRepository {
  
  
  @PersistenceContext(unitName = "app-template-pu")
  EntityManager entityManager;
  
  public AppTimestamp create() {
    AppTimestamp appTimestamp = new AppTimestamp();
    appTimestamp.setAppTimestamp(new Date());
    entityManager.persist(appTimestamp);
    return appTimestamp;
  }
  
  public List<AppTimestamp> findAll() {
    TypedQuery<AppTimestamp> typedQuery = entityManager.createQuery(
      "select o from AppTimestamp o order by id desc", AppTimestamp.class);
    
    return typedQuery.getResultList();
  }
}
