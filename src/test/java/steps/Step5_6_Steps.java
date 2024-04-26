package steps;

import io.cucumber.java.en.Given;
import pages.Step5_6_Page;


public class Step5_6_Steps {
	
	Step5_6_Page step4 = new Step5_6_Page();
	
	@Given("Ingresa el numero de tarjeta {string}")
	public void ingresa_el_numero_de_tarjeta(String cardNumber) {
		step4.complete_CardNumber(cardNumber);
	}
	
	@Given("Presiona el boton Siguiente del paso 5")
	public void presiona_el_boton_Siguiente_del_paso_5() {
		step4.click_Next();
	}
	
	@Given("Presiona el boton Siguiente del paso 6")
	public void presiona_el_boton_Siguiente_del_paso_6() {
		step4.click_Next_Step6();
	}
}
