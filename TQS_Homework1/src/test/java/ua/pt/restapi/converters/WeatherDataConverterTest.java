/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.restapi.converters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ua.pt.restapi.models.WeatherData;

/**
 *
 * @author ana
 */
public class WeatherDataConverterTest {

    private WeatherDataConverter converter;
    private WeatherData data;

    public WeatherDataConverterTest() {
        converter = new WeatherDataConverter();
        data = new WeatherData("Partly cloudy", "Céu pouco nublado", 2);
        data.setId(0);
    }

    @Test
    public void convertFromWToString() {
        assertNull(converter.convertToDatabaseColumn(null));
        String expected_out = "{\"id\":0,\"descIdWeatherTypeEN\":\"Partly cloudy\",\"descIdWeatherTypePT\":\"Céu pouco nublado\",\"idWeatherType\":2}";
        assertEquals(converter.convertToDatabaseColumn(data), expected_out);
    }

    @Test
    public void convertFromStringToW() {
        assertNull(converter.convertToDatabaseColumn(null));

        String to_convert = "{\"id\":0,\"descIdWeatherTypeEN\":\"Partly cloudy\",\"descIdWeatherTypePT\":\"Céu pouco nublado\",\"idWeatherType\":2}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(), data.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdWeatherType(), data.getIdWeatherType());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescIdWeatherTypeEN(), data.getDescIdWeatherTypeEN());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescIdWeatherTypePT(), data.getDescIdWeatherTypePT());
    }

}
