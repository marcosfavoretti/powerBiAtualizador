import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetBearer {
    String getToken() {
        StringBuilder output = new StringBuilder();
        try {
            // Comando PowerShell a ser executado
            String command = "powershell.exe -Command \"$password = ConvertTo-SecureString -String 'JhoN12*2019' -AsPlainText -Force; " +
                    "$username = 'jhoni.willian@ethos.ind.br'; " +
                    "$credential = New-Object System.Management.Automation.PSCredential($username, $password); " +
                    "Connect-PowerBIServiceAccount -Credential $credential; " +
                    "$token = Get-PowerBIAccessToken -AsString; " +
                    "Write-Output $token\"";

            // Cria o processo do PowerShell
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Lê a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            	if(line.startsWith("Bearer")) {
            		 output.append(line).append(System.lineSeparator());
            	}
            }

            // Aguarda o término do processo
            int exitCode = process.waitFor();
            System.out.println("O comando do PowerShell terminou com o código de saída: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString().trim();
    }
}