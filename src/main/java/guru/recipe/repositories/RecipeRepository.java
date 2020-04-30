package guru.recipe.repositories;

import guru.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by @author Kalmaasali on 30/04/2020.
 **/
@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Long> {
    List<Recipe> findByDescription(String description);
}
