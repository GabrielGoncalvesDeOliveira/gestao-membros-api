package com.pontolivre.gestaomembrosapi.commons.utils;

import java.time.LocalDateTime;
import java.util.TimeZone;

public class UtilService {

    public static LocalDateTime dateTimeNow() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        return LocalDateTime.now();
    }
}
