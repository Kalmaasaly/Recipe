package guru.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by @author Kalmaasali on 17/05/2020.
 **/
@Setter
@Getter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private String description;

}
