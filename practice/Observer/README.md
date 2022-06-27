# Observer Design Pattern

* Observer is a behavioral design pattern. It specifies communication between objects: observable and observers. An observable is an object which notifies observers about the changes in its state.
  
* For example, a news agency can notify channels when it receives news. Receiving news is what changes the state of the news agency, and it causes the channels to be notified.

## Design Participants

Source: [Link](https://howtodoinjava.com/design-patterns/behavioral/observer-design-pattern/)

* Subject: Subject Class
* Concrete Subject : MessagePublisher Class
* Observer: Observer Class
* Concrete Observer: MessageSubscriber Classes
* Message is an immutable class that is passed to the Subject.

## Diagrams

![UML](UML\observer-pattern-arch.jpg)

![Sequence](UML\observer_pattern_seq.png)

## Notes

1) All observers must implement the Observer interface.
2) Can add/remove observers at runtime.
3) All registered handler objects get notifications at the same time and they process the update at same time.
