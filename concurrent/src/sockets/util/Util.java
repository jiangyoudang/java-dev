package sockets.util;

import java.nio.ByteBuffer;

public class Util {

  public static int trans(int data) {
    if (Character.isLetter(data)) {
      return data ^ ' ';
    } else {
      return data;
    }
  }

  public static void trans(ByteBuffer buff) {
    buff.flip();
    for(int i=0; i < buff.limit(); i++){
      buff.put(i, (byte) trans(buff.get(i)));
    }


  }
}
