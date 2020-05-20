package guru.recipe.converters;

import guru.recipe.commands.NotesCommand;
import guru.recipe.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
class NotesCommandToNotesTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NotesCommandToNotes converter;
    @BeforeEach
    void setUp() {
        converter=new NotesCommandToNotes();
    }

    @Test
    void convert() {
        //given
        NotesCommand notesCommand=new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setDescription(RECIPE_NOTES);
        //when
        Notes notes=converter.convert(notesCommand);
        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE,notesCommand.getId());
        assertEquals(RECIPE_NOTES,notesCommand.getDescription());
    }

    @Test
    void testNullParameter() throws Exception{

        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new NotesCommand()));
    }
}