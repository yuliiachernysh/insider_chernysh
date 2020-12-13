package apiTest;

import actions.PetActions;
import configs.ConfigProperties;
import configs.ConfigurationProvider;
import libs.RetrieveUtil;
import models.Pet;
import okhttp3.MediaType;
import okhttp3.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class CRUDPetNegativeTest extends BaseCRUDPetTest{
    private Object invalidId = "test";

    @Test
    public void AddNewPetTest() throws IOException {
        Pet pet = ConstructPet(invalidId, AliveStatus);
        Response response = petActions.CreatePet(pet);

        Assert.assertNotEquals(response.code(), 200);

    }

    @Test
    public void DeleteById() throws IOException {
        Response response = petActions.DeleteById(new Long (2));
        assertThat(response.code(), equalTo(404));
    }
    
}
