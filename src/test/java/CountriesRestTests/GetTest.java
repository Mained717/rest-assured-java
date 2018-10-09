
package CountriesRestTests;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LogForTest;

import static com.jayway.restassured.RestAssured.get;

public class GetTest {

    @Test
    public void getRequestFindCapital() throws JSONException {



        // выполняем запрос get для доступа ко всем параметрам ответа
        Response resp = get("http://restcountries.eu/rest/v1/name/ukraine");

        JSONArray jsonResponse = new JSONArray(resp.asString());
        // получение параметра capital (столицы Норвегии)
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        // проверка, что столицей является Осло
        Assert.assertEquals(capital, "Kiev");

    }

    @Test
    public void getCurrency() throws JSONException{

        Response response = get("http://restcountries.eu/rest/v2/currency/cop");

        JSONArray jsonResponse = new JSONArray(response.asString());

        String currency = jsonResponse.getJSONObject(0).getString("currencies");

        System.out.println(currency);
    }
}