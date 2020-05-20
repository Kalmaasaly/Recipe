package guru.recipe.converters;

import guru.recipe.commands.CategoryCommand;
import guru.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
class CategoryToCategoryCommandTest {
    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "descript";
    CategoryToCategoryCommand converter;
    @BeforeEach
    void setUp() {
        converter=new CategoryToCategoryCommand();
    }

    @Test
    void convert() {
        //given
        Category category=new Category();
        category.setDescription(DESCRIPTION);
        category.setId(ID_VALUE);
        //when
        CategoryCommand categoryCommand=converter.convert(category);
        //then
        assertEquals(ID_VALUE,categoryCommand.getId());
        assertEquals(DESCRIPTION,categoryCommand.getDescription());
    }
}