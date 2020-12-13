package apiTest;

import libs.RetrieveUtil;
import models.Pet;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CRUDPetPositiveTest extends BaseCRUDPetTest{


    @Test
    public void AddNewPetTest() throws IOException {
        Pet pet = ConstructPet(id, AliveStatus);
        Response response = petActions.CreatePet(pet);

        assertThat(response.code(), equalTo(200));

        Response createdPetResponse = petActions.GetById(id);
        Pet updatedPet = RetrieveUtil.retrieveResourceFromResponse(createdPetResponse, Pet.class);
        Assert.assertEquals(pet.getName(), updatedPet.getName());
        Assert.assertEquals(pet.getStatus(), updatedPet.getStatus());
    }

    @Test
    public void UploadPetImage() throws IOException {
        Pet pet = ConstructPet(id, AliveStatus);
        petActions.CreatePet(pet);

        Response response = petActions.UploadPetImage(id, "../../test-classes/testImage.jpeg");

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void GetNewPetById() throws IOException {
        Pet pet = ConstructPet(id, AliveStatus);
        petActions.CreatePet(pet);

        Response response = petActions.GetById(id);

        assertThat(response.code(), equalTo(200));

        Pet updatedPet  = RetrieveUtil.retrieveResourceFromResponse(response, Pet.class);
        Assert.assertEquals(pet.getName(), updatedPet.getName());
    }

    @Test
    public void GetPetByStatus() throws IOException {
        Pet pet = ConstructPet(id, AliveStatus);
        petActions.CreatePet(pet);
        Pet petSold = ConstructPet(id, "sold");
        petActions.CreatePet(petSold);

        Response response = petActions.GetByStatus(AliveStatus);

        assertThat(response.code(), equalTo(200));
        Pet pets[] = RetrieveUtil.retrieveResourceFromResponse(response, Pet[].class);
        for(Pet alivePet: pets){
            Assert.assertEquals(AliveStatus, alivePet.getStatus());
        }
    }

    @Test
    public void PutStatusForPet() throws IOException {
        Pet pet = ConstructPet(id, AliveStatus);
        petActions.CreatePet(pet);
        pet.setStatus("pending");

        Response response = petActions.UpdatePet(pet);

        assertThat(response.code(), equalTo(200));

        Response updatedPetResponse = petActions.GetById(id);
        Pet updatedPet = RetrieveUtil.retrieveResourceFromResponse(updatedPetResponse, Pet.class);
        Assert.assertEquals("pending", updatedPet.getStatus());
    }

    @Test
    public void GetPetInfoById() throws IOException {
        String newName ="New Name";
        String newStatus = "pending";
        Pet pet = ConstructPet(id, AliveStatus);
        petActions.CreatePet(pet);

        Response response = petActions.UpdatePetStatusAndName(id, newName, newStatus);
        assertThat(response.code(), equalTo(200));

        Response updatedPetResponse = petActions.GetById(id);
        Pet updatedPet = RetrieveUtil.retrieveResourceFromResponse(updatedPetResponse, Pet.class);
        Assert.assertEquals(newName, updatedPet.getName());
        Assert.assertEquals(newStatus, updatedPet.getStatus());
    }

    @Test
    public void DeleteById() throws IOException {
        Pet pet = ConstructPet(id, AliveStatus);
        petActions.CreatePet(pet);

        Response response = petActions.DeleteById(id);
        assertThat(response.code(), equalTo(200));

        Response deletedPetResponse = petActions.GetById(id);
        assertThat(deletedPetResponse.code(), equalTo(404));
    }
}
