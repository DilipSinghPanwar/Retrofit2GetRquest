package androiddevs.com.retrofitsample.simplegetrequest.retrofit2utils;

/**
 * Created by ADMIN on 4/7/2018.
 */

public interface UrlConfig {

    String DEVICE_TYPE = "android";
    int TIME_OUT_MIN = 1000 * 30;
    int TIME_OUT_MAX = 1000 * 40;
    int MAX_RETRIES = 2;
    String PER_PAGE = "10";

    String AUTH_KEY = "X-GRUBPOINTSAUTHKEY";
    String AUTH_VALUE = "123456";

    String CONTENT_TYPE_KEY = "Content-Type";
    String CONTENT_TYPE_VALUE = "application/json";

    int PROGRESS = 1;
    int NO_PROGRESS = 0;

    String BASEURL = "http://grubbucks.com/webservice/";
    String GET_PROFILE = "getProfile";

}