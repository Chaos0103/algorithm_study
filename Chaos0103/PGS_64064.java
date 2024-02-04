import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private void dfs(int index, List<List<String>> bans, Set<String> set, Set<Set<String>> banSet) {
        if (index == bans.size()) {
            banSet.add(new HashSet<>(set));
            return;
        }

        for (String id : bans.get(index)) {
            if (set.contains(id)) {
                continue;
            }
            set.add(id);
            dfs(index + 1, bans, set, banSet);
            set.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> bans = new ArrayList<>();
        for (String ban : banned_id) {
            List<String> temp = new ArrayList<>();
            for (String user : user_id) {
                boolean matches = user.matches(ban.replace("*", "."));
                if (matches) {
                    temp.add(user);
                }
            }
            bans.add(temp);
        }

        Set<Set<String>> banSet = new HashSet<>();
        dfs(0, bans, new HashSet<>(), banSet);
        return banSet.size();
    }
}
