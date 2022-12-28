package homework1412.controller;

import homework1412.service.IngredientFilesService;
import homework1412.service.RecipeFileService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FilesController {
    private final IngredientFilesService ingredientFilesService;
    private final RecipeFileService recipeFileService;


    public FilesController(IngredientFilesService ingredientFilesService, RecipeFileService recipeFileService) {
        this.ingredientFilesService = ingredientFilesService;
        this.recipeFileService = recipeFileService;
    }

    @GetMapping(value = "/exportrecipe", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputStreamResource> downloadRecipeFile() throws FileNotFoundException {
        File file = recipeFileService.getDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).contentLength(file.length()).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"RecipeFile.json\"").body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/exportingredient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputStreamResource> downloadIngredientFile() throws FileNotFoundException {
        File file = ingredientFilesService.getDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).contentLength(file.length()).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"IngredientFile.json\"").body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/importrecipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadRecipeFile(@RequestParam MultipartFile file){
        recipeFileService.removeDataFile();
        File recipeFile = recipeFileService.getDataFile();
        try (FileOutputStream fos =  new FileOutputStream(recipeFile)){
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping(value = "/importingredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity <Void> uploadingredientFile(@RequestParam MultipartFile file){
        ingredientFilesService.getDataFile();
        File ingredientFile = ingredientFilesService.getDataFile();
        try (FileOutputStream fos =  new FileOutputStream(ingredientFile)){
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}
