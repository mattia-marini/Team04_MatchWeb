# MatchWeb

**MatchWeb** is a web application that simulates a sports betting and scorecard site.

---

## Running Instructions – IntelliJ

You can run the application directly from IntelliJ IDEA:

1. **Clone the repository** containing the [**MatchREST API**](https://github.com/mattia-marini/Team04_REST).
2. **Run MatchREST** as described in its README.
3. Ensure all **Maven dependencies** are installed:

    * Go to `View → Tool Windows → Maven → Reload All Maven Projects`.
4. **Run the MatchWeb application** from IntelliJ IDEA:

    * The application will be available at:
      `http://localhost:8080`

---

## Running Instructions – Tomcat

Alternatively, you can deploy and run the application in Tomcat:

1. **Clone both this and the [**MatchREST API**](https://github.com/mattia-marini/Team04_REST) repo
2. For both projects:

    * Go to `View → Tool Windows → Maven → Reload All Maven Projects`.
    * In the `Lifecycle` section, press `clean` and then `package`.
3. Copy the generated `-SNAPSHOT` folders from `/target` into Tomcat’s `webapps` folder:

    * `MatchWeb`: `/target/Team04_MatchWeb-0.0.1-SNAPSHOT`
    * `MatchREST`: `/target/Team04_REST-0.0.1-SNAPSHOT`
    * Rename them to `Team04_MatchWeb` and `Team04_REST`, respectively.
4. Update this repository’s `application.properties`:

```properties
api.base.url=http://localhost:8080/Team04_REST
```

5. Start Tomcat and open the application in a browser:
   `http://localhost:8080/Team04_MatchWeb`
