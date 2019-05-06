/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.restapi.converters;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ua.pt.restapi.converters.WindSpeedDataConverter;
import ua.pt.restapi.models.WindSpeed;
import ua.pt.restapi.models.WindSpeedData;

/**
 *
 * @author ana
 */
public class WindSpeedDataConverterTest {

        private WindSpeedDataConverter converter;
    private WindSpeedData data;

    public WindSpeedDataConverterTest() {
        converter = new WindSpeedDataConverter();
        data = new WindSpeedData("Very Strong", "Muito Forte", "4");
        data.setId(0);
    }

    @Test
    public void convertFromWSToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"descClassWindSpeedDailyEN\":\"Very Strong\",\"descClassWindSpeedDailyPT\":\"Muito Forte\",\"classWindSpeed\":\"4\"}";
        assertEquals(converter.convertToDatabaseColumn(data), expected_out);
    }

    @Test
    public void convertFromStringToWS() {
        assertNull(converter.convertToDatabaseColumn(null));

        String to_convert = "{\"id\":0,\"descClassWindSpeedDailyEN\":\"Very Strong\",\"descClassWindSpeedDailyPT\":\"Muito Forte\",\"classWindSpeed\":\"4\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(), data.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getClassWindSpeed(), data.getClassWindSpeed());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescClassWindSpeedDailyEN(), data.getDescClassWindSpeedDailyEN());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescClassWindSpeedDailyPT(), data.getDescClassWindSpeedDailyPT());
    }
}
