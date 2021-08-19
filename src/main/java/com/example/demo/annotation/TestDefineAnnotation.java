package com.example.demo.annotation;

import org.springframework.util.Assert;

import java.lang.annotation.Annotation;

/**
 * @author blindskipper
 */
@DefinedAnnotation(sort = 2)
public class TestDefineAnnotation {

    public static void main(String[] args) {
        Class<DefineAnnotation> cls = DefineAnnotation.class;
        DefinedAnnotation definedAnnotation = cls.getAnnotation(DefinedAnnotation.class);
        // assert关键字和 Assert api区别
        // assert关键字可通过 java -ea -dsa 等参数关闭，所以spring等框架采用Assert api方式进行防御性编程
        Assert.notNull(definedAnnotation,"DefinedAnnotation is not allow null");
        System.out.printf("annotation values is [%s] \n",definedAnnotation.sort());

        Class<? extends Annotation> type = definedAnnotation.annotationType();
        System.out.printf("type is [%s] \n",type);

        System.out.printf("annotation equals is [%s] \n",
                definedAnnotation.equals(TestDefineAnnotation.class.getAnnotation(DefinedAnnotation.class)));

        System.out.printf("annotation hashcode is [%s] \n",definedAnnotation.hashCode());
        System.out.printf("annotation toString is [%s] \n",definedAnnotation.toString());
        /*
          how to reproduce:javap DefinedAnnotation

          public interface com.example.demo.annotation.DefinedAnnotation extends java.lang.annotation.Annotation {
            public abstract java.lang.String value();
            public abstract int sort();
          }
         */
        System.out.printf("java.lang.annotation.Annotation is interface:[%s] \n",DefinedAnnotation.class.isInterface());
    }

    @DefinedAnnotation(sort = 1)
    class DefineAnnotation{

    }

    @Schedule(sort = 1)
    @Schedule(sort = 2)
    class ScheduleDefine{

    }
}
