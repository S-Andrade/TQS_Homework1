package ua.pt.restapi.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ua.pt.restapi.models.WeatherForecastData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author ana
 */
@Converter
public class WeatherForecastDataConverter implements AttributeConverter<WeatherForecastData, String> {

    @Override
    public String convertToDatabaseColumn(WeatherForecastData weatherForecastDataList) {
        if (weatherForecastDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherForecastData>() {
        }.getType();

        String json = gson.toJson(weatherForecastDataList, type);
        return json;
    }

    @Override
    public WeatherForecastData convertToEntityAttribute(String weatherForecastData) {
        if (weatherForecastData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherForecastData>() {
        }.getType();

        WeatherForecastData weatherForecastDataList = gson.fromJson(weatherForecastData, type);
        return weatherForecastDataList;
    }

}
