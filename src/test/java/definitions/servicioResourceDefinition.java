package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.requestResource;

import java.util.List;
import java.util.Map;

public class servicioResourceDefinition {
    requestResource resource;

    public servicioResourceDefinition() {
        resource = new requestResource();
    }

    @Dado("listar recursos")
    public void listarRecursos() {
        resource.getListResource();
    }

    @Cuando("mostrar el listado de recursos")
    public void mostrarElListadoDeRecursos() {
        ResponseBody body = requestResource.responseResource;
        System.out.println(body.asString());
    }

    @Y("validar codigo de respuesta de recurso {string}")
    public void validarCodigoDeRespuestaDeRecurso(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), requestResource.responseResource.getStatusCode());
    }

    @Entonces("validar numero de recursos")
    public void validarNumeroDeRecursos() {
        ResponseBody body = requestResource.responseResource;
        JsonPath json = new JsonPath(body.asString());
        List<String> listado = json.with(body.asString()).get("data");
        int cantidad = json.getInt("per_page");
        Assert.assertEquals(cantidad, listado.size());
    }


    @Dado("listar recurso con id {string}")
    public void listarRecursoConId(String id) {
        resource.getSingleResource(id);
    }

    @Cuando("mostrar informacion del recurso")
    public void mostrarInformacionDelRecurso() {
        ResponseBody body = requestResource.responseResource;
        System.out.println(body.asString());
    }

    @Entonces("validar informacion de la consulta del recurso")
    public void validarInformacionDeLaConsultaDelRecurso(DataTable recurso) {
        ResponseBody body = requestResource.responseResource;
        JsonPath json = new JsonPath(body.asString()).setRootPath("data");
        List<Map<String, String>> data = recurso.asMaps(String.class,String.class);
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(data.get(i).get("nombre"), json.getString("name"));
            Assert.assertEquals(data.get(i).get("anio"), json.getString("year"));
            Assert.assertEquals(data.get(i).get("color"), json.getString("color"));
            Assert.assertEquals(data.get(i).get("pantone"), json.getString("pantone_value"));
        }
    }
}
