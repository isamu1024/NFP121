#verbose=true

bean.id.1=pile1
pile1.class=adapter.Adaptateur
pile1.property.1=collection
pile1.property.1.param.1=arrayList

bean.id.2=arrayList
arrayList.class=java.util.ArrayList


bean.id.3=pile2
pile2.class=adapter.Adaptateur
pile2.property.1=collection
pile2.property.1.param.1=linkedList

bean.id.4=linkedList
linkedList.class=java.util.LinkedList

bean.id.5=fabrique
fabrique.class=adapter.Fabrique
fabrique.property.1=instance
fabrique.property.1.param.1=pile1
