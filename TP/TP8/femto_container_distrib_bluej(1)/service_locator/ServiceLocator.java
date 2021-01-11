package service_locator;

import java.util.*;
import container.*;

public class ServiceLocator implements ServiceLocatorI{
  // Map<NomDuContainer,ApplicationContext>  
  private Map<String,ApplicationContext> containers;
  // Un cache, cf: le patron ServiceLocator original
  private Map<String,Object> cache;
  
  public int cacheAccess; // pour des statistiques �ventuelles sur l'int�r�t d'un cache
  
  public ServiceLocator(){
    this.containers = new TreeMap<String,ApplicationContext>();
    this.cache = new TreeMap<String,Object>();
  }
  
  public <T> T lookup(String serviceName) throws Exception{
    T t = (T) cache.get(serviceName);
    if(t==null){ //le bean n'est pas dans le cache
      for(ApplicationContext container : containers.values()){
        for( String bean : container){
          if(serviceName.equals(bean)){ // attention en cas de doublon, 
                             // ce sera le premier bean avec ce nom qui sera s�lectionn�
            Object service = container.getBean(bean);
            cache.put(serviceName, service);
            return (T)service;
          }
        }
      }
      throw new Exception(" service not found");
    }else{
        cacheAccess++;
    }
    return (T)cache.get(serviceName);
  }
  
  public <T> T lookup(String containerName, String serviceName) throws Exception{
    ApplicationContext container = containers.get(containerName);
    if(container==null)throw new Exception(" containerName not found");
    return container.getBean(serviceName);
  }
  
  
  public void setContainer(ApplicationContext container) throws Exception{
    try{
        assert container.getName()!=null:"attention � la pr�c�dence des initialisation des beans...";
        containers.put(container.getName(),container);
    }catch(Exception e){
        throw e;
    }
  }
  
  private List<String> services(){
     List<String> services = new ArrayList<String>();
     for(ApplicationContext container : containers.values())
         for(String bean : container)
             services.add(bean);
 
     return services;
  }
     
  public Iterator<String> iterator(){
      return services().iterator();
  }
  
  public Iterator<ApplicationContext> iteratorContainers(){
      return containers.values().iterator();
  }
  

  public Iterator<String> iteratorServices(ApplicationContext container){
      return containers.get(container.getName()).iterator();
  }
}
    
    


