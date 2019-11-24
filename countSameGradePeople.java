import java.util.*;

public class countSameGradePeople {
//    public static void main(String[] args) {
//        LinkedList<Integer> link = new LinkedList<>();
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        while (N!=0) {
//            HashMap<Integer, Integer> grade = new HashMap<>();
//            for (int i = 0; i < N; i++){
//                int k = sc.nextInt();
//                if (grade.containsKey(k)) {
//                    grade.put(k, grade.get(k) + 1);
//                } else
//                    grade.put(k, 1);
//            }
//            int num = sc.nextInt();
//            if (grade.get(num)!=null)
//                link.add(grade.get(num));
//            else
//                link.add(0);
//            N = sc.nextInt();
//        }
//        for (Integer integer : link) {
//            System.out.println(integer);
//        }
//    }
        public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> list1 = new ArrayList<>();
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                if (n == 0) {
                    break;
                }
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int grade = scanner.nextInt();
                    list.add(grade);
                }
                int grade1 = scanner.nextInt();
                int count = 0;
                for (Integer integer : list) {
                    if (integer.equals(grade1)) {
                        count++;
                    }
                }
                list1.add(count);
            }
            if (list1.isEmpty()) {
                return;
            }
            for (Integer integer : list1) {
                System.out.println(integer);
            }
        }
}
