package steps;

import org.assertj.core.api.SoftAssertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Resume_Page;
import utils.Attendee;
import utils.DataShared;


public class Resume_Steps {
	
	Resume_Page resume = new Resume_Page();
	DataShared dataShared = DataShared.getInstance();
	private SoftAssertions softly = Attendee.getSoftly();
	
	@Given("Visualiza el resumen de la cotizacion")
	public void visualiza_el_resumen_de_la_cotizacion() {
		softly.assertThat(resume.resume_getName()).isEqualTo(dataShared.getName());
		softly.assertThat(resume.resume_getIDNumber()).isEqualTo(dataShared.getIdCard());
		softly.assertThat(resume.resume_getBirthday()).isEqualTo(dataShared.getBirthday());
		softly.assertThat(resume.resume_getAmount()).contains(dataShared.getAmount());
		softly.assertThat(resume.resume_getTotal()).contains(dataShared.getTotal());
	}
	
	@Given("Acepta los TyC")
	public void acepta_los_TyC() {
		resume.check_TC();;
	}
	
	@When("Presiona el botón Siguiente")
	public void presiona_el_boton_Siguiente() {
		resume.click_Next();
	}
	
	@Then("Visualiza la pantalla de Finalizacion del tramite de Poliza")
	public void visualiza_la_pantalla_de_Finalizacion_del_tramite_de_Poliza() {
		softly.assertThat(resume.finishedSteps()).isTrue();
		softly.assertAll();
	}
	
	
}
