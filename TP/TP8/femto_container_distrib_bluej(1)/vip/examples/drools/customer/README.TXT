# https://www.baeldung.com/drools-excel
#    Individual customers with greater than 3 years get 15% discount
#    Individual customers with less than 3 years get 5% discount
#    All business customers get 20% discount
#
verbose=true


bean.id.1=rule1
rule1.class=vip.rules.Rule
rule1.property.1=condition
rule1.property.1.param.1=when1
rule1.property.2=command
rule1.property.2.param.1=actionDiscount15

bean.id.2=rule2
rule2.class=vip.rules.Rule
rule2.property.1=condition
rule2.property.1.param.1=when2
rule2.property.2=command
rule2.property.2.param.1=actionDiscount5

bean.id.3=rule3
rule3.class=vip.rules.Rule
rule3.property.1=condition
rule3.property.1.param.1=whenAllBusinessCustomer
rule3.property.2=command
rule3.property.2.param.1=actionDiscount20

bean.id.4=when1
when1.class=vip.rules.And
when1.property.1=conditions
when1.property.1.param.1=whenIndividualCustomer greaterThan

bean.id.5=when2
when2.class=vip.rules.And
when2.property.1=conditions
when2.property.1.param.1=whenIndividualCustomer lessThan

bean.id.6=rules
rules.class=vip.rules.Rules
rules.property.1=rules
rules.property.1.param.1=rule1 rule2 rule3


# if Individual customers
bean.id.7=whenIndividualCustomer
whenIndividualCustomer.class=vip.examples.drools.customer.When
whenIndividualCustomer.property.1=type
whenIndividualCustomer.property.1.param.1=INDIVIDUAL

# All business customers
bean.id.8=whenAllBusinessCustomer
whenAllBusinessCustomer.class=vip.examples.drools.customer.When
whenAllBusinessCustomer.property.1=type
whenAllBusinessCustomer.property.1.param.1=BUSINESS

bean.id.9=greaterThan
greaterThan.class=vip.examples.drools.customer.GreaterThan
greaterThan.property.1=value
greaterThan.property.1.param.1=3

bean.id.10=lessThan
lessThan.class=vip.examples.drools.customer.LessThan
lessThan.property.1=value
lessThan.property.1.param.1=3

bean.id.11=actionDiscount15
actionDiscount15.class=vip.examples.drools.customer.Action
actionDiscount15.property.1=discount
actionDiscount15.property.1.param.1=15

bean.id.12=actionDiscount5
actionDiscount5.class=vip.examples.drools.customer.Action
actionDiscount5.property.1=discount
actionDiscount5.property.1.param.1=5

bean.id.13=actionDiscount20
actionDiscount20.class=vip.examples.drools.customer.Action
actionDiscount20.property.1=discount
actionDiscount20.property.1.param.1=20


