import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class ApiRequests{
	
	private Bd bd;
	
	ApiRequests(){
		bd = new Bd();
	}
	
	
	public void DataSetUpdate(String token, String idRelatorio, String nomeRelatorio) {
		try {
				URL url =new URL("https://api.powerbi.com/v1.0/myorg/datasets/"+idRelatorio+"/refreshes");
				HttpURLConnection conn = (HttpURLConnection)
				url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
				conn.setRequestProperty("Authorization", token);
				String requestBody = "{\"notifyOption\": \"\"}";
				byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
				  try (DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream())) {
		                outputStream.write(requestBodyBytes);
		                outputStream.flush();
		            }
				
				conn.connect();
				
				
				System.out.println(url);
				System.out.println("Status HTTP-> " + conn.getResponseCode());
				
				if (conn.getResponseCode() > 202) {// verfica se deu certo a requisi�ao
					throw new RuntimeException("HttpResponseCode: " + conn.getResponseCode() );
				}
				
				else {
					System.out.println("Relatorio :"+ nomeRelatorio +": atualizado com sucesso \n");
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					String datestr = format.format(date);
					bd.InsertInto(nomeRelatorio, datestr);
				}
				conn.disconnect();
			}
			catch(Exception e) {
				
			}
	}
}