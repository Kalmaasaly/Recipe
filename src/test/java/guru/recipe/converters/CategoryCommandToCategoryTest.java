package guru.recipe.converters;

import guru.recipe.commands.CategoryCommand;
import guru.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "descript";
    CategoryCommandToCategory converter;
    @BeforeEach
    void setUp() {
        converter=new CategoryCommandToCategory();
    }

    @Test
    void convert() {
        //given
        CategoryCommand categoryCommand=new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);
        //when
        Category category=converter.convert(categoryCommand);
        //then
        assertEquals(ID_VALUE,category.getId());
        assertEquals(DESCRIPTION,category.getDescription());

    }
}