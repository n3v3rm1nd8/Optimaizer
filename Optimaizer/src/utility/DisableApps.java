/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;

/**
 *
 * @author n3v3rm1nd
 */
public class DisableApps {
    
    public void disable(){
        WinReg.HKEYByReference hKey = new WinReg.HKEYByReference();
        int rc = Advapi32.INSTANCE.RegOpenKeyEx(WinReg.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\BackgroundAccessApplications",0, WinNT.KEY_SET_VALUE, hKey);

        if (rc == 0) {  // ERROR_SUCCESS = 0
            // Escribir el valor ToastEnabled = 0 (desactivar notificaciones)
            int value = 1;
            IntByReference valueRef = new IntByReference(value);
            rc = Advapi32.INSTANCE.RegSetValueEx(hKey.getValue(), "GlobalUserDisabled", 0, WinNT.REG_DWORD, valueRef.getPointer(), 4);

            if (rc == 0) {
                System.out.println("Apps desactivadas.");
            } else {
                System.out.println("Error al modificar el valor del registro.");
            }

            Advapi32.INSTANCE.RegCloseKey(hKey.getValue());
        } else {
            System.out.println("Error al abrir la clave del registro.");
        }
    }
}
