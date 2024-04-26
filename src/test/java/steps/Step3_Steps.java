package steps;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.Step3_Page;
import utils.DataShared;


public class Step3_Steps {
	
	Step3_Page step3 = new Step3_Page();
	DataShared dataShared = DataShared.getInstance();
	
	@Given("Completa sus datos personales")
	public void completa_sus_datos_personales(DataTable table) {
		Map<String, String> data = table.transpose().asMap();
		step3.complete_Name(data.get("Nombre"));
		step3.complete_Surname(data.get("Apellido"));
		String idNumber = step3.complete_DNI(data.get("DNI"));
		step3.select_Gender(data.get("Sexo"));
		step3.select_IdentificationGenderType(data.get("Genero"));
		step3.select_CivilStatus(data.get("EstadoCivil"));
		
		//save data
		dataShared.setName(data.get("Nombre") + " " + data.get("Apellido"));
		dataShared.setIdCard(idNumber);
	}
	
	@Given("Completa sus datos de contacto")
	public void completa_sus_datos_de_contacto(DataTable table) {
		Map<String, String> data = table.transpose().asMap();
		step3.complete_Email(data.get("Email"));
		step3.complete_Password(data.get("Contrasena"));
		step3.complete_Street(data.get("Calle"));
		step3.complete_HouseNumber(data.get("Numero"));
		step3.complete_Zip(data.get("CP"));
		step3.select_City(data.get("Ciudad"));
	}
	
	@Given("Presiona el boton Siguiente del paso 3")
	public void presiona_el_boton_Siguiente_del_paso_3() {
		step3.click_Next();
	}
}
