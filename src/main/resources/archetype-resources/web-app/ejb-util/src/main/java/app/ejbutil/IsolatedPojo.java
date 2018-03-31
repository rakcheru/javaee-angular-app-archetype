package org.learning.app.ejbutil;

import javax.inject.Inject;

public class IsolatedPojo {
  
  public IsolatedPojo() {
    System.out.println("IsolatedPojo.IsolatedPojo");
  }
  
  @Inject
  MyConstants myConstants;
  
}
