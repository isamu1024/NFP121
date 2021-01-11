#
verbose=true

bean.id.1=rule1
rule1.class=vip.rules.Rule
rule1.property.1=condition
rule1.property.1.param.1=conditions
rule1.property.2=command
rule1.property.2.param.1=ajout

bean.id.2=ajout
ajout.class=vip.examples.list.Ajout


bean.id.3=conditions
conditions.class=vip.rules.And
conditions.property.1=conditions
#conditions.property.1.param.1=egal inf
conditions.property.1.param.1=vrai

bean.id.4=egal
egal.class=vip.examples.list.Egal
egal.property.1=elt
egal.property.1.param.1=e10

bean.id.5=inf
inf.class=vip.examples.list.Inf
inf.property.1=elt
inf.property.1.param.1=e10

bean.id.6=e10
e10.class=vip.examples.list.Entier
e10.property.1=valeur
e10.property.1.param.1=10

bean.id.7=e33
e33.class=vip.examples.list.Entier
e33.property.1=valeur
e33.property.1.param.1=33

bean.id.8=rules
rules.class=vip.rules.Rules
rules.property.1=rules
rules.property.1.param.1=rule1

bean.id.9=invocateur
invocateur.class=vip.rules.Invoker
invocateur.property.1=rule
invocateur.property.1.param.1=rules

bean.id.10=vrai
vrai.class=vip.rules.True

# en commentaires ici
#bean.id.11=propertiesFormatter
propertiesFormatter.class=config_editor.PropertiesFormatter

#bean.id.12=swingPropertiesFormatter
swingPropertiesFormatter.class=config_editor.SwingPropertiesFormatter

#bean.id.13=configurator
configurator.class=config_editor.ConfigGenerator
configurator.property.1=formatter
#configurator.property.1.param.1=propertiesFormatter
configurator.property.1.param.1=swingPropertiesFormatter

#bean.id.14=ihm
ihm.class=config_editor.ConfigGeneratorGUI
ihm.property.1=classBean
ihm.property.1.param.1=vip/examples/list/
ihm.property.2=configConfigurator
ihm.property.2.param.1=configurator



