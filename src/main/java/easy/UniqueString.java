package easy;

public class UniqueString {

    public boolean allUnique(String s) {
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] > 0) return false;
            map[s.charAt(i)]++;
        }
        return true;
    }

}
