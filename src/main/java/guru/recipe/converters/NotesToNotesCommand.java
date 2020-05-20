package guru.recipe.converters;

import guru.recipe.commands.NotesCommand;
import guru.recipe.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Override
    public NotesCommand convert(Notes source) {
        if (source==null){
                return null;
            }
            final NotesCommand notes=new NotesCommand();
            notes.setId(source.getId());
            notes.setDescription(source.getRecipeNote());
            return notes;

    }
}
