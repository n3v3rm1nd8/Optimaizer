/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;
import java.io.File;

/**
 *
 * @author n3v3rm1nd
 */
public class DeleteFiles {
    
    public void deleteFile(String path) {
        File p = new File(path);

        // Asegura que el directorio no esté vacío o que no sea null
        if (p.isDirectory()) {
            deleteContents(p);  // Llama a la función recursiva para eliminar solo el contenido
        }
    }

    // Método recursivo para eliminar el contenido
    private void deleteContents(File dir) {
        File[] files = dir.listFiles();  // Lista los archivos y subdirectorios dentro del directorio
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteContents(file);  // Llamada recursiva para eliminar el contenido del subdirectorio
                }
                file.delete();  // Elimina el archivo o subdirectorio vacío
            }
        }
    }
}




