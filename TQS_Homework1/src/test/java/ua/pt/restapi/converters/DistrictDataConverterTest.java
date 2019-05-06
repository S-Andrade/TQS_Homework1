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
import ua.pt.restapi.models.DistrictData;

/**
 *
 * @author ana
 */
public class DistrictDataConverterTest {

    private DistrictDataConverter converter;
    private DistrictData data;

    public DistrictDataConverterTest() {
        converter = new DistrictDataConverter();
        data = new DistrictData(1,"AVR", 5, 1010500, "40.6413", 1, "Aveiro", "-8.6535");
        data.setId(0);
    }

    @Test
    public void convertFromDToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"idRegiao\":1,\"idAreaAviso\":\"AVR\",\"idConcelho\":5,\"globalIdLocal\":1010500,\"latitude\":\"40.6413\",\"idDistrito\":1,\"local\":\"Aveiro\",\"longitude\":\"-8.6535\"}";
        assertEquals(converter.convertToDatabaseColumn(data), expected_out);
    }

    @Test
    public void convertFromStringToD() {
        assertNull(converter.convertToDatabaseColumn(null));

        String to_convert = "{\"id\":0,\"idRegiao\":1,\"idAreaAviso\":\"AVR\",\"idConcelho\":5,\"globalIdLocal\":1010500,\"latitude\":\"40.6413\",\"idDistrito\":1,\"local\":\"Aveiro\",\"longitude\":\"-8.6535\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(), data.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getGlobalIdLocal(), data.getGlobalIdLocal());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdAreaAviso(), data.getIdAreaAviso());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdConcelho(), data.getIdConcelho());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdDistrito(), data.getIdDistrito());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdRegiao(), data.getIdRegiao());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLatitude(), data.getLatitude());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLocal(), data.getLocal());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLongitude(), data.getLongitude());
    }

}
