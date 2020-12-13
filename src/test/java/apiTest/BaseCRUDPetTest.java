package apiTest;

import actions.PetActions;
import configs.ConfigProperties;
import configs.ConfigurationProvider;
import models.Category;
import models.Pet;
import models.Tags;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BaseCRUDPetTest {
    protected ConfigProperties configuration;
    protected PetActions petActions;

    protected Long id;
    protected String AliveStatus = "alive";

    @Before
    public void BeforeTest(){
        id = ThreadLocalRandom.current().nextLong(1000000);
        this.configuration = ConfigurationProvider.getConfiguration();
        petActions = new PetActions(this.configuration.baseUrlApi() + "pet/");
    }

    @After
    public void AfterTest() throws IOException {
        petActions.DeleteById(id);
    }

    protected Pet ConstructPet(Object id, String status) {
        String name = "TestCat";

        ArrayList<String> photoUrl = new ArrayList<String>();
        photoUrl.add("photourl");

        Tags tag = new Tags();
        tag.id = 1;
        tag.name = "tagsName";

        ArrayList<Tags> tags = new ArrayList<Tags>();
        tags.add(tag);

        Category category = new Category();
        category.id = 1;
        category.name = "categotyTes";

        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setPhotoUrls(photoUrl);
        pet.setStatus(status);
        pet.setTags(tags);
        pet.setCategory(category);

        return pet;
    }
}
