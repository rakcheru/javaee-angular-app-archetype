package org.learning.app.ejb.stateless;

import org.learning.app.ejbutil.MyConstants;
import org.learning.app.ejbutil.UnitConverter;
import org.learning.app.model.AppTimestamp;
import org.learning.app.repository.AppTimestampRepository;
import org.learning.app.utility.Calculator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class StatelessEjb {
  
  @Inject
  MyConstants myConstants;
  
  @Inject
  UnitConverter unitConverter;
  
  @Inject
  Calculator calculator;
  
  @Inject
  AppTimestampRepository appTimestampRepository;
  
  public double getPiValue() {
    return myConstants.getPiValue();
  }
  
  public double convertCmToInches(double a) {
    return unitConverter.convertCmToInch(a);
  }
  
  public int delegatedSum(int a, int b) {
    return calculator.sum(a, b);
  }
  
  public List<AppTimestamp> createAndGetAll() {
    appTimestampRepository.create();
    return appTimestampRepository.findAll();
  }
}
