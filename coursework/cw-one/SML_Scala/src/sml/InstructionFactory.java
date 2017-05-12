package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by aman1 on 12/05/2017.
 */
public class InstructionFactory {

    public Instruction createInstruction(String[] fields) {

        Instruction result = null;
        try {
            Class instructionClass = Class.forName(generateClassName(fields[1]));
            Constructor[] constructor = instructionClass.getConstructors();
            Object[] args = generateConstructorObjects(fields, constructor[0].getParameterTypes());
            result = (Instruction) constructor[0].newInstance(args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String generateClassName(String prefix) {
        return ("sml." + prefix.substring(0, 1).toUpperCase() + prefix.substring(1).toLowerCase() + "Instruction");
    }

    Object[] generateConstructorObjects(String[] fields, Class[] cparams) {

        if (fields.length != cparams.length) {
            throw new IllegalArgumentException("If argument object and parameter length mismatch");
        }
        Object[] objectRes = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            try {
                if (cparams[i].getSimpleName().equals("int")) {
                    objectRes[i] = Integer.parseInt(fields[i]);
                } else {
                    objectRes[i] = fields[i];
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return objectRes;
    }


}
