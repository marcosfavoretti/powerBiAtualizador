import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		   
		ApiRequests api = new ApiRequests();
	   	GetBearer bearer = new GetBearer();
	   	String token = bearer.getToken();
	   	Relatorios relatorio = new Relatorios();
        System.out.println(token + "\n");
	    // Iterar sobre o HashMap usando foreach
        for (Map.Entry<String, String> entry : relatorio.relatorios.entrySet()) {
          	System.out.println(entry.getKey());
            api.DataSetUpdate(token, entry.getValue(), entry.getKey());
        }
	   	
	   	
	       
	       
	}

}
