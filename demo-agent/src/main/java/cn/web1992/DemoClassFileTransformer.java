package cn.web1992;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author web1992
 * @date 2021/1/19  11:36 上午
 */
public class DemoClassFileTransformer implements ClassFileTransformer {


    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        //System.out.println("transform()");
        if (className.equals("cn/web1992/Hello")) {
            ClassPool classPool = ClassPool.getDefault();

            try {
                CtClass class1 = classPool.get(className.replaceAll("/", "."));
                CtMethod ctMethod = class1.getDeclaredMethod("say");
                if (!ctMethod.isEmpty()) {
                    ctMethod.insertBefore("System.out.println(\"before hello!!!\");");
                }
                return class1.toBytecode();
            } catch (NotFoundException | CannotCompileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
