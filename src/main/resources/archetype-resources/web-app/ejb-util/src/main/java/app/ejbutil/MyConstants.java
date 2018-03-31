package org.learning.app.ejbutil;

import org.learning.app.utility.Calculator;

import javax.inject.Inject;

public class MyConstants {
  
  @Inject
  private Calculator calculator;
  
  public double getPiValue() {
    return Math.PI;
  }
  
  public int delegatedSum(int a, int b) {
    return calculator.sum(a, b);
  }
}
