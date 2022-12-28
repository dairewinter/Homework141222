package homework1412.service.impl;

import homework1412.service.IngredientFilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class IngredientFilesServiceImpl implements IngredientFilesService {

    @Value("${path.to.data.file}")
    private String ingredientDataFilePath;

    @Value("${name.of.ingredient.file}")
    private String ingredientDataFileName;

    @Override
    public boolean saveToFile(String json){
        try {
            removeDataFile();
            Files.writeString(Path.of(ingredientDataFilePath, ingredientDataFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromFile(){
        try {
           return Files.readString(Path.of(ingredientDataFilePath, ingredientDataFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean removeDataFile(){
        try {
            Path path = Path.of(ingredientDataFilePath, ingredientDataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } return false;
    }
}
