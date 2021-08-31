package com.example.demo.thread.local;

import org.springframework.util.Assert;

/**
 * @author blindskipper
 */
public class InheritableThreadLocalTest {

    private static final InheritableThreadLocal<String> INHERITABLE_THREAD_LOCAL = new NameInheritableThreadLocal<String>("test-"){
        /**
         * 给子线程设置value
         * @param parentValue
         * @return
         */
        @Override
        protected String childValue(String parentValue) {
            return "super.childValue(parentValue)";
        }

        @Override
        protected String initialValue() {
            return "super.initialValue()";
        }
    };

    public static void main(String[] args) {
        // 是否显示调用set的区别
        INHERITABLE_THREAD_LOCAL.set("value");
        new Thread(() -> {
            System.out.println("test0-INHERITABLE_THREAD_LOCAL-" + Thread.currentThread() + " : " + INHERITABLE_THREAD_LOCAL.get());
        }).start();
        new Thread(() -> {
            System.out.println("test1-INHERITABLE_THREAD_LOCAL-" + Thread.currentThread() + " : " + INHERITABLE_THREAD_LOCAL.get());
        }).start();
        System.out.println(Thread.currentThread() + " : " + INHERITABLE_THREAD_LOCAL.get());
    }

    static class  NameInheritableThreadLocal<T> extends InheritableThreadLocal<T> {
        private final String threadName;

        public NameInheritableThreadLocal(String threadName) {
            Assert.hasText(threadName, "thread name must not be empty");
            this.threadName = threadName;
        }

        @Override
        public String toString() {
            return "NameInheritableThreadLocal{" +
                    "threadName='" + threadName + '\'' +
                    '}';
        }
    }

}
