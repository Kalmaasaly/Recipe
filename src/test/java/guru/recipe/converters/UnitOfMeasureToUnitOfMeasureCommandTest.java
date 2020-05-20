package guru.recipe.converters;

import guru.recipe.commands.UnitOfMeasureCommand;
import guru.recipe.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
class UnitOfMeasureToUnitOfMeasureCommandTest {
    public static String DESCRIPTION="Description";
    public static Long LONG_VALUE=new Long(1L);
    UnitOfMeasureToUnitOfMeasureCommand converter;
    @BeforeEach
    void setUp() {
        converter=new UnitOfMeasureToUnitOfMeasureCommand();
    }
    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
    @Test
    void convert() {
        //given
        UnitOfMeasure command=new UnitOfMeasure();
        command.setDescription(DESCRIPTION);
        command.setId(LONG_VALUE);
        //when
        UnitOfMeasureCommand unitOfMeasureCommand= converter.convert(command);
        //then
        assertNotNull(unitOfMeasureCommand);
        assertEquals(LONG_VALUE,command.getId());
        assertEquals(DESCRIPTION,command.getDescription());
    }
}