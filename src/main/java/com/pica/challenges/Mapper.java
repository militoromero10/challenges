package com.pica.challenges;

public interface Mapper<I, O>{

    I toEntity(O challenge);
    O toDto(I dto);
}
