package github.bhattaditya.blog.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, String resourceField, String resourceValue) {
        super(String.format("%s not found with %s: %s",resourceName, resourceField, resourceValue));
    }
}
