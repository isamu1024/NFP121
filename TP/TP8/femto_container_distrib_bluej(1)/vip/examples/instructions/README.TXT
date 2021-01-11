#
verbose=true


bean.id.1=i
i.class=java.util.concurrent.atomic.AtomicInteger

bean.id.2=inc
inc.class=vip.examples.instructions.Inc
inc.property.1=operand
inc.property.1.param.1=2

bean.id.3=inf
inf.class=vip.examples.instructions.LessThan
inf.property.1=operand
inf.property.1.param.1=10

bean.id.4=sup
sup.class=vip.examples.instructions.GreaterThan
sup.property.1=operand
sup.property.1.param.1=0

bean.id.5=and
and.class=vip.instructions.And
and.property.1=condition1
and.property.1.param.1=sup
and.property.2=condition2
and.property.2.param.1=inf

bean.id.6=seq
seq.class=vip.instructions.Sequence
seq.property.1=instruction1
seq.property.1.param.1=inc
seq.property.2=instruction2
seq.property.2.param.1=inc

bean.id.7=while
while.class=vip.instructions.While
while.property.1=condition
while.property.1.param.1=inf
while.property.2=instruction
while.property.2.param.1=inc

bean.id.8=inf_v
inf_v.class=vip.examples.instructions.Inf
inf_v.property.1=element
inf_v.property.1.param.1=v10

bean.id.9=v10
v10.class=vip.examples.instructions.Variable
v10.property.1=value
v10.property.1.param.1=10

bean.id.10=inc_v
inc_v.class=vip.examples.instructions.Plus1
inc_v.property.1=element
inc_v.property.1.param.1=v10

bean.id.11=while_v
while_v.class=vip.instructions.While
while_v.property.1=condition
while_v.property.1.param.1=inf_v
while_v.property.2=instruction
while_v.property.2.param.1=inc_v

bean.id.12=inc_m
inc_m.class=vip.examples.instructions.Plus1_Memory


bean.id.13=while_while
while_while.class=vip.instructions.While
while_while.property.1=condition
while_while.property.1.param.1=inf
while_while.property.2=instruction
while_while.property.2.param.1=sequence

bean.id.14=sequence
sequence.class=vip.instructions.Sequence
sequence.property.1=instruction1
sequence.property.1.param.1=debug
sequence.property.2=instruction2
sequence.property.2.param.1=inc

bean.id.15=debug
debug.class=vip.instructions.Debug

bean.id.16=while_list
while_list.class=vip.instructions.While
while_list.property.1=condition
while_list.property.1.param.1=inf_list
while_list.property.2=instruction
while_list.property.2.param.1=ajout_list

bean.id.17=inf_list
inf_list.class=vip.examples.instructions.InfList
inf_list.property.1=operand
inf_list.property.1.param.1=10


bean.id.18=ajout_list
ajout_list.class=vip.examples.instructions.Ajout
ajout_list.property.1=element
ajout_list.property.1.param.1=33
