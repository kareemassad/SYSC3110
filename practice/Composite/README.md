# Composite Design Pattern

* Composite design pattern is a structural pattern which modifies the structure of an object.

* This pattern is most suitable in cases where you need to work with objects which form a tree like hierarchy.

## Design Participants

Source: [Link](https://howtodoinjava.com/design-patterns/structural/composite-design-pattern/)

* Client: Client Class (Main)
* Component : Component Class
* Leaf: AccountStatment, DepositeAccount, SavingsAccount Class
* Composite: CompositeAccount Classes

## Diagrams

![UML](UML\composite-design-pattern.png)


## Notes

1) The composite pattern defines class hierarchies consisting of individual objects and composite objects.
2) Adding new components can be easy and client code does not need to be changed since client deals with the new components through the component interface.
3) All registered handler objects get notifications at the same time and they process the update at same time.
