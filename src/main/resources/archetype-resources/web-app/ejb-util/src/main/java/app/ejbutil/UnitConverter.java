package org.learning.app.ejbutil;

import javax.enterprise.context.Dependent;

@Dependent
public class UnitConverter {
  
  public double convertCmToInch(double cm) {
    return cm / 2.54;
  }
  
}
