import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class WeatherAPIURLConnection {
    public static void main(String[] args) throws IOException {
        try{
            //https://stackoverflow.com/questions/77961941/url-to-uri-class-cast-exception
            //
            String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=Seoul&APPID=f57d579de7b0fbf006e81423934de112";
            URL url = URI.create(urlStr).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("HTTP 상태 코드: " + responseCode);
            if(responseCode != HttpURLConnection.HTTP_OK){
                System.out.println("커넥션 에러 발생");
                System.out.println(connection.getResponseMessage());
                return;
            }
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();

        }catch(MalformedURLException e){
            System.out.println("URL Malformed: " + e.getMessage());
        }
    }
}
