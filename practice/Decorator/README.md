# Template Design Pattern

* In software engineering, decorator design pattern is used to add additional features or behaviors to a particular instance of a class, while not modifying the other instances of same class. 
* Decorators provide a flexible alternative to sub-classing for extending functionality. 
* Decorating an object changes it's behavior but not it's interface. 

## Design Participants

Source: [Link](https://howtodoinjava.com/design-patterns/structural/decorator-design-pattern/)

* Component (Wrapper): Report.java
* Concrete Component (Original Object) : SupportReport
* Decorator (Abstract class with ref to concrete component and implemnents component interface) : ColumnDecorator (Report.java as interface)
* Concrete Decorator (Extends decorator and builds additional functionality): SupportLinkDecorator and SupportPopupDecorator


## Diagrams

![UML](UML\decorator-design-pattern-participants.png)
![UML](UML\DecoratorExample1.png)