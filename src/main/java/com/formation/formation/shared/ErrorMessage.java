package com.formation.formation.shared;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ErrorMessage {
    String message;
    Date timestamp;
    Integer code;
     

}
