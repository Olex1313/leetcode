package medium;

import java.util.HashMap;

public class MakingFilenamesUnique {

    /**
     * @param names array of strings representing filenames
     * @return array of actual filenames
     * Example: ["gta","gta(1)","gta","avalon"] -> ["gta","gta(1)","gta(2)","avalon"]
     * @see <a href="https://leetcode.com/problems/making-file-names-unique/">Task</a>
     */
    public String[] getFolderNames(String[] names) {
        var m = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; m.put(names[i], 1), i++) {
            if (m.containsKey(names[i])) {
                int k = m.get(names[i]);
                while (m.containsKey(names[i] + "(" + k + ")")) {
                    k++;
                }
                m.put(names[i], k + 1);
                names[i] = names[i] + "(" + k + ")";
            }
        }
        return names;
    }

}
