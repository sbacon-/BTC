import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BTC {
	public static void main(String[] args) {
		try {
			String credibleSoucre = "https://www.google.com/finance/quote/BTC-USD";
            readFromWeb(credibleSoucre);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readFromWeb(String webURL) throws IOException {
        URLConnection connection = new URL(webURL).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();
        InputStream is =  connection.getInputStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
            	if(line.contains("YMlKec fxKbKc")) {
                    String ymlkec = line.split("\"YMlKec fxKbKc\"")[1];
                    System.out.println(ymlkec.split("/div")[0]);
                }
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }

    }
}
