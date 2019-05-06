package ua.pt.restapi.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ua.pt.restapi.models.WeatherData;

/**
 *
 * @author ana
 */
@Converter
public class WeatherDataConverter implements AttributeConverter<WeatherData, String> {

    @Override
    public String convertToDatabaseColumn(WeatherData weatherDataList) {
        if (weatherDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherData>(){}.getType();

        String json = gson.toJson(weatherDataList, type);
        return json;
    }

    @Override
    public WeatherData convertToEntityAttribute(String weatherIDData) {
        if (weatherIDData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherData>(){}.getType();

        WeatherData weatherDataList = gson.fromJson(weatherIDData, type);
        return weatherDataList;
    }
}
