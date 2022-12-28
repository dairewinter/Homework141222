package homework1412.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface IngredientFilesService {
    boolean saveToFile(String json);

    String readFromFile();

    boolean removeDataFile();

    File getDataFile();
}
