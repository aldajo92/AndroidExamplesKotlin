# Android Examples (Kotlin)

- If you want to create a class:

```kotlin
class MyClass(param: Int, optParamOne: String = "", optParamTwo: Int = 2) {
    init {
        // Initialized code
    }
}
```

- after, you can use the parameters in the following way:
```kotlin
val object1 = MyClass(1)
val object2 = MyClass(1, "hello")
val object3 = MyClass(param = 1, optParamOne = "hello")
val object4 = MyClass(1, "hello", 4)
```