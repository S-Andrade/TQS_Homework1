package ua.pt.restapi.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.pt.restapi.dao.WeatherForecastDAO;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.DistrictData;
import ua.pt.restapi.models.WeatherData;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WeatherForecastData;
import ua.pt.restapi.models.WindSpeedData;
/**
 *
 * @author ana
 */
@WebServlet("/weather/*")
public class AppServlet extends HttpServlet {

    private static final long serialVersionUID = -5832176047021911038L;

    @EJB
    private WeatherForecastDAO WeatherForecastDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        District district = WeatherForecastDAO.getDistricts();
        List<DistrictData> districtData = new ArrayList<>();

        for (DistrictData w : district.getData()) {
            districtData.add(w);
        }

        request.setAttribute("districtData", districtData);
        request.getRequestDispatcher("WEB-INF/weather.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        WeatherForecast w = WeatherForecastDAO.getWeatherForecastByDistrict(WeatherForecastDAO.translateDistrict(name));
        List<String> wType = new ArrayList<>();
        List<String> windSpeedList = new ArrayList<>();
        for(WeatherForecastData data : w.getData()){
          WeatherData weatherType = WeatherForecastDAO.findWeatherById(data.getIdWeatherType());
          wType.add(weatherType.getDescIdWeatherTypeEN());
          WindSpeedData windSpeedC = WeatherForecastDAO.findWindSpeedById(data.getClassWindSpeed()+"");
          windSpeedList.add(windSpeedC.getDescClassWindSpeedDailyEN());
        }
        request.setAttribute("districtData", w.getData());
        request.setAttribute("name", name);
        request.setAttribute("weatherTypes", wType);
        request.setAttribute("windSpeedList", windSpeedList);
        request.getRequestDispatcher("WEB-INF/weatherDistrict.jsp").forward(request, response);
    }
}
