package guru.recipe.domain;


import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by @author Kalmaasali on 06/05/2020.
 **/
public class CategoryTest {

     Category category;

    @Before
    public void setUp(){
        category=new Category();

    }
    @Test
    public  void getId() {
        Long idValue= 4L;
        category.setId(idValue);
        assertEquals(idValue,category.getId());
    }

    @Test
    public  void getDescription() {
    }

    @Test
    public  void getRecipes() {
    }
}