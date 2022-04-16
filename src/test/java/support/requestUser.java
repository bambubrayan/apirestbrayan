package support;

import io.restassured.response.Response;
import objects.payloadUser;

public class requestUser {

    apihelper api;
    public static Response responseUser;
    payloadUser user;

    public requestUser() {
        api = new apihelper();
    }

    public void getUsers() {
        String url = "https://reqres.in/api/users";
        responseUser = api.get(url);
    }

    public void getUser(String id) {
        String url = "https://reqres.in/api/users/" + id;
        responseUser = api.get(url);
    }

    public void createUser(String nombre, String puesto) {
        String url = "https://reqres.in/api/users";
        user = new payloadUser(nombre, puesto);
        responseUser = api.post(url, user);

    }

    public void updateUserPut(String id, String nombre, String puesto) {
        String url = "https://reqres.in/api/users/" + id;
        user = new payloadUser(nombre, puesto);
        responseUser = api.put(url, user);
    }

    public void updateUserPatch(String id, String nombre, String puesto) {
        String url = "https://reqres.in/api/users/" + id;
        user = new payloadUser(nombre, puesto);
        responseUser = api.patch(url, user);

    }
}