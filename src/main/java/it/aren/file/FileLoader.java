/**
 * 
 */
package it.aren.file;

/**
 * The file loader interface to loading file.
 * @param <T> is the parameter type for loading files
 */
public interface FileLoader<T> {
    
    /**
     * Method to load a file.
     * @param fileName file’s name to load
     */
    T loadFile(String fileName);
}
