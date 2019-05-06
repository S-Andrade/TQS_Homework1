package ua.pt.restapi.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ua.pt.restapi.models.WindSpeedData;

/**
 *
 * @author ana
 */
@Converter
public class WindSpeedDataConverter implements AttributeConverter<WindSpeedData, String>{

    @Override
    public String convertToDatabaseColumn(WindSpeedData windSpeedDataList) {
        if (windSpeedDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WindSpeedData>(){}.getType();

        String json = gson.toJson(windSpeedDataList, type);
        return json;    }

    @Override
    public WindSpeedData convertToEntityAttribute(String windSpeedData) {
        if (windSpeedData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WindSpeedData>(){}.getType();

        WindSpeedData windSpeedDataList = gson.fromJson(windSpeedData, type);
        return windSpeedDataList;    }

}
