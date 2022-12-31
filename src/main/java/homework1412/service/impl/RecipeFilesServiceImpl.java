package homework1412.service.impl;

import homework1412.service.RecipeFileService;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RecipeFilesServiceImpl implements RecipeFileService {
    @Value("${path.to.data.file}")
    private String recipeDataFilePath;

    @Value("${name.of.recipe.file}")
    private String recipeDataFileName;

    @Override
    public boolean saveToFile(String json){
        try {
            removeDataFile();
            Files.writeString(Path.of(recipeDataFilePath, recipeDataFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromFile(){
        try {
            return Files.readString(Path.of(recipeDataFilePath, recipeDataFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeDataFile(){
        try {
            Path path = Path.of(recipeDataFilePath, recipeDataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } return false;
    }

    @Override
    public File getDataFile(){
        return new File(recipeDataFilePath + "/" + recipeDataFileName);
    }

}
