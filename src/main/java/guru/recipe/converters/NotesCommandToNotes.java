package guru.recipe.converters;

import guru.recipe.commands.NotesCommand;
import guru.recipe.domain.Notes;
import lombok.Synchronized;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if(source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNote(source.getDescription());
        return notes;
    }
}
