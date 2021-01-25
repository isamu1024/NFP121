#verbose=true

bean.id.1=estPair
estPair.class=vip.examples.number.EstPair

bean.id.2=estImpair
estImpair.class=vip.examples.number.EstImpair

bean.id.3=inc10
inc10.class=vip.examples.number.Inc
inc10.property.1=increment
inc10.property.1.param.1=10

bean.id.4=inc100
inc100.class=vip.examples.number.Inc
inc100.property.1=increment
inc100.property.1.param.1=100

bean.id.5=rule1
rule1.class=vip.rules.Rule
rule1.property.1=condition
rule1.property.1.param.1=estPair
rule1.property.2=command
rule1.property.2.param.1=inc10

bean.id.6=rule2
rule2.class=vip.rules.Rule
rule2.property.1=condition
rule2.property.1.param.1=estImpair
rule2.property.2=command
rule2.property.2.param.1=inc100

bean.id.7=rules
rules.class=vip.rules.Rules
rules.property.1=rules
rules.property.1.param.1=rule1 rule2

bean.id.8=ruleReflection
ruleReflection.class=vip.rules.RuleReflection
ruleReflection.property.1=condition
ruleReflection.property.1.param.1=vip.examples.number.EstImpair
ruleReflection.property.2=command
ruleReflection.property.2.param.1=vip.examples.number.Inc

bean.id.9=invoker
invoker.class=vip.rules.Invoker
invoker.property.1=rule
invoker.property.1.param.1=rules
invoker.property.2=undo
invoker.property.2.param.1=true
