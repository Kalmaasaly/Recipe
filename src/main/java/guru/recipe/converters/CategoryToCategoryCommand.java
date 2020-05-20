package guru.recipe.converters;

import guru.recipe.commands.CategoryCommand;
import guru.recipe.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.stereotype.Component;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Override
    public CategoryCommand convert(Category source) {
        if(source ==null){
            return null;
        }
        final CategoryCommand categoryCommand=new CategoryCommand();
        categoryCommand.setDescription(source.getDescription());
        categoryCommand.setId(source.getId());
        return categoryCommand;

    }
}
