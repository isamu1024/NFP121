#
verbose=true

bean.id.1=conditionCDI
conditionCDI.class=vip.examples.drools.contract.ConditionCDI

bean.id.2=operationCDI
operationCDI.class=vip.examples.drools.contract.OperationPros
operationCDI.property.1=opérande
operationCDI.property.1.param.1=1
operationCDI.property.2=message
operationCDI.property.2.param.1="Règle \"a un CDI\" déclenchée !"

bean.id.3=regleCDI
regleCDI.class=vip.rules.Rule
regleCDI.property.1=command
regleCDI.property.1.param.1=operationCDI
regleCDI.property.2=condition
regleCDI.property.2.param.1=conditionCDI

bean.id.4=reglesCDI
reglesCDI.class=vip.rules.Rules
reglesCDI.property.1=rules
reglesCDI.property.1.param.1=regleCDI regleSalaire

bean.id.5=conditionSalaire
conditionSalaire.class=vip.examples.drools.contract.ConditionSalaire
conditionSalaire.property.1=salaireMin
conditionSalaire.property.1.param.1=45000
conditionSalaire.property.2=salaireMax
conditionSalaire.property.2.param.1=60000

bean.id.6=operationSalaire
operationSalaire.class=vip.examples.drools.contract.OperationPros
operationSalaire.property.1=opérande
operationSalaire.property.1.param.1=2
operationSalaire.property.2=message
operationSalaire.property.2.param.1="Règle \"a un bon salaire\" déclenchée !"

bean.id.7=regleSalaire
regleSalaire.class=vip.rules.Rule
regleSalaire.property.1=command
regleSalaire.property.1.param.1=operationSalaire
regleSalaire.property.2=condition
regleSalaire.property.2.param.1=conditionSalaire

# invoker
bean.id.8=invoker
invoker.class=vip.rules.Invoker
invoker.property.1=rule
invoker.property.1.param.1=reglesCDI
#invoker.property.1.param.1=regleCDI



