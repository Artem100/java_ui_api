package apiTest;

import api.ActionsAPI;
import api.JsonFixtures;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import api.json.UserFields;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.greaterThan;

public class CreateUser {

    @BeforeClass
    public void setUp(){RestAssured.baseURI = "https://jsonplaceholder.typicode.com";}

    @Description("Send username and pass only")
    @Test
    public void test01(){
        UserFields userFields = JsonFixtures.createNewUser("345345", "Hello", "1");
        ValidatableResponse createdUser = ActionsAPI.newUser(userFields);
        Assert.assertEquals(createdUser.extract().statusCode(),201);
//        assertThat(createdUser.extract("id"), CoreMatchers.not(isEmptyString()));
//        assertThat(createdUser.extract("id"), CoreMatchers.not(isEmptyString()));
        createdUser.body("id", greaterThan(102));
    }


}
