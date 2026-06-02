public class Printer {
    static class RangePrinter implements Runnable{
        private final long start;
        private final long finish;
        RangePrinter(long start, long finish){
            this.start = start;
            this.finish = finish;
        }

        @Override
        public void run() {
            for(long i =start; i<= finish; i++){
                System.out.println(i);
            }
        }
        public static void main(String[] args) throws InterruptedException {
            long max = 5000000;
            int numThreads = 10;
            long range = max/numThreads;
            Thread[] threads = new Thread[numThreads];

            Long iniciot = System.currentTimeMillis();
            for(int i=0; i<numThreads; i++){
                long start = i*range+1;
                long finish = (i == numThreads-1) ? max : (i+1) *range;
                threads[i] = new Thread(new RangePrinter(start,finish));
                threads[i].start();
            }
            for (Thread t : threads){
                t.join();
            }
            Long fint = System.currentTimeMillis();
            System.out.println(fint-iniciot + "ms");
        }
    }
}
