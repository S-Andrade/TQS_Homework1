package ua.pt.restapi.service;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.Weather;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WindSpeed;

/**
 *
 * @author ana
 */
@Stateless
public class WeatherService {

    public WeatherForecast consumeWeatherForecast(String globalIdLocal) {
        //previsao 5 dias
        String targetUrl = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/"+globalIdLocal+".json";
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        WeatherForecast wf = response.readEntity(WeatherForecast.class);

        response.close();
        client.close();

        return wf;
    }

    public WindSpeed consumeWindSpeed() {
        //lista da intensidade vento
        String targetUrl= "http://api.ipma.pt/open-data/wind-speed-daily-classe.json";

        //previsão de vento
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        WindSpeed wf = response.readEntity(WindSpeed.class);

        response.close();
        client.close();

        return wf;
    }

    public District consumeDistrict() {
        //identificadoção das capitais distrito e ilhas
        String targetUrl = "http://api.ipma.pt/open-data/distrits-islands.json";
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        District wf = response.readEntity(District.class);

        response.close();
        client.close();

        return wf;
    }

    public Weather consumeWeather() {
        //identificadores do tempo
        String targetUrl = "http://api.ipma.pt/open-data/weather-type-classe.json";
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        Weather wf = response.readEntity(Weather.class);

        response.close();
        client.close();

        return wf;
    }

}
