package com.kubernetesprojects.basickubeproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST)
public class ZeroOrNegativeDimensionsNotAllowed extends IllegalStateException{
  public ZeroOrNegativeDimensionsNotAllowed(String message){super(message);}
}
