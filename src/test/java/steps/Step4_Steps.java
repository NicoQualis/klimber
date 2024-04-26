package steps;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.Step4_Page;


public class Step4_Steps {
	
	Step4_Page step4 = new Step4_Page();
	
	@Given("Completa el formulario de Datos Adicionales")
	public void completa_el_formulario_de_Datos_Adicionales(DataTable table) {
		Map<String, String> data = table.transpose().asMap();
		step4.select_Nationality(data.get("Nacionalidad"));
		step4.complete_PlaceOfBirth(data.get("LugarDeNacimiento"));
		step4.complete_Occupation(data.get("Ocupacion"));
		step4.complete_SalaryAnual(data.get("IIBB"));
		step4.complete_FullName(data.get("ConyugeNombre"));
		step4.complete_NumberId(data.get("ConyugeDni"));
		step4.select_AnnualIncome(data.get("Origen"));
	}
	
	@Given("Presiona el boton Siguiente del paso 4")
	public void presiona_el_boton_Siguiente_del_paso_4() {
		step4.click_Next();
	}
}
