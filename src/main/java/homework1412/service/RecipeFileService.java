package homework1412.service;

import org.springframework.stereotype.Service;

@Service
public interface RecipeFileService {
    boolean saveToFile(String json);

    String readFromFile();
}
