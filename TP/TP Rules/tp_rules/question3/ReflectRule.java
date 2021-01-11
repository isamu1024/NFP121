package question3;

import question1.ReflectSpecification;
import question2.ReflectCommand;

public class ReflectRule<E,R> extends Rule<E,R>  {

    protected ReflectSpecification<E>  instanceSpecification=null;
    protected ReflectCommand<E,R>  instanceCommand=null;

    public void setSpecification(String specification){
        try{

            Class rSpec = Class.forName(specification);
            Object oSpec = rSpec.newInstance();
            if (oSpec instanceof ReflectSpecification)
                this.instanceSpecification = (ReflectSpecification<E>) oSpec;
            else
                throw new NoClassDefFoundError();


        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setCommand(String command){
        try{
            Class rComm = Class.forName(command);
            Object oComm = rComm.newInstance();
            if (oComm instanceof ReflectCommand)
                this.instanceCommand = (ReflectCommand<E,R>) oComm;
            else
                throw new NoClassDefFoundError();
         }catch(Exception e){
            e.printStackTrace();
        }
    }
}
