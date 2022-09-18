package com.smw.common.valid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

  private final Set<Integer> set = new HashSet<>();

  @Override
  public void initialize(ListValue constraintAnnotation) {
    int[] values = constraintAnnotation.values();
    Arrays.stream(values).forEach(set::add);
  }

  @Override
  public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
    return set.contains(integer);
  }
}
