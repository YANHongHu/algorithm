public class MyThread{

    public static void main(String[] args) throws InterruptedException {
        concurruency();
        serial();
    }

    private static void serial() {
        long begin = System.nanoTime();
        long sum1=0,sum2=0,sum3=0;
        for(int i=0;i<=1000000;i++){
            sum1+=i;
        }
        System.out.println(sum1);
        for(int i=1;i<=1000001;i+=2){
            sum2+=i;
        }
        System.out.println(sum2);
        for(int i=1;i<=100000;i++){
            sum3+=i*i;
        }
        System.out.println(sum3);
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("单行: %f 毫秒%n", ms);
    }

    private static void concurruency() throws InterruptedException {
        long begin = System.nanoTime();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                long sum = 0;
                for(int i=0;i<=1000000;i++){
                    sum+=i;
                }
                System.out.println(sum);
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long sum = 0;
                for(int i=1;i<=1000001;i+=2){
                    sum+=i;
                }
                System.out.println(sum);
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                long sum = 0;
                for(int i=1;i<=100000;i++){
                    sum+=i*i;
                }
                System.out.println(sum);
            }
        });
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("并发: %f 毫秒%n", ms);
    }
}
