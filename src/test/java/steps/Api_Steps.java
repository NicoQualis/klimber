package steps;

import org.assertj.core.api.SoftAssertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Attendee;


public class Api_Steps {
	
	private SoftAssertions softly = Attendee.getSoftly();
	private String accessToken;
    private Response response;

    @Given("El usuario obtiene el token de acceso")
    public void el_usuario_obtiene_el_token_de_acceso() {
        RestAssured.baseURI = "https://accounts.spotify.com";
        RequestSpecification request = RestAssured.given();
        request.param("grant_type", "client_credentials")
                .param("client_id", System.getenv("SPOTIFY_CLIENT_ID"))
                .param("client_secret", System.getenv("SPOTIFY_CLIENT_SECRET"))
                .header("Content-Type", "application/x-www-form-urlencoded");
        
        response = request.post("/api/token");
        accessToken = response.jsonPath().getString("access_token");
    }

    @When("Solicita la informacion del artista utilizando el token obtenido")
    public void solicita_la_informacion_del_artista_utilizando_el_token_obtenido() {
        RestAssured.baseURI = "https://api.spotify.com";
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + accessToken);

        response = request.get("/v1/artists/4Z8W4fKeB5YxbusRsdQVPb");
    }

    @Then("Valida que el codigo de estado de la respuesta es {int}")
    public void valida_que_el_codigo_de_estado_de_la_respuesta_es(int expectedStatusCode) {
    	softly.assertThat(response.getStatusCode()).isEqualTo(expectedStatusCode);
    }

    @Then("Valida que el nombre del artista es {string}")
    public void valida_que_el_nombre_del_artista_es(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        softly.assertThat(actualName).isEqualTo(expectedName);
        softly.assertAll();
    }
}
