public class encapsulation {
    public static void main(String[] args){
        int[] data;
        data = new int[3];

        for( int value : data){
            System.out.println(value);
        }
//        String[] data;
//        data = new String[3];

//        for( String value : data){
//            System.out.println(value);
//        }
        //0번지 배열에 값 12를 넣어보자
        data[0] = 12;
        System.out.println("-------------");
        for(int num:data){
            System.out.println(num);
        }
    }

}