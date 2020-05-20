package guru.recipe.converters;

import guru.recipe.commands.IngredientCommand;
import guru.recipe.commands.UnitOfMeasureCommand;
import guru.recipe.domain.Ingredient;
import guru.recipe.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final Long ID=new Long(1L);
    public static final String DESCRIPTION="Cheeseburger";
    public static final BigDecimal AMOUNT=new BigDecimal("1");
    public static final Long UOM=new Long(1L);
    IngredientCommandToIngredient converter;
    @BeforeEach
    void setUp() {
        converter=new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void convert() {
        //given
        IngredientCommand ingredientCommand=new IngredientCommand();
        ingredientCommand.setId(ID);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);

        UnitOfMeasureCommand unitOfMeasureCommand=new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM);
        ingredientCommand.setUom(unitOfMeasureCommand);
        //then
        Ingredient ingredient=converter.convert(ingredientCommand);

        assertNotNull(ingredient);
        assertEquals(UOM,ingredient.getUom().getId());
        assertEquals(ID,ingredient.getId());
        assertEquals(DESCRIPTION,ingredient.getDescription());
        assertEquals(AMOUNT,ingredient.getAmount());

    }
}