import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public String hashMappin() {
        HashMap<String, String> userMap = new HashMap<String, String>(); 
        userMap.put("Hash on the Water", "Haaaaash on the water");
        userMap.put("All You Need Is Hash", "All you need is hash, hash, hash is all you need");
        userMap.put("Hash! The Herald Angels Sing", "Christmas stuff");
        userMap.put("Hashin' Round The Mountain", "She'll be hashin' round the mountain when she comes!");

        String songTitle = userMap.get("All You Need Is Hash");

        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(String.format("%s:" + " %s", key, userMap.get(key))); 
        }
        return songTitle;
    }
}


