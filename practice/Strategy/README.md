# Strategy Design Pattern

* Strategy design pattern is behavioral design pattern where we choose a specific implementation of algorithm or task in run time – out of multiple other implementations for same task.

* The important point is that these implementations are interchangeable – based on task a implementation may be picked without disturbing the application workflow.

## Design Participants

Source: [Link](https://howtodoinjava.com/design-patterns/behavioral/strategy-design-pattern/)

* Client: SocialMediaContext Class
* Abstraction (Interface) : SocialMediaStrategyInterface
* Implementations (Strategy) : Strategy1, Strategy2, Strategy3

## Diagrams

* In Strategy pattern, we first create an abstraction of algorithm. This is an interface having the abstract operation. Then we create implementations of this abstraction and these are called strategies.

* A client will always call the abstraction, and will pass a context object. This context object will decide which strategy to use.

![UML](UML\Strategy-Pattern-Participants.png)

![UML](UML\Strategy-Pattern-ClassDiagram.jpg)
