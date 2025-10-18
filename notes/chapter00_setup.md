# Chapter 0 — Environment Setup and Build Process

## 🧩 Overview

Before starting the book’s exercises, we need a working setup of the **Lox interpreters** (`jlox` in Java and `clox` in C).

Bob Nystrom’s repository uses `make` and a few Dart scripts to orchestrate the build process.

---

## ⚙️ Commands Summary

### `make get`

This step:

- Runs a Dart script (`tool/bin/get.dart`).
- Downloads all Dart dependencies used by the project’s build and test scripts.
- Prepares the environment for the later `make` step.

➡️ Analogy: It’s like `bundle install` (Ruby) or `npm install` (JavaScript).
It doesn’t compile Lox yet — it only sets up the toolchain.

---

### `make`

This command orchestrates everything:

1. **Compiles the Java Lox interpreter (`jlox`)**

   - Internally runs `javac com/craftinginterpreters/lox/*.java`.
   - Generates a small launcher script `./jlox` so you can run Lox easily.
   - Equivalent manual command: `java com.craftinginterpreters.lox.Lox`

2. **Compiles the C Lox interpreter (`clox`)**

   - Runs `make` inside the `clox/` folder.
   - Produces a native binary `./clox`.

3. **(Optional)** Builds the book’s static site content.

After this step, you’ll have two executables in the repo root:

```bash
./jlox
./clox
```

---

## 🧠 What Each Command Does

| Command | Description | Output |
|----------|--------------|---------|
| `make get` | Installs Dart dependencies for build scripts | Prepared toolchain |
| `make` | Builds `jlox` (Java) + `clox` (C) | `./jlox`, `./clox` executables |
| `./jlox` | Runs the Java tree-walk interpreter | Executes `.lox` files |
| `./clox` | Runs the C bytecode VM | Executes `.lox` files faster |

---

## 💡 Running the Lox Interpreter

Once `make` completes, you can use `jlox` in two ways:

### 1. Interactive REPL (Read–Eval–Print Loop)

Simply run:

```bash
./jlox
```

You’ll see a Lox prompt:

```
> print "Hello, world!";
Hello, world!
> 2 + 3 * 4;
14
>
```

Type Ctrl + D (or Ctrl + C) to exit.

### 2. Run a .lox Script

Write your program, for example hello.lox:

```lox
print "Hello from Lox!";
```

Then run it:

```bash
./jlox path/to/hello.lox
# => Hello from Lox!
```

---

## 😅 Reflecting on What “Compiler” and “Interpreter” Mean Here

- The directory `java/com/craftinginterpreters/lox/` contains the **Java source files** that implement how the Lox language is interpreted. These are *not* Lox programs themselves — they are the **Java implementation of the Lox interpreter**.

- When we run: `$ javac com/craftinginterpreters/lox/*.java` we compile those Java files into `.class` bytecode files. Together, these compiled files form the Java-based Lox interpreter, often called `jlox`.

- When we run `java com.craftinginterpreters.lox.Lox`
 (or the shortcut ./jlox), we execute the Java Lox interpreter itself. This starts **a Lox REPL (Read–Eval–Print Loop) where we can type and evaluate Lox code interactively.**

- When we run `java com.craftinginterpreters.lox.Lox path/to/program.lox` (or equivalently `./jlox path/to/program.lox`), we ask the Java Lox interpreter to read and execute a .lox source file. The interpreter parses and executes each line of Lox code according to the rules defined in the Java implementation.

- The `.class` files generated in `java/com/craftinginterpreters/lox/` by the compilation command (`$ javac com/craftinginterpreters/lox/*.java`) are automatically decompiled by IntelliJfor them to be readable. Otherwise they won't be readable as they are actually **Java bytecode**, not text-based source code, a binary format that runs on the Java Virtual Machine (JVM).