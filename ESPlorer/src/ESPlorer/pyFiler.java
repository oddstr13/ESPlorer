/**
 *
 * @author 4refr0nt
 */
package ESPlorer;

import static ESPlorer.ESPlorer.sendBuf;
import java.util.ArrayList;

public class pyFiler {

    private static String dir = "";

    public static final int OK = 0;
    public static final int ERROR_COMMUNICATION = 1;

    public pyFiler() {

    }

    public String ListDir() {
        return "";
    }

    public boolean Put(String ft, String[] s) {

        boolean success = true;
        sendBuf = new ArrayList<String>();

        sendBuf.add("f=open('" + escape(ft) + "','wb')");
        for (String subs : s) {
            sendBuf.add("f.write(bytes(" + lineToByteList(subs) + "))");
        }
        sendBuf.add("f.close()");
        sendBuf.add("del f");

        return success;
    }

    public boolean Get() {
        return false;
    }

    public boolean Rename() {
        return false;
    }

    public int Length() {
        return 0;
    }

    public String cd() {
        return dir;
    }

    public String pwd() {
        return dir;
    }

    public String GetParent() {
        return "";
    }

    public boolean isExist() {
        return false;
    }
    
    public String lineToByteList(String str) {
        StringBuilder buf = new StringBuilder((str.length() * 4)+5);
        buf.append('[');
        
        for(byte b : str.getBytes()) {
            buf.append(String.valueOf(b));
            buf.append(',');
        }
        
        buf.append("10"); // \n - newline
        buf.append(']');
        
        return buf.toString();
    }

    public String escape(String str) {
        char ch;
        StringBuilder buf = new StringBuilder(str.length() * 2);
        int intValue;

        for (int i = 0, l = str.length(); i < l; ++i) {

            ch = str.charAt(i);
            if (ch == '"') {
                //intValue = ch;
                buf.append("\\");
                //buf.append(ch);
            } else if (ch == '\'') {
                intValue = ch;
                buf.append("\\");
                //buf.append(intValue);
//            } else {
            }
            buf.append(ch);
        }
        return buf.toString();
    } // escape
} // pyFiler
