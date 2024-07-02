public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] data = {{1,2,3},{4,5,6}};

//        //일반 for
//        for(int i = 0 ; i < data.length ; i++){
//            System.out.println(data);
//            for(int j = 0 ; j < data[i].length ; j++){
//                System.out.println(data[i][j]);
//            }
//        }
        //enhanced for
        for(int[] index : data){
            System.out.println(data);
            for(int value : index){
                System.out.println(value);
            }
        }
    }
}
