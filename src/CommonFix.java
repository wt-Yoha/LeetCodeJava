public class CommonFix {

    public static String commonFix(String[] strs){

        if(strs==null||strs.length==0||strs[0]==null)
            return "";


        int minlen = strs[0].length();
        int pos = -1;
        boolean flag = true;


        for(String s : strs){
            if(s==null)
                return "";
            if(s.length()<minlen)
                minlen = s.length();
        }

        for(int i=0;i<minlen;pos++,i++){

            char c = strs[0].charAt(i);

            for(String s : strs){
                if(s.charAt(i)!=c){
                    flag = false;
                    break;
                }
            }

            if(!flag) break;
        }

        if(pos==-1||minlen==0)
            return "";

        return strs[0].subSequence(0,pos+1).toString();
    }

    public static void main(String[] args){
        String[] strs = new String[1];
        strs[0] = "flower";
//        strs[1] = "flow";
//        strs[2] = "flight";

//        strs[0] = "flower";
//        strs[1] = "alow";
//        strs[2] = "flight";

        System.out.print(commonFix(strs));
    }

}
