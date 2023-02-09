# Conventions

_This document gives the naming and writing conventions that must be respected in this project._

## General

The entire project must be **written in english** (code & docs). Only the "management" documents are in french.

- **Class** names use `UpperCamelCase` notation.

- **Methods**, **functions** and **variables** use the `lowerCamelCase` notation.

- `@Composable` **functions**  use the `UpperCamelCase` notation.

- **const** variables use the `UPPERCASE_UNDERSCORE_SEPARATED` notation.

## Git commit

A commit's message begins with a _[gitmoji](https://gitmoji.dev/)_ corresponding to the work being done. There follows an explanation in a few words of the work done. (try to specify which files have been modify).

```
📝 update README => add image and title
```

## Kotlin samples

```kotlin

abstract class Foo<out T : Any> : IFoo {
    abstract fun foo(a: Int): T
}

class FooImpl : Foo() {
    constructor(x: String) : this(x) { 
        /*...*/ 
    }

    val x = object : IFoo { 
        /*...*/ 
    }
}

class Person(
    id: Int,
    name: String,
    surname: String
) : Human(id, name),
    KotlinMaker {
        fun foo() { 
            /*...*/ 
        }
    }

if (elements != null) {
    for (element in elements) {
        // ...
    }
}
```

## Abbreviation

- id => identifier
- pkg => package
- min => minimum
- max => maximum
- db => database

