package homework1412.service;

import org.springframework.stereotype.Service;

@Service
public interface IngredientFilesService {
    boolean saveToFile(String json);

    String readFromFile();
}
