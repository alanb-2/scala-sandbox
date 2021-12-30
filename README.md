# scala-sandbox

Repository that contains modules used to test out scala features and libraries.  See the `README.md` in each module to 
understand what each is testing.

All commands are run from the project root.  Note that the examples are given for execution from the CLI.  Commands will 
execute more quickly if the `sbt` shell is used instead.

## Prerequisites

* Java 17
* Sbt 1.6.0
* Python 3.6+

### pre-commit

1.  Install `pre-commit`
    ```shell
    pip install pre-commit
    ```
    
2.  Configure `pre-commit`
    ```shell
    pre-commit install
    ```

For advanced configuration options see https://pre-commit.com/

## Commands

### Format

```shell
sbt scalafmt
```

```shell
sbt scalafmtSbt
```
The project uses the `scalafmt` plugin and rules defined in `.scala.fmt.conf`.  More advanced execution options are 
available at https://scalameta.org/scalafmt/docs/installation.html#task-keys

### Compile

```shell
sbt clean compile
```

### Test

```shell
sbt clean test
```

### Coverage

```shell
sbt clean jacoco
```

### Assembly

```shell
sbt clean assembly
```
