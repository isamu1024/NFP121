
bean.id.1=nombre1
nombre1.class=observer.Nombre
nombre1.property.1=valeur
nombre1.property.1.param.1=7
nombre1.property.2=observer
nombre1.property.2.param.1=observateur1
nombre1.property.3=observer
nombre1.property.3.param.1=observateur2

bean.id.2=observateur1
observateur1.class=observer.NombreObserver
observateur1.property.1=nom
observateur1.property.1.param.1=obs_1

bean.id.3=observateur2
observateur2.class=observer.NombreObserver
observateur2.property.1=nom
observateur2.property.1.param.1=obs_2

bean.id.4=conditionEstPair
conditionEstPair.class=observer.ConditionEstPair

bean.id.5=operationPlus1
operationPlus1.class=observer.OperationPlus
operationPlus1.property.1=operande
operationPlus1.property.1.param.1=1

bean.id.6=operationPlus2
operationPlus2.class=observer.OperationPlus
operationPlus2.property.1=operande
operationPlus2.property.1.param.1=2

bean.id.7=CommandePlus1
CommandePlus1.class=observer.CommandeNombre
CommandePlus1.property.1=operation
CommandePlus1.property.1.param.1=operationPlus1
CommandePlus1.property.2=condition
CommandePlus1.property.2.param.1=conditionEstPair

bean.id.8=plus
plus.class=observer.CommandeNombre
plus.property.1=operation
plus.property.1.param.1=operationPlus1
plus.property.2=condition
plus.property.2.param.1=toujoursVrai

bean.id.9=CommandePlus2
CommandePlus2.class=observer.CommandeNombre
CommandePlus2.property.1=operation
CommandePlus2.property.1.param.1=operationPlus2
CommandePlus2.property.2=condition
CommandePlus2.property.2.param.1=conditionEstPair

bean.id.10=toujoursVrai
toujoursVrai.class=conditions.VRAI

