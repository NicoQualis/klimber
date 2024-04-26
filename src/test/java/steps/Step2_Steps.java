package steps;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.Step2_Page;


public class Step2_Steps {
	
	Step2_Page step2 = new Step2_Page();
	
	@Given("Completa el formulario Necesito conocerte un poco mas")
	public void completa_el_formulario_Necesito_conocerte_un_poco_mas(DataTable table) {
		Map<String, String> data = table.transpose().asMap();
		step2.complete_PreviousIllness(data.get("EnfermedadPrevia"));
		step2.complete_Assistance(data.get("AsistenciaActividades"));
		step2.complete_Body(data.get("Altura"),data.get("Peso"));
		step2.complete_Covid19(data.get("Covid19"));
	}
	
	@Given("Presiona el boton Siguiente del paso 2")
	public void presiona_el_boton_Siguiente_del_paso_2() {
		step2.click_Next();
	}
}
