package com.example.marginalutility;

import java.io.*;

import java.util.ArrayList;

public class SerializationUtil {
//methods for serialization and deserialization, static so we dont have to instantiate class to access methods
        public static void serialize(Object obj, String fileName) throws IOException, ClassNotFoundException
        {try {
        FileOutputStream fileOut = new FileOutputStream("fileName");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.write(obj);
        out.close();
        fileOut.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
/*      no return type, object into serialized byte by .write() of out object, serialized object passed into file through
fileOut stream
 */

//       deserialization
        /* we need file with serialized data, we passed it into fileIn stream, then while extracting,in stream object converts
        into original object state, it is need to be stored somewhere, since return type is Object class type we store in Object
    reference variable    ,
         input because we see it relative to Java Program(JVM), since data coming into JVM from file sd Input */
        public static Object deserialize(String fileName)
        {
            FileInputStream fileIn = new FileInputStream("fileName");
            ObjectInputStream in = new ObjectInputStream(fileIn);
             Object obj = in.read();
//             we will do typecast later, in that process rebuilding the class's object occurs
//            we will close the stream , flush and then return whatever we collected
            fileIn.close();
            in.close();
            return obj;
        }


}
