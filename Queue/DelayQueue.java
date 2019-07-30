package Queue;

import java.util.Iterator;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueue extends java.util.concurrent.DelayQueue
{
    public static void main(String[] args) {
        DelayQueue queue = new DelayQueue();

        DelayedTest obj1 = new DelayedTest(10);
        DelayedTest obj2 = new DelayedTest(5);
        DelayedTest obj3 = new DelayedTest(15);

        queue.offer(obj1);
        queue.offer(obj2);
        queue.offer(obj3);

        Iterator itr = queue.iterator();
        while (itr.hasNext()){
            DelayedTest dt = (DelayedTest)itr.next();
            System.out.println(dt.delayTime);
        }
    }

    static class DelayedTest implements Delayed{

        private long delayTime = 0;

        DelayedTest(long delayTime){
            this.delayTime = delayTime;
        }

        @Override
        public int compareTo(Delayed obj){
            if (this.delayTime < ((DelayedTest)obj).delayTime){return -1;}
            else if (this.delayTime > ((DelayedTest)obj).delayTime) {return 1;}
            return 0;
        }

        @Override
        public long getDelay(TimeUnit unit){
            unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.NANOSECONDS);
            return 0;
        }
    }
}
