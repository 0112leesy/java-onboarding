package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<String> get_duplicated_list(Map<String, List<String>> map){

        List<String> duplicated_list = get_identical_list(map);
        ArrayList<String> key_list = new ArrayList<>(map.keySet());

        for(int i=0; i<key_list.size(); i++) {
            for(int j=0; j<key_list.size(); j++) {

                if(i ==j) continue;

                if(is_duplicate(key_list.get(i), key_list.get(j))){

                    for(String email: map.get(key_list.get(i))) {
                        duplicated_list.add(email);
                    }
                    for(String email: map.get(key_list.get(j))) {
                        duplicated_list.add(email);
                    }

                }

            }
        }

        return duplicated_list;
    }

    static List<String> get_identical_list(Map<String, List<String>> map){

        List<String> identical_list = new ArrayList<>();

        for(String key: map.keySet()) {
            if(map.get(key).size() > 1 && key.length() > 1) {
                for(String email : map.get(key)) {
                    identical_list.add(email);
                }
            }
        }

        return identical_list;
    }

    static boolean is_duplicate(String key, String nickname) {

        for(int i=0; i<nickname.length()-2; i++) {
            String sub_nickname = nickname.substring(i, i+2);
            if(key.contains(sub_nickname)) return true;
        }

        return false;
    }

    static Map<String, List<String>> list_to_map(List<List<String>> forms){

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if(map.containsKey(nickname)) {
                map.get(nickname).add(email);
            }
            else {
                List<String> email_list = new ArrayList<>();
                email_list.add(email);
                map.put(nickname, email_list);
            }
        }

        return map;
    }

}
