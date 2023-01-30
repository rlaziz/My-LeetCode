class Solution {
    class MyStruct {
        String key;
        String value;

        MyStruct(String k){
            this.key = k;
            this.value = "";
        }
        public String toString(){
            return this.key + " : " + this.value;
        }
    }
    public boolean isMatch(String s, String p) {
        List<MyStruct> map = new ArrayList<>();

        for (int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            switch(c){
                case '*' ->{
                    MyStruct last = map.get(map.size() - 1);
                    last.key += c;
                    if (map.size() > 1){
                        MyStruct prev = map.get(map.size() - 2);
                        if ((prev.key).equals(last.key)){
                            map.remove(map.size() - 1);
                        }
                    }
                }
                default -> {
                    map.add(new MyStruct(""+c));
                }
            }
        }
        /*


         */
        boolean result = accumulate(map,s,0);
        return result;
    }
    boolean accumulate(List<MyStruct> map, String s, int cr){
        if (s.length() == 0){
            if (cr == map.size()){
                return true;
            }else {
                String reg = map.get(cr).key;
                if (reg.length() == 1){
                    return false;
                }else {
                    return accumulate(map,s,cr+1);
                }
            }
        }
        if (cr >= map.size()){
            return s.length() == 0;
        }
        // cr - current Registry
        MyStruct struct = map.get(cr);
        String reg = struct.key;

        if (reg.length() == 2){
            char p = reg.charAt(0);
            if (s.length() == 0){
                return cr == map.size() - 1;
            }
            if (p == '.'){

                boolean result = false;
                for (int i = s.length(); i >= 0; i--){
                    if (result){
                        return true;
                    }
                    result = result || accumulate(map,s.substring(i),cr + 1);
                }
                return result;

            }else {
                int matches = 0;
                char c = s.charAt(0);
                while(c == p){
                    matches++;
                    if (matches == s.length()){
                        break;
                    }
                    c = s.charAt(matches);
                }
                boolean result = false;
                for (int i = matches; i >= 0; i--){
                    if (result){
                        struct.value += s.substring(0,i);
                        return true;
                    }
                    result = result || accumulate(map,s.substring(i),cr + 1);
                }
                return result;
            }
        }else {
            char c = s.charAt(0);
            char p = reg.charAt(0);
            if (p == c || p == '.'){
                struct.value += c;
                return accumulate(map,s.substring(1), cr + 1);
            }else {
                return false;
            }
        }

    }
}