/**
 * 
 */
package it.aren.file;

/**
 * The file saver interface to write file.
 * @param <T> is the parameter type for writing files
 */
public interface FileSaver<T> {

    /**
     * Method to write a file.
     * @param objToSave object to save
     * @param fileName file’s name to write
     */
    void saveFile(T objToSave, String fileName);
}
