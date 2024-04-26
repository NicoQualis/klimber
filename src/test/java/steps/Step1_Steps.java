package steps;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.Step1_Page;
import utils.Attendee;
import utils.DataShared;


public class Step1_Steps {
	
	private Attendee attendee = Attendee.getInstance();
	Step1_Page step1Page = new Step1_Page();
	DataShared dataShared = DataShared.getInstance();
	
	@Given("El usuario ingresa a la web de Klimber")
	public void el_usuario_ingresa_a_la_web_de_Klimber() {
		attendee.openPage(attendee.getProperty("klimber.data.url"));	    
	}

	@Given("Completa los campos de cotizacion del seguro de vida")
	public void completa_los_campos_de_cotizacion_del_seguro_de_vida(DataTable table) {
		Map<String, String> data = table.transpose().asMap();
		step1Page.complete_birthday(data.get("FechaDeNacimiento"));
		step1Page.select_Prov(data.get("Provincia"));
		step1Page.complete_Cell(data.get("CodArea"),data.get("Celular"));
		step1Page.slide_insured(data.get("SumaAsegurada"));
		
		//save data
		dataShared.setBirthday(data.get("FechaDeNacimiento"));
		dataShared.setAmount(attendee.formatNumber(data.get("SumaAsegurada")));
	}
	
	@Given("Elije la cobertura adicional {string}")
	public void elije_la_cobertura_adicional(String additional) {
		step1Page.check_additional(additional);
	}
	
	@Given("Presiona sobre el boton Contratar")
	public void presiona_sobre_el_boton_Contratar() throws InterruptedException {
		//save data
		String total = attendee.extractNumber(step1Page.step1_getTotal());
		dataShared.setTotal(total);
		step1Page.click_Contract();
	}
}
