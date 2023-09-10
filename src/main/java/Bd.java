import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Bd {
	private Connection connect;
	
	public Bd() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://apolo/dbinvent_ethosmet", "root", "eth@1231235");
			System.out.println("banco de dados conectado");
		} catch (Exception e) {
			
		}
	}

	public void InsertInto(String name, String string) {
		
		System.out.println(name);
						
		if (name.equals("PinturaLiq")) {
			PinturaLiqupdate(string);

		} else if (name.equals("Banho")) {
			Banhoupdate(string);
		
		} else if (name.equals("Solda")) {
			Soldaupdate(string);
		
		} else if (name.equals("Portas")) {
			Portasupdate(string);
		
		} else if (name.equals("Embarque")) {
			Embarqueupdate(string);
		}
		else if (name.equals("Semanal")) {
			Semanalupdate(string);
		}
	}
		public void Banhoupdate(String string) {
			try {
				PreparedStatement preparedStatement = connect.prepareStatement("UPDATE dbinvent_ethosmet.powerbi SET dataBanho = '"+ string+"'");
				preparedStatement.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public void PinturaLiqupdate(String string) {
			try {
				PreparedStatement preparedStatement = connect.prepareStatement("UPDATE dbinvent_ethosmet.powerbi SET dataPintura = '"+ string+"'");
				preparedStatement.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void Soldaupdate(String string) {
			try {
				PreparedStatement preparedStatement = connect.prepareStatement("UPDATE dbinvent_ethosmet.powerbi SET dataSolda = '"+ string+"'");
				preparedStatement.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public void Portasupdate(String string) {
			try {
				PreparedStatement preparedStatement = connect.prepareStatement("UPDATE dbinvent_ethosmet.powerbi SET dataPortas = '"+ string+"'");
				preparedStatement.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void Embarqueupdate(String string) {
			try {
				PreparedStatement preparedStatement = connect.prepareStatement("UPDATE dbinvent_ethosmet.powerbi SET dataEmbarque = '"+ string+"'");
				preparedStatement.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void Semanalupdate(String string) {
			try {
				PreparedStatement preparedStatement = connect.prepareStatement("UPDATE dbinvent_ethosmet.powerbi SET dataSemanal = '"+ string+"'");
				preparedStatement.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
}
