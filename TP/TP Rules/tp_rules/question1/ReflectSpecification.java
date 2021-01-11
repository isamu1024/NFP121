package question1;

import java.lang.reflect.*;

public class ReflectSpecification<E> implements SpecificationI<E>{
    protected SpecificationI<E>  instanceSpecification=null;

    public SpecificationI<E> getSpecification(){
        return instanceSpecification;
    }

    public void setSpecification(String specification){
        Class c = null;
        try {
             c = Class.forName(specification);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found ! "+ e.getMessage());
        }

        try {
            this.instanceSpecification = (SpecificationI<E>) c.newInstance();
        } catch (Exception e) {
        }
    }

    public boolean isSatisfiedBy(E e){
        Method mSpecification=null;
        try{

            return this.instanceSpecification.isSatisfiedBy(e);

        }catch(Exception exc){
            exc.printStackTrace();
            throw new RuntimeException(exc);
        }finally{

        }

    }
}
