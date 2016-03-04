public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ret = new LinkedList<>();
        for(int i = 0; i < digits.length(); i++){
            int len = ret.size();
            switch(digits.charAt(i)){
                case '0':
                    if(len == 0){
                        ret.addLast(" ");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+" ");
                        len--;
                    }
                    break;
                case '2':
                    if(len == 0){
                        ret.addLast("a");
                        ret.addLast("b");
                        ret.addLast("c");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"a");
                        ret.addLast(s+"b");
                        ret.addLast(s+"c");
                        len--;
                    }
                    break;
                case '3':
                    if(len == 0){
                        ret.addLast("d");
                        ret.addLast("e");
                        ret.addLast("f");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"d");
                        ret.addLast(s+"e");
                        ret.addLast(s+"f");
                        len--;
                    }
                    break;
                case '4':
                    if(len == 0){
                        ret.addLast("g");
                        ret.addLast("h");
                        ret.addLast("i");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"g");
                        ret.addLast(s+"h");
                        ret.addLast(s+"i");
                        len--;
                    }
                    break;
                case '5':
                    if(len == 0){
                        ret.addLast("j");
                        ret.addLast("k");
                        ret.addLast("l");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"j");
                        ret.addLast(s+"k");
                        ret.addLast(s+"l");
                        len--;
                    }
                    break;
                case '6':
                    if(len == 0){
                        ret.addLast("m");
                        ret.addLast("n");
                        ret.addLast("o");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"m");
                        ret.addLast(s+"n");
                        ret.addLast(s+"o");
                        len--;
                    }
                    break;
                case '7':
                    if(len == 0){
                        ret.addLast("p");
                        ret.addLast("q");
                        ret.addLast("r");
                        ret.addLast("s");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"p");
                        ret.addLast(s+"q");
                        ret.addLast(s+"r");
                        ret.addLast(s+"s");
                        len--;
                    }
                    break;
                case '8':
                    if(len == 0){
                        ret.addLast("t");
                        ret.addLast("u");
                        ret.addLast("v");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"t");
                        ret.addLast(s+"u");
                        ret.addLast(s+"v");
                        len--;
                    }
                    break;
                case '9':
                    if(len == 0){
                        ret.addLast("w");
                        ret.addLast("x");
                        ret.addLast("y");
                        ret.addLast("z");
                    }
                    while(len > 0){
                        String s = ret.getFirst();
                        ret.removeFirst();
                        ret.addLast(s+"w");
                        ret.addLast(s+"x");
                        ret.addLast(s+"y");
                        ret.addLast(s+"z");
                        len--;
                    }
                    break;
                default:
                    return ret;
            }
        }
        return ret;
    }
}
